package com.projetosoftwareteusz.teusz.controller;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetosoftwareteusz.teusz.dto.CriarPedidoRequest;
import com.projetosoftwareteusz.teusz.entities.Pedido;
import com.projetosoftwareteusz.teusz.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody CriarPedidoRequest request) {
        
        Pedido novoPedido = pedidoService.criarPedido(request.getTipo(), request.getItens());
        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoPorId(@PathVariable Integer id) {
        
        Optional<Pedido> pedido = pedidoService.buscarPorId(id);

        return pedido.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


}
