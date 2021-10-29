package com.hemebiotech.analytics;

import java.io.IOException;

/**
 * Anything that will write symptom data into a specified file
 *
 *
 */
public interface ISymptomWriter {
    /**
     * Generate a .out file with symptoms and occurrences
     */
    void writeSymptoms() throws IOException;
}

