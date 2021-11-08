package com.hemebiotech.analytics;

import java.util.Map;

/**<b>Anything that will count symptoms</b>
 *<br><br>
 *
 * @author Ernholla MARINASY
 *
 * @see AnalyticsCounter
 * @see CountSymptomDataFromFile
 * @see CountSymptomDataFromFile#countSymptoms()
 */
public interface ISymptomCounter {
    /**<b>Count symptom occurrences from a list with duplicates</b>
     *<br><br>
     * @return a TreeMap with symptoms as keys and occurrences as values
     *
     * @see ISymptomCounter
     */
    Map<String, Integer> countSymptoms();
}

