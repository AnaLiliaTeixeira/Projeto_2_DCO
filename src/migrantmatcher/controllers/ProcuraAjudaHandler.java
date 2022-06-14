package migrantmatcher.controllers;

import java.util.List;

import com.telegramsms.TelegramSMSSender;

import migrantmatcher.domain.Ajuda;
import migrantmatcher.domain.CatalogoMigrantes;
import migrantmatcher.domain.Familia;
import migrantmatcher.domain.ListaAjudas;
import migrantmatcher.domain.ListaRegioes;
import migrantmatcher.domain.Membro;
import migrantmatcher.domain.Migrante;
import migrantmatcher.domain.Regiao;
import migrantmatcher.exceptions.AjudaNaoDefinidaException;
import migrantmatcher.exceptions.RegiaoNaoDisponivelException;

public class ProcuraAjudaHandler {

	private CatalogoMigrantes cm = new CatalogoMigrantes();
	private ListaAjudas la = new ListaAjudas();
	private ListaRegioes lr = new ListaRegioes();
	private Regiao regiaoEscolhida;

	public void registaMigrante(String nome, int contacto) {
		cm.addMigrante(new Migrante(nome, contacto));		
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

	public List<Ajuda> indicaRegiaoEscolhida(String regiao, List<Regiao> listaRegioes) throws RegiaoNaoDisponivelException {
		
		Regiao regiaoEscolhida = new Regiao(regiao);
//		for (Regiao r : listaRegioes) {
//			if (regiaoEscolhida.equals(r)) {
//				this.regiaoEscolhida = regiaoEscolhida;
//			}
//		} */será necessário fazer isto?/*
		
		return la.getListaAjudasPossiveis(regiaoEscolhida);
	}
	
	public Ajuda escolheAjuda(String ajuda, List<Ajuda> listaAjudasPossiveis) throws AjudaNaoDefinidaException {
		
		Ajuda ajudaEscolhida = new Ajuda(ajuda);
		
		for (Ajuda a : listaAjudasPossiveis) {
			if (ajudaEscolhida.equals(a)) {
				return ajudaEscolhida;
			}
		}
		
		throw new AjudaNaoDefinidaException();
	}

	public void confirmaPedidoAjuda(List<Ajuda> ajudasNecessarias) {
		// TODO Auto-generated method stub
		TelegramSMSSender smsSender = new TelegramSMSSender();
		for (Ajuda a : ajudasNecessarias) {
			
		}
		
	}


	
}
