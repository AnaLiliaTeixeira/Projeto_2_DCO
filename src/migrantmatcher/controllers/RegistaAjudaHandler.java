package migrantmatcher.controllers;

import java.util.List;

import migrantmatcher.domain.Alojamento;
import migrantmatcher.domain.CatalogoAlojamentos;
import migrantmatcher.domain.CatalogoItens;
import migrantmatcher.domain.CatalogoVoluntarios;
import migrantmatcher.domain.Item;
import migrantmatcher.domain.ListaRegioes;
import migrantmatcher.domain.Regiao;
import migrantmatcher.domain.Voluntario;
import migrantmatcher.exceptions.RegiaoNaoDisponivelException;

public class RegistaAjudaHandler extends Handler {
	
	private CatalogoVoluntarios catVoluntarios;
	private CatalogoAlojamentos catAloj;
	private CatalogoItens catItens;
	private ListaRegioes lr;
	
	public RegistaAjudaHandler(CatalogoVoluntarios catVoluntarios, CatalogoItens catItens, CatalogoAlojamentos catAloj, ListaRegioes lr) {
		this.catVoluntarios = catVoluntarios;
		this.catItens = catItens;
		this.catAloj = catAloj;
		this.lr = lr;
	}

	public Voluntario identificaVoluntario(int contacto) {
		return catVoluntarios.getVoluntario(contacto);
	}

	public List<Regiao> indicaNumeroPessoas(int numero) {	
		return lr.getListaRegioes();
	}

	public Alojamento indicaRegiao(String nomeRegiao, List<Regiao> listaRegioes, int numeroPessoas, Voluntario vol) throws RegiaoNaoDisponivelException{					
		for (Regiao regiao : listaRegioes) {
			if (regiao.getRegiao().equals(nomeRegiao)) {
				Alojamento aloj = new Alojamento(numeroPessoas, regiao, vol);
				catAloj.addAlojamento(aloj);
				return aloj;
			}
		}
		throw new RegiaoNaoDisponivelException();
	}

	public Item indicaDescricaoItem(String descricao, Voluntario vol) {
		Item item = new Item(descricao, vol);
		catItens.addItem(item);
		return item;
	}

	public void confirmaAjuda(int codigo_indicado, int codigo_unico) {
		if (codigo_indicado == codigo_unico) {
			//TODO
		}
	}
	



}
