package com.casedesenvolvedor.casedesenvolvedor.support;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.casedesenvolvedor.casedesenvolvedor.model.Arquivo;

public class BackupStorage {
	
	public static List<Arquivo> arquivosStorage() {
		File folder1 = new File("C:/Users/Guilherme/Desktop/ENTRARNAEQUALS/casedesenvolvedor/src/main/resources/Arquivos/UflaCard");
		File folder2 = new File("C:/Users/Guilherme/Desktop/ENTRARNAEQUALS/casedesenvolvedor/src/main/resources/Arquivos/FagammonCard");
		File[] listOfFiles1 = folder1.listFiles();
		File[] listOfFiles2 = folder2.listFiles();
		List<Arquivo> listaArq = new ArrayList<Arquivo>();
		for (File file : listOfFiles1) {
		    if (file.isFile()) {
		    	listaArq.add(LeitorCard.lerArquivo(file.getPath()));
		    }
		}
		for (File file : listOfFiles2) {
		    if (file.isFile()) {
		    	listaArq.add(LeitorCard.lerArquivo(file.getPath()));
		    }
		}
		return listaArq;
	}
}
