package com.edmilson.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edmilson.cursomc.domain.Pagamento;

//tenho que colocar qual sera a classe que quero obter e qual é o tipo do identificador da categoria

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
