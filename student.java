import java.util.ArrayList;

public class Student {

        private String name;
        private String matricNo;
        private String courseID;
        private String attendance;
        
public Student(String name, String courseID, String matricNo, String attendance){
        
        this.name = name;
        this.matricNo = matricNo;
        this.courseID = courseID;
        this.attendance = attendance;
        
}

        public String getAttendance(){
                return attendance;
        }
        
        public String getName(){
                return name;
                
        }
        
        public String getMatricno(){
                return matricNo;
        }
        

        public String getID(){
                return courseID;
        
        }
        
        public void setName(String name){
                this.name = name;
        }
        
        public void setMatricno(String matricNo){
                this.matricNo = matricNo;
                
        }
    
        public void setAttendance(String a){
                this.attendance = a;
        }
        
        public void setIDe(String c){
                this.courseID = c;
        }

        public String toString() {
        	   return this.name + "\t" + this.getID() + "\t" + this.getMatricno() +"\t" + this.getAttendance() ;
        	   
        	}
}
