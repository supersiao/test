package studentAttendance;
public class Course { 
    private String courseID;
    private String courseName;
    private String courseExported = "no";
    
public Course( String courseID, String courseName){
    this.courseID = courseID;
    this.courseName = courseName;    
}

public String getCourseID(){
return courseID;
}

public void setCourseID(String courseID){
this.courseID = courseID;
}

public String getCourseName(){
return courseName;
}

public void setCourseName(String cN){
this.courseName = cN;
}

public String getCourseExported(){
return courseExported;
}

public void setCourseExported(String cE){
this.courseExported = cE;
}

public String toString() {
       return this.getCourseID() + ". " + this.getCourseName();
}

}