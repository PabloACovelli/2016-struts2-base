package utn.frd.bean;

public class Persona {
	
	private long id;
	private String name;
	private int age;
	private String gender;
	
	public Persona(long id, String name, int edad, String gender){
		this.id=id;
		this.name=name;
		this.age=edad;
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
