package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {

public static String getXpath(String fID) {

	String FilePath = "C:\\Users\\Pallavi\\ebay-e2e\\src\\main\\java\\utility\\Datasheet.xls";
	FileInputStream fs;

	HashMap<String, ArrayList<String>> XPathData = new HashMap<String, ArrayList<String>>();
	try {
		fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
	
	Sheet sh = wb.getSheet(0); // this is to get the access to Sheet1. 
	// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();

			for (int row = 0; row < totalNoOfRows; row++) {
				String fieldID=null;
				ArrayList<String> x = new ArrayList<String>();
				for (int col = 0; col < totalNoOfCols; col++) {
					
							
					if(col==0) {
						//System.out.println("Setting Key:"+sh.getCell(col, row).getContents() + "\t");
						fieldID=sh.getCell(col, row).getContents();
					}
					else {
						//System.out.println("Pushing data:"+sh.getCell(col, row).getContents() + "\t");
						x.add(sh.getCell(col, row).getContents());
					}
					
					for(int i = 0; i < x.size(); i++) {   
						   //System.out.print(x.get(i)+" ");
						} 
					
					
				}
				XPathData.put(fieldID, x);
			}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (BiffException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return XPathData.get(fID).get(1);
	}


public static String getKeys(String fID) {

	String FilePath = "D://Downloads//Book1.xls";
	FileInputStream fs;

	HashMap<String, String> keysData = new HashMap<String, String>();
	try {
		fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
	
	Sheet sh = wb.getSheet(1); // this is to get the access to Sheet1. 
	// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();

			for (int row = 0; row < totalNoOfRows; row++) {
				String fieldID=null;
				String x = null;
				for (int col = 0; col < totalNoOfCols; col++) {
					
							
					if(col==0) {
						fieldID=sh.getCell(col, row).getContents();
					}
					else {
						x=sh.getCell(col, row).getContents();
					}
			
					
					
				}
				keysData.put(fieldID, x);
			}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (BiffException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return keysData.get(fID);
	}
}

