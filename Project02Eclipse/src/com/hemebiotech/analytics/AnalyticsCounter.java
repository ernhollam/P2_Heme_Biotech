package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/** Outputs a file with symptoms ordered alphabetically and their occurrences
 *
 * Analyses side effects trend to make a prediction in order to improve our products.
 * It works with a .txt file with all symptoms and their duplicates.
 * It outputs an .out file with all the symptoms and how many times they occurred during the experience.
 *
 * AnalyticsCounter is made of three steps:
 * 		- Read a simple text file with symptoms and their duplicates
 * 		- Analyse the symptoms file and count how many times they appeared
 * 		- Write the symptoms alphabetically and the number of occurrences in a .out file
 *
 * @author Ernholla MARINASY
 */
public class AnalyticsCounter {

	/** Main method for AnalyticsCounter
	 *
	 */
	public static void main(String... args) throws Exception {
		// Create local variables for all function outputs
		List<String> symptomsReadFromFile;
		Map<String,Integer> symptomsWithOccurrences;

		// Read symptoms from specified file
		ISymptomReader listFromSymptomReader = new ReadSymptomDataFromFile("symptoms.txt");
		symptomsReadFromFile = listFromSymptomReader.getSymptoms();

		//Count symptoms in symptomsFromFile
		ISymptomCounter symptomsListFromFile = new CountSymptomDataFromFile(symptomsReadFromFile);
		symptomsWithOccurrences = symptomsListFromFile.countSymptoms();

		// Write symptoms in result.out
		ISymptomWriter myFileWriter = new WriteSymptomDataFromFile("result.out", symptomsWithOccurrences);
		myFileWriter.writeSymptoms();
	}
}
