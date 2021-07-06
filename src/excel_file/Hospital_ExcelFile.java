package excel_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import driver_file.DriverSetup;

public class Hospital_ExcelFile extends DriverSetup{
	
	public String[] fetchdata() throws IOException{

		File file=new File(System.getProperty("user.dir")+ "/Resources\\Hospital_Names.xlsx");        //fetching the excel
		FileInputStream readfile = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(readfile);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		
		System.out.println("***********************************************************************");
		
		String details[]=new String[2];
		for(int i=0;i<2;i++) {
			details[i]=String.valueOf(sheet.getRow(1).getCell(i));                  //reading the data frm excel
		}
		
		test = extent.createTest("Hospital_ExcelFile_fetchdata_method");
		return details;

}

    public void write_in_excel(String[] data) throws IOException {
    	
    	
    	File file=new File(System.getProperty("user.dir")+ "/Resources\\Hospital_Names.xlsx");          //fetching the data in excel
   		FileInputStream fin = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fin);
		XSSFSheet sh = wb.getSheetAt(1);
		
		for(int j=0;j<5;j++) {		
			
		sh.createRow(j+2).createCell(0).setCellValue(data[j]);                                //writing the data
		
		}
		sh.autoSizeColumn(0);
		
		FileOutputStream fout = new FileOutputStream(file);                               //closing the excel
		wb.write(fout);
		wb.close();
		test = extent.createTest("Hospital_ExcelFile_write_method");
	
    }
}