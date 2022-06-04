package migrantmatcher.controllers;

import java.util.List;

import migrantmatcher.domain.CatalogoAlojamentos;
import migrantmatcher.domain.CatalogoItens;
import migrantmatcher.domain.CatalogoVoluntarios;
import migrantmatcher.domain.ListaRegioes;
import migrantmatcher.domain.Regiao;
import migrantmatcher.domain.Voluntario;
import migrantmatcher.exceptions.RegiaoNaoDisponivelException;

public class RegistaAjudaHandler {
	private CatalogoVoluntarios catVoluntarios;
	private ListaRegioes lr;
	private CatalogoAlojamentos cal;
	private CatalogoItens catItens;
	
	public RegistaAjudaHandler(CatalogoVoluntarios catVoluntarios) {
		this.catVoluntarios = catVoluntarios;
	}

	public Voluntario identificaVoluntario(int contacto) { // 1
		return catVoluntarios.getVoluntario(contacto);
	}

	public List<Regiao> indicaNumeroPessoas(int numero) {	
		return lr.getListaRegioes();
	}

	public Regiao indicaRegiao(String nomeRegiao) throws RegiaoNaoDisponivelException{
		return lr.getListaRegioes()
			.stream()
			.filter(regiao -> regiao.getRegiao().equals(nomeRegiao))
			.findFirst()
			.orElseThrow();
	}

	public void indicaDescricaoItem(String descricao) {
		catItens.addItem(descricao);
	}

	public void confirmaAjuda(int codigo_indicado, int codigo_unico) {
		if (codigo_indicado == codigo_unico) {
			//TODO
		}
	}
}
