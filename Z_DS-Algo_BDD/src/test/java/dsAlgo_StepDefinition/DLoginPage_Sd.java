package dsAlgo_StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dsAlgo_Driverfactory.DriverFactory;
import dsAlgo_PageObject.ALandingPage;
import dsAlgo_PageObject.BHomePage;
import dsAlgo_PageObject.CRegisterPage;
import dsAlgo_PageObject.DLoginPage;
import dsAlgo_Utilities.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DLoginPage_Sd {
	private ALandingPage landingPage=new ALandingPage(DriverFactory.getDriver());
	private BHomePage homePage=new BHomePage(DriverFactory.getDriver());
	private DLoginPage loginPage=new DLoginPage(DriverFactory.getDriver());
	private CRegisterPage registerPage=new CRegisterPage(DriverFactory.getDriver());
	private WebDriver driver=DriverFactory.getDriver();
	private ConfigReader config=new ConfigReader();
	private static String error;
	private static String result;
	private static String msg;
	
	
	@Given("User is on Login page")
	public void user_is_on_login_page() {
	   homePage=new BHomePage(driver);
	   loginPage=homePage.signin_Btn();
	   
	   System.out.println("User should be on login page "+driver.getCurrentUrl());	  
	}
	@When("User clicks on login button with all empty field")
	public void user_clicks_on_login_button_with_all_empty_field() {
	    error= loginPage.login_click();
	    System.out.println("empty field error chek  "+error);
	 
	}
	
	@Then("User verify the message at username as {string}")
	public void user_verify_the_message_at_username_as(String string) {
		  Assert.assertEquals(error, string, "Please fill out this field.");
	}
	
	
	
	@When("User enters invalid username as {string} and password as {string} and gets the result {string}")
	public void user_enters_invalid_username_as_and_password_as_and_gets_the_result(String uname, String pwd, String Result) {
	  loginPage.login_entry(uname, pwd);
	  result=Result;
	}
	
	@When("User clicks login button")
	public void user_clicks_login_button() {
	   loginPage.logBtn_click();
	}
	
	@Then("User verify the message as {string}")
	public void user_verify_the_message_as(String string) {
	   System.out.println(result);
	   System.out.println(string);
	}
	
	
	
	
	
	@When("User enters valid username {string} and password {string}")
	public void user_enters_username_and_password(String uname, String pwd) {
	  loginPage.valid_login(uname, pwd);
	}
	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		result=loginPage.success_login();
	}
	@Then("It should navigate to the home page with a message {string}")
	public void it_should_navigate_to_the_home_page_with_a_message(String string) {
	   System.out.println("logged message sholuf cod"+result+string);
	}
	
	
	
	
	
	
	
	
	
	@When("User clicks on signout")
	public void user_clicks_on_signout() throws InterruptedException {
		loginPage=homePage.signin_Btn();
		//System.out.println(driver.getCurrentUrl());
		String uname=config.getUserName();
		String pwd=config.getPassword();
		//System.out.println(uname +pwd);
		 loginPage.valid_login(uname, pwd);
		 result=loginPage.success_login();
		// System.out.println(result);
		  msg=loginPage.success_logout();
		  
	}
	@Then("Message displayed LoggedOut Successfully")
	public void message_displayed_logged_out_successfully() throws InterruptedException {
	  //  String msg=loginPage.success_logout();
	     System.out.println(msg);
	}

}
