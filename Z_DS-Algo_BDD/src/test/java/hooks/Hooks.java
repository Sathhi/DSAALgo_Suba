package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsAlgo_Driverfactory.DriverFactory;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.LoggerLoad;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	static WebDriverWait wait ;
	
	
	@Before(order=0)//will execute 0 and then 1
	public void getProperty() throws IOException
	{   
		LoggerLoad.info("Loading Config Properties ");
		configReader =new ConfigReader();
		prop=configReader.init_prop();		
	}
	
	@Before(order=1)
	public void launchBrowser()
	{
		String browserName=prop.getProperty("browser");
		String geturl=prop.getProperty("url");
		LoggerLoad.info("Initializing the DriverFactory class ");
		driverFactory=new DriverFactory();
	    LoggerLoad.info(browserName+ " browser is Launching");
		driver=driverFactory.init_driver(browserName,geturl);	
		
	}
	
	@After(order=0)// will execute after "1" then order 0
	public void quitBrowser()
	{
		LoggerLoad.info("Closing Browser");
		driver.quit();
	}
	
	@After(order=1)//for After it will start from 1 and then 0
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())//take ScreenShot;
		{	
			LoggerLoad.error("Steps Failed , Taking Screenshot");
			String screenShotName=scenario.getName().replaceAll("", "_");
			byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath,"image/png", screenShotName);
		}
	}
}
