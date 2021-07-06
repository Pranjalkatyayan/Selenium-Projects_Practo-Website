package excel_file;

import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import driver_file.DriverSetup;

public class Corporate_Wellness_Excel extends DriverSetup{
	
   
	public String[][] fetchdata() throws IOException{

		File file=new File(System.getProperty("user.dir")+"/Resources\\Corporate_Wellness.xlsx");   //fetching excel sheet
		FileInputStream readfile = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(readfile);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);


		System.out.println("****************************************************************************");
		String data[][]=new String[3][5];
		for(int i=1;i<3;i++) {                                   
			for(int j=0;j<5;j++) {
				data[i][j]=String.valueOf(sheet.getRow(i).getCell(j));              //reading data from excel
				
			}
		}
		
	  test = extent.createTest("Corporate_Wellness_ExcelFile_fetchdata_method");
	  return data;
}

	public void write_into_excel(String[] data) throws IOException {
		
		File file=new File(System.getProperty("user.dir")+ "/Resources\\Corporate_Wellness.xlsx");        //fetching excel sheet
   		FileInputStream fin = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fin);
		XSSFSheet sh = wb.getSheetAt(1);
		
		for(int j=0;j<2;j++) {		
			
		sh.createRow(j+2).createCell(0).setCellValue(data[j]);                                    //writing data in excel
		
		}
		sh.autoSizeColumn(0);
		
		FileOutputStream fout = new FileOutputStream(file);                                  //closing the sheet
		wb.write(fout);
		wb.close();
	
		test = extent.createTest("CorporateWellness_ExcelFile_write_method");
		
	}
   
}