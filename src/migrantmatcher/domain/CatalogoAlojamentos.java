package migrantmatcher.domain;

import java.util.ArrayList;
import java.util.List;

public class CatalogoAlojamentos {

	private List<Alojamento> catAloj = new ArrayList<>();
	
	public void addAlojamento(Alojamento aloj) {
		catAloj.add(aloj);
	}
	
	public List<Alojamento> getListaAlojamentos() {
		return catAloj;
	}	
}
