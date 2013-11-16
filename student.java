package hi;

import java.util.ArrayList;

public class student {

	private String name;
	private String matricNo;
	private String courseName;
	private String attendance;
	
public student(String name, String courseName, String matricNo, String attendance){
	
	this.name = name;
	this.matricNo = matricNo;
	this.courseName = courseName;
	
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
	

	public String getCoursename(){
		return courseName;
	
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
	
	public void setCoursename(String c){
		this.courseName = c;
	}
}


