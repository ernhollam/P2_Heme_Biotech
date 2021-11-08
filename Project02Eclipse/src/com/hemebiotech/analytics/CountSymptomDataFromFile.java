package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Use loops to count the symptoms from a List variable
 *
 */
public class CountSymptomDataFromFile implements ISymptomCounter {

	private final List<String> symptomsList;

	/**
	 *
	 * @param symptomsList a List<String> of all symptoms found in file
	 */
	public CountSymptomDataFromFile(List<String> symptomsList) {
		this.symptomsList = symptomsList;
	}

	@Override
	public Map<String, Integer> countSymptoms() {
		if (symptomsList.size()==0){
			// If provided list is empty, return empty TreeMap
			return new TreeMap<>();
		}
		else {
			// Browse list and count symptoms
			Map<String, Integer> result = new TreeMap<>();
			for (int indexList = 0; indexList < symptomsList.size(); indexList++) {
				// Initialize number of occurrence of selected symptom
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