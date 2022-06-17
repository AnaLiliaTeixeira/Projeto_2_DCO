package migrantmatcher.domain;

import java.util.ArrayList;
import java.util.List;

public class CatalogoMigrantes {

	private List<PessoaMigrante> catMigrantes = new ArrayList<>();
		
	public void addMigrante(Migrante m) {
		catMigrantes.add(m);		
	}
	
	public void addFamilia(Familia f) {
		catMigrantes.add(f);
	}
	
	public List<PessoaMigrante> getCatMigrantes() {
		return catMigrantes;
	}
}
