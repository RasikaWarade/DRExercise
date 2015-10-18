package com.dr.nlp.rw.ds;
/*
 * Class: Word
 * The data structure to store the word in a sentence.
 */

public class Word extends Items{
	private String word;

	/*
	 * private constructor
	 */
	public Word() {
		this.word=null;
	}

	/*
	 * getter method: returns word
	 */
	public String getWord() {
		return word;
	}

	/*
	 * setter method
	 */
	public void setWord(String word) {
		this.word = word;
	}
	
	/*
	 * get the XML tag name for the object 
	 */
	public String getXMLTag(){
		return "Word";
	}
}
