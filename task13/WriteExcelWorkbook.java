package task13;
 
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelWorkbook {
	
	public static void main(String[] args) throws IOException {
			
	    XSSFWorkbook xlWorkBook = new XSSFWorkbook();//New Excel workbook creation
		XSSFSheet xlWorkSheet= xlWorkBook.createSheet("Sheet1"); //Excel Sheet creation
		xlWorkSheet= xlWorkBook.getSheetAt(0);
		XSSFRow xlRow= xlWorkSheet.createRow(0); //Row creation
		XSSFCell xlCell = xlRow.createCell(0); //Cell creation
		
		//Data Insertion
		xlCell.setCellValue("Name");
		xlCell = xlRow.createCell(1);
		xlCell.setCellValue("Age");
		xlCell = xlRow.createCell(2);
		xlCell.setCellValue("Email");
				
		xlRow= xlWorkSheet.createRow(1);
		xlCell = xlRow.createCell(0);
		xlCell.setCellValue("John Doe");
		xlCell = xlRow.createCell(1);
		xlCell.setCellValue("30");
		xlCell = xlRow.createCell(2);
		xlCell.setCellValue("john@test.com");
		
		xlRow= xlWorkSheet.createRow(2);
		xlCell = xlRow.createCell(0);
		xlCell.setCellValue("Jane Doe");
		xlCell = xlRow.createCell(1);
		xlCell.setCellValue("28");
		xlCell = xlRow.createCell(2);
		xlCell.setCellValue("john@test.com");
		
		xlRow= xlWorkSheet.createRow(3);
		xlCell = xlRow.createCell(0);
		xlCell.setCellValue("Bob Smith");
		xlCell = xlRow.createCell(1);
		xlCell.setCellValue("35");
		xlCell = xlRow.createCell(2);
		xlCell.setCellValue("jacky@example.com");
		
		xlRow= xlWorkSheet.createRow(4);
		xlCell = xlRow.createCell(0);
		xlCell.setCellValue("Swapnil");
		xlCell = xlRow.createCell(1);
		xlCell.setCellValue("37");
		xlCell = xlRow.createCell(2);
		xlCell.setCellValue("swapnil@example.com");
			
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Admin\\Desktop\\Task13.xlsx");
		xlWorkBook.write(fos);
		xlWorkBook.close();
		fos.close();

	}

}
