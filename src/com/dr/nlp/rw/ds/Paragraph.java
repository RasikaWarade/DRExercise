package com.dr.nlp.rw.ds;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Class: Paragraph
 * It store the data structure for paragraph and has list of sentences
 * It processes the paragraph using the Regular Expression pattern:
 * (\\.|\\?|\\!|\\.\"|\\.'|\\?\"|\\?'|\\!\"|\\!')\\s+[A-Z|\"|\']
 * 
 * which determines the sentence boundary by detecting: * . ? ! ." .' ?" ?' !" !'
 */

public class Paragraph {
	private ArrayList<Sentence> sentences;
	private final static String REGEX_PATTERN = "(\\.|\\?|\\!|\\.\"|\\.'|\\?\"|\\?'|\\!\"|\\!')\\s+[A-Z|\"|\']";

	/*
	 * private constructor
	 */
	public Paragraph() {
		this.sentences = new ArrayList<Sentence>();
	}
	/*
	 * getter method
	 */
	public ArrayList<Sentence> getSentences() {
		return sentences;
	}

	/*
	 * setter method
	 */
	public void setSentences(ArrayList<Sentence> sentences) {
		this.sentences = sentences;
	}

	/*
	 * get the XML tag name for the object 
	 */
	public String getXMLTag(){
		return "Paragraph";
	}

	public void process(String para) {
		if (!para.equals("")) {

			// Create a Pattern object
			Pattern r = Pattern.compile(REGEX_PATTERN);

			// Now create matcher object.
			Matcher m = r.matcher(para);
			int beginIndex=0;

			while (m.find( )) {
				//System.out.println("Process sentence:"+para.substring(beginIndex,m.end()-1));

				//process the sentence further and add it to the list of sentences for the given paragraph 
				Sentence sentence = new Sentence();
				sentence.process(para.substring(beginIndex,m.end()-1));
				sentences.add(sentence);
				beginIndex=m.end()-1;
			}

			//process the last part of the sentence
			Sentence sentence = new Sentence();
			//System.out.println("Process sentence:"+para.substring(beginIndex));
			sentence.process(para.substring(beginIndex));
			sentences.add(sentence);
		}
	}
}
