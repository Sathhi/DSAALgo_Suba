package dsAlgo_PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsAlgo_Driverfactory.DriverFactory;

public class DLoginPage {
    private WebDriver driver=DriverFactory.getDriver();
    String error;
    String msg;
    
    @FindBy(xpath = "//input[@id='id_username']")private WebElement username;
	@FindBy(xpath = "//input[@id='id_password']")private WebElement password;
	@FindBy(xpath = "//input[@value='Login']")private WebElement loginbtn;
	@FindBy(xpath = "//div[contains(text(),'Invalid Username and Password')]")private WebElement alertMsg;
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[2]/a[1]")private WebElement registerlink;
	@FindBy(xpath = "//div[contains(text(),'You are logged in')]")private WebElement successLogin;
	@FindBy(xpath = "//a[contains(text(),'Sign out')]")private WebElement signout;
	@FindBy(xpath = "//div[contains(text(),'Logged out successfully')]")private	WebElement successLogout;
	@FindBy (xpath="//div[@class='alert alert-primary']")private WebElement alert;
    
	public DLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String login_click()
	{
		username.sendKeys("");
		password.sendKeys(" ");
		loginbtn.click();
		error=username.getAttribute("validationMessage");
		return error;

	}

	public void login_entry(String uname, String pwd) {
		
		username.clear();
		username.sendKeys(uname);
		password.clear();
		password.sendKeys(pwd);
			
	}

	public String logBtn_click() {
		loginbtn.click();
		if(alertMsg.isDisplayed())		
			 msg= "Invalid Username and Password";
		return msg;
		
		
	}
	
	
	public void sign_out() throws InterruptedException
	{ Thread.sleep(3000);
		signout.click();
	}
	
	public String success_logout() throws InterruptedException
	{   sign_out();
		String successlogout=successLogout.getText();
		return successlogout;
	}
		
	public void valid_login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
	}
	
	public String success_login()
	{
		loginbtn.click();
		if(successLogin.isDisplayed())
		msg= "You are logged in";
		else msg="you are no logged in";
		return msg;
	}
	}
	
	


