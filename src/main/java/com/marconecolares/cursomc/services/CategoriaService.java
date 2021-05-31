package com.marconecolares.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marconecolares.cursomc.domain.Categoria;
import com.marconecolares.cursomc.repositories.CategoriaRepository;
import com.marconecolares.cursomc.services.exceptions.ObjectNotFoundException;



@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		 Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!" + id + 
				" " + Categoria.class.getName()));
		}

	
	
}
