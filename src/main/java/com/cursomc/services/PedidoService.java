package com.cursomc.services;


import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cursomc.models.ItemPedido;
import com.cursomc.models.PagamentoComBoleto;
import com.cursomc.models.Pedido;
import com.cursomc.models.enums.EstadoPagamento;
import com.cursomc.repositories.ItemPedidoRepository;
import com.cursomc.repositories.PagamentoRepository;
import com.cursomc.repositories.PedidoRepository;
import com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	public Pedido findById(Integer id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setCliente(clienteService.findById(obj.getCliente().getId()));
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		
		// criando data de vencimento quando o pagamento é com boleto
		if(obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto =  (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		
		obj = pedidoRepository.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		
		// percorre todos os itens de pedido associado ao pedido
		for(ItemPedido x : obj.getItens()) {
			x.setDesconto(0.0);
			x.setProduto(produtoService.findById(x.getProduto().getId()));
			x.setPreco(x.getProduto().getPreco());
			x.setPedido(obj);
		}
		
		itemPedidoRepository.saveAll(obj.getItens());
		System.out.println(obj);
		return obj;
	}
}
