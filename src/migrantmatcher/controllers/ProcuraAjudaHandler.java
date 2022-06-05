package migrantmatcher.controllers;

import java.util.List;

import migrantmatcher.domain.Ajuda;
import migrantmatcher.domain.CatalogoMigrantes;
import migrantmatcher.domain.ListaAjudas;
import migrantmatcher.domain.ListaMembros;
import migrantmatcher.domain.ListaRegioes;
import migrantmatcher.domain.Membro;
import migrantmatcher.domain.Migrante;
import migrantmatcher.domain.Regiao;

public class ProcuraAjudaHandler {

	private CatalogoMigrantes cm = new CatalogoMigrantes();
	private ListaRegioes lr = new ListaRegioes();
	private ListaMembros lm = new ListaMembros();

	public void registaMigrante(String nome, int contacto) {
		cm.addMigrante(new Migrante(nome, contacto));		
	}

	public void registaFamilia(int numeroPessoas) {
		// TODO Auto-generated method stub
		
	}
	
	public void indicaDadosCasal(String nome, int contacto) {
		// TODO Auto-generated method stub
		
	}
	
	public void indicaOutroMembro(String nome) {
		lm.addOutroMembro(new Membro(nome));	
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
