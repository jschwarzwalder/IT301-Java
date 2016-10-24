/**
 * Jami Schwarzwalder
 * Oct 23, 2016
 * SharedData.java
 * Manages an array list of string values that will be pulled from each file.
 */
package edu.it.greenriver.liststhread;

import java.util.ArrayList;

/**
 * Manages an array list of string values that will be pulled from each file.
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class SharedData
{
    //create a static array list field here...
	private static ArrayList<String> wordsFromFile = new ArrayList<String>();

    /**
     * Adds a word to the array list
     * 
     * @param word a String to be added to List
     */
    public static void add(String word)
    {	
    	synchronized(System.out){
	    	//add word to the array list
	    	wordsFromFile.add(word);
    	}
    }

    /**
     * Returns the number of elements in the array list
     * 
     * @return size of array list
     */
    public static int wordPhraseTotal()
    {
    	synchronized(System.out){
	        //return the number of elements in the array list
	    	return wordsFromFile.size();
    	}
    }

    /**
     * Returns the element at the index "position" in the array list
     * 
     * @param position of element to return
     * @return String from array at index given
     */
    public static String getWordPhrase(int position)
    {	
    	synchronized(System.out){
	        //returns the element at index "position" in the array list
	    	return wordsFromFile.get(position);
    	}
    }
}
