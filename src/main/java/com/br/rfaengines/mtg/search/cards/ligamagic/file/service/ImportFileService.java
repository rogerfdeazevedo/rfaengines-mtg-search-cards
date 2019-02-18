package com.br.rfaengines.mtg.search.cards.ligamagic.file.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.br.rfaengines.mtg.search.cards.ligamagic.file.process.ProcessImportFile;
import com.br.rfaengines.mtg.search.cards.ligamagic.file.vo.FileSearch;

public class ImportFileService {
	
	private static final Logger LOGGER = Logger.getLogger(ImportFileService.class);

	private String pathIn;
	private String extensionIn;
	private String extensionProc;
	
	private ArrayList<String> fileNameList;	
	private List<FileSearch> fileSearchList;
	
	private boolean isFileToImport;
	
	public ImportFileService(String pathIn,  String extensionIn, String extensionProc) {
		this.pathIn = pathIn;
		this.extensionIn = extensionIn;
		this.extensionProc = extensionProc;
		this.fileNameList = new ArrayList<String>();		
		this.isFileToImport = false;
	}
	
	public List<FileSearch> importFile(){
		
		LOGGER.info("importFile init");
		
		listFile();
		
		if(isFileToImport) {					
			
			fileSearchList = new ArrayList<FileSearch>();
					
			for(String fileName : fileNameList) {
				
				String filePath = pathIn + "\\" + fileName;
				
				ArrayList<String> contentFile = readFile(filePath);
				
				ProcessImportFile processImportFile = new ProcessImportFile(fileName, contentFile);
				
				FileSearch fileSearch = processImportFile.processFileInit();
				
				fileSearchList.add(fileSearch);
				
				renameFileToProc(fileName);
				
			} 
			
		} else {
			LOGGER.info("Não há arquivos para importar:  " + pathIn);
		}		
		
		LOGGER.info("importFile end");
		
		return fileSearchList;
	}

	private void listFile() {		 
		try {
			File files[];
			File dir = new File(this.pathIn);	
			files = dir.listFiles();				
			for(int i = 0; i < files.length; i++){					
				if (files[i].getName().endsWith(this.extensionIn)) {					
					String fileName = files[i].getName();						
					fileNameList.add(fileName);							
				} 				   
			}
			
			if(!fileNameList.isEmpty()) {
				isFileToImport = true;
			}
			
		} catch (Exception e) {
			LOGGER.error("Falha ao tentar importar arquivos: " + pathIn, e);
		}
	}
	
	private ArrayList<String> readFile(String filePath) {
		ArrayList<String> lines = new ArrayList<String>();
		try {			
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			while (br.ready()) {
				String line = br.readLine();
				lines.add(line);
			}
			br.close();
		} catch (IOException e) {
			LOGGER.error("Falha ao ler arquivo: " + pathIn, e);
		}
		return lines;
	}
	
	private void renameFileToProc(String fileName) {
		try {
			String filePath = pathIn + "/" + fileName;
			new File(filePath).renameTo(new File(filePath + extensionProc));		
		} catch (Exception e) {
			LOGGER.error("Falha ao tentar renomear arquivo para processado ", e);
		}
	}
	
}
