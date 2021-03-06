package com.edmilson.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edmilson.cursomc.domain.Categoria;
import com.edmilson.cursomc.domain.Cidade;
import com.edmilson.cursomc.domain.Cliente;
import com.edmilson.cursomc.domain.Endereco;
import com.edmilson.cursomc.domain.Estado;
import com.edmilson.cursomc.domain.Pagamento;
import com.edmilson.cursomc.domain.PagamentoComBoleto;
import com.edmilson.cursomc.domain.PagamentoComCartao;
import com.edmilson.cursomc.domain.Pedido;
import com.edmilson.cursomc.domain.Produto;
import com.edmilson.cursomc.domain.enums.EstadoPagamento;
import com.edmilson.cursomc.domain.enums.TipoCliente;
import com.edmilson.cursomc.repositories.CategoriaRepositry;
import com.edmilson.cursomc.repositories.CidadeRepository;
import com.edmilson.cursomc.repositories.ClienteRepository;
import com.edmilson.cursomc.repositories.EnderecoRepository;
import com.edmilson.cursomc.repositories.EstadoRepository;
import com.edmilson.cursomc.repositories.PagamentoRepository;
import com.edmilson.cursomc.repositories.PedidoRepository;
import com.edmilson.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepositry categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
		
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null,"mouse", 80.00);
		Produto p2 = new Produto(null,"impressora", 800.00);
		Produto p3 = new Produto(null,"Computador", 2000.00);
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "S??o Paulo");
		
		Cidade c1 = new Cidade(null, "Uberandia", est1);
		Cidade c2 = new Cidade(null, "S??o Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		Cliente cli1 = new Cliente (null,"Edmilson","missosouza@gmail.com","36616087115", TipoCliente.PESSOA_FISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("999233667","981254392"));
		
		Endereco e1 = new Endereco(null,"rua das Flores","300","Apto 202", "Jardim","3661125", cli1, c1);
		Endereco e2 = new Endereco(null,"Rua Anibal Pavao","3090","Casa", "Jardim Monaco","31261228", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));	
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null,sdf.parse("20/10/2017 10:32"),cli1, e1);
		
		Pedido ped2 = new Pedido(null,sdf.parse("20/10/2021 20:11"),cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO,ped1,6);
		Pagamento pagto2 = new PagamentoComBoleto
				(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("15/12/2019 16:35"),null);
		
		ped1.setPagamento(pagto1);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
	
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
			
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
	    
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
	}

}
