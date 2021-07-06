package project_file;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Landing_Page extends Diagonistic {

	@Test(priority=3)
	public void visitCorporateWellnessPage() throws InterruptedException, IOException {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		
		By location = By.xpath("//input[@placeholder='Search location']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(location));
		
		By corporateWellness = By.xpath("//span[contains(text(),'For Providers')]");             //click on for providers
		wait.until(ExpectedConditions.visibilityOfElementLocated(corporateWellness));
		
		By visitcorporatewellness = By.xpath("//a[contains(text(),'Corporate wellness')]");      //click on corporate wellness
		

        driver.findElement(corporateWellness).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(visitcorporatewellness));
        
        Screeshot.captureScreensoht(driver, "corporate wellness");                              //Taking Screenshot
        
		driver.findElement(visitcorporatewellness).click();
		String mainwindow = driver.getWindowHandle();
		String currentwindow = driver.getWindowHandle();                                          //handling multiple windows
		
		
		Set<String> windowsid = driver.getWindowHandles();
		Iterator<String> itr = windowsid.iterator();
		String mainpageid = itr.next();
		String childpageid = itr.next();
		
		driver.switchTo().window(childpageid);                                                    //changing the focus of seliniumto  new window
		
		test = extent.createTest("Landing_Page_method");
	}

}
