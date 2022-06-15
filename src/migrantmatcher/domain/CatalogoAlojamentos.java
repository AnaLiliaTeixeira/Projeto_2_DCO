package migrantmatcher.domain;

import java.util.List;

public class CatalogoAlojamentos extends ListaAjudas{

	private List<Alojamento> catAloj;
	
	public void addAlojamento(Alojamento aloj) {
		catAloj.add(aloj);
	}
	
	public List<Alojamento> getCatalogoAlojamentos() {
		return catAloj;
	}
	
}
