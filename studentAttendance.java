import java.util.ArrayList;
import java.util.Scanner;

public class studentAttendance {

        private static ArrayList<Student> studentList = new ArrayList<Student>();
        private static ArrayList<Course> courseList = new ArrayList<Course>();
        
        public void initStudent() {
            Student s1 = new Student("Jasmine Hu","C01" , "13AGC019Y","Present");
            Student s2 = new Student("Yve       ","C01" , "13AGC023Y", "Present");
            Student s3 = new Student("Veronica ","C01", "13AGC014J", "Absent");
            Student s4 = new Student("Jiaxiong", "C01" , "13AGC010L", "Present");
            Student s5 = new Student("Shiny   ", "C01", "13AGC090L", "Present");
            
            Student s6 = new Student("Maoxiong", "C02", "13AGC015H", "Late");
            Student s7 = new Student("Terence  ", "C02", "13AGC034L", "Present");
            Student s8 = new Student("Ting Wen ","C02", "13AGC012S","Present");
            Student s9 = new Student("Yuan Hui ", "C02", "13AGC091Y", "Present");
            Student s10 = new Student("Ngai Fong", "C02", "13AGC012J", "Absent");
            
            
            studentList.add(s1);
            studentList.add(s2);
            studentList.add(s3);
            studentList.add(s5);
            studentList.add(s6);
            studentList.add(s7);
            studentList.add(s8);
            studentList.add(s9);
            studentList.add(s10);
            
     }
        
      public void initCourse(){
    	  Course c1 = new Course("C01", "Advanced Programming");
    	  Course c2 = new Course("C02", "Alogrithmic Language");
    	  Course c3 = new Course("C03", "PSD");
    	  Course c4 = new Course("C04", "Programming Language");
    	  
    	  courseList.add(c1);
    	  courseList.add(c2);
    	  courseList.add(c3);
    	  courseList.add(c4);
    	  
    	  
      }
      
      
        public void select(int s) throws InterruptedException {
                Scanner scan = new Scanner(System.in);
                
                
                switch (s) {
                case 1:
                        int valid = 0;
                        int courseIndex = 0;
                        String studn = null;
                        String courseName = null;
                        String studentName = null;
                        int studentIndex = 0;
                        while (valid == 0) {
                                displayAllCourse();
                                System.out.println("Please enter which course you want to edit?");
                                courseIndex = scan.nextInt();
                                
                                if (checkCourse(courseIndex)) {
                                	courseName = courseList.get(courseIndex -1).getCourseName();
                                        valid++;
                                        
                                        while (valid == 1) {
                                                getAllStudent();
                                                System.out.println("Which Student ");
                                                studentIndex = scan.nextInt();
                                                if (checkStudent(studentIndex)) {
                                                	studentName = studentList.get(studentIndex -1).getName();
                                                        valid++;
                                                        
                                                        while (valid == 2) {
                                                                System.out.println("What do you want to update? (Present | Absent | Late)");
                                                                String update = scan.nextLine();

                                                                if (update.equalsIgnoreCase("Present")
                                                                                || update.equalsIgnoreCase("Absent")
                                                                                || update.equalsIgnoreCase("Late")) {
                                                                                valid++;
                                                                        editAttendance(studentName, courseIndex, update);
                                                                }
                                                        }
                                                } else {
                                                        System.out.println("Please try again.");
                                                }
                                        }
                                } else {
                                        System.out.println("Wrong input, please key in again.");
                                }

                        }
                        printUI();
                        break;

               
                case 2:
                        getAllStudent();
                        printUI();
                        break;

                case 3:
                        displayAllCourse();
                        printUI();
                        break;

                case 4:

                        valid = 0;

                        while (valid == 0) {
                                displayAllCourse();
                                System.out.println("Which lesson do you want to view?");
                                courseIndex = scan.nextInt();

                                if (checkCourse(courseIndex)) {
                                        valid++;
                                        viewSA(courseIndex);
                                } else {
                                        System.out.println("Please try again.");
                                }
                        }
                        printUI();
                        break;

                case 0:
                        System.out.println("Exit Success.");
                        System.out.println();
                        break;

                default:
                        System.out.println("Invalid Selection");
                        printUI();
                        break;
                }
        }

        public void printUI() throws NumberFormatException, InterruptedException {

                int i = 0;
                Scanner scan = new Scanner(System.in);
                System.out.println("------------------------------------------------------");
                System.out.println("|                                                     |");
                System.out.println("|              Student Attendance System!             |");
                System.out.println("|                                                     |");
                System.out.println("------------------------------------------------------");
                System.out.println("Please select an option");
                System.out.println(++i + ".\t Edit attendance");
                System.out.println(++i + ".\t Display a list of student");
                System.out.println(++i + ".\t Display a list of sessions");
                System.out.println(++i + ".\t View Student attendance");

                System.out.println("0.\t Back");

                System.out.println("Enter an option: ");

                String choice = scan.nextLine();
                if (isInteger(choice)) {
                        select(Integer.parseInt(choice));
                } else {
                        printUI();
                }

        }
        
        public void viewSA(int coursea) {
        	String courNameID = courseList.get(coursea -1).getCourseID();
        	for(int i=0; i<studentList.size(); i++){
        			if(studentList.get(i).getID().equals(courNameID))
                        System.out.println(studentList.get(i).toString());
        	}
        }

        
        public void displayAttendance(int courseIndex) {
        	String c = courseList.get(courseIndex).getCourseID();
        	for(int i=0; i<studentList.size(); i++){
        		 if(studentList.get(i).getID().equalsIgnoreCase(c));
        		 System.out.println(studentList.get(i).toString());
        	 }

        }

        public void displayAllCourse() {
             
        	for(int i=0; i < courseList.size(); i++){
  
        		System.out.println((i + 1) + "\t" + courseList.get(i).getCourseName());
        	}
              
        }
     public void editAttendance(String studentn, int coursea, String update) {
    	 	String c = courseList.get(coursea -1).getCourseID();
    	 	System.out.println(c);
        	for(int i=0; i<studentList.size(); i++){
            	 if(studentList.get(i).getName().equalsIgnoreCase(studentn) && studentList.get(i).getID().equals(c)){
            			 studentList.get(i).setAttendance(update);
            	 }
             }
        }

        
        public void getAllStudent() {
        	for(int i=0; i<studentList.size(); i++){
        		if(studentList.get(i).getMatricno().equalsIgnoreCase(studentList.get(i).getMatricno()))
        			System.out.println((i + 1) + "\t" + studentList.get(i).getName() + "\t" + studentList.get(i).getMatricno());
        		
                        
                }
               
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

        public boolean checkStudent(int studentIndex) {
        	Student s = studentList.get(studentIndex -1);
                return (studentList.contains(s));
        }
        
        public boolean checkCourse(int index){
        	Course courseName  = courseList.get(index -1);
        	return (courseList.contains(courseName));
        }
       
        
}
