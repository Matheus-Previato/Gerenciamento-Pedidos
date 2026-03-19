package com.request.Gerenciamento_Pedidos.Controllers;

import com.request.Gerenciamento_Pedidos.Models.PedidoModel;
import com.request.Gerenciamento_Pedidos.Services.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    //Criar novo pedido (POST)
    @PostMapping
    public ResponseEntity<PedidoModel> criar(@RequestBody PedidoModel pedido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(pedido));
    }

    //Listar todos os pedidos (GET)
    @GetMapping
    public ResponseEntity<List<PedidoModel>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    //Buscar pedido por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<PedidoModel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Deletar pedido por ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}