package studentAttendance;


import java.util.Scanner;

public class Main {

        public static void main(String[] args) throws InterruptedException {
                // TODO Auto-generated method stub
                String username;
                String password;


                Scanner scanner = new Scanner (System.in);
                System.out.println("Enter your username");  
                username = scanner.next(); 
                System.out.println("Enter your password");  
                password = scanner.next(); 
                authenticate(username,password);
                scanner.close();
        }


        public static void authenticate(String username, String password) throws InterruptedException {

                if (username.equals("admin") && password.equals("password")) {

                
                studentAttendance sa = new studentAttendance();
                sa.initStudent();
                sa.initCourse();
                // tutorLoadGrade tg = new tutorLoadGrade();
                int i = 1;
                Scanner sc = new Scanner(System.in);

                while (i != 0) {
                        System.out.println("Please enter an option?");
                        System.out.println("1.\t Grades");
                        System.out.println("2.\t Attendance");
                        System.out.println("3.\t Exit");

                        String ans = sc.nextLine();
                        Thread t = new Thread();
                        if (isInteger(ans)) {

                                switch (Integer.parseInt(ans)) {
                                case 1:

                                        t.start();

                                        for (i = 0; i < 4; i++) {
                                                Thread.sleep(100);
                                                System.out.print(".");
                                        }

                                        System.out.println("Database not found!");
                                        System.out.println();

                                        //tg.printUI();
                                        break;

                                case 2:
                                        sa.printUI();
                                        break;

                                case 3:
                                        i = 0;
                                        System.out.println("Thank you!");
                                        break;

                                default:
                                        System.out.print("Wrong input, pls try again!");
                                        System.out.println();

                                }

                        }
                }
                sc.close();
                } 
                else{
                        System.out.println("User and password not valid, Please try again!!");
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

}