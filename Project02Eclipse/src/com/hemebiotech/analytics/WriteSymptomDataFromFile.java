package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomDataFromFile implements ISymptomWriter{
    private String filepath;

    /**
     *
     * @param filepath a full or partial path where the result of the analysis will be saved
     */
    public WriteSymptomDataFromFile (String filepath) {
        this.filepath = filepath;
    }


    public FileWriter WriteKnownSymptoms(int headCount, int rashCount, int pupilCount) throws IOException {
        FileWriter writer = new FileWriter (filepath);
        writer.write("headache: " + headCount + "\n");
        writer.write("rash: " + rashCount + "\n");
        writer.write("dialated pupils: " + pupilCount + "\n");
        writer.close();

        return writer;
    }

    /**
     * Generate a .out file with symptoms and occurrences
     *
     * @return a .out file with symptoms and their occurrences
     */
    @Override
    public Map<String, Integer> SetSymptoms() {
        return null;
    }
}
