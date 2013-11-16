
package hi;

import java.util.ArrayList;

public class student {

	private String name;
	private String matricNo;
	private String courseName;
	private String setCoursename;
	
public student(String name, String courseName, String matricNo){
	
	this.name = name;
	this.matricNo = matricNo;
	this.courseName = courseName;
	
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
    
	
	
	public void setCoursename(String c){
		this.setCoursename = c;
	}
}


