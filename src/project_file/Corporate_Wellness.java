package project_file;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import excel_file.Corporate_Wellness_Excel;

public class Corporate_Wellness extends Landing_Page {

	@Test(priority = 4)
	public void sendData() throws InterruptedException,IOException {

		                  
		By name = By.xpath("//input[@id='name']");                                     //retrive all the xpath
		By organisation = By.xpath("//input[@id='organization_name']");
		By email = By.xpath("//input[@id='official_email_id']");
		By contactNumber = By.xpath("//input[@id='official_phone_no']");
		By scheduleDemo = By.xpath("//button[@id='button-style']");
		By home = By.xpath("//img[@alt='Practo Logo']");


		Corporate_Wellness_Excel ts=new Corporate_Wellness_Excel();                    //fetching data from excel
		String excel_data[][] = new String[3][5];
		excel_data=ts.fetchdata();
		
		driver.findElement(name).sendKeys(excel_data[1][1]);                           //sending data from excel
		driver.findElement(organisation).sendKeys(excel_data[1][2]);;
		driver.findElement(email).sendKeys(excel_data[1][3]);
		driver.findElement(contactNumber).sendKeys(excel_data[1][4]);;
		
		Screeshot.captureScreensoht(driver, "data filled");                              //Taking Screenshot
		driver.findElement(scheduleDemo).click();
	
		
		Alert alert = driver.switchTo().alert();                                      //capturing alert message
	 
		
		String[] alert_Text=new String[2];
		
		alert_Text[0] = alert.getText();
		System.out.println(alert_Text[0]);
		alert.accept();
   
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(excel_data[2][3]);;
		driver.findElement(scheduleDemo).click();
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Alert alert2 = driver.switchTo().alert();
		
		
		alert_Text[1] = alert2.getText();
		System.out.println(alert_Text[1]);
		alert.accept();

		System.out.println("\n**************************************************************************\n");
		
		ts.write_into_excel(alert_Text);                                             //writing into excel

		test = extent.createTest("Corporate_Wellness_method");
	}

}
