package migrantmatcher.controllers;

import java.util.List;

import migrantmatcher.domain.Ajuda;
import migrantmatcher.domain.CatalogoMigrantes;
import migrantmatcher.domain.ListaAjudas;
import migrantmatcher.domain.ListaRegioes;
import migrantmatcher.domain.Migrante;
import migrantmatcher.domain.Regiao;

public class ProcuraAjudaHandler {

	private CatalogoMigrantes cm = new CatalogoMigrantes();
	private ListaRegioes lr = new ListaRegioes();

	public void registaMigrante(String nome, int contacto) {
		cm.addMigrante(new Migrante(nome, contacto));		
	}

	public void registaFamilia(int numeroPessoas) {
		// TODO Auto-generated method stub
		
	}

	public List<Regiao> pedeListaRegioesPossiveis() {
		return lr.getListaRegioes();
		
	}

	public ListaAjudas indicaRegiaoEscolhida(String regiao) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Ajuda escolheAjuda(String ajuda) {
		// TODO Auto-generated method stub
		return null;
	}

	public void confirmaPedidoAjuda() {
		// TODO Auto-generated method stub
		
	}

	
}
