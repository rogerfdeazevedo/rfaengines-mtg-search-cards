package com.br.rfaengines.mtg.search.cards.ligamagic.file.process;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.br.rfaengines.mtg.search.cards.ligamagic.file.vo.CardData;
import com.br.rfaengines.mtg.search.cards.ligamagic.file.vo.FileSearch;
import com.br.rfaengines.mtg.search.cards.ligamagic.file.vo.HeaderFile;

public class ProcessExportFile {

	private static final Logger LOGGER = Logger.getLogger(ProcessExportFile.class);

	private FileSearch fileSearch;	

	private ArrayList<String> contentFile;
	
	private boolean isResultSearchFile;

	public ProcessExportFile(FileSearch fileSearch, boolean isResultSearchFile) {
		this.fileSearch = fileSearch;
		this.contentFile = new ArrayList<String>();
		this.isResultSearchFile = isResultSearchFile;
	}

	public ArrayList<String> processFile() {

		LOGGER.info("processExportFile init: " + fileSearch.getFileName());

		if(isResultSearchFile) {
			montarHeader();
		}
		
		for (int i = 0; i < fileSearch.getCardList().size(); i++) {

			CardData cardData = fileSearch.getCardList().get(i);

			String line = montarLinha(cardData);			

			if(isResultSearchFile) {
				
				contentFile.add(line);
				
			} else {
				
				if(!contentFile.contains(line)) {
					
					contentFile.add(line);
					
				}
				
			}
			
			
		}

		LOGGER.info("processExportFile end: " + fileSearch.getFileName());

		return contentFile;
	}

	private void montarHeader() {
		HeaderFile header = new HeaderFile();
		String headerStr = header.resultSearch();
		contentFile.add(headerStr);
	}
	
	private String montarLinha(CardData cardData) {
		
		StringBuilder line = new StringBuilder();
		
		line
		.append(cardData.getQtd()).append(";")
		.append(cardData.getNameENGUS()).append(";")
		;
		
		if(isResultSearchFile) {
			line
			.append(cardData.getNomePTBR()).append(";")
			.append(cardData.getColor()).append(";")
			.append(cardData.getManaCost()).append(";")
			.append(cardData.getCmc()).append(";")
			.append(cardData.getType()).append(";")
			.append(cardData.getTexto()).append(";")
			.append(cardData.getEfeitoQtd()).append(";")
			.append(cardData.getEfeitoDrawBackQtd()).append(";")
			.append(cardData.getEfeitoScore()).append(";")
			.append(cardData.getEfeitoPrincipal()).append(";")
			.append(cardData.getEfeitoOutros()).append(";")
			.append(cardData.getEdhCategoria()).append(";")
			.append(cardData.getTenhoQtd()).append(";")
			.append(cardData.getComprar()).append(";")
			.append(cardData.getColecao()).append(";")
			.append(cardData.getPrecoMenor()).append(";")
			.append(cardData.getEstado()).append(";")
			.append(cardData.getLojaMenorPreco()).append(";")
			.append(cardData.getDataPesquisa()).append(";")
//			.append(cardData.getLojas()).append(";")			
			;
		}		
		
		return line.toString();
		
	}

}
