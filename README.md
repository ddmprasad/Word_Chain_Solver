# Word Chain Solver : 
  Two words are connected by a word chain if it is possible to change one into the other by making a series of single-character changes, such that every intermediate form is also a word. 
For example, CAT and DOG are connected with a word chain because CAT, COT, COG and DOG are all words. DEMONIC and UMBRELLA are not.
Write a program that takes a list of words and then reads pairs of words on stdin and prints "YES"; if the words are connected by a chain, and "NO" if they are not. If YES, the words in the word chain should be listed out on the console. The program should take the path to the word list from a file, and should then loop,reading pairs of whitespace-delimited words from the file and printing "YES" or "NO"

# Constraints:
  1) Only one operation is allowed between words in the chain.
  2) The operation may consist of changing any single character but the length of the words should not change. 
  3) All comparisons should be case insensitive.
  4) The answer should return the shortest word chain that solves each word chain puzzle.



# *****Proposed Solution*****

# Assumptions for Development
    1)	Inputs dic1)tionary supplied in input Text (.txt) file. 
    2)	Dictionary words are loaded only for input word length to save memmory and complexity.
    3)	Log4J is used for logging purpose as external jar.
    4)	Exception Handling is considered.
    5)  Design proposed consist of using Singleton design pattern for loading and reading words

# Steps to run the project
    1)	Go to the Eclipse
    2)	select the project folder
    3)	Run maven clean install
    4)	It will run the test cases and gives the output

      
# Logger level
    1)	INFO in current configuration in log4j.properties file
    2)	It can be changed to DEBUG if want to get more information
    3)	Output log file gets generated at C:\\Temp\\log4j-application.log
