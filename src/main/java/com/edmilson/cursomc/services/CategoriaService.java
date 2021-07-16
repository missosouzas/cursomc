package com.edmilson.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edmilson.cursomc.domain.Categoria;
import com.edmilson.cursomc.repositories.CategoriaRepositry;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepositry repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
