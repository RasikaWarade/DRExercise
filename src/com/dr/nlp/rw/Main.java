package com.dr.nlp.rw;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import com.dr.nlp.rw.task.TokenizerTask;

/*
 * DRProgram: Main Class
 * Feature 1: To identify sentence boundary and tokenize the text in the input file "nlp_data.txt"
 * Outputs an xml file
 */
public class Main {

	//Public Variable for Debugging 
	public static boolean DEBUG=false;

	public static void main(String[] args) throws TransformerException, IOException{

		//Create instance for TokenizerTask
		TokenizerTask tokenizer=new TokenizerTask();
		//Takes input file name as an argument
		tokenizer.setFileName(args[0]);
		//Read the input file and process
		tokenizer.readFile();
		//Store the Objects in XML format
		tokenizer.convertObjectToXML();
	}

}