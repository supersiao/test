package studentAttendance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class studentAttendance {

        ArrayList<Student> studentList = new ArrayList<Student>();
        ArrayList<String> courseList = new ArrayList<String>();
        Map<String, LinkedHashMap<String, String>> course = new LinkedHashMap<String, LinkedHashMap<String, String>>();
        
        public void initCourses() {
            courseList.add("Programming Language");
            courseList.add("Advanced Programming Language");
            courseList.add("Algorithmic Language");
        
        }
        
        public void initStudent() {
            Student s1 = new Student("Jasmine Hu","Programming Language", "13AGC019Y","Present");
            Student s2 = new Student("Yve", "Programming Language", "13AGC023Y", "Present");
            Student s3 = new Student("Veronica ","Programming Language", "13AGC014J", "Absent");
            Student s4 = new Student("Jiaxiong", "Advanced Programming Language", "13AGC010L", "Late");
            Student s5 = new Student("Shiny", "Advanced Programming Language", "13AGC090L", "Present");
            
            studentList.add(s1);
            studentList.add(s2);
            studentList.add(s3);
            studentList.add(s4);
            studentList.add(s5);
            
     }
        
        public void select(int s) throws InterruptedException {
                Scanner scan = new Scanner(System.in);

            	
                switch (s) {
                case 1:
                        int valid = 0;
                        int courseIndex = 0;
                        String coursea = null;
                        String studn = null;
                        while (valid == 0) {
                                displayAllCourse();
                                System.out.println("Please enter which course you want to edit?");
                                courseIndex = scan.nextInt();

                                if (checkCourse(courseIndex)) {
                                	valid++;
                                	   coursea = courseList.get(courseIndex -1);
                                        while (valid == 1) {
                                                getAllStudent();
                                                System.out.println("Which Student ");
                                                studn = scan.nextLine();
                                                if (checkStudent(studn)) {
                                                	valid++;

                                                        while (valid == 2) {
                                                                System.out.println("What do you want to update? (Present | Absent | Late)");
                                                                String update = scan.nextLine();

                                                                if (update.equals("Present")
                                                                                || update.equals("Absent")
                                                                                || update.equals("Late")) {
                                                                		valid++;
                                                                        editAttendance(studn, coursea, update);
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
                                System.out.println("Which course is the student from?");
                                courseIndex = scan.nextInt();

                                if (checkCourse(courseIndex)) {
                                	valid++;
                                	coursea = courseList.get(courseIndex - 1);
                                        while (valid == 1) {
                                                displayAttendance(coursea);
                                                System.out
                                                                .println("Please select which student?");
                                                studn = scan.nextLine();

                                                if (checkStudent(studn)) {
                                                	valid++;
                                                        markLate(coursea, studn);
                                                        displayAttendance(coursea);
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

                case 5:

                	valid = 0;

                        while (valid == 0) {
                                displayAllCourse();
                                System.out.println("Which lesson do you want to view?");
                                courseIndex = scan.nextInt();

                                if (checkCourse(courseIndex)) {
                                	valid++;
                                	coursea = courseList.get(courseIndex -1);
                                        viewSA(coursea);
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
                System.out.println(++i + ".\t Mark Late Student");
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

        public void viewSA(String coursea) {
                Map<String, String> session = course.get(coursea);

                for (Student n : studentList) {
                        System.out.println(n + "   " + session.get(n));
                }
        }

        public void markLate(String coursea, String studentn) {
                Map<String, String> session = course.get(coursea);

                session.remove(studentn);
                session.put(studentn, "Late");

                course.remove(coursea);
                course.put(coursea, (LinkedHashMap<String, String>) session);
        }

        public void displayAttendance(String courseName) {
                Map<String, String> temp = course.get(courseName);

                for (Student name : studentList) {
                        System.out.println(name + " is " + temp.get(name) + " for "
                                        + courseName);
                }

        }

        public void displayAllCourse() {
        	if(courseList.size() > 0){
        		  for (int i=0; i<courseList.size(); i++) {
                      System.out.println(i+1 + ")" + courseList.get(i));
              }
        	}else {
        		System.out.println("No Courses has been added");
        	}
              
        }

        public void editAttendance(String studentn, String coursea, String update) {

                Map<String, String> session = course.get(coursea);
                session.remove(studentn);
                session.put(studentn, update);
                course.remove(coursea);
                course.put(coursea, (LinkedHashMap<String, String>) session);
        }

        
        

        public void getAllStudent() {
        	initStudent();if(studentList.size() > 0){
        	for (int i=0; i< studentList.size(); i++) {
                        System.out.println("Student : " + studentList.get(i));
                }
        	}else {
        		System.out.println("No student has been added!");
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

        public boolean checkStudent(String name) {
                return (studentList.contains(name));
        }

        public boolean checkCourse(int courseIndex) {
                return (courseList.contains(courseList.get(courseIndex - 1)));
        }
}
