import java.io.*;
import java.util.*;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;


public class csvexportstory {
	static ArrayList<String> student = new ArrayList<String>();
        static ArrayList<String> course = new ArrayList<String>();
	static Map<String, LinkedHashMap<String, String>> grade = new LinkedHashMap<String, LinkedHashMap<String, String>>();

	public static void main(String[] args) throws IOException {

		student.add("JiaXiong");
                optPrint();
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

                                if (!student.contains(word)) {
                                        System.out.println("Student Not Found in the current database");
                                        System.out.println("Do you want to add " + word + " into the student database? (yes | no)");
                                        String add = scan.nextLine();

                                        if (add.toLowerCase().equals("yes") || add.toLowerCase().equals("y")) 
					{
                                                student.add(word);
						System.out.println("Student added to database");
						System.out.println("Enter the course name?");
                       				courseStr = scan.nextLine();
						System.out.println("Enter the course grade?");
                       				gradeStr = scan.nextLine();
						session.put(word, gradeStr);
                                        } 
					else {
                                                System.out.println("Student not added to database");
                                        }

                                } 
				else {
					System.out.println(word + " already exist in database");
					System.out.println("Enter the course name?");
                       			courseStr = scan.nextLine();
					System.out.println("Enter the course grade?");
                       			gradeStr = scan.nextLine();
                                        session.put(word, gradeStr);
                                        System.out.println(word + " added");
                                }
				course.add(courseStr);
                        	grade.put(courseStr, (LinkedHashMap<String, String>) session);
                        	System.out.println("The grade has been entered into the system!");
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
                System.out.println("Please choose something to do");
                System.out.println(++i +".\t Import Course Information");
                //System.out.println(++i +".\t Manually Insert Grades");
                //System.out.println(++i +".\t View Single Course Grades");
                System.out.println(++i +".\t View All Course Grades");
                System.out.println(++i +".\t Export All grades");
                System.out.println(++i +".\t Export student grades");
                System.out.println(++i +".\t Export subject grades");
                //System.out.println(++i +".\t Edit student grades");
                //System.out.println(++i +".\t Delete grades");
                System.out.println("0.\t End");


                System.out.println("Select the choice: ");
                String choice = scan.nextLine();
                
                if (isInteger(choice)) {
                        menu(Integer.parseInt(choice));
                } else {
                        optPrint();
                }

                return false;
        }
	
	 public static void menu(int choice){
                Scanner scan = new Scanner(System.in);
                String file = "";
                String path = "";
                
                switch (choice) {
                case 1:
			JFrame j = new JFrame();
                        j.toFront();
                        System.out.println("Please wait while the file selector is loading, dont not type while loading!!");
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
		case 3:
                        System.out.println("Enter the path u want to export the path.");
                        path = scan.nextLine();

                        exportAllGrade(path);
                        optPrint();

                        break;

                /*case 2:
                        mInsertGrade();
                        printUI();
                        break;


                case 3:
                        displayCourse();
                        System.out.println("Enter the course you want to view!");
                        ans = scan.nextLine();


                        displayCourseGrade(ans);
                        printUI();
                        break;


                case 4:
                        displayAllCourseGrade();
                        printUI();
                        break;
                        

                case 6:
                        displayStudent();
                        System.out.println("Which student's grade do you want to export?");
                        ans = scan.nextLine();
                        
                        exportStudentGrade(ans);
                        printUI();
                        break;
                        
                case 7:
                        displayCourse();
                        System.out.println("Which course grade do you want to export?");
                        ans = scan.nextLine();
                        
                        exportGrade(ans);
                        printUI();
                        break;
                        
                case 8: 
                        displayCourse();
                        System.out.println("Which course do you want to edit?");
                        String c = scan.nextLine();
                        
                        displayStudent();
                        System.out.println("Which student do you want to edit the grade?");
                        String s = scan.nextLine();
                        
                        System.out.println("What grade is he suppose to have?");
                        ans = scan.nextLine();
                        
                        editCourse(c, s, ans);
                        printUI();
                        break;
                        
                case 9:
                        displayCourse();
                        System.out.println("Which course do you want to delete?");
                        ans = scan.nextLine();
                        
                        deleteCourse(ans);
                        printUI();
                        break;*/
                        
                case 0:
                        System.out.println("End Program!");
                        break;
                        
                default:
                        System.out.println("Invalid Selection");
                        optPrint();
                        break;


                }
        }

	 public static boolean exportAllGrade(String path) {
                String url = path + "all.csv";
                try {
                        FileWriter writer = new FileWriter(url);
                        for (String c : course) {
                                Map<String, String> session = grade.get(c);
                                writer.append("Course: " + c + "\n");
                                for (String name : student) {
                                        if (session.containsKey(name)) {
                                                writer.append(name + "," + session.get(name) + "," + c + "\n");
                                        }
                                }
                                writer.append("\n");
                        }

                        // generate whatever data you want

                        writer.flush();
                        writer.close();
                        System.out.println("The grade for has been successfully exported to " + url);
                        return true;
                } catch (IOException e) {
                        System.out.println("Read File Fail..");
                        return false;
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
