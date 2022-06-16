package migrantmatcher.controllers;

import java.util.List;

import com.pidgeonsmssender.sdk.PidgeonSMSSender;

import migrantmatcher.domain.Ajuda;
import migrantmatcher.domain.CatalogoAlojamentos;
import migrantmatcher.domain.CatalogoItens;
import migrantmatcher.domain.CatalogoMigrantes;
import migrantmatcher.domain.Familia;
import migrantmatcher.domain.ListaRegioes;
import migrantmatcher.domain.Membro;
import migrantmatcher.domain.Migrante;
import migrantmatcher.domain.Regiao;
import migrantmatcher.exceptions.AjudaNaoDefinidaException;
import migrantmatcher.exceptions.RegiaoNaoDisponivelException;
import migrantmatcher.strategies.OrdenaAjudasStrategy;

public class ProcuraAjudaHandler extends Handler {

	private CatalogoMigrantes cm;
	private CatalogoAlojamentos cal;
	private CatalogoItens ci;
	private ListaRegioes lr;
	
//	private static ProcuraAjudaHandler INSTANCE = new ProcuraAjudaHandler();
//
//	public static ProcuraAjudaHandler getInstance() {
//		return INSTANCE;
//	}
//	
//	protected ProcuraAjudaHandler() {
//		
//	}
//	
//	public ProcuraAjudaHandler() {
//		
//	}
	
	public ProcuraAjudaHandler(CatalogoMigrantes catMigrantes, CatalogoItens catItens, CatalogoAlojamentos catAloj, ListaRegioes lr) {
		this.cm = catMigrantes;
		this.ci = catItens;
		this.cal = catAloj;
		this.lr = lr;
	}

	public Migrante registaMigrante(String nome, int contacto) {
		Migrante mig = new Migrante(nome, contacto);
		cm.addMigrante(mig);	
		return mig;
	}

	public void registaFamilia(Familia f) {	
		cm.addFamilia(f);		
	}
	
	public void indicaDadosCasal(Familia f, String nome, int contacto) {
		f.setCC_nome(nome);
		f.setCC_contacto(contacto);	
	}
	
	public void indicaOutroMembro(Familia f, String nome) {
		f.addMembro(new Membro(nome));
	}

	public List<Regiao> pedeListaRegioesPossiveis() {
		return lr.getListaRegioes();	
	}

	public List<Ajuda> indicaRegiaoEscolhida(String regiao, List<Regiao> listaRegioes, OrdenaAjudasStrategy st) throws RegiaoNaoDisponivelException {		
		return st.ordenaAjudas(cal, ci, new Regiao(regiao));
	}
	
	public Ajuda escolheAjuda(String ajuda, List<Ajuda> listaAjudasPossiveis) throws AjudaNaoDefinidaException {
		
		Ajuda ajudaEscolhida = new Ajuda(ajuda);
		
		for (Ajuda a : listaAjudasPossiveis) {
			if (ajudaEscolhida.equalsAjuda(a)) {
				return ajudaEscolhida;
			}
		}
		
		throw new AjudaNaoDefinidaException();
	}

	public void confirmaPedidoAjuda(List<Ajuda> ajudasPedidas) {
		
		PidgeonSMSSender smsSender = new PidgeonSMSSender();
		ajudasPedidas.stream()
		.forEach(a -> smsSender.send(Integer.toString(a.getVoluntario().getContacto()), "Nova ajuda pretendida"));
		
	}	
}
