package driver_file;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class DriverSetup extends DriverUtils {

	public static WebDriver driver;
	public static Scanner sc;

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeSuite
	public WebDriver getDriver() {
		sc = new Scanner(System.in);

		// Getting Operating System Details from User
		System.out.println("Select Browser:\n1.Chrome\n2.Edge(Version- 86.0.622.61).\n3.FireFox");
		System.out.println("Select Option Number:");
		int option = sc.nextInt();

		// invoking browsers based on operating system
		switch (option) {
		case 1:

			driver = chromeMac(); // invoking chrome
			break;

		case 2:
			driver = edgeMac(); // Invoking edge
			break;

		case 3:
			driver = firefoxMac(); // invoking firefox
			break;

		default:
			System.out.println("Please Enter 1 or 2 or 3 only");
		}
		return driver;
	}

	@BeforeTest
	public void extentReportSetup() {

		htmlReporter = new ExtentHtmlReporter(
		System.getProperty("user.dir") + "/Extent Reports/Extent_Report.html");
		extent = new ExtentReports();                                         // create object of ExtentReports
		extent.attachReporter(htmlReporter);

		htmlReporter.config().setDocumentTitle("Automation Report");          // Tittle of Report
		htmlReporter.config().setReportName("Extent Report ");                // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);                            // Default Theme of Report

	}

	@Test(priority = 0)
	public void openURL() {
		driver.get("http://www.practo.com"); // going to home page

	}

	@AfterMethod
	public void extentReportsDemo(ITestResult result) {

		
	}

	@AfterTest
	public void endReport() {
		extent.flush();

	}

	@AfterSuite
	public void closeBrowser() {

		driver.quit();                                           // closing browser
		driver.quit();
	}

}
