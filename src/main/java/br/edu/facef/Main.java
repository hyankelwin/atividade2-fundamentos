package br.edu.facef;

import br.edu.facef.business.Calculos;
import br.edu.facef.business.ClienteBusiness;
import br.edu.facef.dao.ClienteDao;
import br.edu.facef.model.Cliente;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hello world!");	
		
		Calculos calculos = new Calculos();
		
		Integer soma = calculos.somar(2,3);
		
		System.out.println("Resultado da soma " + soma);
	
		System.out.println("--------- salvar cliente");
		
		Cliente novoCliente = new Cliente();
		
		novoCliente.setNome("Jose da silva");
		novoCliente.setEstado("SP");
		novoCliente.setCidade("Franca City");
		
		ClienteBusiness clienteBusiness = new ClienteBusiness(new ClienteDao());
		
		Cliente clienteSalvo =  clienteBusiness.salvarCliente(novoCliente);
		
		System.out.println("Cliente salvo: " + clienteSalvo);
		
	}

}
