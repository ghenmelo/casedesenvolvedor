package com.casedesenvolvedor.casedesenvolvedor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casedesenvolvedor.casedesenvolvedor.model.Card;
@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
	
}
