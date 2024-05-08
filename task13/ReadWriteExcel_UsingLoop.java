package task13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel_UsingLoop {
		
		public static void main(String[] args) throws IOException {
		    XSSFWorkbook xlWorkBook = new XSSFWorkbook();//New Excel workbook creation
			XSSFSheet xlWorkSheet= xlWorkBook.createSheet("Sheet1"); //Excel Sheet creation
			xlWorkSheet= xlWorkBook.getSheetAt(0);
			XSSFRow xlRow;
			XSSFCell xlCell;
			Scanner scan =new Scanner(System.in);	
			
			//Data Insertion
			for(int i=0;i<=4;i++) {
				 xlRow= xlWorkSheet.createRow(i); //Row creation
				for(int j=0;j<=2;j++) {
					 System.out.println("Enter the value");
					 xlCell = xlRow.createCell(j); //Cell creation
					
					xlCell.setCellValue(scan.nextLine());;
				}
			}
			
			FileOutputStream fos=new FileOutputStream("C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\\\Excel_ApachePOI\\Task13.xlsx");
			xlWorkBook.write(fos);
			
			//read the excel file
			FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\\\Excel_ApachePOI\\Task13.xlsx");
					
			XSSFWorkbook xlWorkbook=new XSSFWorkbook(fis);
			XSSFSheet xlSheet= xlWorkbook.getSheetAt(0); //get Sheet1
					
			//print the values present in sheet
			for(int i=0;i<= xlSheet.getLastRowNum();i++) {
				xlRow= xlSheet.getRow(i);
				
				for(int j=0;j< xlRow.getLastCellNum();j++) {
					xlCell= xlRow.getCell(j);
				    System.out.print(xlCell.getStringCellValue()+"      ");
				    }
			System.out.println("");
			}
			
		
			fis.close();
			fos.close();
			xlWorkbook.close();	
			xlWorkBook.close();
			scan.close();

		}
}
