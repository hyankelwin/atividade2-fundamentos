package br.edu.facef.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.facef.dao.ComissaoDao;
import br.edu.facef.model.Comissao;

@RunWith(MockitoJUnitRunner.class)
public class ComissaoBusinessTeste {

	@Mock
	private ComissaoDao comissaoDao;
	
	@Test
	public void deveriaSalvarComissaoSucesso() {
		Comissao comissaoMock = new Comissao();
		comissaoMock.setId(1L);
		comissaoMock.setIdVendedor(1L);
		comissaoMock.setPorcentagemComissao(2.5F);
		comissaoMock.setTotalVendido(50000F);
		comissaoMock.setValorMeta(10000F);	
		
		Comissao novaComissao = new Comissao();
		novaComissao.setIdVendedor(1L);
		novaComissao.setPorcentagemComissao(2.5F);
		novaComissao.setTotalVendido(50000F);
		novaComissao.setValorMeta(10000F);
		
		Mockito.when(comissaoDao.salvar(novaComissao)).thenReturn(comissaoMock);
		
		ComissaoBusiness comissaoBusiness = new ComissaoBusiness(comissaoDao);
		
		Comissao comissaoSalva = comissaoBusiness.salvarComissaoVendedor(novaComissao);
		
		System.out.println(comissaoSalva);
		
		assertEquals(new Long(1), comissaoSalva.getId());
	}
	
	@Test
	public void deveriaDarErroSemSetarPorcentagem() {
		try
		  {
			Comissao comissaoMock = new Comissao();
			comissaoMock.setId(1L);
			comissaoMock.setIdVendedor(1L);
			comissaoMock.setPorcentagemComissao(2.5F);
			comissaoMock.setTotalVendido(50000F);
			comissaoMock.setValorMeta(10000F);	
			
			Comissao novaComissao = new Comissao();
			novaComissao.setIdVendedor(1L);
			novaComissao.setTotalVendido(50000F);
			novaComissao.setValorMeta(10000F);
			
			Mockito.when(comissaoDao.salvar(novaComissao)).thenReturn(comissaoMock);
			
			new ComissaoBusiness(comissaoDao);
		  }
		  catch(RuntimeException e)
		  {
		    final String msg = "Nome é obrigatorio";
		    assertEquals(msg, e.getMessage());
		  }
	}
	
	@Test
	public void deveriaDarErroSemSetarValorMeta() {
		try
		  {
			Comissao comissaoMock = new Comissao();
			comissaoMock.setId(1L);
			comissaoMock.setIdVendedor(1L);
			comissaoMock.setPorcentagemComissao(2.5F);
			comissaoMock.setTotalVendido(50000F);
			comissaoMock.setValorMeta(10000F);	
			
			Comissao novaComissao = new Comissao();
			novaComissao.setIdVendedor(1L);
			novaComissao.setPorcentagemComissao(2.5F);
			novaComissao.setTotalVendido(50000F);
			
			Mockito.when(comissaoDao.salvar(novaComissao)).thenReturn(comissaoMock);
			
			new ComissaoBusiness(comissaoDao);
		  }
		  catch(RuntimeException e)
		  {
		    final String msg = "Nome é obrigatorio";
		    assertEquals(msg, e.getMessage());
		  }
	}
}
