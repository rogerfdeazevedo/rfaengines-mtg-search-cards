package com.br.rfaengines.mtg.search.cards.ligamagic.file.service;

import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.br.rfaengines.mtg.search.cards.ligamagic.apimtg.service.ApiMtgService;
import com.br.rfaengines.mtg.search.cards.ligamagic.file.vo.FileSearch;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileTest {

	private ObjectMapper mapper;
	private String pathIn;
	private String pathOut;
	private String extensionIn;
	private String extensionProc;
	private boolean isResultSearchFile;

	@BeforeTest
	public void preCon() {
		mapper = new ObjectMapper();
		pathIn = System.getProperty("user.dir") + "/files/import";
		pathOut = System.getProperty("user.dir") + "/files/export";
		extensionIn = ".txt";
		extensionProc = ".PROC";
		isResultSearchFile = true;		
	}

	@Test
	public void file() throws JsonProcessingException {

		ImportFileService importFileService = new ImportFileService(pathIn, extensionIn, extensionProc);

		List<FileSearch> fileSearchList = importFileService.importFile();
		
		ApiMtgService apiMtg = new ApiMtgService(fileSearchList);
		
		fileSearchList = apiMtg.processFileSearchList();
		
		System.out.println("fileSearchList: " + mapper.writeValueAsString(fileSearchList));

		ExportFileService exportFileService = new ExportFileService(pathOut, fileSearchList, isResultSearchFile);

		exportFileService.exportFile();

	}

}
