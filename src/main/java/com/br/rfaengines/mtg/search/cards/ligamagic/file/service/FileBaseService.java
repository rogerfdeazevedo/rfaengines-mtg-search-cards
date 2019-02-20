package com.br.rfaengines.mtg.search.cards.ligamagic.file.service;

import org.testng.annotations.BeforeTest;

import com.br.rfaengines.mtg.search.cards.util.PropertiesUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileBaseService {

	protected ObjectMapper mapper;
	protected String pathIn;
	protected String pathOut;
	protected String extensionIn;
	protected String extensionProc;

	@BeforeTest
	protected void preCon() {
		mapper = new ObjectMapper();
		pathIn = PropertiesUtil.getValue("file.dir.import");
		pathOut = PropertiesUtil.getValue("file.dir.export");
		extensionIn = PropertiesUtil.getValue("file.dir.extensionIn");
		extensionProc = PropertiesUtil.getValue("file.dir.extensionOut");
	}
	
}
