package com.br.rfaengines.mtg.search.cards.ligamagic.file.process;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.br.rfaengines.mtg.search.cards.ligamagic.file.vo.CardData;
import com.br.rfaengines.mtg.search.cards.ligamagic.file.vo.FileSearch;

public class ProcessImportFile {	
	
	private static final Logger LOGGER = Logger.getLogger(ProcessImportFile.class);
	
	private String qtd;
	private String nameENGUS;	
	private String fileName;
	
	private ArrayList<String> contentFile;
	
	private FileSearch fileSearch;
	
	public ProcessImportFile(String fileName, ArrayList<String> contentFile) {
		this.qtd = "";
		this.nameENGUS = "";
		this.fileName = fileName;
		this.contentFile = contentFile;
		this.fileSearch = new FileSearch();
	}
	
	public FileSearch processFileInit() {
		
		LOGGER.info("processImportFile init: " + fileName);
		
		fileSearch.setFileName(fileName);
		
		List<CardData> cardList = new ArrayList<CardData>();
		
		int size = contentFile.size();
		
		for(int i = 0; i < size; i++) {		
			
			String line = contentFile.get(i);
			
			qtd = line.substring(0, 1);			
			nameENGUS = line.substring(2);	
			
			CardData cardData = new CardData();				
			cardData.setQtd(qtd);
			cardData.setNameENGUS(nameENGUS);
			
			cardList.add(cardData);
			
		}
		
		fileSearch.setCardList(cardList);
		
		LOGGER.info("processImportFile end: " + fileName);
		
		return fileSearch;
	}

}
