package ejagruti.finsys.config;


import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
/**
 * @How to Use: Pass the path of the image where you want to store the snapshot
 * @author ABHISHEK PRIYADARSHI
 *
 */
public class TakeScreenShot {
	public static String TakeScreenShot(String ImagePath, WebDriver webdriver) throws IOException{
		File src= ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
		File dest = new File(ImagePath);
		FileUtils.copyFile(src, dest);
		String s = dest.toString();
		return s;
	}
	public static void main(String[] args) throws InterruptedException, IOException
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://localhost:90/finsys");
		Thread.sleep(10000);
		TakeScreenShot("d:\\abc.png",driver);
	}

}
