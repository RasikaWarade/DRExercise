package com.dr.nlp.rw;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import com.dr.nlp.rw.task.NERTask;
import com.dr.nlp.rw.task.TokenizerTask;
import com.dr.nlp.rw.threadpool.ThreadPoolManager;

/*
 * DRProgram: Main Class
 * It takes first argument as feature no and requires extra arguments as per Task to be performed
 * 
 * Feature 1: To identify sentence boundary and tokenize the text in the path for the input file ("nlp_data.txt")
 * Input: Takes input filename "nlp_data.txt" as second argument
 * java Main 1 nlp_data.txt
 * 
 * Outputs an xml file 
 * 
 * Feature 2: To add rudimentary recognition of proper nouns  in the input file 
 * Input: Takes input path for the file with Named-entities ("NER.txt") as second argument and path for the input filename ("nlp_data.txt") as third argument
 * java Main 2 NER.txt nlp_data.txt
 * Outputs an xml file 
 * 
 * Feature 3: To parallel process the input files and tokenize 
 * Input: Takes input path for the directory extracted from the zip file as second argument and path for the file with Named-entities ("NER.txt") as third argument
 * java Main 3 nlp_data NER.txt
 * java Main 3 <dir-name> NER.txt
 * Outputs an xml file for each input file in the zip file 
 *  
 */
public class Main {

	/*
	 * Main funcion: program starts here 
	 */
	public static void main(String[] args) throws TransformerException, IOException{
		if(Integer.parseInt(args[0])==1){
			
			//Create instance for TokenizerTask
			TokenizerTask tokenizer=new TokenizerTask();
			//Takes input file name as an argument
			tokenizer.setFileName(args[1]);
			//Read the input file and process
			tokenizer.readFile();
			//Store the Objects in XML format
			tokenizer.convertObjectToXML();
			
			
		}else if(Integer.parseInt(args[0])==2){
			
			//Create instance for NERTask
			NERTask neRognition=new NERTask();
			//Takes input file name as an argument
			neRognition.setNERfileName(args[1]);
			//Store the given named entities in an arraylist
			neRognition.setList();
			
			//Create instance for TokenizerTask
			TokenizerTask tokenizer=new TokenizerTask();
			//Takes input file name as an argument
			tokenizer.setFileName(args[2]);
			//Read the input file and process
			tokenizer.readFile();
			//Store the Objects in XML format
			tokenizer.convertObjectToXML();
			
		}
		else{
			//Create a thread pool
			ThreadPoolManager TPM= new ThreadPoolManager();
			TPM.setZipFilename(args[1]);
			
			//Save the given named entities in an arraylist object of Singleton class
			NERTask neRognition=new NERTask();
			//Read file NER.txt
			neRognition.setNERfileName(args[2]);
			neRognition.setList();
			
			//initialize the ThreadPoolManager
			TPM.init();
			
			
		}
	}

}