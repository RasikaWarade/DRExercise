package com.dr.nlp.rw.ds;

/*
 * Class: NamedEntity
 * The data structure to store the named-entities.
 */

public class NamedEntity extends Items{

	private String namedEntity;
	/*
	 * getter method: returns Name-entity
	 */
	public String getNamedEntity() {
		return namedEntity;
	}

	/*
	 * setter method
	 */
	public void setNamedEntity(String namedEntity) {
		this.namedEntity = namedEntity;
	}
	
	/*
	 * get the XML tag name for the object 
	 */
	public String getXMLTag(){
		return "Named-Entity";
	}
}
