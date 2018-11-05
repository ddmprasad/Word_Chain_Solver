/**
 * 
 */
package com.hexad.word.chain.solver.Word_chain_solver;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.hexad.word.chain.solver.Word_chain_solver.constants.WordChianSolverConstant;

/**
 * @author prasad
 *
 */
public class WordChainProcessorTest {

	
	private static final Logger log = Logger.getLogger(WordChainProcessorTest.class);
	/**
	 * Test method for {@link com.hexad.word.chain.solver.Word_chain_solver.WordChainProcessor#processWordChain()}.
	 */
	@Test
	public void testProcessWordChainWithValidWordChain() {
		WordChainProcessor object = new WordChainProcessor();
		log.info("Positive case : please enter words having valid word chain");
		String result = object.processWordChain();
		assertEquals(WordChianSolverConstant.YES_TEXT, result);
	}

	/**
	 * Test method for {@link com.hexad.word.chain.solver.Word_chain_solver.WordChainProcessor#processWordChain()}.
	 */
	@Test
	public void testProcessWordChainWithInValidWordChain() {
		WordChainProcessor object = new WordChainProcessor();
		log.info("Negative case : please enter words having Invalid word chain");
		String result = object.processWordChain();
		assertEquals(WordChianSolverConstant.NO_TEXT, result);
	}
	
}
