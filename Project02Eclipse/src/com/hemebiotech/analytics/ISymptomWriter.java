package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 *
 * The implementation does not need to order the list
 *
 */
public interface ISymptomWriter {
    /**
     * Generate a .out file with symptoms and occurrences
     *
     * @return a .out file with symptoms and their occurrences
     */
    Map<String, Integer> SetSymptoms ();
}

