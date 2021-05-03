package comp3111.popnames;

import java.util.Arrays;

import org.apache.commons.csv.*;
import edu.duke.*;
/**
 * This package handles all query related to the birth dataset
 * <B>WARNING all func here will assume the input is valid</B> 
 * 
 * @author kalung
 *
 */
public class AnalyzeNames {
	/**
	 * Parse the csv and return aa array of CSVRecord 
	 * @param year the year of interest
	 * @return a array of record found on that year
	 */
	public static CSVParser getFileParser(int year) {
		FileResource fr = new FileResource(String.format("dataset/yob%s.csv", year));
		return fr.getCSVParser(false);
	}
	
	/**
	 * Get the summary of birth
	 * @param year the year of interest
	 * @return the report in string
	 */
	public static String getSummary(int year) {
		String oReport = "";
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		int totalNames = 0;
		int uniqueBoys = 0;
		int uniqueGirls = 0;

		oReport = String.format("Summary (Year of %d):\n", year);
		for (CSVRecord rec : getFileParser(year)) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += numBorn;
			totalNames += 1;
			if (rec.get(1).equals("M")) {
				totalBoys += numBorn;
				uniqueBoys++;
			} else {
				totalGirls += numBorn;
				uniqueGirls++;
			}
		}

		oReport += String.format("Total Births = %,d\n", totalBirths);
		oReport += String.format("***Baby Girls = %,d\n", totalGirls);
		oReport += String.format("***Baby Boys = %,d\n", totalBoys);

		oReport += String.format("Total Number of Unique Names = %,d\n", totalNames);
		oReport += String.format("***Unique Names (baby girls) = %,d\n", uniqueGirls);
		oReport += String.format("***Unique Names (baby boys) = %,d\n", uniqueBoys);

		return oReport;
	}

	/**
	 * Get the rank of a name in the csv file
	 * @param year the year of interest
	 * @param name the name of interest
	 * @param gender the gender of interest(M/F)
	 * @return rank if found;-1 if not found
	 */
	public static int getRank(int year, String name, String gender) {
		boolean found = false;
		int oRank = 0;
		int rank = 1;
		for (CSVRecord rec : getFileParser(year)) {
			// Increment rank if gender matches param
			if (rec.get(1).equals(gender)) {
				// Return rank if name matches param
				if (rec.get(0).equals(name)) {
					found = true;
					oRank = rank;
					break;
				}
				rank++;
			}
		}
		if (found)
			return oRank;
		else
			return -1;
	}
	
	/**
	 * Get the birth name of year by rank
	 * @param year the year of interest
	 * @param rank the rank of interest
	 * @param gender the gender of interest(M/F)
	 * @return Name of interest if found;error message if not found
	 */
	public static String getName(int year, int rank, String gender) {
		boolean found = false;
		String oName = "";
		int currentRank = 0;

		// For every name entry in the CSV file
		for (CSVRecord rec : getFileParser(year)) {
			// Get its rank if gender matches param
			if (rec.get(1).equals(gender)) {
				// Get the name whose rank matches param
				currentRank++;
				if (currentRank == rank) {
					found = true;
					oName = rec.get(0);
					break;
				}
			}
		}
		if (found)
			return oName;
		else
			return "information on the name at the specified rank is not available";
	}

	// for Task 1 calculating the total number of that specific name
	/**
	 * Get the total birth for a gender in a year
	 * @param year the year of interest
	 * @param gender the gender of interest(M/F)
	 * @return the total occurrence;0 if error
	 */
	public static int getTotalOccur(int year, String gender) {

		int totalNumber = 0;
		// For every name entry in the CSV file
		for (CSVRecord rec : getFileParser(year)) {
			// check if this is correct gender
			if (rec.get(1).equals(gender)) {
				// addition to the total number
				totalNumber += Integer.parseInt(rec.get(2));

			}

		}

		return totalNumber;
	}
	/**
	 * Get the number of birth for a specific rank in a year
	 * @param year the year of interest
	 * @param gender the gender of interest(M/F)
	 * @param rank  the rank of interest
	 * @return the occurrence(data) in that rank in that year;0 if error
	 */
	public static int getNumber(int year, String gender, int rank) {

		int NumberOccurr = 0;
		int currrank = 0;
		// For every name entry in the CSV file
		for (CSVRecord rec : getFileParser(year)) {
			if (rec.get(1).equals(gender)) {
				currrank++;
				if (rank == currrank) {
					NumberOccurr = Integer.parseInt(rec.get(2));
					break;
				}
			}

		}

		return NumberOccurr;
	}

	//for task 2
	//get the most freq name at specific rank
	public static String get_MostFreqName(int year, int year2, String gender, int rank) {
		String[] name_array = new String[year2-year+1];
		int [] freq = new int [name_array.length];
		int k = 0;
		for(int i = year; i <= year2; i++) {
			name_array[k] = getName(i, rank, gender);
			k++;
		}
		System.out.println(Arrays.toString(name_array));
		int visited = -1;
		for(int i = 0; i < name_array.length; i++) {
			int count = 1;
			for (int j = i+1; j < name_array.length; j++) {
				if(name_array[i].equals(name_array[j])) {
					count++;
					freq[j] = visited;
				}
			}
			if(freq[i] != visited) {
				freq[i] = count;
			}
			
		}
		System.out.println(Arrays.toString(freq));
		int most_freq_index = 0;
		int frequency = freq[0];
		for(int i = 1; i < freq.length; i++) {
			if(freq[i] > frequency && frequency != -1) {
				frequency = freq[i];
				most_freq_index = i;
				System.out.println(frequency);
			}
		}
		return name_array[most_freq_index];
	}
	
	//get the most freq name 's freq at specific rank 
	public static int get_MostFreqName_freq(int year, int year2, String gender, int rank) {
		String[] name_array = new String[year2-year+1];
		int [] freq = new int [name_array.length];
		int k = 0;
		for(int i = year; i <= year2; i++) {
			name_array[k] = getName(i, rank, gender);
			k++;
		}
		//System.out.println(Arrays.toString(name_array));
		int visited = -1;
		for(int i = 0; i < name_array.length; i++) {
			int count = 1;
			for (int j = i+1; j < name_array.length; j++) {
				if(name_array[i].equals(name_array[j])) {
					count++;
					freq[j] = visited;
				}
			}
			if(freq[i] != visited) {
				freq[i] = count;
			}
			
		}
		//System.out.println(Arrays.toString(freq));
		int most_freq_index = 0;
		int frequency = freq[0];
		for(int i = 1; i < freq.length; i++) {
			if(freq[i] > frequency && frequency != -1) {
				frequency = freq[i];
				most_freq_index = i;
				//System.out.println(frequency);
			}
		}
		return frequency;
	}

		
	
	
	public static String[] get_MostFreqName_array(int year, int year2, String gender, int rank) {
		String[] name_array = new String[year2-year+1];
		int [] freq = new int [name_array.length];
		int k = 0;
		for(int i = year; i <= year2; i++) {
			name_array[k] = getName(i, rank, gender);
			k++;
		}
		int visited = -1;
		for(int i = 0; i < name_array.length; i++) {
			int count = 1;
			for (int j = i+1; j < name_array.length; j++) {
				if(name_array[i] == name_array[j]) {
					count++;
					freq[j] = visited;
				}
			}
			if(freq[i] != visited) {
				freq[i] = count;
			}
		}
		int most_freq_index = 0;
		int frequency = freq[0];
		for(int i = 1; i < freq.length; i++) {
			if(freq[i] > frequency && frequency != -1) {
				frequency = freq[i];
				most_freq_index = i;
				//System.out.println(frequency);
			}
		}
		return name_array;
	}
	
	public static int get_name_Occurrence(int year, int year2, String gender, int rank, String Name) {
		boolean found = false;
		int occurr_number = 0;
		int currrank = 0;
		for(int i = year; i <= year2; i++) {
			for (CSVRecord rec : getFileParser(i)) {
				if(rec.get(1).equals(gender)) {
						if(rec.get(0).equals(Name)) {
							if (rank == getRank(i, Name, gender)) {
								found = true;
								occurr_number += Integer.parseInt(rec.get(2));
								//System.out.println(occurr_number);
								break;
							}
						}
				}
			}
		}
		if(found) {
			return occurr_number;
		}
		else return 0;
	}
	
	public static int get_name_Occurrence_by_years(int year, String gender, int rank, String Name) {
		boolean found = false;
		int occurr_number = 0;
		int currrank = 0;
		for (CSVRecord rec : getFileParser(year)) {
				if(rec.get(1).equals(gender)) {
					currrank++;
					if (rank == currrank) {
						if(rec.get(0).equals(Name)) {
							found = true;
							occurr_number = Integer.parseInt(rec.get(2));
							//System.out.println(occurr_number);
							break;
						}
					}
				}
			}
		if(found) {
			return occurr_number;
		}
		else return 0;
	}
	
	public static int get_name_Freq(int year, int year2, String gender, int rank, String Name) {
		boolean found = false;
		int freq_number = 0;
		int currrank = 0;
		for(int i = year; i <= year2; i++) {
			for (CSVRecord rec : getFileParser(i)) {
				if(rec.get(1).equals(gender)) {
						if(rec.get(0).equals(Name)) {
							if (rank == getRank(i, Name, gender)) {
								found = true;
								freq_number += 1;
								//System.out.println(occurr_number);
								break;
							}
						}
				}
			}
		}
		if(found) {
			return freq_number;
		}
		else return 0;
	}
	
  
	/**
	 * Get the record for specific name for a year(for one gender)
	 * @param year the year of interest
	 * @param name the name of interest
	 * @param gender the gender of interest
	 * @return ;-1 if error
	 */
	public static int tsk3csv_find_name_by_year(int year, String name, String gender) {
		int out = 0;
		for (CSVRecord rec : getFileParser(year)) {
			if (rec.get(1).equals(gender)) {
				if (rec.get(0).equals(name)) {
					out = Integer.parseInt(rec.get(2));
				}
			}
		}

		if (out > 0) {
			return out;
		}
		return -1;
	}
	
	/**
	 * Get the highest rank for the same name in a period
	 * @param years the starting year
	 * @param yeare the ending year
	 * @param name the name of interest
	 * @param gender the gender of interest
	 * @return highest rank in a period;-1 if not found
	 */
	public static int tsk3csv_get_highest_rank(int years, int yeare, String name, String gender) {
		int rank = -1;
		for (int i = years; i <= yeare; i++) {
			if (getRank(i, name, gender) > rank) {
				rank = getRank(i, name, gender);
			}
		}
		return rank;
	}
	
	/**
	 * Get the highest year for the same name in a period
	 * @param years the starting year
	 * @param yeare the ending year
	 * @param name the name of interest
	 * @param gender the gender of interest
	 * @return highest rank in a period;-1 if not found
	 */
	public static int tsk3csv_get_highest_year(int years, int yeare, String name, String gender) {
		int rank = -1;
		int out = 0;
		for (int i = years; i <= yeare; i++) {
			if (getRank(i, name, gender) > rank) {
				rank = getRank(i, name, gender);
				out = i;
			}
		}
		return out;
	}
	/**
	 * Get the total entry(lines of data) in one year for specific gender
	 * @param year the year of interest
	 * @param gender the gender of interest(M/F)
	 * @return the total entry(lines of data) in one year for specific gender
	 */
	public static int tsk3csv_num_entry_by_gender(int year, String gender) {
		int count = 0;
		for (CSVRecord rec : getFileParser(year)) {
			if (rec.get(1).equals(gender)) {
				count++;
			}
		}
		return count;
	}
	/**
	 * Get the total entry(lines of data) in one year
	 * @param year the year of interest
	 * @return the total entry(lines of data) in one year
	 */
	public static int tsk6csv_num_entry(int year) {
		int count = 0;
		for (CSVRecord rec : getFileParser(year)) {
			count++;
		}
		return count;
	}

}
