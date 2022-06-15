package migrantmatcher.strategies;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import migrantmatcher.domain.Ajuda;
import migrantmatcher.domain.CatalogoAlojamentos;
import migrantmatcher.domain.CatalogoItens;

public class OrdenaAjudasPorDataDeDisponibilizacao implements OrdenaAjudasStrategy {

	List<Ajuda> listaAjudas = new ArrayList<>();
	@Override
	public List<Ajuda> ordenaAjudas(CatalogoAlojamentos catAloj, CatalogoItens catItens) {
			
		listaAjudas.addAll(catAloj.getCatalogoAlojamentos());
		listaAjudas.addAll(catItens.getCatalogoItens());
		listaAjudas.sort(Comparator.comparing(Ajuda::getCreatedTime));
		//listaAjudas.sort((a1, a2) -> ((Ajuda) a1).getCreatedTime().compareTo(((Ajuda) a2).getCreatedTime()));
		
		return listaAjudas;
	}

}
