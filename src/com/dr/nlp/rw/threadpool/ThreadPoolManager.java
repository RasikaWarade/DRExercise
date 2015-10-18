package com.dr.nlp.rw.threadpool;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/*
 * Class: ThreadPoolManager
 * It manages thread pool with threads equal to the given number of files inside the zip file and assigns tasks to each worker 
 */
public class ThreadPoolManager { 
	private static int noOfThreads=1;
	private String zipFilename="";

	/*
	 * getter: returns the filename of Zip file
	 */
	public String getZipFilename() {
		return zipFilename;
	}

	/*
	 * setter
	 */
	public void setZipFilename(String zipFilename) {
		this.zipFilename = zipFilename;
	}

	/*
	 * getter: returns the noOfThreads set for the thread pool
	 */
	public int getNoOfThreads() {
		return noOfThreads;
	}

	/*
	 * setter
	 */
	public void setNoOfThreads(int noOfThreads) {
		this.noOfThreads = noOfThreads;
	}

	/*
	 * function to create thread pool and assign task to each worker thread
	 */
	public void init() throws IOException {  

		ExecutorService executor = Executors.newFixedThreadPool(noOfThreads);//creating a pool of threads  
		ArrayList<String> inputFileNameList=new ArrayList<String>();

		File directory = new File(zipFilename);
		//get all the files from a directory
		File[] fList = directory.listFiles();
		for (File file : fList){
			inputFileNameList.add(zipFilename+"/"+file.getName());
		}
		//Assign the noOfThreads to the total number of files 
		this.noOfThreads=fList.length;
		//System.out.println(inputFileNameList.get(0));
		int fileNo=0;
		for (int i = 0; i < noOfThreads; i++) {  
			Runnable worker = new Worker(inputFileNameList.get(fileNo));  
			executor.execute(worker);//calling execute method of ExecutorService  
			fileNo++;
		}  
		executor.shutdown();  
		while (!executor.isTerminated()) {   }  

		System.out.println("Finished all threads");  
	}  
}  