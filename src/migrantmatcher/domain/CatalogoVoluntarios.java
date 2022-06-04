package migrantmatcher.domain;

import java.util.ArrayList;
import java.util.List;


public class CatalogoVoluntarios {
	
	private List<Voluntario> catVoluntarios = new ArrayList<>();
	
	public void addVoluntario(Voluntario v) {
		catVoluntarios.add(v);
	}
	
	public Voluntario getVoluntario(int contacto) {
		for (Voluntario v : catVoluntarios) {
			if (v.getContacto() == contacto) {
				return v;
			}
		}
		Voluntario newVoluntario = new Voluntario(contacto);
		addVoluntario(newVoluntario);
		return newVoluntario;
	}
}
