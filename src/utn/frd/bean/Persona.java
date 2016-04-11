package utn.frd.bean;

public class Persona {
	
	private long id;
	private String name;
	private int age;
	private String gender;
	
	public Persona(long id, String name, int age, String gender){
		this.id=id;
		this.name=name;
		this.age=age;
		this.gender=gender;
	}

	public void setId(long id){
		this.id=id;
	}
	
	public void setName(String name){
		this.name=name;
		
	}
	
	public void setAge(int age){
		this.age=age;
	}
	
	public void setGender(String gender){
		this.gender=gender;
	}
	
	public long getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	public String getGender(){
		return gender;
	}
}