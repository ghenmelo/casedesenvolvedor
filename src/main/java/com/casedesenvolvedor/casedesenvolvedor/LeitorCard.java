package com.casedesenvolvedor.casedesenvolvedor;


import java.io.BufferedReader;
import java.io.FileReader;

import com.casedesenvolvedor.casedesenvolvedor.model.Card;

public class LeitorCard {
	
	public void lerArquivo() {
		String nomeArquivo = "nomeArquivo.txt";
		Card newCard = null;
		try {
			BufferedReader arquivoLeitura = new BufferedReader(new FileReader(nomeArquivo));
			String linha = arquivoLeitura.readLine();
			if(linha.charAt(0) == '0') {//UflaCard
				newCard = lerCardUfla(linha);
			}else { //FagammonCard
				newCard = lerCardFagammon(linha);
			}
			arquivoLeitura.close();
		}catch(Exception exception){
			System.out.println("Nao foi possivel abrir o arquivo !!!");
		}
	}
	/*A funcao lerCardFagammon, a partir de uma string recebida por parametro retorna 
	 *um objeto CARD.
	 */
	public Card lerCardFagammon(String card) {
		String data = card.substring(1, 8);
		String numeroEstabelecimento = card.substring(9, 16);
		String constanteInstituicao = card.substring(17, 28);
		String numeroSequencial = card.substring(29,35);
		Card newCard = new Card(data,numeroEstabelecimento,constanteInstituicao,numeroSequencial);
		return newCard;
	}
	
	/*A funcao lerCardUfla, a partir de uma string recebida por parametro retorna 
	 *um objeto CARD.
	 */
	public Card lerCardUfla(String card) {
		String numeroEstabelecimento = card.substring(1, 10);
		String data = card.substring(11,18);
		String periodoInicial = card.substring(19, 26);
		String periodoFinal = card.substring(27, 34);
		String numeroSequencial = card.substring(35,41);
		String constanteInstituicao = card.substring(42, 49);
		Card newCard = new Card(data,numeroEstabelecimento,constanteInstituicao,numeroSequencial);
		return newCard;
	}
}
