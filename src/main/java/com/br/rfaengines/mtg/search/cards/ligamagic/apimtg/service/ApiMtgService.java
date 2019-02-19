package com.br.rfaengines.mtg.search.cards.ligamagic.apimtg.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.br.rfaengines.mtg.search.cards.ligamagic.apimtg.process.ProcessFileSearchApiMtg;
import com.br.rfaengines.mtg.search.cards.ligamagic.file.vo.FileSearch;

public class ApiMtgService {
	
	private static final Logger LOGGER = Logger.getLogger(ApiMtgService.class);	
	
	private List<FileSearch> fileSearchList;
	private List<FileSearch> fileSearchListReturn;
	
	public ApiMtgService(List<FileSearch> fileSearchList) {
		this.fileSearchList = fileSearchList;				
	}
	
	public List<FileSearch> processFileSearchList() {
		
		LOGGER.info("apiMtg init");
		
		if(!fileSearchList.isEmpty()) {
			
			fileSearchListReturn = new ArrayList<FileSearch>();
			
			for (FileSearch fileSearch : fileSearchList) {
				
				ProcessFileSearchApiMtg process = new ProcessFileSearchApiMtg(fileSearch);
			
				fileSearchListReturn.add(process.processFile());
				
			}
		}
		
		LOGGER.info("apiMtg end");
		
		return fileSearchListReturn;
	}
	
}
