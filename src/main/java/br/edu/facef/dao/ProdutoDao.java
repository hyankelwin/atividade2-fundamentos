package br.edu.facef.dao;

import br.edu.facef.model.Produto;

public class ProdutoDao {
	
	public Produto cadastrar(final Produto produto) {
		produto.setId(999L);
		
		//TODO: chamar função salvar bd
		return produto;
	}

}