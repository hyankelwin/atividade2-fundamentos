package br.edu.facef.business;

import br.edu.facef.dao.ProdutoDao;
import br.edu.facef.model.Produto;

public class CadastrarProdutoBusiness {
	
	private ProdutoDao produtoDao;
	
	public CadastrarProdutoBusiness(ProdutoDao dao) {
		this.produtoDao = dao;
	}
	
	public Produto cadastrarProduto(Produto produto) {
		if(produto == null) {
			throw new RuntimeException("Produto é obrigatorio");
		}
		
		if(produto.getNome() == null) {
			throw new RuntimeException("Nome do produto é obrigatorio");
		}
		
		return this.produtoDao.cadastrar(produto);
	}
}
