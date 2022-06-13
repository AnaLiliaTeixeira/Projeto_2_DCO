package migrantmatcher.controllers;

import java.util.List;

import migrantmatcher.domain.Ajuda;
import migrantmatcher.domain.CatalogoMigrantes;
import migrantmatcher.domain.Familia;
import migrantmatcher.domain.ListaAjudas;
import migrantmatcher.domain.ListaRegioes;
import migrantmatcher.domain.Membro;
import migrantmatcher.domain.Migrante;
import migrantmatcher.domain.Regiao;

public class ProcuraAjudaHandler {

	private CatalogoMigrantes cm = new CatalogoMigrantes();
	private ListaRegioes lr = new ListaRegioes();

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

	public ListaAjudas indicaRegiaoEscolhida(String regiao) {
		//temos que ver se existe na lr?
		return null;
	}
	
	public Ajuda escolheAjuda(String ajuda) {
		//aqui será a mesma cena? NAO SEI??
		return null;
	}

	public void confirmaPedidoAjuda() {
		// TODO Auto-generated method stub
		
	}


	
}
