/**
 * 
 */
package com.hexad.word.chain.solver.Word_chain_solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.apache.log4j.Logger;

import com.hexad.word.chain.solver.Word_chain_solver.constants.WordChianSolverConstant;

/**
 * @author prasad
 *
 */
public class WordChainFinder {
	
	private static final Logger log = Logger.getLogger(WordChainFinder.class);

	private Set<String> dictionaryCopy = null;
	List<String> wordChain = new ArrayList<String>();

	public WordChainFinder() {
		this.dictionaryCopy = DictionaryLoader.getDictinaory();
	}

	/**
	 * This method validate the word from dictionary
	 * @param word
	 * @return
	 */
	private boolean isValidWord(final String word) {
		return this.dictionaryCopy.contains(word);
	}

	/**
	 * This method is exposed to find the chain of words
	 * @param firstWord
	 * @param secondWord
	 * @return
	 */
	public List<String> findPossibleWordChain(final String firstWord, final String secondWord) {
		wordChain = new ArrayList<String>();
		if (this.isValidWord(firstWord) && this.isValidWord(secondWord)) {
			log.debug("Start finding chains");
			findChains(firstWord, secondWord, 0);
		}
		checkVaildChains();
		return wordChain;
	}

	/**
	 * This method check the validity of chain if it contains on the entered letters
	 */
	private void checkVaildChains() {
		if(this.wordChain.size()== 1 && this.wordChain.get(0).split(WordChianSolverConstant.HYPHEN_SEPARATOR).length == 2) {
			wordChain = new ArrayList<String>();
		}
	}

	/**
	 * This method compute all the valid chain in from the words
	 * @param firstWord
	 * @param secondWord
	 * @param level
	 */
	private void findChains(final String firstWord, final String secondWord, int level) {
		List<String> allPossibleWordsChain = this.getNextWordInChain(firstWord, secondWord);
		while (true) {
			if (this.wordChain.size() > 0) {
				break;
			}
			final List<String> allPossibleWordsChainCpy = new ArrayList<String>(allPossibleWordsChain);
			allPossibleWordsChain = new ArrayList<String>();
			for (final String newword : allPossibleWordsChainCpy) {
				//iterate with valid chains
				allPossibleWordsChain.addAll(this.getNextWordInChain(newword, secondWord));
			}
		}
	}

	/**
	 * This method find out all the possible chains with valid words from a to z
	 * @param fullword
	 * @param end
	 * @return
	 */
	private List<String> getNextWordInChain(final String fullword, final String end) {
		final String word = this.getlastword(fullword);
		final ArrayList<String> allPossibleWords = new ArrayList<String>();
		for (int i = 0; i < word.length(); i++) {
			for (char j = 'a'; j <= 'z'; j++) {
				final char[] newWord = word.toCharArray();
				//replace 
				newWord[i] = j;
				final String newword = String.valueOf(newWord);
				if (newword.equals(end)) {
					//if there is no valid chain word and it matches with second word
					this.wordChain.add(fullword + WordChianSolverConstant.HYPHEN_SEPARATOR + newword);
				} else if (!newword.equals(word) && !fullword.startsWith(newword + WordChianSolverConstant.HYPHEN_SEPARATOR)
						&& !fullword.contains(WordChianSolverConstant.HYPHEN_SEPARATOR + newword 
								+ WordChianSolverConstant.HYPHEN_SEPARATOR) && this.dictionaryCopy.contains(newword)) {
					//add to valid possible word list if its valid
					allPossibleWords.add(fullword + WordChianSolverConstant.HYPHEN_SEPARATOR + newword);
				}
			}
		}
		return allPossibleWords;
	}

	/**
	 * This Method takes out the last word computed in word chain
	 * @param lastWorkingWord
	 * @return
	 */
	private String getlastword(final String lastWorkingWord) {
		final String[] allWords = lastWorkingWord.split(WordChianSolverConstant.HYPHEN_SEPARATOR);
		return allWords[allWords.length - 1];
	}

}
