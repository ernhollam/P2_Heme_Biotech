package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**<p> <b>A counter that can count and order symptoms alphabetically from a file</b><br>
 * Uses two for-loops to count the symptoms from a <em>List</em> variable<br><br><br>
 * </p>
 * @author Ernholla MARINASY
 *
 * @see com.hemebiotech.analytics.ISymptomCounter
 * @see CountSymptomDataFromFile#CountSymptomDataFromFile(List)
 * @see CountSymptomDataFromFile#countSymptoms
 */
public class CountSymptomDataFromFile implements ISymptomCounter {
	/**
	 * List of all symptoms
	 */
	private final List<String> symptomsList;

	/**Constructor for CountSymptomDataFromFile
	 *
	 * @param symptomsList a List of all symptoms found in file
	 *<br><br>
	 * @see CountSymptomDataFromFile
	 */
	public CountSymptomDataFromFile(List<String> symptomsList) {
		this.symptomsList = symptomsList;
	}

	/**<b>Counts symptoms read from file and return an alphabetically ordered list of symptoms</b>
	 *
	 * <p>The secret lies in the use of a <em>TreeMap</em>, an efficient means of storing key-value pairs in sorted order.<br>
	 * The keys maintained in the map are the symptoms or side effects, the values mapped are the side effects' occurrences.<br>
	 * <br>
	 * <strong>countSymptoms</strong> works as follows:
	 * <ol>
	 *     <li>Check if the specified <em>List</em> is empty, if so, return an empty <em>TreeMap</em></li>
	 *     <li>If the <em>List</em> contains symptoms, browse it, use one symptom at a time.
	 *     First see if the symptom has already been counted, then browse the <em>List</em> again and count how many times it appears</li>
	 * </ol>
	 * @return A TreeMap with all symptoms and their occurrences
	 *<br><br>
	 * @see AnalyticsCounter
	 * @see ISymptomCounter
	 * @see CountSymptomDataFromFile
	 */
	@Override
	public Map<String, Integer> countSymptoms() {
		Map<String, Integer> res;
		if (symptomsList.size() == 0) {
			res = new TreeMap<>();
		} else {
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
			res = result;
		}

		return res;
	}

}
