package br.edu.facef.business;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.facef.dao.ClienteDao;
import br.edu.facef.model.Cliente;

@RunWith(MockitoJUnitRunner.class)
public class ClienteBusinessTest {
	
	@Mock
	private ClienteDao clienteDao;

	@Test
	public void deveriaSalvarClienteSucesso() {
		Cliente clienteMock = new Cliente();
		clienteMock.setId(111L);
		clienteMock.setNome("Maria da silva");
		clienteMock.setCidade("Monto santo de minas");
		clienteMock.setEstado("MG");
		
		Cliente novoCliente = new Cliente();
		novoCliente.setNome("Jose da silva");
		novoCliente.setEstado("SP");
		novoCliente.setCidade("Franca City");
		
		Mockito.when(clienteDao.salvar(novoCliente)).thenReturn(clienteMock);
		
		ClienteBusiness clienteBusiness = new ClienteBusiness(clienteDao);
				
		Cliente clienteSalvo = clienteBusiness.salvarCliente(novoCliente);
		
		System.out.println(clienteSalvo);
		
		assertEquals(new Long(111), clienteSalvo.getId());
	}
	
	@Test
	public void deveriaDarErroNomeNuloSalvarCliente() {
		try
		  {
		    Cliente clienteMock = new Cliente();
			clienteMock.setId(111L);
			clienteMock.setCidade("Monto santo de minas");
			clienteMock.setEstado("MG");
			
			Cliente novoCliente = new Cliente();
			novoCliente.setEstado("SP");
			novoCliente.setCidade("Franca City");
			
			Mockito.when(clienteDao.salvar(novoCliente)).thenReturn(clienteMock);
			
			new ClienteBusiness(clienteDao);
		  }
		  catch(RuntimeException e)
		  {
		    final String msg = "Nome é obrigatorio";
		    assertEquals(msg, e.getMessage());
		  }
	}
	
	@Test
	public void deveriaDarErroSemClienteAoSalvarCliente() {
		try
		  {
		    Cliente clienteMock = new Cliente();
			
			Cliente novoCliente = new Cliente();
			
			Mockito.when(clienteDao.salvar(novoCliente)).thenReturn(clienteMock);
			
			new ClienteBusiness(clienteDao);
		  }
		  catch(RuntimeException e)
		  {
		    final String msg = "Cliente é obrigatorio";
		    assertEquals(msg, e.getMessage());
		  }
	}
}
