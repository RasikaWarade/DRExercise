package com.dr.nlp.rw.ds;

/*
 * Class: NamedEntity
 * The data structure to store the named-entities.
 */

public class NamedEntity extends Items{

	private String namedEntity;

	public String getNamedEntity() {
		return namedEntity;
	}

	public void setNamedEntity(String namedEntity) {
		this.namedEntity = namedEntity;
	}

	public String getXMLTag(){
		return "Named-Entity";
	}
}
