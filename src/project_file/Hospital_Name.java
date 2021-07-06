package project_file;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import driver_file.DriverSetup;
import excel_file.Hospital_ExcelFile;

public class Hospital_Name extends DriverSetup {

	@Test(priority = 1)
	public static void hospital() throws InterruptedException, IOException {

		
		Screeshot.captureScreensoht(driver, "homepage");                                    //Taking Screenshot
		Hospital_ExcelFile hs= new Hospital_ExcelFile();                                    //Reading data from Excel file by making object of class Hospital_Excel
		String data[] = new String[2];                           
		data = hs.fetchdata();

		for (int i = 0; i < 2; i++) {                                                        //Verfying data fetched from excel
			System.out.println(data[i]);
		}

		WebDriverWait wait = new WebDriverWait(driver, 60);                                   //Explict Wait

		By city = By.xpath("//input[@placeholder='Search location']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(city));

		WebElement location = driver.findElement(city);
		location.click();
		
		By clear = By.xpath("//i[@class='icon-ic_cross_solid']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(city));
		WebElement cl=driver.findElement(clear);
		cl.click();
	
		location.sendKeys(data[0]);                                                           //Selecting city banglore
		Thread.sleep(4000);
		location.sendKeys(Keys.ARROW_DOWN);
		location.sendKeys(Keys.ARROW_DOWN);
		location.sendKeys(Keys.ENTER);
		
		By search_bar = By.xpath("//input[@placeholder='Search doctors, clinics, hospitals, etc.']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(search_bar));

		WebElement service = driver.findElement(search_bar);
		service.clear();
		service.sendKeys(data[1]);                                                             //Sending Keyword Hospital in search button
		Thread.sleep(4000);
		service.sendKeys(Keys.ARROW_DOWN);
		service.sendKeys(Keys.ENTER);
		
		

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By open = By.xpath("//span[contains(text(),'Open 24X7')]");                              //applying filter
		wait.until(ExpectedConditions.visibilityOfElementLocated(open));
		driver.findElement(open).click();                                                         // 24*7

		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[contains(text(),'All Filters')]")).click();          //applying filter

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(" //span[contains(text(),'Has Parking')]")).click();        //applying filter

		System.out.println("\n**************************************************************************\n");

		By hospital_name = By.xpath("//h2[@data-qa-id='hospital_name']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(hospital_name));
		List<WebElement> hospitalNameList = driver.findElements(hospital_name);

		String hospital[] = new String[5];

		for (int i = 0; i < 5; i++) {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			hospital[i] = hospitalNameList.get(i).getAttribute("innerHTML");                    //printing Hospital Names
			System.out.println(hospital[i]);                                                    //printing 5 hospital names
		}
		Screeshot.captureScreensoht(driver, "hospital name");                                   //Taking Screenshot

		System.out.println("\n**************************************************************************\n");

		hs.write_in_excel(hospital);                                                            //Writing the data in Excel file

		test = extent.createTest("Hospital_Names_method");
		
		driver.navigate().to("http://www.practo.com");

	}

}
