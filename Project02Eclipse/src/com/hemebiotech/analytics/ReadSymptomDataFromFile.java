package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**<b> Simple brute force implementation of reading a file line by line</b>
 *
 * @author Caroline HEDOT
 *
 * @see com.hemebiotech.analytics.ISymptomReader
 * @see ReadSymptomDataFromFile#ReadSymptomDataFromFile
 * @see ReadSymptomDataFromFile#getSymptoms()
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	/**
	 * Path to input .txt file
	 *
	 * @see ReadSymptomDataFromFile
	 * @see ReadSymptomDataFromFile#getSymptoms()
	 */
	private final String filepath;
	
	/**Constructor for ReadSymptomDataFromFile
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 * <br><br>
	 * @see ReadSymptomDataFromFile
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	/**<b>Read a .txt file and output a list of symptoms</b>
	 * <br>
	 * <p>
	 *     Uses a buffered reader to reduce access to disk.<br>
	 *     Reads file line by line and writer each line into a <em>List</em> variable.
	 * </p>
	 * @return A List of symptoms as they appear in the input file
	 * <br><br>
	 * @see AnalyticsCounter
	 * @see ISymptomReader
	 * @see ReadSymptomDataFromFile
	 */
	@Override
	public List<String> getSymptoms() {
		List<String> result = new ArrayList<>();

		if (filepath != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
