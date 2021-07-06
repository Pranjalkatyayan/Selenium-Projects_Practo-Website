package excel_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import driver_file.DriverSetup;

public class Diagonistic_Excelfile extends DriverSetup {

	public void write_data(String[] data) throws IOException {

			File file = new File(System.getProperty("user.dir") + "/Resources\\Diagonistic_Cities.xlsx");        //fetching the excel sheet
			FileInputStream fin = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fin);
			XSSFSheet sh = wb.getSheetAt(0);

			for (int j = 0; j < 8; j++) {

				sh.createRow(j+2).createCell(0).setCellValue(data[52+j]);                         //writing the data in excel

			}
			sh.autoSizeColumn(0);

			FileOutputStream fout = new FileOutputStream(file);                       //closing the excel 
			wb.write(fout);
			wb.close();
			test = extent.createTest("Diagonistic_ExcelFile_write_method");

		
	}
}