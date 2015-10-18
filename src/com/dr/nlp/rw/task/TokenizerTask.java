package com.dr.nlp.rw.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.dr.nlp.rw.ds.Items;
import com.dr.nlp.rw.ds.Paragraph;
import com.dr.nlp.rw.ds.Punctuation;
import com.dr.nlp.rw.ds.Sentence;
import com.dr.nlp.rw.ds.Word;

/*
 * Class: TokenizerTask
 * It the takes the input file and processes it to store the list of paragraphs in the file.
 * After further tokenizing of the paragraphs, it also has functionality to output the model objects in XML format.
 */

public class TokenizerTask {


	private  ArrayList<Paragraph> paragraphs;
	private String fileName;

	/*
	 * private constructor
	 */
	public TokenizerTask() {
		this.paragraphs = new ArrayList<Paragraph>();
		this.fileName="";
	}
	/*
	 * getter
	 */
	public String getFileName() {
		return fileName;
	}

	/*
	 * setter
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/*
	 * getter: returns the list of paragraphs
	 */
	public  ArrayList<Paragraph> getParagraphs() {
		return paragraphs;
	}

	/*
	 * setter
	 */
	public  void setParagraphs(ArrayList<Paragraph> paragraphs) {
		this.paragraphs = paragraphs;
	}

	/*
	 * process the paragraph to extract sentences
	 */
	public void process(String para){

		if( !para.isEmpty()){

			//System.out.println("Para:"+para);
			Paragraph paragraph = new Paragraph();
			paragraph.process(para);
			//System.out.println(paragraph.toString());
			paragraphs.add(paragraph);
		}


	}

	/*
	 * Read the input file and extract the paragraphs
	 */
	public void readFile() {
		BufferedReader br = null;

		try {

			String currentLine;

			br = new BufferedReader(new FileReader(fileName));

			while ((currentLine = br.readLine()) != null) {

				if (!currentLine.equals("")) {
					String[] paragraphs = currentLine.split("\\n\\n");

					for (String paragraphEntry : paragraphs) {
						//process(paragraphEntry);
						//System.out.println("Para:"+paragraphEntry);
						Paragraph paragraph = new Paragraph();
						paragraph.process(paragraphEntry);
						this.paragraphs.add(paragraph);
					}
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
	/*
	 * Convert the Java Object Model to output in XML document
	 */
	public void convertObjectToXML() throws TransformerException{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element fileElement = doc.createElement("TextFile");
			doc.appendChild(fileElement);

			// set attribute to file element
			Attr attr = doc.createAttribute("filename");
			attr.setValue(this.fileName);
			fileElement.setAttributeNode(attr);
			
			//Tagged for paragraphs,sentence,word and punctuation

			for (Paragraph paragraph : paragraphs) { // for each paragraph

				Element paragraphElement = doc.createElement(paragraph.getXMLTag());
				fileElement.appendChild(paragraphElement);
				//System.out.println("PARAGRAPH:"+paragraph.getSentences().size());
				for (Sentence sentence : paragraph.getSentences()) { // for each sentence
					Element sentenceElement = doc.createElement(sentence.getXMLTag());
					paragraphElement.appendChild(sentenceElement);
					//System.out.println("Sentence:"+sentence.getSentencesItems().size());
					for (Items sentenceItem : sentence.getSentencesItems()) { // for each sentence  item
						if (sentenceItem instanceof Word) {
							Word word = (Word)sentenceItem;
							Element wordElement = doc.createElement(word.getXMLTag());
							wordElement.appendChild(doc.createTextNode(word.getWord()));
							sentenceElement.appendChild(wordElement); //output text for each word
							//System.out.println("Word:"+word.getWord());
						}
						else if (sentenceItem instanceof Punctuation) {
							Punctuation punctuation = (Punctuation)sentenceItem;
							Element punctuationElement = doc.createElement(punctuation.getXMLTag());
							punctuationElement.appendChild(doc.createTextNode(punctuation.getPunctuation()));
							sentenceElement.appendChild(punctuationElement); //output text for each punctuation
							//System.out.println("Punctuation:"+punctuation.getPunctuation());
						}	

					}
				}
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);

			//System.out.println(fileName.lastIndexOf("/"));
			StreamResult result = new StreamResult(new File("output_"+fileName.substring(fileName.lastIndexOf("/")+1, fileName.length()-4)+".xml"));
			transformer.transform(source, result);

			System.out.println("File: "+"output_"+fileName.substring(fileName.lastIndexOf("/")+1, fileName.length()-4)+".xml"+" saved!");

		}
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
