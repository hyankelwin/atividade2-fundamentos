package br.edu.facef.business;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.facef.dao.ClienteDao;
import br.edu.facef.dao.VendaDao;
import br.edu.facef.model.Cliente;
import br.edu.facef.model.Venda;

@RunWith(MockitoJUnitRunner.class)
public class EfetuarVendaBusinessTest {
	
	@Mock
	private VendaDao vendaDao;

	@Test
	public void deveriaEfetuarVendaSucesso() {
		Venda vendaMock = new Venda();
		vendaMock.setId(111L);
		vendaMock.setClienteId("111");
		vendaMock.setProduto("222");
		vendaMock.setTotal(20.0F);
		
		Venda novaVenda = new Venda();
		novaVenda.setClienteId("111");
		novaVenda.setProduto("222");
		novaVenda.setTotal(20.0F);
		
		Mockito.when(vendaDao.efetuar(novaVenda)).thenReturn(vendaMock);
		
		EfetuarVendaBusiness efetuarVendaBusiness = new EfetuarVendaBusiness(vendaDao);
				
		Venda vendaEfetuada = efetuarVendaBusiness.efetuarVenda(novaVenda);
		
		System.out.println(vendaEfetuada);
		
		assertEquals(new Long(111), vendaEfetuada.getId());
	}
	
	@Test
	public void deveriaDarErroTotalNuloEfetuarVenda() {
		try
		  {
			Venda vendaMock = new Venda();
			vendaMock.setId(111L);
			vendaMock.setClienteId("111");
			vendaMock.setProduto("222");
			
			Venda novaVenda = new Venda();
			novaVenda.setClienteId("111");
			novaVenda.setProduto("222");
			
			Mockito.when(vendaDao.efetuar(novaVenda)).thenReturn(vendaMock);
			
			new EfetuarVendaBusiness(vendaDao);
		  }
		  catch(RuntimeException e)
		  {
		    final String msg = "Total da venda é obrigatorio";
		    assertEquals(msg, e.getMessage());
		  }
	}
	
	@Test
	public void deveriaDarErroSemVendaAoEfeutarVendaCliente() {
		try
		  {
		    Venda vendaMock = new Venda();
			
		    Venda novaVenda = new Venda();
			
			Mockito.when(vendaDao.efetuar(novaVenda)).thenReturn(vendaMock);
			
			new EfetuarVendaBusiness(vendaDao);
		  }
		  catch(RuntimeException e)
		  {
		    final String msg = "Informe os dados da venda";
		    assertEquals(msg, e.getMessage());
		  }
	}
}
