package Getr.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Getr.PageObjects.OnboardingPage;

public class BaseTest {
	public WebDriver driver;
	public  OnboardingPage ob;
	
	public WebDriver Intializer() throws IOException 
	{
	
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Getr\\Resources\\Globaldata.properties");
	prop.load(fis);
	String browsername = prop.getProperty("browser");
	if (browsername.contains("chrome"))
	{
		ChromeOptions options = new ChromeOptions();
		if (browsername.contains("headless"))
		{
			options.addArguments("headless");
		}
		 driver = new ChromeDriver(options);
		 driver.manage().window().setSize(new Dimension(1440,900));
		
	}
	else if (browsername.equalsIgnoreCase("Firefox"))
	{
		 driver = new FirefoxDriver();
	}
	else if (browsername.equalsIgnoreCase("Edge"))
	{
		 driver = new EdgeDriver();
	}
	
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
	
}
	public String getScreenshot(String testcasename, WebDriver driver2 ) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver2; 
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+ "//reports//" + testcasename + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+ "//reports//" + testcasename + ".png";
		}
		
	@BeforeMethod (alwaysRun = true)
	public OnboardingPage Landingpage () throws IOException
	{
		driver = Intializer();
		ob = new OnboardingPage(driver);
		ob.goTo();
		return ob;
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void closedriver()
	{
		driver.close();
	}

	
}
