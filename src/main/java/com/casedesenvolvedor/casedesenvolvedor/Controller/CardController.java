package com.casedesenvolvedor.casedesenvolvedor.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.casedesenvolvedor.casedesenvolvedor.model.Card;
import com.casedesenvolvedor.casedesenvolvedor.repository.CardRepository;

public class CardController {
	
	@Autowired
	CardRepository crud;
	
	public void salvarNovoCard(Card card) {
		crud.save(card);
	}
	
}
