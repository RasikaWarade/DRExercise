package com.dr.nlp.rw.ds;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Class: Sentence
 * The data structure to store the sentences.
 * It processes further using non-word character pattern.
 */
public class Sentence{
	private ArrayList<Items> sentenceItems;
	private final static String REGEX_PATTERN = "\\W";

	/*
	 * private constructor
	 */
	
	public Sentence() {
		this.sentenceItems = new ArrayList<Items>();
	}

	/*
	 * getter method
	 */
	public ArrayList<Items> getSentencesItems() {
		return sentenceItems;
	}
	/*
	 * setter method
	 */
	public void setSentencesItems(ArrayList<Items> sentenceItems) {
		this.sentenceItems = sentenceItems;
	}
	
	/*
	 * get the XML tag name for the object 
	 */
	public String getXMLTag(){
		return "Sentence";
	}


	/*
	 * Process sentence to see if any named entity is present
	 * if present break down the sentence and process the left over sentence to get words and punctuation
	 */
	public void process(String sentence){

		while(sentenceContainsNamedEntity(sentence)){
			//System.out.println(sentence);
			//System.out.println("Contains Named :"+sentence);
			String findStr=getNamedEntity(sentence);
			//System.out.println("Find:"+findStr);

			int lastIndex = 0;
			int startIndex=0;
			while(lastIndex != -1){

				lastIndex = sentence.indexOf(findStr,lastIndex);
				if(lastIndex != -1){
					if(startIndex==0){

						//Process beginning
						//System.out.println(sentence.substring(startIndex,lastIndex));
						addWordPunctuation(sentence.substring(startIndex,lastIndex));
						//process named entity
						NamedEntity ner=new NamedEntity();
						//System.out.println("Process Named-Entity:"+findStr);
						ner.setNamedEntity(findStr);
						sentenceItems.add(ner);
						startIndex=lastIndex+findStr.length();
						sentence=sentence.substring(startIndex);


					}	
				}

			}


		}
		addWordPunctuation(sentence);
	}
	/*
	 * get words or punctuation
	 */
	public void addWordPunctuation(String sentence) {


		//System.out.println(sentence);
		// Create a Pattern object
		Pattern r = Pattern.compile(REGEX_PATTERN);

		// Now create matcher object.
		Matcher m = r.matcher(sentence);
		int beginIndex=0;
		while (m.find( )) {
			if (beginIndex != m.start()) {
				//System.out.println("Process Word:"+sentence.substring(beginIndex,m.start()));
				Word w=new Word();
				w.setWord(sentence.substring(beginIndex,m.start()));
				sentenceItems.add(w);
				beginIndex = m.end();
			} else
				beginIndex++;


			//System.out.println("Process punctuation:"+m.group());
			Punctuation p=new Punctuation();
			p.setPunctuation(m.group());
			sentenceItems.add(p);


		}

	}
	/*
	 * check if the sentence contains any named entity
	 */
	public boolean sentenceContainsNamedEntity(String sentence){
		NamedEntityList neList = NamedEntityList.getInstance();
		for(String entity:neList.getNamedEntityList()){
			if(sentence.contains(entity))
				return true;
		}
		return false;
	}
	/*
	 * get the named entity
	 */
	public String getNamedEntity(String sentence){
		NamedEntityList neList = NamedEntityList.getInstance();
		for(String entity:neList.getNamedEntityList()){
			if(sentence.contains(entity))
				return entity;
		}
		return "";
	}


}
