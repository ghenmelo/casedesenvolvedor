package com.casedesenvolvedor.casedesenvolvedor.model;



public class Arquivo{
	
	private String caminho;
	private String recepcionado;
	private String card;
	
	public Arquivo(String caminho,String card) {
		this.caminho = caminho;
		this.card = card;
		this.recepcionado = "nao";
	}
	

	public String getCaminho() {
		return caminho;
	}


	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}


	public void setCard(String cardPrimitivo) {
		this.card = cardPrimitivo;
	}


	public String getCard() {
		return card;
	}

	public String getRecepcionado() {
		return recepcionado;
	}

	public void setRecepcionado(String recepcionado) {
		this.recepcionado = recepcionado;
	}
	
}

	