package migrantmatcher;

import migrantmatcher.controllers.CatalogoHandlers;
import migrantmatcher.controllers.ProcuraAjudaHandler;
import migrantmatcher.controllers.RegistaAjudaHandler;
import migrantmatcher.domain.CatalogoAlojamentos;
import migrantmatcher.domain.CatalogoItens;
import migrantmatcher.domain.CatalogoMigrantes;
import migrantmatcher.domain.CatalogoVoluntarios;
import migrantmatcher.domain.ListaRegioes;

public class MigrantMatcher {

	private CatalogoHandlers catHandlers = new CatalogoHandlers();
	private CatalogoVoluntarios catVoluntarios = new CatalogoVoluntarios();
	private CatalogoMigrantes catMigrantes = new CatalogoMigrantes();
	private CatalogoItens catItens = new CatalogoItens();
	private CatalogoAlojamentos catAloj = new CatalogoAlojamentos();
	private ListaRegioes lr = new ListaRegioes();
	
	public RegistaAjudaHandler getRegistaAjudaHandler() {
		RegistaAjudaHandler handler = new RegistaAjudaHandler(catVoluntarios, catItens, catAloj, lr);
		catHandlers.addHandler(handler);
		return handler;
	}
	
	public ProcuraAjudaHandler getProcuraAjudaHandler() {
		ProcuraAjudaHandler handler = new ProcuraAjudaHandler(catMigrantes, catItens, catAloj, lr);
		catHandlers.addHandler(handler);
		return handler;	
	}

	public CatalogoVoluntarios getCatalogoVoluntarios() {
		return catVoluntarios;
	}
	
	public CatalogoMigrantes getCatalogoMigrantes() {
		return catMigrantes;
	}
	
	public CatalogoAlojamentos getCatalogoAlojamentos() {
		return catAloj;
	}
	
	public CatalogoItens getCatalogoItens() {
		return catItens;
	}

	public ListaRegioes getListaRegioes() {
		return lr;
	}

	
	
}