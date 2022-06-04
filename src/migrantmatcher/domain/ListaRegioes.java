package migrantmatcher.domain;

import java.util.ArrayList;
import java.util.List;

public class ListaRegioes {

	private List<Regiao> lr = new ArrayList<>();
	private String[] nutsII = {"NORTE", "ALGARVE", "CENTRO", "ÁREA_METROPOLITANA_DE_LISBOA",
			"ALENTEJO", "REGIÃO_AUTÓNOMA_DOS_AÇORES", "REGIÃO_AUTÓNOMA_DA_MADEIRA"};
	
	
	public List<Regiao> getListaRegioes() {
		for (String s : nutsII) {
			lr.add(setRegiao(s));
		}
		return lr;
	}
	
	public Regiao setRegiao(String regiao) {
		return new Regiao(regiao);
	}
}
