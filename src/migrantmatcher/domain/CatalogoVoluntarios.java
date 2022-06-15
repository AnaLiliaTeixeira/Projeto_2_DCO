package migrantmatcher.domain;

import java.util.ArrayList;
import java.util.List;


public class CatalogoVoluntarios {
	
	private List<Voluntario> catVoluntarios = new ArrayList<>();
	
	public Voluntario getVoluntario(int contacto) {
		for (Voluntario v : catVoluntarios) {
			if (v.getContacto() == contacto) {
				return v;
			}
		}
		Voluntario newVoluntario = new Voluntario(contacto);
		catVoluntarios.add(newVoluntario);
		return newVoluntario;
	}
}
