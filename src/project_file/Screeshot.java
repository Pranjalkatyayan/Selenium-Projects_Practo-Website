package project_file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screeshot {

	public static void captureScreensoht(WebDriver driver,String scnname) throws IOException 
	{

		TakesScreenshot ts=(TakesScreenshot)driver;                                                 //Taking Screenshot code
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File("./Screenshot/"+scnname+".png"));


}
}
