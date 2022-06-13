package migrantmatcher.domain;

import java.util.ArrayList;
import java.util.List;

public class ListaRegioes {

	private List<Regiao> lr = new ArrayList<>();
//	private String[] nutsII = {"NORTE", "ALGARVE", "CENTRO", "ÁREA_METROPOLITANA_DE_LISBOA",
//			"ALENTEJO", "REGIÃO_AUTÓNOMA_DOS_AÇORES", "REGIÃO_AUTÓNOMA_DA_MADEIRA"};
	
	public ListaRegioes() {
		for (Regioes r : Regioes.values()) {
			lr.add(setRegiao(r.toString()));
			//lr.add(setRegiao(s));
		}
	}
	
	public List<Regiao> getListaRegioes() {
		return lr;
	}
	
	public Regiao setRegiao(String regiao) {
		return new Regiao(regiao);
	}
}
