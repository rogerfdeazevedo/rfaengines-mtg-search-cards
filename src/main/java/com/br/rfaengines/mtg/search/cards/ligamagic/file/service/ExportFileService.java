package com.br.rfaengines.mtg.search.cards.ligamagic.file.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.br.rfaengines.mtg.search.cards.ligamagic.file.process.ProcessExportFile;
import com.br.rfaengines.mtg.search.cards.ligamagic.file.vo.FileSearch;

public class ExportFileService {

	private static final Logger LOGGER = Logger.getLogger(ExportFileService.class);

	private String path;

	private List<FileSearch> fileSearchList;

	private boolean isResultSearchFile;

	public ExportFileService(String pathOut, List<FileSearch> fileSearchList, boolean isResultSearchFile) {
		this.path = pathOut;
		this.fileSearchList = fileSearchList;
		this.isResultSearchFile = isResultSearchFile;
	}

	public void exportFile() {

		LOGGER.info("exportFile init");

		if (!fileSearchList.isEmpty()) {

			for (FileSearch fileSearch : fileSearchList) {

				ProcessExportFile process = new ProcessExportFile(fileSearch, isResultSearchFile);

				ArrayList<String> contentFile = process.processFile();

				String fileName = getDate() + "-" + fileSearch.getFileName();

				writeFile(fileName, contentFile);

			}

		}

		LOGGER.info("exportFile end");
	}

	public void writeFile(String fileName, ArrayList<String> contentFile) {
		try {
			String filePath = path + "/" + fileName;
			BufferedWriter StrW = new BufferedWriter(new FileWriter(filePath));
			for (int i = 0; i < contentFile.size(); i++) {
				StrW.write(contentFile.get(i) + "\n");
			}
			StrW.close();
		} catch (IOException e) {
			LOGGER.error("Falha ao tentar salvar arquivo ", e);
		}
	}
	
	public String getDate() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyymmddhhMMss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

}
