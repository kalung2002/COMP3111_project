package comp3111.popnames;

import org.apache.commons.csv.*;
import edu.duke.*;

public class AnalyzeNames {

	public static CSVParser getFileParser(int year) {
		FileResource fr = new FileResource(String.format("dataset/yob%s.csv", year));
		return fr.getCSVParser(false);
	}

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
	
	public static int tsk3csv_find_name_by_year(int year,String name,String gender) {
		int out =0;
		for (CSVRecord rec : getFileParser(year)) {
			if(rec.get(1).equals(gender)) {
				if(rec.get(0).equals(name)) {
					out=Integer.parseInt(rec.get(2));
				}
			}
		}
		
		if(out>0) {return out;}
		return -1;
	}
	public static int tsk3csv_get_highest_rank(int years,int yeare,String name,String gender) {
		int rank=-1;
		for(int i=years;i<=yeare;i++) {
			if(getRank(i,name,gender)>rank) {
				rank=getRank(i,name,gender);
			}
		}
		return rank;
	}
	public static int tsk3csv_get_highest_year(int years,int yeare,String name,String gender) {
		int rank=-1;
		int out=0;
		for(int i=years;i<=yeare;i++) {
			if(getRank(i,name,gender)>rank) {
				rank=getRank(i,name,gender);
				out=i;
			}
		}
		return out;
	}
	

}
