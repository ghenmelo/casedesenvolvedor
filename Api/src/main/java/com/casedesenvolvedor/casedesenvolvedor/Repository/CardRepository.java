package com.casedesenvolvedor.casedesenvolvedor.Repository;


//	
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.casedesenvolvedor.casedesenvolvedor.Model.Card;
@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
	@Query("SELECT cardPrimitivo FROM Card c WHERE c.codigo >= 0") List<String> findAllCardsPrimitives();
}
