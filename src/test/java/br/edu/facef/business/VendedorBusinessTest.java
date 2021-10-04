package br.edu.facef.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.facef.dao.VendedorDao;
import br.edu.facef.model.Vendedor;

@RunWith(MockitoJUnitRunner.class)
public class VendedorBusinessTest {
	@Mock
	private VendedorDao vendedorDao;

	@Test
	public void deveriaSalvarClienteSucesso() {
		Vendedor vendedorMock = new Vendedor();
		vendedorMock.setId(1L);
		vendedorMock.setNome("Mária da Silva");
		vendedorMock.setSalario(2000F);
		vendedorMock.setCargo("Vendedora");
		
		Vendedor novoVendedor = new Vendedor();
		novoVendedor.setNome("Mária da Silva");
		novoVendedor.setSalario(2000F);
		novoVendedor.setCargo("Vendedora");
		
		Mockito.when(vendedorDao.salvar(novoVendedor)).thenReturn(vendedorMock);
		
		VendedorBusiness vendedorBusiness = new VendedorBusiness(vendedorDao);
				
		Vendedor vendedorSalvo = vendedorBusiness.salvarVendedor(novoVendedor);
		
		System.out.println(vendedorSalvo);
		
		assertEquals(new Long(1), vendedorSalvo.getId());
	}
	
	@Test
	public void deveriaDarErroCargoNuloSalvar() {
		try
		  {
			Vendedor vendedorMock = new Vendedor();
			vendedorMock.setId(1L);
			vendedorMock.setNome("Mária da Silva");
			vendedorMock.setSalario(2000F);
			vendedorMock.setCargo("Vendedora");
			
			Vendedor novoVendedor = new Vendedor();
			novoVendedor.setNome("Mária da Silva");
			novoVendedor.setSalario(2000F);
			
			Mockito.when(vendedorDao.salvar(novoVendedor)).thenReturn(vendedorMock);
			
			new VendedorBusiness(vendedorDao);
		  }
		  catch(RuntimeException e)
		  {
		    final String msg = "Cargo do vendedor obrigatório!";
		    assertEquals(msg, e.getMessage());
		  }
	}
	
	@Test
	public void deveriaDarErroVendedorNuloAoSalvar() {
		try
		  {
			Vendedor vendedorMock = new Vendedor();
			vendedorMock.setId(1L);
			vendedorMock.setNome("Mária da Silva");
			vendedorMock.setSalario(2000F);
			vendedorMock.setCargo("Vendedora");
			
			Vendedor novoVendedor = new Vendedor();
			
			Mockito.when(vendedorDao.salvar(novoVendedor)).thenReturn(vendedorMock);
			
			new VendedorBusiness(vendedorDao);
		  }
		  catch(RuntimeException e)
		  {
		    final String msg = "Não informado os dados do Vendedor!";
		    assertEquals(msg, e.getMessage());
		  }
	}
}
