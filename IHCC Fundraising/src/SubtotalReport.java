/*
 * This program show the records for each major, 
 * breaking and printing a subtotal for each one. It will create
 * a file called subtotal.prt.
 * Nico Busatto 01/20/2019
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.*;
import java.util.Date;
import java.util.Scanner;

public class SubtotalReport {
	
	static Scanner majorScanner;        
	static PrintWriter pw;              
	static NumberFormat nf;          
	static boolean eof = false;       
	static String iString;           
	static String iRecord;            
	static String iStudentID;    
	static char iGender;
	static String iMajorCode;
	static int cMajorCode;
	static int hMajorCode;
	static String iDonation;
	static String oGender;
	static double cDonation;
	static String oDonation;
	static String oMajorName1, oMajorName2, oMajorName3, oMajorName4, oMajorName5, oMajorName6, oMajorName7, oMajorName8,
					oMajorName9, oMajorName10, oMajorName11, oMajorName12, oMajorName13;
	static int cGtCounter;
	static double cGtAccumulator;
	static String oGtAccumulator;
	static double cMajorAcc;
	static int cMajorCounter;
	static String oMajorAcc;
	static String colHdgFormat = "%-12s%14s%11s%14s%10s%n";
	static String colHdgFormat2 = "%-10s%9s%8s%39s%n";
	static String detailFormat = "%-8s%5s%-7s%2s%-34s%2s%-8s%n";
    static Date iDate = new Date();
    static String FormattedDate = new SimpleDateFormat("MM-dd-yyyy").format(iDate);
	

	public static void main(String[] args) {

		//call init()		
		init();
		
		headings();
			
		while (eof != true) {
			
			if (hMajorCode != cMajorCode) {
				
				subtotals();
				
			} else {
			
				calcs();
				
				output();
				
				input();
				
			}

		}
		
		subtotals();
									
		grandtotals();
		
		pw.close();
		System.out.println("Program ending, have a good one!");
				
	}	
	
	public static void init() {
		
		//set scanner to the input file
		try {
			majorScanner = new Scanner(new File("IHCCFUND.DAT"));
			majorScanner.useDelimiter(System.getProperty("line.separator"));
		} catch (FileNotFoundException e1) {
			System.out.println("File error");
		}
		
		//initialize the PrintWriter object
		try {
			pw = new PrintWriter(new File ("subtotal.prt"));
		} catch (FileNotFoundException e) {
			System.out.println("Output file error");
		}
		
		//Number Formatter
		nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);
			
		//do first read
		input();
		
		//Assing Major code to hold field
		hMajorCode = cMajorCode;
			
	}
	
	public static void input() {

		if (majorScanner.hasNext()) {
			iRecord = majorScanner.next();
			iStudentID = iRecord.substring(0,7);	   //file position 1 - 8
			iString = iRecord.substring(7,8);	       //file position 8 - 9
			iGender = iString.charAt(0);
			iMajorCode = iRecord.substring(8,10);	   //file position 9 - 11
		    iDonation = iRecord.substring(10,17);      //file position 11 - 18
			cDonation = Double.parseDouble(iDonation);
			
		} else {
			
			//If end of file, set eof to true
			eof = true;
			
		}
		
		switch (iMajorCode) {
		
			case "01":
				cMajorCode = 1;
				break;				
			case "02":
				cMajorCode = 2;
				break;
			case "03":
				cMajorCode = 3;
				break;				
			case "04":
				cMajorCode = 4;
				break;
			case "05":
				cMajorCode = 5;
				break;				
			case "06":
				cMajorCode = 6;
				break;
			case "07":
				cMajorCode = 7;
				break;
			case "08":
				cMajorCode = 8;
				break;
			case "09":
				cMajorCode = 9;
				break;
			case "10":
				cMajorCode = 10;
				break;
			case "11":
				cMajorCode = 11;
				break;
			case "12":
				cMajorCode = 12;
				break;
			case "13":
				cMajorCode = 13;
				break;	
			
		}
		
	}
	
	public static void calcs() {
		
		//Evaluate Major Code and calc tot records and amounts
		switch(iMajorCode) {
		
			case "01":
				cMajorCounter++;
				cMajorAcc += cDonation;
				cGtCounter++;
				cGtAccumulator += cDonation;
				break;
			case "02":
				cMajorCounter++;
				cMajorAcc += cDonation;
				cGtCounter++;
				cGtAccumulator += cDonation;
				break;
			case "03":
				cMajorCounter++;
				cMajorAcc += cDonation;
				cGtCounter++;
				cGtAccumulator += cDonation;
				break;
			case "04":
				cMajorCounter++;
				cMajorAcc += cDonation;
				cGtCounter++;
				cGtAccumulator += cDonation;
				break;
			case "05":
				cMajorCounter++;
				cMajorAcc += cDonation;
				cGtCounter++;
				cGtAccumulator += cDonation;
				break;
			case "06":
				cMajorCounter++;
				cMajorAcc += cDonation;
				cGtCounter++;
				cGtAccumulator += cDonation;
				break;
			case "07":
				cMajorCounter++;
				cMajorAcc += cDonation;
				cGtCounter++;
				cGtAccumulator += cDonation;
				break;
			case "08":
				cMajorCounter++;
				cMajorAcc += cDonation;
				cGtCounter++;
				cGtAccumulator += cDonation;
				break;
			case "09":
				cMajorCounter++;
				cMajorAcc += cDonation;
				cGtCounter++;
				cGtAccumulator += cDonation;
				break;
			case "10":
				cMajorCounter++;
				cMajorAcc += cDonation;
				cGtCounter++;
				cGtAccumulator += cDonation;
				break;
			case "11":
				cMajorCounter++;
				cMajorAcc += cDonation;
				cGtCounter++;
				cGtAccumulator += cDonation;
				break;
			case "12":
				cMajorCounter++;
				cMajorAcc += cDonation;
				cGtCounter++;
				cGtAccumulator += cDonation;
				break;
			case "13":
				cMajorCounter++;
				cMajorAcc+= cDonation;
				cGtCounter++;
				cGtAccumulator += cDonation;
				break;	
		}
		
	}
	
	public static void headings() {
		
		pw.format(colHdgFormat, "Indian Hills", " ", "Subtotal Report", " ", FormattedDate);
		pw.println("");
		pw.format(colHdgFormat2, "Student ID" , "Gender" , "Major" , "Donation");
		pw.println("");
		
	}
	
	public static void output() {
		
		//Format in $ all the amounts
		oDonation = nf.format(cDonation);
		oMajorAcc = nf.format(cMajorAcc);

		switch(iGender) {
		
		case 'M':
			oGender = "Male";
			break;
		case 'F':
			oGender = "Female";
			break;
		}
		
		//Print detail line with Major literal based on Major code
		switch (iMajorCode) {
		
			case "01":
				oMajorName1 = "COMPUTER SOFTWARE DEVELOPMENT";
				pw.format(detailFormat, iStudentID , "" , oGender , "  " , oMajorName1 , "  " , oDonation);
				break;
			case "02":
				oMajorName2 = "DIESEL POWER SYSTEMS TECHNOLOGY";
				pw.format(detailFormat, iStudentID , ""  , oGender , "  " , oMajorName2 ,  "  " , oDonation);
				break;
			case "03":
				oMajorName3 = "AUTOMOTIVE TECHNOLOGY";
				pw.format(detailFormat, iStudentID , ""  , oGender , "  " , oMajorName3 , "  " , oDonation);
				break;
			case "04":
				oMajorName4 = "LASER / ELECTRO-OPTICS TECHNOLOGY";
				pw.format(detailFormat, iStudentID , ""  , oGender , "  " , oMajorName4 , "  " , oDonation);
				break;
			case "05":
				oMajorName5 = "ROBOTICS/AUTOMATION TECHNOLOGY";
				pw.format(detailFormat, iStudentID , ""  , oGender , "  " , oMajorName5 , "  " , oDonation);
				break;
			case "06":
				oMajorName6 = "DIGITAL FORENSICS";
				pw.format(detailFormat, iStudentID , ""  , oGender , "  " , oMajorName6 , "  " , oDonation);
				break;
			case "07":
				oMajorName7 = "MACHINE TECHNOLOGY";
				pw.format(detailFormat, iStudentID , ""  , oGender , "  " , oMajorName7 , "  " , oDonation);
				break;
			case "08":
				oMajorName8 = "GEOSPATIAL TECHNOLOGY";
				pw.format(detailFormat, iStudentID , ""  , oGender , "  " , oMajorName8 , "  " , oDonation);
				break;
			case "09":
				oMajorName9 = "ADMINISTRATIVE ASSISTANT";
				pw.format(detailFormat, iStudentID , ""  , oGender , "  " , oMajorName9 , "  " , oDonation);
				break;
			case "10":
				oMajorName10 = "ACCOUNTING ASSISTANT";
				pw.format(detailFormat, iStudentID , ""  , oGender , "  " , oMajorName10 , "  " , oDonation);
				break;
			case "11":
				oMajorName11 = "WELDING TECHNOLOGY";
				pw.format(detailFormat, iStudentID , ""  , oGender , "  " , oMajorName11 , "  " , oDonation);
				break;
			case "12":
				oMajorName12 = "AUTOMOTIVE COLLISION TECHNOLOGY";
				pw.format(detailFormat, iStudentID , ""  , oGender , "  " , oMajorName12 , "  " , oDonation);
				break;
			case "13":
				oMajorName13 = "AVIATION PILOT TRAINING";
				pw.format(detailFormat, iStudentID , ""  , oGender , "  " , oMajorName13 , "  " , oDonation);
				break;		 
		}
		
	}
	
	//Print subtotals for each major after breaking
	public static void subtotals() {
		//"%-34s%6d%7.2f"
		
		switch (hMajorCode) {
		
			case 1:
				pw.println("");
				pw.format("%-34s%6d%2s%20s%n", oMajorName1 , cMajorCounter, "  ",  oMajorAcc);
				pw.println("");
				break;
			case 2:
				pw.println("");
				pw.format("%-34s%6d%2s%20s%n", oMajorName2 , cMajorCounter, "  ", oMajorAcc);
				pw.println("");
				break;
			case 3:
				pw.println("");
				pw.format("%-34s%6d%2s%20s%n", oMajorName3 , cMajorCounter, "  ", oMajorAcc);
				pw.println("");
				break;
			case 4:
				pw.println("");
				pw.format("%-34s%6d%2s%20s%n", oMajorName4 , cMajorCounter, "  ", oMajorAcc);
				pw.println("");
				break;
			case 5:
				pw.println("");
				pw.format("%-34s%6d%2s%20s%n", oMajorName5 , cMajorCounter, "  ", oMajorAcc);
				pw.println("");
				break;
			case 6:
				pw.println("");
				pw.format("%-34s%6d%2s%20s%n", oMajorName6 , cMajorCounter, "  ", oMajorAcc);
				pw.println("");
				break;
			case 7:
				pw.println("");
				pw.format("%-34s%6d%2s%20s%n", oMajorName7 , cMajorCounter, "  ", oMajorAcc);
				pw.println("");
				break;
			case 8:
				pw.println("");
				pw.format("%-34s%6d%2s%20s%n", oMajorName8 , cMajorCounter, "  ", oMajorAcc);
				pw.println("");
				break;
			case 9:
				pw.println("");
				pw.format("%-34s%6d%2s%20s%n", oMajorName9 , cMajorCounter, "  ", oMajorAcc);
				pw.println("");
				break;
			case 10:
				pw.println("");
				pw.format("%-34s%6d%2s%20s%n", oMajorName10 , cMajorCounter, "  ", oMajorAcc);
				pw.println("");
				break;
			case 11:
				pw.println("");
				pw.format("%-34s%6d%2s%20s%n", oMajorName11 , cMajorCounter, "  ", oMajorAcc);
				pw.println("");
				break;
			case 12:
				pw.println("");
				pw.format("%-34s%6d%2s%20s%n", oMajorName12 , cMajorCounter, "  ", oMajorAcc);
				pw.println("");
				break;
			case 13:
				pw.println("");
				pw.format("%-34s%6d%2s%20s%n", oMajorName13 , cMajorCounter, "  ", oMajorAcc);
				pw.println("");
				break;		
		}
		
		cMajorCounter = 0;
		
		cMajorAcc = 0;
		
		hMajorCode = cMajorCode;
		
	}
	//Print grand totals
	public static void grandtotals() {
		
		oGtAccumulator = nf.format(cGtAccumulator);
		
		pw.println("");
		pw.format("%-9d%2s%9s%n", cGtCounter , "  " , oGtAccumulator);
		
	}

}
