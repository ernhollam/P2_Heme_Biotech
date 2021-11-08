package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**<b>Writes symptoms from a TreeMap to a result.out file</b>
 *
 * @author Ernholla MARINASY
 *
 * @see com.hemebiotech.analytics.ISymptomWriter
 * @see WriteSymptomDataFromFile#WriteSymptomDataFromFile(String, Map)
 * @see WriteSymptomDataFromFile#writeSymptoms()
 */
public class WriteSymptomDataFromFile implements ISymptomWriter{
    /**
     * Output file path
     *
     * @see WriteSymptomDataFromFile
     * @see WriteSymptomDataFromFile#writeSymptoms()
     */
    private String filepath;

    /**
     * List of all symptoms in a Map variable
     * @see WriteSymptomDataFromFile
     * @see WriteSymptomDataFromFile#writeSymptoms()
     */
    private Map<String, Integer> symptomsList;

    /**Constructor for WriteSymptomDataFromFile
     *
     * @param filepath a full or partial path where the result of the analysis will be saved
     * @param symptomsList a <em>TreeMap</em> containing the list of all occurrences of symptoms ordered alphabetically
     * <br><br>
     * @see WriteSymptomDataFromFile
     */
    public WriteSymptomDataFromFile(String filepath, Map<String, Integer> symptomsList) {
        this.filepath = filepath;
        this.symptomsList = symptomsList;
    }

    /**<b>Writes symptoms and occurrences into specified file in filepath</b>
     *<br>
     *
     * <p>
     *     Uses buffered writer to reduce access to disk.<br>
     *     Writes each <em>TreeMap</em>'s key-value pair into <em>result.out</em> file
     * </p>
     * <br>
     * @throws IOException an I/O exception
     *
     * @see AnalyticsCounter
     * @see ISymptomWriter
     * @see WriteSymptomDataFromFile
     */
    @Override
    public void writeSymptoms() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            if (filepath != null) {
                for (Map.Entry idx_symptom : symptomsList.entrySet()) {
                    writer.write(idx_symptom.getKey() + " " + idx_symptom.getValue() + "\n");
                }
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
