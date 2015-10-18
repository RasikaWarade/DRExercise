package com.dr.nlp.rw.ds;

/*
 * Class: Punctuation
 * The data structure to store the punctuation in a sentence.
 */
public class Punctuation extends Items{
	private String punctuation;

	/*
	 * private constructor
	 */
	public Punctuation() {
		this.punctuation=null;
	}

	/*
	 * getter method: returns Punctuation
	 */
	public String getPunctuation() {
		return punctuation;
	}
	/*
	 * setter method
	 */

	public void setPunctuation(String punctuation) {
		this.punctuation = punctuation;
	}
	
	/*
	 * get the XML tag name for the object 
	 */
	public String getXMLTag(){
		return "Punctuation";
	}

}
