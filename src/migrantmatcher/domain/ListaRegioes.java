package migrantmatcher.domain;

import java.util.ArrayList;
import java.util.List;

public class ListaRegioes {

	private List<Regiao> lr = new ArrayList<>();
	
	public ListaRegioes() {
		for (Regioes r : Regioes.values()) {
			lr.add(setRegiao(r.toString()));
		}
	}
	
	public List<Regiao> getListaRegioes() {
		return lr;
	}
	
	public Regiao setRegiao(String regiao) {
		return new Regiao(regiao);
	}
}
