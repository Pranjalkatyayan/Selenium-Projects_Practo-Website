package project_file;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import excel_file.Diagonistic_Excelfile;

@Test(priority = 2)
public class Diagonistic extends Hospital_Name {

	public static void cities() throws InterruptedException, IOException {

		driver.navigate().to("http://www.practo.com");
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		By diagonistic_xpath = By.xpath("//div[contains(text(),'Diagnostics')]");             
		wait.until(ExpectedConditions.visibilityOfElementLocated(diagonistic_xpath));

		WebElement diagnostic = driver.findElement(diagonistic_xpath);                // click on diagonistic
		diagnostic.click();
		
		Screeshot.captureScreensoht(driver, "citypic");                              //Taking Screenshot

		List<WebElement> bigcities = driver.findElements(By.tagName("li"));
		List<String> citi = new ArrayList<>();

		for (int i = 0; i < bigcities.size(); i++) {

			citi.add(bigcities.get(i).getText()); 
			System.out.println(bigcities.get(i).getText());                          //fetching the cities name 

		}

		String[] city_list = new String[citi.size()];
		city_list = citi.toArray(city_list);

		int x = city_list.length;

		System.out.println(x);
		System.out.println("*************************************************************************");

		Diagonistic_Excelfile ex = new Diagonistic_Excelfile();                    //witing the data into excel
		ex.write_data(city_list);

		test = extent.createTest("Diagonistc_method");
		driver.navigate().to("http://www.practo.com");                             //navigate to home

	}
}
