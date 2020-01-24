package com.casedesenvolvedor.casedesenvolvedor.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.casedesenvolvedor.casedesenvolvedor.BackupStorage;
import com.casedesenvolvedor.casedesenvolvedor.LeitorCard;
import com.casedesenvolvedor.casedesenvolvedor.model.Arquivo;
import com.casedesenvolvedor.casedesenvolvedor.model.Card;
import com.casedesenvolvedor.casedesenvolvedor.repository.CardRepository;
import com.mysql.cj.log.Log;

@Controller
public class CardController {
	
	@Autowired
	private CardRepository  crud;
	
	
	@RequestMapping(value = "/")
	public String beginScreen() {
		return "beginScreen";
	}
	
	@RequestMapping(value = "/viewCards" , method = RequestMethod.GET)
	public ModelAndView viewCards() {
		ModelAndView mv = new ModelAndView("/viewCards");
		List<Card> list = crud.findAll();
		Map<String, List<Card>> valores = new HashMap<>();
		valores.put("Arquivo", list);
		mv.addAllObjects(valores);	
		return mv;
	}
	
	@RequestMapping(value = "/cardsRecepcionados", method = RequestMethod.GET)
	public ModelAndView cardsRecepcionados() {
		List<Arquivo> listArq = BackupStorage.arquivosStorage();
		ModelAndView mv = new ModelAndView("/cardsRecepcionados");
		Map<String,List<Arquivo>> mapa = new HashMap<String,List<Arquivo>>();
		List<Arquivo> tempList = new ArrayList<Arquivo>();
		List<String> c = crud.findAllCardsPrimitives();
		for (Arquivo arq : listArq) {
			if (c != null &&  c.contains(arq.getCard())){
				arq.setRecepcionado("sim");
				tempList.add(arq);
			}else {
				tempList.add(arq);
			}
		}
		mapa.put("Arquivo", tempList);
		mv.addAllObjects(mapa);
		return mv;
	}
	
	@RequestMapping(value = "/cardsRecepcionados", method = RequestMethod.POST)
	public String recepcionarCard(String card) {
		Card newCard = LeitorCard.retornarCard(card);
		try {
			crud.save(newCard);
		}catch(DataAccessException ex){
			return "redirect:/";
		}
		return "redirect:/cardsRecepcionados";
	}
	
	
	
}
