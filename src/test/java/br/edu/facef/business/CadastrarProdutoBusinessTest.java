package br.edu.facef.business;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.facef.dao.ProdutoDao;
import br.edu.facef.model.Produto;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarProdutoBusinessTest {
	
	@Mock
	private ProdutoDao ProdutoDao;

	@Test
	public void deveriaCadastrarProdutoSucesso() {
		Produto ProdutoMock = new Produto();
		ProdutoMock.setId(111L);
		ProdutoMock.setNome("Geladeira Consul");
		ProdutoMock.setCodigo("123");
		ProdutoMock.setValor(20.00);
		
		Produto novoProduto = new Produto();
		novoProduto.setNome("Jose da silva");
		novoProduto.setCodigo("123");
		novoProduto.setValor(20.00);
		
		Mockito.when(ProdutoDao.cadastrar(novoProduto)).thenReturn(ProdutoMock);
		
		CadastrarProdutoBusiness produtoBusiness = new CadastrarProdutoBusiness(ProdutoDao);
				
		Produto ProdutoSalvo = produtoBusiness.cadastrarProduto(novoProduto);
		
		System.out.println(ProdutoSalvo);
		
		assertEquals(new Long(111), ProdutoSalvo.getId());
	}
	
	@Test
	public void deveriaDarErroNomeNuloCadastrarProduto() {
		try
		  {
			Produto ProdutoMock = new Produto();
			ProdutoMock.setId(111L);
			ProdutoMock.setCodigo("123");
			ProdutoMock.setValor(20.00);
			
			Produto novoProduto = new Produto();
			novoProduto.setCodigo("123");
			novoProduto.setValor(20.00);
			
			Mockito.when(ProdutoDao.cadastrar(novoProduto)).thenReturn(ProdutoMock);
			
			new CadastrarProdutoBusiness(ProdutoDao);
		  }
		  catch(RuntimeException e)
		  {
		    final String msg = "Nome do produto é obrigatorio";
		    assertEquals(msg, e.getMessage());
		  }
	}
	
	@Test
	public void deveriaDarErroSemProdutoAoCadastrarProduto() {
		try
		  {
		    Produto ProdutoMock = new Produto();
			
			Produto novoProduto = new Produto();
			
			Mockito.when(ProdutoDao.cadastrar(novoProduto)).thenReturn(ProdutoMock);
			
			new CadastrarProdutoBusiness(ProdutoDao);
		  }
		  catch(RuntimeException e)
		  {
		    final String msg = "Produto é obrigatorio";
		    assertEquals(msg, e.getMessage());
		  }
	}
}
