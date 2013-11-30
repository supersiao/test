import java.io.*;
import java.util.*;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;


public class csvexportstory {
	static ArrayList<Student> student = new ArrayList<Student>();
	static ArrayList<Course> course = new ArrayList<Course>();

	public void initStudent() {
                 Student s1 = new Student("Jasmine Hu","13AGC019Y","Programming Language 3","A");
                 Student s2 = new Student("Yve","13AGC023Y","PSD 3","A");
                 Student s3 = new Student("Veronica","13AGC014J","Algorithmic Language 3","A");
                 Student s4 = new Student("Jiaxiong","13AGC010L","Advanced Programming Language 3","B");
                 Student s5 = new Student("Shiny","13AGC090L","Advanced Programming Language 3","B");
                  
                 student.add(s1);
                 student.add(s2);
                 student.add(s3);
                 student.add(s4);
                 student.add(s5);
        }      
        public void initCourse(){
                Course c1 = new Course("C01", "Programming Language 3");
                Course c2 = new Course("C02", "PSD 3");
                Course c3 = new Course("C03", "Algorithmic Language 3");
                Course c4 = new Course("C04", "Advanced Programming Language 3");

                course.add(c1);
                course.add(c2);
                course.add(c3);
                course.add(c4);

                
        }

	public static boolean isInteger(String str) {
                int size = str.length();

                for (int i = 0; i < size; i++) {
                        if (!Character.isDigit(str.charAt(i))) {
                                return false;
                        }
                }

                return size > 0;
        }

	public static boolean importCourseInfor(String url) {
		Scanner scan = new Scanner(System.in);
                Map<String, String> session = new LinkedHashMap<String, String>();
		String courseStr = "", gradeStr = "";
                BufferedReader br = null;

                try {
                        String word;
                        br = new BufferedReader(new FileReader(url));
			
                        while ((word = br.readLine()) != null) {
				boolean studentExist = false;
				String[] tempWordArr= word.split(",");
				
				for (Student s : student) 
				{
					 if (s.getName().equals(tempWordArr[0])) 
					 {
						System.out.println("equal");
						studentExist = true;
					 }
					 if(studentExist)
					 {
						System.out.println("break");
						break;
					 }
				}
				if(!studentExist)
				{		
				        System.out.println("Student Not Found in the current database");
				        System.out.println("Do you want to add " + tempWordArr[0] + " into the student database? (yes | no)");
				        String add = scan.nextLine();

				        if (add.toLowerCase().equals("yes") || add.toLowerCase().equals("y")) 
					{
						Student newStudent = new Student(tempWordArr[0],tempWordArr[1], tempWordArr[2],tempWordArr[3]);
						student.add(newStudent);
						System.out.println("Student added to database");
		                        } 
					else {
		                                System.out.println("Student not added to database");
		                        }
		                } 
				else 
				{
					System.out.println(tempWordArr[0] + " already exist in database");
		                }
                        }

                        return true;
                } catch (IOException e) {

                        System.out.println("IO Exception");
                        return false;

                } finally {
                        try 
			{
                             if (br != null)
                                   br.close();
                      	} catch (IOException ex) {
                                ex.printStackTrace();
                                return false;
                        }
                }
        }

	public static boolean optPrint() {
                Scanner scan = new Scanner(System.in);
                int i = 0;
		System.out.println("--------------------------------------------------------");
                System.out.println("|                                                       |");
                System.out.println("|              Student Grade Export System!             |");
                System.out.println("|                                                       |");
                System.out.println("--------------------------------------------------------");
                System.out.println("Please choose something to do");
                System.out.println(++i +".\t Import Course Information");
                System.out.println(++i +".\t Export All grades");
		System.out.println(++i +".\t View Single Course Grades");
                System.out.println(++i +".\t Export student grades");
		System.out.println("0.\t End");
                //System.out.println(++i +".\t Edit student grades");
                //System.out.println(++i +".\t Delete grades");

                System.out.println("Select the choice: ");
                String choice = scan.nextLine();
                
                if (isInteger(choice)) {
                        menu(Integer.parseInt(choice));
                } else {
                        optPrint();
                }

                return false;
        }

	

        public static boolean checkCourse(String courseName) {
		boolean courseExist = false;
		for (Course c : course) {
			if(c.getCourseName().equals(courseName))
			{
				courseExist = true;
				break;
			}				
		}
                return courseExist;
        }

	public static boolean checkStudent(String studentName) {
                boolean studentExist = false;
		for (Student s : student) {
			if(s.getName().equals(studentName))
			{
				studentExist = true;
				break;
			}				
		}
                return studentExist;
        }


        public static void menu(int choice){
                Scanner scan = new Scanner(System.in);
                String file = "";
                String path = "";
		String course = "";
		String student = "";
                
                switch (choice) {
                case 1:
			JFrame j = new JFrame();
                        j.toFront();
                        System.out.println("Please wait while the file selector is loading, do not type while loading!!");
                        file = saveMap(j);
                        j.toBack();
                	j.dispose();
			
			 if (file == null) {
                                System.out.println("No file is being selected.");
                                optPrint();
                                break;
                        }
   
                        importCourseInfor(file);
                        optPrint();
                        break;
		case 2:
                        System.out.println("Enter the path u want to export the path.");
                        path = scan.nextLine();

                        exportAllGrade(path);
                        optPrint();

                        break;
		case 3:
                        courseExisted();

                        System.out.println("Enter the course you want to view!");
                        course = scan.nextLine();

                        if (checkCourse(course)) 
			{
			        System.out.println("Enter the path u want to export the path.");
                        	path = scan.nextLine();
                       	     	exportCourseGrade(course, path);
                        } 
			else 
			{
                             System.out.println("Course not existed.");
                        }
                     
                        optPrint();
                        break;

		case 4:
                        studentExisted();

                        System.out.println("Enter the student name that you want to view his/her grade!");
                        student = scan.nextLine();

			if (checkStudent(student)) 
			{
                             System.out.println("Enter the path u want to export the path.");
                             path = scan.nextLine();
			     exportStudentGrade(student, path);
                        } 
			else 
			{
                             System.out.println("student not existed.");
                        }
                        
                        optPrint();
                        break;
               
                case 0:
                        System.out.println("End Program!");
                        break;
                        
                default:
                        System.out.println("Invalid Selection");
                        optPrint();
                        break;


                }
        }
	public static void courseExisted() {
		for (Course c : course) {
			System.out.println(c.getCourseName());			
		}
        }

	public static void studentExisted() {
                for (Student s : student) {
                        System.out.println(s.getName());
                }
        }

	public static void exportCourseGrade(String c, String url) {
		try {
			String urls = url + "Course.csv";
                        FileWriter writer = new FileWriter(urls);
			for (Student s : student) {
				if(s.getCoursename().equals(c))
				{	
					writer.append(s.getName() + "," + s.getMatricno() + "," + s.getCoursename() + "," + s.getGrade() 						+ "\n");
				}
			}
			writer.append("\n");
			writer.flush();
                        writer.close();
                        System.out.println("The grade has been successfully exported to " + url);
		    } 
		    catch (IOException e) 
		    {
                        System.out.println("Read File Fail..");
                    }
        }

	 public static boolean exportStudentGrade(String studentName, String url) {
                try {
			String urls = url + studentName + ".csv";
                        FileWriter writer = new FileWriter(urls);

                        for (Student s : student) 
			{
                                if (s.getName().equals(studentName)) 
				{               
                                      writer.append(s.getName() + "," + s.getMatricno() + "," + s.getCoursename() + "," + s.getGrade() 						+ "\n");
                                }
                        }

			writer.append("\n");
                        writer.flush();
                        writer.close();
                        System.out.println("The student has been successfully exported to "+ url);
                        return true;

                } catch (IOException e) 
		{
                        System.out.println("Read File Fail..");
                        return false;
                }
        }


	public static void exportAllGrade(String path) {
		Scanner scan = new Scanner(System.in);
                String url = path + "all.csv";
                try {
                        FileWriter writer = new FileWriter(url);
			String courseExported = "";
                        for (Student s : student) {
				int i =0;
				boolean courseEqual = false;
                                String courseStr = s.getCoursename();
				for (Course c : course) {
					if(c.getCourseName().equals(courseStr))
					{
						courseEqual = true;
						courseExported = c.getCourseExported();
						break;
					}
					i++;				
				}
				if(courseEqual)
				{
					if(courseExported.toLowerCase().equals("no"))
					{
						course.get(i).setCourseExported("yes");
						writer.append(course.get(i).toString() + "\n");
						for (Student s1 : student) {
							if(s1.getCoursename().equals(courseStr))
							{	
								writer.append(s1.getName() + "," + s1.getMatricno() + "," + s1.getCoursename() + "," + s1.getGrade() + "\n");
							}
						}
						writer.append("\n");
					}
				}
				else
				{
					System.out.println("Course Not Found in the current database");
				        System.out.println("Do you want to add " + courseStr + " into the course database? (yes | no)");
				        String add = scan.nextLine();

				        if (add.toLowerCase().equals("yes") || add.toLowerCase().equals("y")) 
					{
						Course newCourse = new Course("C0" + (course.size() + 1), courseStr);
						newCourse.setCourseExported("yes");
						course.add(newCourse);
						System.out.println("Course added to database");
						writer.append(course.get(i).toString() + "\n");
						for (Student s2 : student) {
							if(s2.getCoursename().equals(courseStr))
							{	
								writer.append(s2.getName() + "," + s2.getMatricno() + "," + s2.getCoursename() + "," + s2.getGrade() + "\n");
							}
						}
						writer.append("\n");
		                        } 
					else {
		                                System.out.println("Course not added to database");
		                        }
				}
                        }
                        writer.append("\n");
                        // generate whatever data you want

                        writer.flush();
                        writer.close();
                        System.out.println("The grade for has been successfully exported to " + url);
                } catch (IOException e) {
                        System.out.println("Read File Fail..");
                }
        }

	public static String saveMap(JFrame f) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("/home/username/Desktop/PSD3/"));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV","csv");
                chooser.setFileFilter(filter);
		chooser.setDialogTitle("Choose a file");  
       		chooser.setVisible(true);  
                int retrival = chooser.showOpenDialog(f);
                if (retrival == JFileChooser.APPROVE_OPTION) {
                        try {
                                return chooser.getSelectedFile().getAbsolutePath();


                        } catch (Exception ex) {
                                ex.printStackTrace();
                        }
                }
                return null;
        }
}
