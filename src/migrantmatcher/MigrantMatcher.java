package migrantmatcher;

import migrantmatcher.controllers.ProcuraAjudaHandler;
import migrantmatcher.controllers.RegistaAjudaHandler;
import migrantmatcher.domain.CatalogoAlojamentos;
import migrantmatcher.domain.CatalogoItens;
import migrantmatcher.domain.CatalogoMigrantes;
import migrantmatcher.domain.CatalogoVoluntarios;

public class MigrantMatcher {

	private CatalogoVoluntarios catVoluntarios = new CatalogoVoluntarios();
	private CatalogoItens catItens = new CatalogoItens();
	private CatalogoAlojamentos catAloj = new CatalogoAlojamentos();
	private CatalogoMigrantes catMigrantes = new CatalogoMigrantes();

	public RegistaAjudaHandler getRegistaAjudaHandler() {
		return new RegistaAjudaHandler(catVoluntarios, catItens, catAloj);
	}
	
	public ProcuraAjudaHandler getProcuraAjudaHandler() {
		return new ProcuraAjudaHandler(catMigrantes , catItens, catAloj);
	}

	public CatalogoItens getCatalogoItens() {
		return catItens;
	}
	
}