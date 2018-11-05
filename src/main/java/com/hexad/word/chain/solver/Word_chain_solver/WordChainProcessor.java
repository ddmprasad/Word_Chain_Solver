/**
 * 
 */
package com.hexad.word.chain.solver.Word_chain_solver;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.hexad.word.chain.solver.Word_chain_solver.constants.WordChianSolverConstant;

/**
 * @author prasad
 *
 */
public class WordChainProcessor {

	private static final Logger log = Logger.getLogger(WordChainProcessor.class);
	
	/**
	 * This is a processor which sets data and calls word chain finder
	 * @return
	 */
	public String processWordChain() {
		List<String> result = null;
		try {
			//Take user inputs
			InputWordReader.getInstance().readWords();
			//load Dictionary
			new DictionaryLoader("src/main/resources/dictionary.txt");
			//find word chain for input words
			WordChainFinder wordChainFinder = new WordChainFinder();
			result = wordChainFinder.findPossibleWordChain(InputWordReader.getInstance().getFirstWord(),
					InputWordReader.getInstance().getSecondWord());
			log.debug("All possible word chains are :");
			for (String string : result) {
				log.debug(string);
			}
		} catch (IOException e) {
			log.error(WordChianSolverConstant.ERROR_LOADING_FILE);
		}
		//if any single word chain exists it return answer as Yes and No if no chains are present
		return (result != null && result.size() > 0) ? WordChianSolverConstant.YES_TEXT : WordChianSolverConstant.NO_TEXT;
	}
}
