package com.hemebiotech.analytics;

import java.util.List;

/**<b>Anything that will read symptom data from a source</b>
 * <br>
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * <br><br>
 * The implementation does not need to order the list
 * <br><br>
 * @author Caroline HEDOT
 *
 * @see AnalyticsCounter
 * @see ReadSymptomDataFromFile
 * @see ReadSymptomDataFromFile#getSymptoms()
 */
public interface ISymptomReader {
	/**<b>If no data is available, return an empty List</b>
	 * <br><br>
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 *
	 * @see ISymptomReader
	 */
	List<String> getSymptoms();
}
