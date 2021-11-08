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
    private String filepath;
    private Map<String, Integer> symptomsList;

    /**<b>Constructor for WriteSymptomDataFromFile</b>
     *
     * @param filepath a full or partial path where the result of the analysis will be saved
     * @param symptomsList a <i>TreeMap</i> containing the list of all occurrences of symptoms ordered alphabetically
     * <br><br>
     * @see WriteSymptomDataFromFile
     */
    public WriteSymptomDataFromFile(String filepath, Map<String, Integer> symptomsList) {
        this.filepath = filepath;
        this.symptomsList = symptomsList;
    }

    /**<b>Write symptoms and occurrences into specified file in filepath</b>
     *<br>
     *
     * <p>
     *     Uses buffered writer to reduce access to disk.<br>
     *     Write each <i>TreeMap</i>'s key-value pair into <i>result.out</i> file
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
