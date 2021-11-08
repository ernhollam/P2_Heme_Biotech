package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**<p> <b>A counter that can count and order symptoms alphabetically from a file</b><br>
 * Implements ISymptomCounter interface<br>
 * Uses two for-loops to count the symptoms from a <i>List</i> variable<br>
 * Has one method <i>countSymptoms</i><br><br>
 * </p>
 * @author Ernholla MARINASY
 *
 * @see com.hemebiotech.analytics.ISymptomCounter
 * @see CountSymptomDataFromFile#CountSymptomDataFromFile(List)
 * @see CountSymptomDataFromFile#countSymptoms
 */
public class CountSymptomDataFromFile implements ISymptomCounter {

	private final List<String> symptomsList;

	/**<b>Constructor for CountSymptomDataFromFile</b>
	 *
	 * @param symptomsList a List<String> of all symptoms found in file
	 *<br><br>
	 * @see CountSymptomDataFromFile
	 */
	public CountSymptomDataFromFile(List<String> symptomsList) {
		this.symptomsList = symptomsList;
	}

	/**<b>Counts symptoms read from file and return an alphabetically ordered list of symptoms</b>
	 * <br>
	 * <p>The secret lies in the use of a <i>TreeMap</i>, an efficient means of storing key-value pairs in sorted order.<br>
	 * The keys maintained in the map are the symptoms or side effects, the values mapped are the side effects' occurrences.<br>
	 * <br>
	 * <b>countSymptoms</b> works as follows:
	 * <ol>
	 *     <li>Check if the specified <i>List</i> is empty, if so, return an empty <i>TreeMap</i></li>
	 *     <li>If the <i>List</i> contains symptoms, browse it, use one symptom at a time.
	 *     First see if the symptom has already been counted, then browse the <i>List</i> again and count how many times it appears</li>
	 * </ol>
	 * </p>
	 * @return A TreeMap with all symptoms and their occurrences
	 *<br><br>
	 * @see AnalyticsCounter
	 * @see ISymptomCounter
	 * @see CountSymptomDataFromFile
	 */
	@Override
	public Map<String, Integer> countSymptoms() {
		if (symptomsList.size()==0){
			return new TreeMap<>();
		}
		else {
			Map<String, Integer> result = new TreeMap<>();
			for (int indexList = 0; indexList < symptomsList.size(); indexList++) {
				int nbOccurrencesOfSymptom = 0;
				// Create temporary variable for the symptom to count
				String currentSymptom = symptomsList.get(indexList);
				if (!result.containsKey(currentSymptom)) {
					// Browse list with current symptom and compare it to symptoms in symptomsList to count how many times it appears in list
					for (String symptomInList : symptomsList) {
						if (symptomInList.equalsIgnoreCase(currentSymptom)) {
							nbOccurrencesOfSymptom += 1;
						}
					}
					result.put(currentSymptom, nbOccurrencesOfSymptom); // Add new symptom to result map
				}
			}
			return result;
		}

	}

}
