package com.br.rfaengines.mtg.search.cards.ligamagic.file.vo;

import java.util.ArrayList;
import java.util.List;

public class FileSearch {

	private String fileName;
	private List<CardData> cardList;	
	
	public FileSearch() {
		this.fileName = "";
		this.cardList = new ArrayList<CardData>();
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public List<CardData> getCardList() {
		return cardList;
	}
	public void setCardList(List<CardData> cardList) {
		this.cardList = cardList;
	}	
	
}
