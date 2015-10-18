package com.dr.nlp.rw.ds;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Class: Sentence
 * The data structure to store the sentences.
 */
public class Sentence{
	private ArrayList<Items> sentenceItems;
	private final static String REGEX_PATTERN = "\\W";


	public Sentence() {
		this.sentenceItems = new ArrayList<Items>();
	}

	public ArrayList<Items> getSentencesItems() {
		return sentenceItems;
	}

	public void setSentencesItems(ArrayList<Items> sentenceItems) {
		this.sentenceItems = sentenceItems;
	}
	public String getXMLTag(){
		return "Sentence";
	}


	public void process(String sentence) {


		//System.out.println(sentence);
		// Create a Pattern object
		Pattern r = Pattern.compile(REGEX_PATTERN);

		// Now create matcher object.
		Matcher m = r.matcher(sentence);
		int beginIndex=0;
		while (m.find( )) {
			if (beginIndex != m.start()) {
				System.out.println("Process Word:"+sentence.substring(beginIndex,m.start()));
				Word w=new Word();
				w.setWord(sentence.substring(beginIndex,m.start()));
				sentenceItems.add(w);
				beginIndex = m.end();
			} else
				beginIndex++;


			System.out.println("Process punctuation:"+m.group());
			Punctuation p=new Punctuation();
			p.setPunctuation(m.group());
			sentenceItems.add(p);


		}

	}

}
