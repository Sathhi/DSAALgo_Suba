package dsAlgo_PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;



import dsAlgo_Utilities.ConfigReader;
import io.cucumber.messages.types.Duration;

public class BHomePage {
	private WebDriver driver;
	 String str2;
	 WebDriverWait wait;
	 String homePageurl=ConfigReader.homePage();
	 
	
	@FindBy(xpath="//div[@class='dropdown-menu']//a")private WebElement menu_Options; 
	@FindBy(xpath="//div[@class='alert alert-primary']")private WebElement error_msg;
	@FindBy(xpath="//a[text()='Data Structures']")private WebElement menudropdown;
	@FindBy(xpath="//button[text()='Get Started']")private WebElement getStarted_btn;
	@FindBy(xpath="//a[text()='Sign in']")private WebElement signIn;
	@FindBy(xpath="//a[text()=' Register ']")private WebElement register;
	@FindBy(xpath = "//div[contains(@class,'alert ')]")private WebElement signinalert;

	
	public BHomePage(WebDriver driver) {
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}
	
	public void homepage() {
		driver.get(homePageurl);		
	}	
	
	
   public void dropDownList(String string) throws InterruptedException
   { 
	 Thread.sleep(3000);	
	 menudropdown.click();
	 List<WebElement> size=driver.findElements(By.xpath("//div[@class='dropdown-menu show']/a"));
	for (WebElement size1 : size) 
	{
	if(size1.getText().contains(string))
	{	
		size1.click();
		String error=error_msg.getText();
		break;		
	}
    }		
   }		
   
   public void getStartBtn_click()
   {
	   List<WebElement> getStartList=driver.findElements(By.xpath("//a[text()='Get Started']"));
	  // System.out.println(getStartList.size());
	   for(WebElement getList:getStartList)
	   {
		   getList.click();
		   String error=error_msg.getText();
		   break;		
	   }	   
   }
   
   public String getErr_msg()
	{
		String error=error_msg.getText();
		return error;
	}	
	
	public DLoginPage signin_Btn()
	{
		signIn.click();
		return new DLoginPage(driver);
	}
	
	public CRegisterPage register_Btn() throws InterruptedException
	{   Thread.sleep(3000);
		register.click();		
		return new CRegisterPage(driver);
	}

	public void menuDropDown() {
		menudropdown.click();
	}
	public void getStartBtn_click(String option)throws InterruptedException
	{	  
	
	// new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(optlst));
	
	 
	 String message=signinalert.getText();
	 if(message.equalsIgnoreCase("You are logged in"))
	 {
		 WebElement optlst= driver.findElement(By.xpath("//h5[text()='"+option+"']/../a")); 
		 optlst.click();
	 }
	
	 
   }
	
}
