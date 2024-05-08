package task13;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelWorkbook {

	public static void main(String[] args) throws IOException {
		//read the excel file
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Desktop\\Task13.xlsx");
		
		XSSFWorkbook xlWorkbook=new XSSFWorkbook(fis);
		XSSFSheet xlSheet= xlWorkbook.getSheetAt(0); //get Sheet1
		
		//print the values present in sheet
		for(int i=0;i<= xlSheet.getLastRowNum();i++) {
			XSSFRow xlRow= xlSheet.getRow(i);
			 
			for(int j=0;j< xlRow.getLastCellNum();j++) {
				XSSFCell xlCell= xlRow.getCell(j);
				System.out.print(xlCell.getStringCellValue()+"      ");
			}
			System.out.println("");
		}
		fis.close();
		xlWorkbook.close();

	}

}
