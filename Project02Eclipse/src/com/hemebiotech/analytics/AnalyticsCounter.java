package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;

public class AnalyticsCounter {
	private static int headCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String... args) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

        // Create instance of symptom reader and them from specified file
        /*ReadSymptomDataFromFile symptomsFromFile = new ReadSymptomDataFromFile("symptoms.txt");
		symptomsFromFile.GetSymptoms();*/

		int i = 0;
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}

		// Write symptoms in specified file
		WriteSymptomDataFromFile myFileWriter = new WriteSymptomDataFromFile("result.out");
		myFileWriter.WriteKnownSymptoms(headCount, rashCount, pupilCount);
	}
}
