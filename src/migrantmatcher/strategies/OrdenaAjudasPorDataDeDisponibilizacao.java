package migrantmatcher.strategies;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import migrantmatcher.domain.Ajuda;
import migrantmatcher.domain.Alojamento;
import migrantmatcher.domain.CatalogoAlojamentos;
import migrantmatcher.domain.CatalogoItens;
import migrantmatcher.domain.Regiao;

public class OrdenaAjudasPorDataDeDisponibilizacao implements OrdenaAjudasStrategy {

	List<Ajuda> listaAjudas = new ArrayList<>();
	
	@Override
	public List<Ajuda> ordenaAjudas(CatalogoAlojamentos catAloj, CatalogoItens catItens, Regiao regiao) {
			
		List<Alojamento> lAloj = catAloj.getListaAlojamentos().stream()
				.filter(r -> r.getRegiao().equalsRegiao(regiao)).collect(Collectors.toList());
		
		listaAjudas.addAll(lAloj);
		listaAjudas.addAll(catItens.getListaItens());
		listaAjudas.sort(Comparator.comparing(Ajuda::getCreatedTime));
		
		return listaAjudas;
	}

}
