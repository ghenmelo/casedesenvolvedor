package com.casedesenvolvedor.casedesenvolvedor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Card")
public class Card {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;
	
	private String numeroEstabelecimento;
	private String data;
	private String periodoInicial;
	private String periodoFinal;
	private String numeroSeqArquivo;
	private String constanteInstituicao;
	
	public Card (String numeroEstabelecimento,String data,String periodoInicial,String periodoFinal,String numeroSeqArquivo,String constanteInstituicao) { //UflaCard construtor
		this.numeroEstabelecimento = numeroEstabelecimento;
		this.data = data;
		this.periodoInicial = periodoInicial;
		this.periodoFinal = periodoFinal;
		this.numeroSeqArquivo = numeroSeqArquivo;
		this.constanteInstituicao = constanteInstituicao;
	}
	public Card (String data,String numeroEstabelecimento,String constanteInstituicao,String numeroSeqArquivo) { //FagammonCard construtor
		this.numeroEstabelecimento = numeroEstabelecimento;
		this.data = data;
		this.numeroSeqArquivo = numeroSeqArquivo;
		this.constanteInstituicao = constanteInstituicao;
	}
	
	public String getNumeroEstabelecimento() {
		return numeroEstabelecimento;
	}
	public void setNumeroEstabelecimento(String numeroEstabelecimento) {
		this.numeroEstabelecimento = numeroEstabelecimento;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getPeriodoInicial() {
		return periodoInicial;
	}
	public void setPeriodoInicial(String periodoInicial) {
		this.periodoInicial = periodoInicial;
	}
	public String getPeriodoFinal() {
		return periodoFinal;
	}
	public void setPeriodoFinal(String periodoFinal) {
		this.periodoFinal = periodoFinal;
	}
	public String getNumeroSeqArquivo() {
		return numeroSeqArquivo;
	}
	public void setNumeroSeqArquivo(String numeroSeqArquivo) {
		this.numeroSeqArquivo = numeroSeqArquivo;
	}
	public String getConstanteInstituicao() {
		return constanteInstituicao;
	}
	public void setConstanteInstituicao(String constanteInstituicao) {
		this.constanteInstituicao = constanteInstituicao;
	}
	
	public String retornarCard() {
		String retorno;
		if (this.getConstanteInstituicao() == "UflaCard") { // UflaCard
			retorno = "0" + this.getNumeroEstabelecimento() + this.getData() +
					this.getPeriodoInicial() + this.getPeriodoFinal() +
					this.getNumeroSeqArquivo() + this.getConstanteInstituicao();
			return retorno;
		}else { // FagammonCard
			retorno = "1" + this.getData()+ this.getNumeroEstabelecimento() +
					 this.getConstanteInstituicao() +this.getNumeroSeqArquivo() ;
			return retorno;
		}
	}
	
}
