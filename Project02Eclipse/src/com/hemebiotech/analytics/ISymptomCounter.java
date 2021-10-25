package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data into a specified file
 *
 *
 */
public interface ISymptomCounter {
    /**
     * Count symptom occurrences from a list with duplicates
     *
     * @return a TreeMap with symptoms as keys and occurrences as values
     */
    Map<String, Integer> countSymptoms();
}

