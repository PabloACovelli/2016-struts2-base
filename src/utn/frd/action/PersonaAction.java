package utn.frd.action;

import com.opensymphony.xwork2.ActionSupport;

import utn.frd.bean.Persona;
import utn.frd.db.PersistentManager;

import java.util.List;

public class PersonaAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String age;
	private String gender;
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	private List<Persona>personas;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
	public String execute(){//inicializar coleccion
		personas = PersistentManager.getInstance();
		
		return SUCCESS;
	}
	
	public String save(){
		
		personas = PersistentManager.getInstance();
		int edad = 0;
		try{
			Persona p= new Persona(personas.size(), name, edad, gender);
			personas.add(p);
		edad = Integer.parseInt(age);
		}
		catch(Exception e){
		addActionError("Ocurrió un error con la edad");
		return ERROR;
		}
		
		return SUCCESS;
		
		}
	
}
