package com.marconecolares.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.marconecolares.cursomc.domain.Categoria;
import com.marconecolares.cursomc.repositories.CategoriaRepository;
import com.marconecolares.cursomc.services.exceptions.DataIntegrityException;
import com.marconecolares.cursomc.services.exceptions.ObjectNotFoundException;



@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		 Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!" + id + 
				" " + Categoria.class.getName()));
		}

	
	public Categoria insert(Categoria obj) {
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
		}
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
}
