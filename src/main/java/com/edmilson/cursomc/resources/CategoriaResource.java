package com.edmilson.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edmilson.cursomc.domain.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {

		Categoria cat1 = new Categoria(1, "Informatica");
		Categoria cat2 = new Categoria(2, "Veículos");
		
		List <Categoria> lista = new ArrayList<>();
		lista.add(cat2);
		lista.add(cat1);
	
		return lista;
	}

}