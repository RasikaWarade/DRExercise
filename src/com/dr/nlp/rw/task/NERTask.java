package com.dr.nlp.rw.task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.dr.nlp.rw.ds.NamedEntityList;

/*
 * Class: NERTask
 * It the takes the input file for named entities and stores it in a list
 * It creates only copy by creating object of NamedEntityList which can be used throughout the program
 */

public class NERTask {
	private String NERfileName;
	private ArrayList<String> namedEntityList;

	public NERTask() {
		this.namedEntityList = new ArrayList<String>();
		this.NERfileName="";
	}

	public String getNERfileName() {
		return NERfileName;
	}
	public void setNERfileName(String nERfileName) {
		NERfileName = nERfileName;
	}
	public void setList() {
		// TODO Auto-generated method stub
		BufferedReader br = null;

		try {

			String currentLine;

			br = new BufferedReader(new FileReader(NERfileName));

			while ((currentLine = br.readLine()) != null) {

				if (!currentLine.equals("")) {


					namedEntityList.add(currentLine);

				}

			}
			//for(String entity:namedEntityList){
			//System.out.println(entity);
			//}
			NamedEntityList neList = NamedEntityList.getInstance();
			neList.setNamedEntityList(namedEntityList);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}


}
