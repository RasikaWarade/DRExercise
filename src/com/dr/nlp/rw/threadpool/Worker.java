package com.dr.nlp.rw.threadpool;

import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;

import javax.xml.transform.TransformerException;

import com.dr.nlp.rw.ds.NamedEntityList;
import com.dr.nlp.rw.task.TokenizerTask;

/*
 * Class: Worker
 * It implements Runnable and acts as a worker thread
 * It processes the given number of files and each worker is assigned a file to process
 * The worker thread further tokenizes the text in the file and generates output as separate xml files in the same folder
 */

class Worker implements Runnable {  
	private String message;
	
	/*
	 * private constructor
	 */
	public Worker(String s){  
		this.message=s;  
	}  
	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {  
		try {
			processmessage(message);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}  
	/*
	 * Performs the task of tokenizing and detecting named-entity in the text
	 */
	private void processmessage(String fileName) throws TransformerException {  
		try {  
			Thread.sleep(2000);
			TokenizerTask tokenizer=new TokenizerTask();
			tokenizer.setFileName(fileName);
			tokenizer.readFile();
			tokenizer.convertObjectToXML();

		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}  
	}  
}  