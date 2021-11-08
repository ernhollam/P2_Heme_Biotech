package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**<p><b>Outputs a file with symptoms ordered alphabetically and their occurrences</b>
 * <br>
 *
 * Analyses side effects trend to make a prediction in order to improve our products.<br>
 * It works with a .txt file with all symptoms and their duplicates.<br>
 * It outputs an .out file with all the symptoms and how many times they occurred during the experience.<br>
 *<ul>  <b>AnalyticsCounter</b> is made of three steps:
 * 	<li>Read a simple text file with symptoms and their duplicates</li>
 * 	<li>Analyse the symptoms file and count how many times they appeared</li>
 * 	<li>Write the symptoms alphabetically and the number of occurrences in a .out file</li>
 *</ul>
 * </p>
 * @author Ernholla MARINASY
 *
 * @see ISymptomReader
 * @see ISymptomCounter
 * @see ISymptomWriter
 * @see ReadSymptomDataFromFile
 * @see CountSymptomDataFromFile
 * @see WriteSymptomDataFromFile
 */
public class AnalyticsCounter {

	/** <b>Main method for AnalyticsCounter</b>
	 * <br>
	 * Requires the presence of a <i>symptoms.txt</i> file in the project folder.
	 * <p>In order to output the symptoms alphabetically, <b>AnalyticsCounter</b> is composed of three steps:
	 * <ol>
	 *     <li>Read the symptoms.txt file and output a <i>List</i> variable with all symptoms and their duplicates</li>
	 *     <li>Analyse the <i>List</i> variable, count the symptoms and output a <i>TreeMap</i> (self ordering Collection) to
	 *     order symptoms alphabetically, the <i>TreeMap</i>'s key is the symptom and its value represents how many times it occurred</li>
	 *     <li>Write the <i>TreeMap</i> content into a <i>result.out</i> file</li>
	 * </ol></p>
	 * <br>
	 * The <i>result.out</i> file appears as such: <br>
	 * anxiety 5<br>
	 * arrhythmias 3<br>
	 * ...
	 * <br><br>
	 * @author Ernholla MARINASY
	 *<br>
	 * @see AnalyticsCounter
	 * @see ISymptomReader
	 * @see ISymptomCounter
	 * @see ISymptomWriter
	 * @see ReadSymptomDataFromFile
	 * @see CountSymptomDataFromFile
	 * @see WriteSymptomDataFromFile
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
