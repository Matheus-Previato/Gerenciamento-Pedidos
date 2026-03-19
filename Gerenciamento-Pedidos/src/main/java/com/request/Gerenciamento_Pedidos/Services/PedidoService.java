package com.request.Gerenciamento_Pedidos.Services;

import com.request.Gerenciamento_Pedidos.Models.PedidoModel;
import com.request.Gerenciamento_Pedidos.Repositories.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public PedidoModel salvar(PedidoModel pedido) {
        return repository.save(pedido);
    }

    public List<PedidoModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<PedidoModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}