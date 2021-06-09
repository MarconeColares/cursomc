package com.marconecolares.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marconecolares.cursomc.domain.Pedido;
import com.marconecolares.cursomc.repositories.PedidoRepository;
import com.marconecolares.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		 Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!" + id + 
				" " + Pedido.class.getName()));
		}
	
}