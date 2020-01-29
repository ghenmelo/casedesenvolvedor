package com.casedesenvolvedor.casedesenvolvedor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "Card")
public class Card {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;
	
	@Column(unique=true)
	private String cardPrimitivo;
	
	public String getCardPrimitivo() {
		return cardPrimitivo;
	}
	public void setCardPrimitivo(String cardPrimitivo) {
		this.cardPrimitivo = cardPrimitivo;
	}
	public Card() {
		
	}
	
	@NotEmpty
	private String numeroEstabelecimento;
	@NotEmpty
	private String data;
	@Nullable
	private String periodoInicial;
	@Nullable
	private String periodoFinal;
	@NotEmpty
	private String numeroSeqArquivo;
	@NotEmpty
	private String constanteInstituicao;
	
	public Card (String numeroEstabelecimento,String data,String periodoInicial,String periodoFinal,String numeroSeqArquivo,String constanteInstituicao,String cardPrimitivo) { //UflaCard construtor
		this.numeroEstabelecimento = numeroEstabelecimento;
		this.data = data;
		this.periodoInicial = periodoInicial;
		this.periodoFinal = periodoFinal;
		this.numeroSeqArquivo = numeroSeqArquivo;
		this.constanteInstituicao = constanteInstituicao;
		this.cardPrimitivo = cardPrimitivo;
	}
	public Card (String data,String numeroEstabelecimento,String constanteInstituicao,String numeroSeqArquivo,String cardPrimitivo) { //FagammonCard construtor
		this.numeroEstabelecimento = numeroEstabelecimento;
		this.data = data;
		this.numeroSeqArquivo = numeroSeqArquivo;
		this.constanteInstituicao = constanteInstituicao;
		this.cardPrimitivo = cardPrimitivo;
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
	public long getCodigo() {
		return codigo;
	}
	
}

