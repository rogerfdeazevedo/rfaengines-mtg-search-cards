package com.br.rfaengines.mtg.search.cards.ligamagic.file.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.br.rfaengines.mtg.search.cards.ligamagic.apimtg.service.ApiMtgService;
import com.br.rfaengines.mtg.search.cards.ligamagic.file.vo.FileSearch;
import com.fasterxml.jackson.core.JsonProcessingException;

public class FileTest extends FileBaseService {	

	private static final Logger LOGGER = Logger.getLogger(FileTest.class);
	
	@Test(groups = { "ignore"})
	public void file() throws JsonProcessingException {

		ImportFileService importFileService = new ImportFileService(pathIn, extensionIn, extensionProc);

		List<FileSearch> fileSearchList = importFileService.importFile();
		
		ApiMtgService apiMtg = new ApiMtgService(fileSearchList);
		
		fileSearchList = apiMtg.processFileSearchList();
		
		LOGGER.info("fileSearchList: " + mapper.writeValueAsString(fileSearchList));

		ExportFileService exportFileService = new ExportFileService(pathOut, fileSearchList, true);

		exportFileService.exportFile();

	}

}
