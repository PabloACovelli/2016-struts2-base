package utn.frd.action;

import com.opensymphony.xwork2.ActionSupport;
import db.PersistentManager;
import utn.frd.bean.Persona;
import java.util.List;
public class PersonaAction extends ActionSupport {

	private String name;
	private String age;
	private String gender;
	private List<Persona> personas;
	
	public String save(){
		personas = PersistentManager.getInstance();
		int edad = 0;
		try{
		edad = Integer.parseInt(age);
		}catch(Exception e){
		addActionError("Ocurrió un error con la edad");
		return ERROR;
		}
		new Persona(personas.size(), name, edad, gender);
		return SUCCESS;
		}
	
}
