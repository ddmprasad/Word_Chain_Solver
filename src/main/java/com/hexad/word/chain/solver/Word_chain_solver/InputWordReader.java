/**
 * 
 */
package com.hexad.word.chain.solver.Word_chain_solver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.hexad.word.chain.solver.Word_chain_solver.exception.WordChainSolverException;

/**
 * @author prasad
 *
 */
public class InputWordReader {

	private static final Logger log = Logger.getLogger(InputWordReader.class);
	
	private static InputWordReader reader = null;
	private String firstWord = null;
	private String secondWord = null;
	private int wordLength = 0;
	
	public static InputWordReader getReader() {
		return reader;
	}

	public String getFirstWord() {
		return this.firstWord;
	}

	
	public String getSecondWord() {
		return this.secondWord;
	}

	private InputWordReader() {
	}

	/**
	 * This method gives singleton instance of class
	 * @return
	 */
	public static InputWordReader getInstance() {
		if(reader == null) {
			reader = new InputWordReader();
		}
		return reader;
	}

	/**SSSS
	 * This method reads two input words from keyboard entry
	 * @throws IOException
	 */
	public void readWords() throws IOException 
	{	
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		//boolean isUnEqualLengthWords = true;		
		while (true)
		{
			log.info("Enter the first word:");
			//convert all the words to lower letters 
			firstWord = br.readLine().toLowerCase();
			log.info("Enter the last word:");
			secondWord = br.readLine().toLowerCase();
			if(firstWord.length() == secondWord.length()) {
				wordLength = firstWord.length();
				break;
			}else {
				log.error("Word length of both the word is not equal");
			}
			
		}
	}

	public int getWordLength() {
		return this.wordLength;
	}
}
