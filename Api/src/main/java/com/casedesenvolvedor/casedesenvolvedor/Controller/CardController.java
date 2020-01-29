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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.casedesenvolvedor.casedesenvolvedor.model.Arquivo;
import com.casedesenvolvedor.casedesenvolvedor.model.Card;
import com.casedesenvolvedor.casedesenvolvedor.repository.CardRepository;
import com.mysql.cj.log.Log;

import com.casedesenvolvedor.casedesenvolvedor.support.BackupStorage;
import com.casedesenvolvedor.casedesenvolvedor.support.LeitorCard;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "URL base para todo URL mapeada no sistema "),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
@RestController
@RequestMapping(value = "/case")
@Api(value = "Case Desenvolvimento")
@CrossOrigin(origins = "*")
public class CardController {
	
	@Autowired
	private CardRepository  crud;
	
	
	@GetMapping(value = "/")
	@ApiOperation(value = "Retorna a string da tela inicial",produces="application/json")
	public String beginScreen() {
		return "beginScreen";
	}
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna uma lista de Card"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	@GetMapping(value = "/viewCards")
	@ApiOperation(value = "Retorna a lista de cards registrados no Banco de Dados",produces="application/json")
	public List<Card> viewCards() {
		List<Card> list = crud.findAll();
		return list;
	}
	
	@ApiOperation(value = "Retorna uma lista de Arquivos salvos no backUp")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Retorna uma lista de Arquivos"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping(value = "/cardsRecepcionados")
	public List<Arquivo> cardsRecepcionados() {
		List<Arquivo> listArq = BackupStorage.arquivosStorage();
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
		return tempList;
	}
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna uma lista de contagem de Recepcionados e nao recepcionados"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	@GetMapping(value = "/graficoRecepcionados")
	@ApiOperation(value = "Retorna a lista para montar o grafico",produces="application/json")
	public Integer[] graficoDeRecepcionados() {
		List<Arquivo> listArq = BackupStorage.arquivosStorage();
		List<String> c = crud.findAllCardsPrimitives();
		Integer[] contagem = new Integer[4];
		contagem[0] = 0;//Pos 1 ufla arquivo recepcionados 
		contagem[1] = 0;//pos 2 fagammon arquivo recepcionados
		contagem[2] = 0;//pos 3 ufla arquivo  nao recepcionados
		contagem[3] = 0;//pos 4 fagammon arquivo  nao recepcionados
		for (Arquivo arq : listArq) {
			if (c != null &&  c.contains(arq.getCard())){
				if (arq.getCard().contains("Ufla")){
					contagem[0] += 1;
				}else {
					contagem[1] += 1;
				}
			}else {
				if (arq.getCard().contains("Ufla")){
					contagem[2] += 1;
				}else {
					contagem[3] += 1;
				}
			}
		}
		return contagem;
	}
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Recebe como parametro uma card primitivo e cria um novo card adicionando no Banco de Dados"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	@PostMapping(value = "/cardsRecepcionados")
	@ApiOperation(value = "Retorna o card salvo no banco de dados",produces="application/json",consumes="application/json")
	public Card recepcionarCard(@RequestParam(value = "card") String card) {
		Card newCard = LeitorCard.retornarCard(card);
		return crud.save(newCard);
	}
	
	
	
}
