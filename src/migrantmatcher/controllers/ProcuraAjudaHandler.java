package migrantmatcher.controllers;

import migrantmatcher.domain.CatalogoMigrantes;
import migrantmatcher.domain.ListaAjudas;
import migrantmatcher.domain.ListaRegioes;
import migrantmatcher.domain.Migrante;

public class ProcuraAjudaHandler {

	private CatalogoMigrantes cm = new CatalogoMigrantes();

	public void registaMigrante(String nome, int contacto) {
		cm.addMigrante(new Migrante(nome, contacto));		
	}

	public void registaFamilia(int numeroPessoas) {
		// TODO Auto-generated method stub
		
	}

	public ListaRegioes pedeListaRegioesPossiveis() {
		// TODO Auto-generated method stub
		
	}

	public ListaAjudas indicaRegiaoEscolhida(String regiao) {
		// TODO Auto-generated method stub
		return null;
	}

	public void confirmaPedidoAjuda() {
		// TODO Auto-generated method stub
		
	}
	
}
