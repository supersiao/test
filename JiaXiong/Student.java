public class Student {

	private String name;
	private String matricNo;
	private String grade;
	private String courseName;
	private String setCoursename;
	
public Student(String name, String matricNo, String courseName, String grade){
	
	this.name = name;
	this.matricNo = matricNo;
	this.grade = grade;
	this.courseName = courseName;
	
}
	
	public String getName(){
		return name;
		
	}
	
	public String getMatricno(){
		return matricNo;
	}
	
	public String getGrade(){
		return grade;
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
    
	public void setGrade(){
		this.grade = grade;	
	}
	
	public void setCoursename(){
		this.setCoursename = courseName;
	}
}



