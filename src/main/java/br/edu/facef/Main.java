package br.edu.facef;

import br.edu.facef.business.ClienteBusiness;
import br.edu.facef.business.ComissaoBusiness;
import br.edu.facef.dao.ClienteDao;
import br.edu.facef.dao.ComissaoDao;
import br.edu.facef.model.Cliente;
import br.edu.facef.model.Comissao;

import br.edu.facef.business.CadastrarProdutoBusiness;
import br.edu.facef.dao.ProdutoDao;
import br.edu.facef.model.Produto;

import br.edu.facef.business.EfetuarVendaBusiness;
import br.edu.facef.dao.VendaDao;
import br.edu.facef.model.Venda;

public class Main {

	public static void main(String[] args) {
		// M�todo de Salvar Cliente
		
		System.out.println("--------- Salvar Cliente");
		
		Cliente novoCliente = new Cliente();
		
		novoCliente.setNome("Jose da silva");
		novoCliente.setEstado("SP");
		novoCliente.setCidade("Franca City");
		
		ClienteBusiness clienteBusiness = new ClienteBusiness(new ClienteDao());
		
		Cliente clienteSalvo =  clienteBusiness.salvarCliente(novoCliente);
		
		System.out.println("Cliente salvo: " + clienteSalvo);
				
		System.out.println("-------- Salvar Comiss�o");
		
		Comissao novaComissao = new Comissao();
		
		novaComissao.setIdVendedor(10L);
		novaComissao.setPorcentagemComissao(2.5F);
		novaComissao.setTotalVendido(5000F);
		novaComissao.setValorMeta(8000F);
		
		ComissaoBusiness comissaoBusiness = new ComissaoBusiness(new ComissaoDao());
		
		Comissao comissaoSalva = comissaoBusiness.salvarComissaoVendedor(novaComissao);
		
		System.out.println("Comissao salva: " + comissaoSalva);
		
		System.out.println("--------- cadastrar produto");
		
		Produto novoProduto = new Produto();
		
		novoProduto.setNome("Geladeira");
		novoProduto.setCodigo("123");
		novoProduto.setValor(20.0F);
		
		CadastrarProdutoBusiness produtoBusiness = new CadastrarProdutoBusiness(new ProdutoDao());
		
		Produto produtoCadastrado =  produtoBusiness.cadastrarProduto(novoProduto);
		
		System.out.println("Produto cadastrado: " + produtoCadastrado);
		
		System.out.println("--------- efetuar venda");
		
		Venda novoVenda = new Venda();
		
		novoVenda.setClienteId("111");
		novoVenda.setProduto("222");
		novoVenda.setTotal(50.00);
		
		EfetuarVendaBusiness efetuarVendaBusiness = new EfetuarVendaBusiness(new VendaDao());
		
		Venda vendaEfetuada =  efetuarVendaBusiness.efetuarVenda(novoVenda);
		
		System.out.println("Venda efetuada: " + vendaEfetuada);
	}

}
