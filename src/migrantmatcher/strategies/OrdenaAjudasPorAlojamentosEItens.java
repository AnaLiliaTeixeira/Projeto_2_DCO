package migrantmatcher.strategies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import migrantmatcher.domain.Ajuda;
import migrantmatcher.domain.Alojamento;
import migrantmatcher.domain.CatalogoAlojamentos;
import migrantmatcher.domain.CatalogoItens;
import migrantmatcher.domain.Item;
import migrantmatcher.domain.Regiao;

public class OrdenaAjudasPorAlojamentosEItens implements OrdenaAjudasStrategy {

	private List<Ajuda> listaAjudas = new ArrayList<>();
	
	@Override
	public List<Ajuda> ordenaAjudas(CatalogoAlojamentos catAloj, CatalogoItens catItens, Regiao regiao) {
		
		List<Alojamento> lAloj = catAloj.getListaAlojamentos().stream()
				.filter(r -> r.getRegiao().equals(regiao)).collect(Collectors.toList());
		
		Collections.shuffle(lAloj);
		Collections.shuffle(catItens.getListaItens());
		
		for (Alojamento aloj : catAloj.getListaAlojamentos()) {
			listaAjudas.add(aloj);
		}
		
		for (Item item : catItens.getListaItens()) {
			listaAjudas.add(item);
		}
		
		return listaAjudas;
	}

}
