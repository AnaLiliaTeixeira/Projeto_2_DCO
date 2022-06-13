package migrantmatcher.domain;

import java.util.ArrayList;
import java.util.List;

public class ListaAjudas {

	private List<Ajuda> la = new ArrayList<>();

	public void addAjuda(Ajuda a) {
		la.add(a);
	}

	public List<Ajuda> getListaAjudasPossiveis(Regiao regiao) {

		List<Ajuda> listaAjudasPossiveis = new ArrayList<>();
		for (Ajuda a : la) {
			if (a.getClass().getSimpleName().equals("Alojamento")) {
				if (!((Alojamento) a).getRegiao().equals(regiao)) {
					//Do nothing
				}
			}
			listaAjudasPossiveis.add(a);
		}
		return listaAjudasPossiveis;
	}

	public List<Ajuda> getListaAjudas() {
		return la;
	}
}
