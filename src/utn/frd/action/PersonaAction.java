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
	private List<Persona> personas;
    
	
	public String execute(){
		personas = PersistentManager.getInstance();
		return SUCCESS;
		}
	
	
	public String save(){	
		personas = PersistentManager.getInstance();
		int edad = 0;
		
		try{
			edad = Integer.parseInt(age);
		    }
		catch(Exception e){
			addActionError("Ocurrió un error con la edad");
			return ERROR;
		    }
		
        
		Persona p= new Persona(personas.size(), name, edad, gender);
		personas.add(p);
		
		
		setName(" ");
		setAge(" ");
		setGender(" ");

		return SUCCESS;
		
	}
	
	public String delete(){
		
		personas = PersistentManager.getInstance();
		long idNuevo = 0;
		
		try{
			idNuevo=Integer.parseInt(id);
			
			}
		catch (Exception e){
			addActionError("Ocurrió un error con el ID");
			return ERROR;
			}
		
		
		Persona persona = getPersona(idNuevo);
		
		if (persona != null){
			personas.remove(persona);
		    }
		else{
			 addActionError("Persona inexistente");
			 
		    }
		
		
		return SUCCESS;
		
	 }
	
	public String modify(){
		
		personas = PersistentManager.getInstance();
		int edad = 0;
		long idNuevo = 0;
		
		try{
			edad = Integer.parseInt(age);
			idNuevo = Integer.parseInt(id);
         	}
		catch (Exception e){
			addActionError("Ocurrió un error con los parámetros");
			return ERROR;
		   }
		
		Persona persona = getPersona(idNuevo);
		
		if (persona != null) {
			persona.setName(name);
			persona.setAge(edad);
			persona.setGender(gender);
		    
			 } 
		
		else {
			addActionError("Persona inexistente");
			
		     }
		
	    
	    return SUCCESS;
	
	}
	
	
	private Persona getPersona(long idNuevo){
		
		Persona p = null;
		
		for(Persona individuo: personas){
			if (idNuevo == individuo.getId() ){
				p=individuo;
				break;
			}
		}
		return p;
	}
	
	
	public void setId(String id){
		this.id=id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setAge(String age){
		this.age=age;
	}
	
	public void setGender(String gender){
		this.gender=gender;
	}
	
	public void setPersonas(List<Persona> personas){
		this.personas=personas;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAge(){
		return age;
	}
	
	public String getGender(){
		return gender;
	}
	
	public String getId(){
		return id;
	}
	
	public List<Persona> getPersonas(){
		return personas;
	}
}


