package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;




public class PracticeExcel {

	private static HSSFWorkbook wb;
	private static HSSFSheet sh;
	
	public static void main(String args[]) throws Exception {
		System.out.println(getIndexOfColumn("FieldName"));
	}
	

public static Integer getIndexOfColumn(String fID) throws Exception {

	String FilePath = "C:\\Users\\Pallavi\\ebay-e2e\\src\\main\\java\\utility\\Datasheet.xls";
	FileInputStream fs;

	HashMap<String, ArrayList<String>> XPathData = new HashMap<String, ArrayList<String>>();
	
		fs = new FileInputStream(FilePath);
		wb = new HSSFWorkbook(fs);
	
	sh = wb.getSheetAt(0); // this is to get the access to Sheet1. 
	// To get the number of rows present in sheet
			int totalNoOfRows = sh.getLastRowNum();

			
	int columnnum=-1;
	HSSFRow row = sh.getRow(0);
	// To get the number of columns present in sheet
				int totalNoOfCols =sh.getRow(0).getLastCellNum(); 
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if(row.getCell(i).toString().equalsIgnoreCase(fID)) {
					columnnum = i;
					break;
				}
			}
			
		return columnnum;	
				String fieldID=null;
				ArrayList<String> x = new ArrayList<String>();
				for (int col = 0; col < totalNoOfCols; col++) {
					
							
					if(col==0) {
						//System.out.println("Setting Key:"+sh.getCell(col, row).getContents() + "\t");
						fieldID=sh.getRow().
					}
					else {
						System.out.println("Pushing data:"+sh.getCell(col, row).getContents() + "\t");
						x.add(sh.getCell(col, row).getContents());
					}
				
					
					
				}
				XPathData.put(fieldID, x);
			}
	} 
	}
}

