package com.projetosoftwareteusz.teusz.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetosoftwareteusz.teusz.Logistica.ILogistica;
import com.projetosoftwareteusz.teusz.Logistica.LogisticaAdapter;
import com.projetosoftwareteusz.teusz.config.ConfiguracaoSistema;
import com.projetosoftwareteusz.teusz.dto.CriarPedidoRequest;
import com.projetosoftwareteusz.teusz.entities.ItemPedido;
import com.projetosoftwareteusz.teusz.entities.Pedido;
import com.projetosoftwareteusz.teusz.entities.StatusPedido;
import com.projetosoftwareteusz.teusz.entities.TipoPedido;
import com.projetosoftwareteusz.teusz.factory.PedidoFactory;
import com.projetosoftwareteusz.teusz.pedido.IPedido;
import com.projetosoftwareteusz.teusz.repository.PedidoRepository;

@Service
public class PedidoService {

    private final PedidoFactory pedidoFactory;
    private final ILogistica logisticaService;
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoFactory pedidoFactory, ILogistica logisticaService, PedidoRepository pedidoRepository) {
        this.pedidoFactory = pedidoFactory;
        this.logisticaService = logisticaService;
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido criarPedido(CriarPedidoRequest request) {
        TipoPedido tipo = request.getTipo();
        if (tipo == null) {
            throw new org.springframework.web.server.ResponseStatusException(
                org.springframework.http.HttpStatus.BAD_REQUEST,
                "Campo 'tipo' é obrigatório (COMUM ou EXPRESSO)"
            );
        }
        Pedido novoPedido = new Pedido();
        novoPedido.setDataCriacao(new Date());
        novoPedido.setStatus(StatusPedido.NOVO);
        novoPedido.setItens(request.getItens());
        Pedido pedidoSalvo = pedidoRepository.save(novoPedido);
        IPedido estrategiaPedido = pedidoFactory.criarPedido(tipo);
        estrategiaPedido.processarPedido(pedidoSalvo);

        pedidoSalvo.setStatus(StatusPedido.EM_PROCESSAMENTO);
        pedidoRepository.save(pedidoSalvo);

        logisticaService.enviar(pedidoSalvo);
        pedidoSalvo.setStatus(StatusPedido.PRONTO);
        return pedidoRepository.save(pedidoSalvo);
    }

    public Optional<Pedido> buscarPorId(Integer id) {
        return pedidoRepository.findById(id);
    }

}
