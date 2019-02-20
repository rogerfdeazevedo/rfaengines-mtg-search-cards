package com.br.rfaengines.mtg.search.cards.ligamagic.apimtg.process;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.br.rfaengines.mtg.search.cards.ligamagic.file.vo.FileSearch;

import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.resource.Card;

public class ProcessFileSearchApiMtg {
	
	private static final Logger LOGGER = Logger.getLogger(ProcessFileSearchApiMtg.class);

	private String cardName;
	private String cardColor;
	private String cardManaCost;
	
	private ArrayList<String> filter;	
	private FileSearch fileSearch;
	
	private Card card;	
	private List<Card> cardList;
	
	public ProcessFileSearchApiMtg(FileSearch fileSearch) {
		this.cardName = "";		
		this.cardColor = "";
		this.cardManaCost = "";
		this.filter = new ArrayList<String>();
		this.fileSearch = fileSearch;
	}
	
	public FileSearch processFile() {			
		
		LOGGER.info("processFile init: " + fileSearch.getFileName());
		
		for (int i = 0; i < fileSearch.getCardList().size();i++) {
			
			apiGetCard(i);	
			apiGetCardColor();
			apiGetCardManaCost();
			
			fileSearch.getCardList().get(i).setColor(cardColor);
			fileSearch.getCardList().get(i).setManaCost(cardManaCost);
			fileSearch.getCardList().get(i).setCmc(card.getCmc() + "");
			fileSearch.getCardList().get(i).setType(card.getType());	
			fileSearch.getCardList().get(i).setTexto(card.getText());
			
		}
		
		LOGGER.info("processFile end: " + fileSearch.getFileName());
		
		return fileSearch;
	}

	private void apiGetCardManaCost() {
		cardManaCost = "";
		if(card.getManaCost() != null) {
			cardManaCost = card.getManaCost();
		}
	}

	private void apiGetCardColor() {
		cardColor = "";		
		if(card.getColorIdentity().length == 0 || card.getType().toLowerCase().contains("land")) {
			cardColor = "coloress";			
		} else {
			for(String str : card.getColorIdentity()) {			
				cardColor = cardColor + str;			
			}	
		}		
	}

	private void apiGetCard(int i) {		
		cardName = fileSearch.getCardList().get(i).getNameENGUS();		
		filter.add("name=\"" + cardName + "\"");		
		cardList = CardAPI.getAllCards(filter);		
		card = cardList.get(0);
	}
	
	
}
