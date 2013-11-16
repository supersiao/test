package hi;

import java.util.ArrayList;

public class Student {

	private String name;
	private String matricNo;
	private String gender;
	private String courseName;
	private String setCoursename;
	
public Student(String name, String matricNo, String gender, String courseName){
	
	this.name = name;
	this.matricNo = matricNo;
	this.gender = gender;
	this.courseName = courseName;
	
}
	
	public String getName(){
		return name;
		
	}
	
	public String getMatricno(){
		return matricNo;
	}
	
	public String getGender(){
		return gender;
	}
	
	public String getCoursename(){
		return courseName;
	
	}
	
	public void setName(){
		this.name = name;
	}
	
	public void setMatricno(){
		this.matricNo = matricNo;
		
	}
    
	public void setGender(){
		this.gender = gender;	
	}
	
	public void setCoursename(){
		this.setCoursename = courseName;
	}
}

