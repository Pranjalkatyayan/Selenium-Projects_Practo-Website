package driver_file;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DriverUtils {
	
	static WebDriver driver;
	public WebDriver chromeMac()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");   //invoking chrome driver
		return setChrome();
	}
	
	public WebDriver firefoxMac()
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//drivers//geckodriver.exe");      //invoking mozilla 
		return setFirefox();
	}
	
	
	public WebDriver edgeMac()
	{
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "//drivers//edge.exe");      //invoking edge
		return setedge();
	}
	
	public WebDriver setChrome()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");                                                         //Setting up of chrome
		options.addArguments("disable-infobars");
		options.addArguments("--disable-popup-blocking");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebDriver setFirefox()
	{
		FirefoxOptions options = new FirefoxOptions();     
		options.setProfile(new FirefoxProfile());                                                              //setting of mozilla
		options.addPreference("dom.webnotifications.enabled", false);
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		return driver;
		

	}
	
	public WebDriver setedge()
	{
		driver=new EdgeDriver();                                                                            //setting of edge
		driver.manage().window().maximize();
		return driver;
		
	}
}
