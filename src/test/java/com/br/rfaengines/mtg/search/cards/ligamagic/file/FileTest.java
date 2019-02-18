package com.br.rfaengines.mtg.search.cards.ligamagic.file;

import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.br.rfaengines.mtg.search.cards.ligamagic.file.service.ExportFileService;
import com.br.rfaengines.mtg.search.cards.ligamagic.file.service.ImportFileService;
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

		String str = mapper.writeValueAsString(fileSearchList);

		System.out.println("fileSearchList: " + str);

		ExportFileService exportFileService = new ExportFileService(pathOut, fileSearchList, isResultSearchFile);

		exportFileService.exportFile();

	}

}
