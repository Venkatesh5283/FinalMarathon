package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCode {
	
	
	public static String[][] excelMethod(String filename) throws IOException {
		// TODO Auto-generated method stub

		XSSFWorkbook wb=new XSSFWorkbook("./Excel Integration/"+filename+".xlsx");
		
		XSSFSheet sheetAt=wb.getSheetAt(0);
		
		int lastRowNum = sheetAt.getLastRowNum();
		
		int lastCellNum = sheetAt.getRow(0).getLastCellNum();
		
		String[][] data=new String[lastRowNum][lastCellNum];
		
		for(int i=1;i<=lastRowNum;i++)
		{
			XSSFRow row = sheetAt.getRow(i);
			
			for(int j=0;j<lastCellNum; j++)
			{
				String stringCellValue = row.getCell(j).getStringCellValue();
				
				data[i-1][j]=stringCellValue;
			}
		}
		wb.close();
		return data;
	}

}
