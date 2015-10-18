package com.dr.nlp.rw.ds;
/*
 * Class: Word
 * The data structure to store the word in a sentence.
 */

public class Word extends Items{
	private String word;

	public Word() {
		this.word=null;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	public String getXMLTag(){
		return "Word";
	}
}
