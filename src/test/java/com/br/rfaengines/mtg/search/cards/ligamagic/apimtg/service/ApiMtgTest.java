package com.br.rfaengines.mtg.search.cards.ligamagic.apimtg.service;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.resource.Card;

public class ApiMtgTest {
	
	private ObjectMapper mapper;
	
	@BeforeTest
	public void preCon() {
		mapper = new ObjectMapper();
	}
	
	@Test
	public void loadCardData() throws JsonProcessingException {
		
		String cardName = "Adaptive Automaton";
		
		ArrayList<String> filter = new ArrayList<String>();
		filter.add("name=\"" + cardName + "\"");	
				
		List<Card> cardList = CardAPI.getAllCards(filter);
		
		Card card = cardList.get(0);		
		
		String cardStr = mapper.writeValueAsString(card);
		
		System.out.println("cardStr: "+ cardStr);	
		
		StringBuilder line = new StringBuilder();		
		
		line
		.append("\n").append("NameENGUS").append("; ").append(card.getName())
		;
		
		String color = "";
		
		for(String str : card.getColorIdentity()) {			
			color = color + str;			
		}
		
		line
		.append("\n").append("Color").append("; ").append(color)		
		.append("\n").append("ManaCost").append("; ").append(card.getManaCost())
		.append("\n").append("Cmc").append("; ").append(card.getCmc())
		.append("\n").append("Type").append("; ").append(card.getType())		
		;
		
		System.out.println("line: \n " + line.toString());
	
		
	}
	

}
