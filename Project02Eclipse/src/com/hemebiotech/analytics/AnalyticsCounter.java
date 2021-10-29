package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	public static void main(String... args) throws Exception {
		// Create local variables for all function outputs
		List<String> symptomsReadFromFile;
		Map<String,Integer> symptomsWithOccurrences;

		// Create instance of symptom reader
		ISymptomReader listFromSymptomReader = new ReadSymptomDataFromFile("symptoms.txt");
		symptomsReadFromFile = listFromSymptomReader.getSymptoms();

		//Count symptoms in symptomsFromFile
		ISymptomCounter symptomsListFromFile = new CountSymptomDataFromFile(symptomsReadFromFile);
		symptomsWithOccurrences = symptomsListFromFile.countSymptoms();

		// Write symptoms in specified file
		ISymptomWriter myFileWriter = new WriteSymptomDataFromFile("result.out", symptomsWithOccurrences);
		myFileWriter.writeSymptoms();
	}
}
