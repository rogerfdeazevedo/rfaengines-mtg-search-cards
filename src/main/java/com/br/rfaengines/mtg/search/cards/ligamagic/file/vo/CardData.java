package com.br.rfaengines.mtg.search.cards.ligamagic.file.vo;

import java.util.ArrayList;
import java.util.List;

import com.br.rfaengines.mtg.search.cards.ligamagic.vo.Loja;

public class CardData {
	
	private String qtd;
	private String nameENGUS;
	private String nomePTBR;	
	private String color;
	private String manaCost;
	private String cmc;
	private String type;	
	private String texto;	
	private String efeitoQtd;
	private String efeitoDrawBackQtd;
	private String efeitoScore;
	private String efeitoPrincipal;
	private String efeitoOutros;
	private String edhCategoria;	
	private String tenhoQtd;
	private String comprar;	
	private String colecao;
	private String precoMenor;
	private String estado;
	private String lojaMenorPreco;
	private String dataPesquisa;	
	private List<Loja> lojas;
	
	public CardData() {
		this.qtd = "";
		this.nameENGUS = "";
		this.nomePTBR = "";
		this.color = "";
		this.manaCost = "";
		this.cmc = "";
		this.type = "";
		this.texto = "";
		this.efeitoQtd = "";
		this.efeitoDrawBackQtd = "";
		this.efeitoScore = "";
		this.efeitoPrincipal = "";
		this.efeitoOutros = "";
		this.edhCategoria = "";
		this.tenhoQtd = "";
		this.comprar = "";
		this.colecao = "";
		this.precoMenor = "";
		this.estado = "";
		this.lojaMenorPreco = "";
		this.dataPesquisa = "";
		this.lojas = new ArrayList<Loja>();
	}

	public String getQtd() {
		return qtd;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setQtd(String qtd) {
		this.qtd = qtd;
	}

	public String getNameENGUS() {
		return nameENGUS;
	}

	public void setNameENGUS(String nameENGUS) {
		this.nameENGUS = nameENGUS;
	}

	public String getNomePTBR() {
		return nomePTBR;
	}

	public void setNomePTBR(String nomePTBR) {
		this.nomePTBR = nomePTBR;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getManaCost() {
		return manaCost;
	}

	public void setManaCost(String manaCost) {
		this.manaCost = manaCost;
	}

	public String getCmc() {
		return cmc;
	}

	public void setCmc(String cmc) {
		this.cmc = cmc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEfeitoQtd() {
		return efeitoQtd;
	}

	public void setEfeitoQtd(String efeitoQtd) {
		this.efeitoQtd = efeitoQtd;
	}

	public String getEfeitoDrawBackQtd() {
		return efeitoDrawBackQtd;
	}

	public void setEfeitoDrawBackQtd(String efeitoDrawBackQtd) {
		this.efeitoDrawBackQtd = efeitoDrawBackQtd;
	}

	public String getEfeitoScore() {
		return efeitoScore;
	}

	public void setEfeitoScore(String efeitoScore) {
		this.efeitoScore = efeitoScore;
	}

	public String getEfeitoPrincipal() {
		return efeitoPrincipal;
	}

	public void setEfeitoPrincipal(String efeitoPrincipal) {
		this.efeitoPrincipal = efeitoPrincipal;
	}

	public String getEfeitoOutros() {
		return efeitoOutros;
	}

	public void setEfeitoOutros(String efeitoOutros) {
		this.efeitoOutros = efeitoOutros;
	}

	public String getEdhCategoria() {
		return edhCategoria;
	}

	public void setEdhCategoria(String edhCategoria) {
		this.edhCategoria = edhCategoria;
	}

	public String getTenhoQtd() {
		return tenhoQtd;
	}

	public void setTenhoQtd(String tenhoQtd) {
		this.tenhoQtd = tenhoQtd;
	}

	public String getComprar() {
		return comprar;
	}

	public void setComprar(String comprar) {
		this.comprar = comprar;
	}

	public String getColecao() {
		return colecao;
	}

	public void setColecao(String colecao) {
		this.colecao = colecao;
	}

	public String getPrecoMenor() {
		return precoMenor;
	}

	public void setPrecoMenor(String precoMenor) {
		this.precoMenor = precoMenor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLojaMenorPreco() {
		return lojaMenorPreco;
	}

	public void setLojaMenorPreco(String lojaMenorPreco) {
		this.lojaMenorPreco = lojaMenorPreco;
	}

	public String getDataPesquisa() {
		return dataPesquisa;
	}

	public void setDataPesquisa(String dataPesquisa) {
		this.dataPesquisa = dataPesquisa;
	}

	public List<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}		

}
