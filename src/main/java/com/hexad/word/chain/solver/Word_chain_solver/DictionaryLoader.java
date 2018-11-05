/**
 * 
 */
package com.hexad.word.chain.solver.Word_chain_solver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.hexad.word.chain.solver.Word_chain_solver.constants.WordChianSolverConstant;
import com.hexad.word.chain.solver.Word_chain_solver.exception.WordChainSolverException;

/**
 * @author prasad
 *
 */
public class DictionaryLoader {

	private static final Logger log = Logger.getLogger(DictionaryLoader.class);
	
	private static Set<String> dictinaory= null;
	
	private static DictionaryLoader loader = null;
	
	public static Set<String> getDictinaory() {
		return Collections.unmodifiableSet(dictinaory);
	}

	public DictionaryLoader(final String dictionaryPath) {
		loadDictionary(dictionaryPath);
	}
	
	/**
	 * This method loads all the words from dictionary
	 * @param dictionaryPath
	 */
	private void loadDictionary(String dictionaryPath) {
		final File file = new File(dictionaryPath);
		
		String word = null;
		try {
			BufferedReader bffrRdr = getFileData(file);
			log.debug("Dictionary file loaded");
			dictinaory = new LinkedHashSet<String>();
			while((word = bffrRdr.readLine())!=null){
				// load only similar length words from dictionary to process as it saves memory and time 
				// also make all words lower case to remove case sensitivity
				if(InputWordReader.getInstance().getWordLength() == word.length()) {
					dictinaory.add(word.toLowerCase());
				}
			}
		} catch (IOException e) {
			log.error(WordChianSolverConstant.INVALID_FILE);
		} catch (WordChainSolverException e) {
			log.error(WordChianSolverConstant.ERROR_LOADING_FILE);
		}
	}
	
	/**
	 * This methods load incoming text dictionary file with words
	 * @param file
	 * @return
	 * @throws WordChainSolverException
	 */
	private static BufferedReader getFileData(File file) throws WordChainSolverException{
		try{
			return new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			throw new WordChainSolverException(WordChianSolverConstant.ERROR_LOADING_FILE);
		}
	}
}
