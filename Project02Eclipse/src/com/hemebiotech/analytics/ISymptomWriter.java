package com.hemebiotech.analytics;

import java.io.IOException;

/**<b>Anything that will write symptoms and occurrences into a specified file</b>
 *<br>
 * The symptoms must be ordered alphabetically and the file may not contain duplicates
 * <br><br>
 *
 * @author Ernholla MARINASY
 *
 * @see AnalyticsCounter
 * @see WriteSymptomDataFromFile
 * @see WriteSymptomDataFromFile#writeSymptoms()
 */
public interface ISymptomWriter {
    /**<b>Generate a .out file with symptoms ordered alphabetically and their occurrences</b>
     * <br><br>
     * @throws IOException an I/O exception
     * @see ISymptomWriter
     */
    void writeSymptoms() throws IOException;
}

