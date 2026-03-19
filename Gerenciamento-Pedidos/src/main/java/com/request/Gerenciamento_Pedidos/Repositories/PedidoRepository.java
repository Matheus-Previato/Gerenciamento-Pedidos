package com.request.Gerenciamento_Pedidos.Repositories;

import com.request.Gerenciamento_Pedidos.Models.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {

}