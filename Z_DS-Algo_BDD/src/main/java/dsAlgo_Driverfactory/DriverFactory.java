package dsAlgo_Driverfactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public static WebDriverWait explicit_wait;

	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
	
	public WebDriver init_driver(String browser,String url)
	{
		System.out.println("driver : initializing the driver first");
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());			
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else
		{
			throw new RuntimeException("BrowserType Not Supported");
		}

	getDriver().manage().deleteAllCookies();
    
	getDriver().manage().window().maximize();
	getDriver().get(url);
	
	
	return getDriver();
	}

//this is used to get the driver with thread local
public static synchronized WebDriver getDriver()
{   
	return tlDriver.get();
}
}
