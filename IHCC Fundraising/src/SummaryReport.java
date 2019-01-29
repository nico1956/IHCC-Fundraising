/*
 * This program print a report for each listed group. 
 * It will print total records, total and average amount
 * raised for that group. It will create a file called summary.prt.
 * Nico Busatto 01/20/2019
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.*;
import java.util.*;

public class SummaryReport {
	
	static Scanner majorScanner;
	static PrintWriter pw;
	static NumberFormat nf;
	static boolean eof = false;
	static String iString;
	static String iRecord;             
	static String iStudentID;
	static char iGender;
	static String iMajorCode;
	static String iDonation, oDonation;
	static double cDonation;
	static int cCountMale, cCountFemale, cCountIT , cCountManufactTech , cCountTransportTech , 
				cMaleCountIT , cFemaleCountIT , cMaleCountManufactTech , cFemaleCountManufactTech , 
					cMaleCountTransportTech , cFemaleCountTransportTech , cOverallCount;
	static double cTotMale$ , cTotFemale$ , cTotIT$ , cTotManufactTech$ , cTotTransportTech$,
					cTotMaleIT$ , cTotFemaleIT$ , cTotMaleManufactTech$ , cTotFemaleManufactTech$ , 
						cTotMaleTransportTech$ , cTotFemaleTransportTech$ , cOverall$;
	static double cAvgMale$ , cAvgFemale$ , cAvgIT$ , cAvgManufactTech$ , cAvgTransportTech$, cAvgMaleIT$ , 
					cAvgFemaleIT$ , cAvgMaleManufactTech$ , cAvgFemaleManufactTech$ , cAvgMaleTransportTech$ ,
						cAvgFemaleTransportTech$ , cAvgOverall$;
	static String oTotMale$ , oTotFemale$ , oTotIT$ , oTotManufactTech$ , oTotTransportTech$,
					oTotMaleIT$ , oTotFemaleIT$ , oTotMaleManufactTech$ , oTotFemaleManufactTech$ , 
						oTotMaleTransportTech$ , oTotFemaleTransportTech$ , oOverall$;
	static String oAvgMale$ , oAvgFemale$ , oAvgIT$ , oAvgManufactTech$ , oAvgTransportTech$, oAvgMaleIT$ , 
					oAvgFemaleIT$ , oAvgMaleManufactTech$ , oAvgFemaleManufactTech$ , oAvgMaleTransportTech$ ,
						oAvgFemaleTransportTech$ , oAvgOverall$;
	static String colHdgFormat = "%-12s%14s%11s%14s%10s%n";
	static String colHdgFormat2 = "%-33s%10s%15s%16s%n";
	static String detailFormat = "%-35s%3s%5d%3s%8s%3s%8s%n";
    static Date iDate = new Date();
    static String FormattedDate = new SimpleDateFormat("MM-dd-yyyy").format(iDate);
    static char i500;
    static Scanner myScanner;

	public static void main(String[] args) {
    
		init();
		
		while (eof == false) {
		
			calcs();
		
			input();
		
		}
		
		average();
		
		output();
		
		pw.close();
		System.out.println("Program ending, have a good one!");
	}
	
	public static void init() {
		
		//set scanner to the input file
		//
		try {
			majorScanner = new Scanner(new File("IHCCFUND.DAT"));
			majorScanner.useDelimiter(System.getProperty("line.separator"));
		} catch (FileNotFoundException e1) {
			System.out.println("File error");

		}
		
		//initialize the PrintWriter object
		try {
			pw = new PrintWriter(new File ("summary.prt"));
		} catch (FileNotFoundException e) {
			System.out.println("Output file error");
		}
		
		nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);
			
    	input();
    			
	}
	
	public static void input() {
				
		if (majorScanner.hasNext()) {
			iRecord = majorScanner.next();
			iStudentID = iRecord.substring(0,7);	   //file position  1 - 8
			iString = iRecord.substring(7,8);	       //file position  8 - 9
			iGender = iString.charAt(0);
			iMajorCode = iRecord.substring(8,10);	   //file position 9 - 11
		    iDonation = iRecord.substring(10,17);      //file position 11 - 18
			cDonation = Double.parseDouble(iDonation);
			
		} else {
			
			eof = true;
			
		}	
		
	}
	
	public static void calcs() {
		
		switch (iGender) {
		
			case 'M':
				cCountMale++;
				cOverallCount++;
				cTotMale$ += cDonation;
				cOverall$ += cDonation;
				break;
			case 'F':
				cCountFemale++;
				cOverallCount++;
				cTotFemale$ += cDonation;
				cOverall$ += cDonation;
				break;
		
		}
		
		switch (iMajorCode) {
		
			case "01":
				cCountIT++;
				cTotIT$ += cDonation;
				if (iGender == 'M') {
					cMaleCountIT++;
					cTotMaleIT$ += cDonation;
					break;
				}
				if (iGender == 'F') {
					cFemaleCountIT++;
					cTotFemaleIT$ += cDonation;
					break;
				}
			case "02":
				cCountTransportTech++;
				cTotTransportTech$ += cDonation;
				if (iGender == 'M') {
					cMaleCountTransportTech++;
					cTotMaleTransportTech$ += cDonation;
					break;
				}
				if (iGender == 'F') {
					cFemaleCountTransportTech++;
					cTotFemaleTransportTech$ += cDonation;
					break;
				}
			case "03":
				cCountTransportTech++;
				cTotTransportTech$ += cDonation;
				if (iGender == 'M') {
					cMaleCountTransportTech++;
					cTotMaleTransportTech$ += cDonation;
					break;
				}
				if (iGender == 'F') {
					cFemaleCountTransportTech++;
					cTotFemaleTransportTech$ += cDonation;
					break;
				}
			case "04":
				cCountManufactTech++;
				cTotManufactTech$ += cDonation;
				if (iGender == 'M') {
					cMaleCountManufactTech++;
					cTotMaleManufactTech$ += cDonation;
					break;
				}
				if (iGender == 'F') {
					cFemaleCountManufactTech++;
					cTotFemaleManufactTech$ += cDonation;
					break;
				}
			case "05":
				cCountManufactTech++;
				cTotManufactTech$ += cDonation;
				if (iGender == 'M') {
					cMaleCountManufactTech++;
					cTotMaleManufactTech$ += cDonation;
					break;
				}
				if (iGender == 'F') {
					cFemaleCountManufactTech++;
					cTotFemaleManufactTech$ += cDonation;
					break;
				}	
			case "06":
				cCountIT++;
				cTotIT$ += cDonation;
				if (iGender == 'M') {
					cMaleCountIT++;
					cTotMaleIT$ += cDonation;
					break;
				}
				if (iGender == 'F') {
					cFemaleCountIT++;
					cTotFemaleIT$ += cDonation;
					break;
				}
			case "07":
				cCountManufactTech++;
				cTotManufactTech$ += cDonation;
				if (iGender == 'M') {
					cMaleCountManufactTech++;
					cTotMaleManufactTech$ += cDonation;
					break;
				}
				if (iGender == 'F') {
					cFemaleCountManufactTech++;
					cTotFemaleManufactTech$ += cDonation;
					break;
				}	
			case "08":
				cCountIT++;
				cTotIT$ += cDonation;
				if (iGender == 'M') {
					cMaleCountIT++;
					cTotMaleIT$ += cDonation;
					break;
				}
				if (iGender == 'F') {
					cFemaleCountIT++;
					cTotFemaleIT$ += cDonation;
					break;
				}
			case "09":
				cCountIT++;
				cTotIT$ += cDonation;
				if (iGender == 'M') {
					cMaleCountIT++;
					cTotMaleIT$ += cDonation;
					break;
				}
				if (iGender == 'F') {
					cFemaleCountIT++;
					cTotFemaleIT$ += cDonation;
					break;
				}
			case "10":
				cCountIT++;
				cTotIT$ += cDonation;
				if (iGender == 'M') {
					cMaleCountIT++;
					cTotMaleIT$ += cDonation;
					break;
				}
				if (iGender == 'F') {
					cFemaleCountIT++;
					cTotFemaleIT$ += cDonation;
					break;
				}
			case "11":
				cCountManufactTech++;
				cTotManufactTech$ += cDonation;
				if (iGender == 'M') {
					cMaleCountManufactTech++;
					cTotMaleManufactTech$ += cDonation;
					break;
				}
				if (iGender == 'F') {
					cFemaleCountManufactTech++;
					cTotFemaleManufactTech$ += cDonation;
					break;
				}
			case "12":
				cCountTransportTech++;
				cTotTransportTech$ += cDonation;
				if (iGender == 'M') {
					cMaleCountTransportTech++;
					cTotMaleTransportTech$ += cDonation;
					break;
				}
				if (iGender == 'F') {
					cFemaleCountTransportTech++;
					cTotFemaleTransportTech$ += cDonation;
					break;
				}
			case "13":
				cCountTransportTech++;
				cTotTransportTech$ += cDonation;
				if (iGender == 'M') {
					cMaleCountTransportTech++;
					cTotMaleTransportTech$ += cDonation;
					break;
				}
				if (iGender == 'F') {
					cFemaleCountTransportTech++;
					cTotFemaleTransportTech$ += cDonation;
					break;
				}	
				
		}
			
	}
	
	public static void average() {
		
		cAvgMale$ = cTotMale$/cCountMale;
		cAvgFemale$ = cTotFemale$/cCountFemale;
		cAvgIT$ = cTotIT$/cCountIT;
		cAvgManufactTech$ = cTotManufactTech$/cCountManufactTech;
		cAvgTransportTech$ = cTotTransportTech$/cCountTransportTech;
		cAvgMaleIT$ = cTotMaleIT$/cMaleCountIT;
		cAvgFemaleIT$ = cTotFemaleIT$/cFemaleCountIT;
		cAvgMaleManufactTech$ = cTotMaleManufactTech$/cMaleCountManufactTech;
		cAvgFemaleManufactTech$ = cTotFemaleManufactTech$/cFemaleCountManufactTech;
		cAvgMaleTransportTech$ = cTotMaleTransportTech$/cMaleCountTransportTech;
		cAvgFemaleTransportTech$ = cTotFemaleTransportTech$/cFemaleCountTransportTech;
		cAvgOverall$ = cOverall$/cOverallCount;
		
	}
	
	public static void output() {
		
		oTotMale$ = nf.format(cTotMale$);
		oTotFemale$ = nf.format(cTotFemale$);
		oTotIT$ = nf.format(cTotIT$);
		oTotMaleIT$ = nf.format(cTotMaleIT$);
		oTotFemaleIT$ = nf.format(cTotFemaleIT$);
		oTotTransportTech$ = nf.format(cTotTransportTech$);
		oTotMaleTransportTech$ = nf.format(cTotMaleTransportTech$);
		oTotFemaleTransportTech$ = nf.format(cTotFemaleTransportTech$);
		oTotManufactTech$ = nf.format(cTotManufactTech$);
		oTotMaleManufactTech$ = nf.format(cTotMaleManufactTech$);
		oTotFemaleManufactTech$ = nf.format(cTotFemaleManufactTech$);
		oOverall$ = nf.format(cOverall$);
		
		oAvgMale$ = nf.format(cAvgMale$);
		oAvgFemale$ = nf.format(cAvgFemale$);
		oAvgIT$ = nf.format(cAvgIT$);
		oAvgMaleIT$ = nf.format(cAvgMaleIT$);
		oAvgFemaleIT$ = nf.format(cAvgFemaleIT$);
		oAvgTransportTech$ = nf.format(cAvgTransportTech$);
		oAvgMaleTransportTech$ = nf.format(cAvgMaleTransportTech$);
		oAvgFemaleTransportTech$ = nf.format(cAvgFemaleTransportTech$);
		oAvgManufactTech$ = nf.format(cAvgManufactTech$);
		oAvgMaleManufactTech$ = nf.format(cAvgMaleManufactTech$);
		oAvgFemaleManufactTech$ = nf.format(cAvgFemaleManufactTech$);
		oAvgOverall$ = nf.format(cAvgOverall$);
		
		pw.format(colHdgFormat, "Indian Hills", " ", "Contribution Report", " ", FormattedDate);
		pw.println("");
		pw.format(colHdgFormat2, "Group Name", "Records", "Total Amount" , "Average Amount");
		pw.println("");
		pw.format(detailFormat, "Male: " , "   " , cCountMale , "   " , oTotMale$ , "   " , oAvgMale$);
		pw.format(detailFormat, "Female: " , "   " , cCountFemale, "   " , oTotFemale$ , "   " , oAvgFemale$);
		pw.format(detailFormat, "Information Technology: " , "   " , cCountIT, "   " , oTotIT$ , "   " , oAvgIT$);
		pw.format(detailFormat, "Manufacturing Technology: " , "   " , cCountManufactTech, "   " , oTotManufactTech$ , "   " , oAvgManufactTech$);
		pw.format(detailFormat, "Transportation Technology: " , "   " , cCountTransportTech, "   " , oTotTransportTech$ , "   " , oAvgTransportTech$);
		pw.format(detailFormat, "Male Information Technology: " , "   " , cMaleCountIT, "   " , oTotMaleIT$ , "   " , oAvgMaleIT$);
		pw.format(detailFormat, "Female Information Technology: " , "   " , cFemaleCountIT, "   " , oTotFemaleIT$ , "   " , oAvgFemaleIT$);
		pw.format(detailFormat, "Male Manufacturing Technology: " , "   " , cMaleCountManufactTech, "   " , oTotMaleManufactTech$ , "   " , oAvgMaleManufactTech$);
		pw.format(detailFormat, "Female Manufacturing Technology: " , "   " , cFemaleCountManufactTech, "   " , oTotFemaleManufactTech$ , "   " , oAvgFemaleManufactTech$);
		pw.format(detailFormat, "Male Transportation Technology: " , "   " , cMaleCountTransportTech, "   " , oTotMaleTransportTech$ , "   " , oAvgMaleTransportTech$);
		pw.format(detailFormat, "Female Transportation Technology: " , "   " , cFemaleCountTransportTech, "   " , oTotFemaleTransportTech$ , "   " , oAvgFemaleTransportTech$);
		pw.println("");
		pw.format(detailFormat, "Overall: " , "   " , cOverallCount, "   " , oOverall$ , "   " , oAvgOverall$);
		
	}
	
	
	
}
