package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data into a specified file
 *
 *
 */
public interface ISymptomWriter {
    /**
     * Generate a .out file with symptoms and occurrences
     *
     * @return a .out file with symptoms and their occurrences
     */
    Map<String, Integer> writeSymptoms();
}

