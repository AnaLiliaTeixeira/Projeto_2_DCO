package migrantmatcher.domain;

import java.util.ArrayList;
import java.util.List;

public class ListaAjudas {

	private List<Ajuda> la = new ArrayList<>();
	
	public void addAjuda(Ajuda a) {
		la.add(a);
	}
}
