package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Write symptoms from a TreeMap to a result.out file
 */
public class WriteSymptomDataFromFile implements ISymptomWriter{
    private String filepath;
    private Map<String, Integer> symptomsList;

    /**
     *
     * @param filepath a full or partial path where the result of the analysis will be saved
     * @param symptomsList A TreeMap containing the list of all occurrences of symptoms ordered alphabetically
     */
    public WriteSymptomDataFromFile(String filepath, Map<String, Integer> symptomsList) {
        this.filepath = filepath;
        this.symptomsList = symptomsList;
    }

    /**
     * Write symptoms and occurrences into specified file in filepath
     *
     * @param TreeMap variables with all symptoms and their occurrences ordered alphabetically
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
