package com.dr.nlp.rw.ds;

/*
 * Class: Punctuation
 * The data structure to store the punctuation in a sentence.
 */
public class Punctuation extends Items{
	private String punctuation;

	public Punctuation() {
		this.punctuation=null;
	}

	public String getPunctuation() {
		return punctuation;
	}

	public void setPunctuation(String punctuation) {
		this.punctuation = punctuation;
	}
	public String getXMLTag(){
		return "Punctuation";
	}

}
