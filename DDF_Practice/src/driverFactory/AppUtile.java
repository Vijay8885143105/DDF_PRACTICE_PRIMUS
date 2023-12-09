package driverFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtile {
	public static Properties p;
	public static WebDriver dr;
	@BeforeTest
	public static void setup() throws Throwable, IOException
	{
		p=new Properties();
		p.load(new FileInputStream("./PropertyFile/Environment.properties"));
		if (p.getProperty("Browser").equalsIgnoreCase("chrome")) {
			dr=new ChromeDriver();
			dr.manage().window().maximize();
		}
		else if (p.getProperty("Browser").equalsIgnoreCase("Firefox")) {
			dr=new FirefoxDriver();
			dr.manage().window().maximize();
		}
		else
		{
			System.out.println("Browser Value is Not Matching");
		}
	}
		@AfterTest
		public static void tearDown()
		{
			dr.quit();
	}
}



