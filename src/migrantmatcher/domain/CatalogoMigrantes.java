package migrantmatcher.domain;

import java.util.ArrayList;
import java.util.List;

public class CatalogoMigrantes {

	private List<Migrante> catMigrantes = new ArrayList<>();
	private List<Familia> catFamilias = new ArrayList<>();
		
	public void addMigrante(Migrante m) {
		catMigrantes.add(m);		
	}
	
	public void addFamilia(Familia f) {
		catFamilias.add(f);
	}
}
