package com.casedesenvolvedor.casedesenvolvedor.support;


import java.io.BufferedReader;
import java.io.FileReader;

import com.casedesenvolvedor.casedesenvolvedor.model.Arquivo;
import com.casedesenvolvedor.casedesenvolvedor.model.Card;

public class LeitorCard {
	
	public static Arquivo lerArquivo(String caminho) {
		String linha = null;
		try {
			BufferedReader arquivoLeitura = new BufferedReader(new FileReader(caminho));
			linha = arquivoLeitura.readLine();
			
			arquivoLeitura.close();
		}catch(Exception exception){
			System.out.println("Nao foi possivel abrir o arquivo !!!");
		}
		if (linha != null) {
			return new Arquivo(caminho,linha);
		}
		return null;
	}
	
	public static Card retornarCard(String linha) {
		if(linha.charAt(0) == '0') {//UflaCard
			return lerCardUfla(linha);
		}else { //FagammonCard
			return lerCardFagammon(linha);
		}
	}
	
	
	
	/*A funcao lerCardFagammon, a partir de uma string recebida por parametro retorna 
	 *um objeto CARD.
	 */
	public static Card lerCardFagammon(String card) {
		String data = card.substring(1, 8);
		String numeroEstabelecimento = card.substring(9, 16);
		String constanteInstituicao = card.substring(17, 28);
		String numeroSequencial = card.substring(29,35);
		Card newCard = new Card(data,numeroEstabelecimento,constanteInstituicao,numeroSequencial,card);
		return newCard;
	}
	
	/*A funcao lerCardUfla, a partir de uma string recebida por parametro retorna 
	 *um objeto CARD.
	 */
	public static Card lerCardUfla(String card) {
		String numeroEstabelecimento = card.substring(1, 10);
		String data = card.substring(11,18);
		String periodoInicial = card.substring(19, 26);
		String periodoFinal = card.substring(27, 34);
		String numeroSequencial = card.substring(35,41);
		String constanteInstituicao = card.substring(42, 49);
		Card newCard = new Card(numeroEstabelecimento,data,periodoInicial,periodoFinal,numeroSequencial,constanteInstituicao,card);
		return newCard;
	}
}