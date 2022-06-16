package migrantmatcher.strategies;

import java.util.List;

import migrantmatcher.domain.Ajuda;
import migrantmatcher.domain.CatalogoAlojamentos;
import migrantmatcher.domain.CatalogoItens;
import migrantmatcher.domain.Regiao;

public interface OrdenaAjudasStrategy {
	
	public List<Ajuda> ordenaAjudas(CatalogoAlojamentos catAloj, CatalogoItens catItens, Regiao regiao);

}
