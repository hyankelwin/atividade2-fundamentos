package br.edu.facef;

import br.edu.facef.business.ClienteBusiness;
import br.edu.facef.business.ComissaoBusiness;
import br.edu.facef.dao.ClienteDao;
import br.edu.facef.dao.ComissaoDao;
import br.edu.facef.model.Cliente;
import br.edu.facef.model.Comissao;

public class Main {

	public static void main(String[] args) {
		// Método de Salvar Cliente
		
		System.out.println("--------- Salvar Cliente");
		
		Cliente novoCliente = new Cliente();
		
		novoCliente.setNome("Jose da silva");
		novoCliente.setEstado("SP");
		novoCliente.setCidade("Franca City");
		
		ClienteBusiness clienteBusiness = new ClienteBusiness(new ClienteDao());
		
		Cliente clienteSalvo =  clienteBusiness.salvarCliente(novoCliente);
		
		System.out.println("Cliente salvo: " + clienteSalvo);
		
		// Método de Salvar Comissão
		
		System.out.println("-------- Salvar Comissão");
		
		Comissao novaComissao = new Comissao();
		
		novaComissao.setIdVendedor(10L);
		novaComissao.setPorcentagemComissao(2.5F);
		novaComissao.setTotalVendido(5000F);
		novaComissao.setValorMeta(8000F);
		
		ComissaoBusiness comissaoBusiness = new ComissaoBusiness(new ComissaoDao());
		
		Comissao comissaoSalva = comissaoBusiness.salvarComissaoVendedor(novaComissao);
		
		System.out.println("Comissao salva: " + comissaoSalva);
	}

}
