package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class base {

	public static WebDriver driver;
	// reusable method to initialize driver

	public static WebDriver initializeDriver() throws IOException
	{
		// if it is chrome then you should invoke that particular browser. and for same others
		Properties prop= new Properties();
		String dir= System.getProperty("user.dir");
		System.out.println(dir);
		String dir1=dir.replace("\\", "\\\\");
		System.out.println(dir1);
		String mainfolder="src/main/java";
		String dir2= dir1 +"\\\\"+mainfolder+ "\\\\resources\\\\configuration.properties";
		FileInputStream fin= new FileInputStream(dir2);
		prop.load(fin);
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		if(browser.equalsIgnoreCase("chrome"))
		{
			String chromepath= dir1 + "\\\\Jars\\\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromepath);
			driver = new ChromeDriver();
		}
		
		if(browser.equalsIgnoreCase("IE"))
		{
			String iepath = dir1 + "\\\\Jars\\\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", iepath);
			driver = new InternetExplorerDriver();
		}
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			String geckopath = dir1 + "\\\\Jars\\\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", geckopath);
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	
	
	
}