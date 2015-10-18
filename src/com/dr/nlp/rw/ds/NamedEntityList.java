package com.dr.nlp.rw.ds;

import java.util.ArrayList;
/*
 * Class: NamedEntityList
 * The data structure to store all the named-entities read from the given input file and stores as an
 * arraylist.
 * The class uses Singleton method to use the object.
 */

public class NamedEntityList {
	//Singleton instance
	private static NamedEntityList oneObj;
	private ArrayList<String> namedEntityList;

	/*
	 * getter method: returns a list of named-entities
	 */
	public ArrayList<String> getNamedEntityList() {
		return namedEntityList;
	}
	/*
	 * setter method
	 */
	public void setNamedEntityList(ArrayList<String> namedEntityList) {
		this.namedEntityList = namedEntityList;
	}
	/**
	 * Create private constructor
	 */
	private NamedEntityList(){

	}
	/**
	 * Create a static method to get instance.
	 */
	public static NamedEntityList getInstance(){
		if(oneObj == null){
			oneObj = new NamedEntityList();
		}
		return oneObj;
	}


}
