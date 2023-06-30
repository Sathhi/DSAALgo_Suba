package dsAlgo_StepDefinition;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import dsAlgo_Driverfactory.DriverFactory;
import dsAlgo_PageObject.ALandingPage;
import dsAlgo_PageObject.BHomePage;
import dsAlgo_PageObject.CRegisterPage;
import dsAlgo_PageObject.DLoginPage;
import dsAlgo_PageObject.EDataStructurePage;
import dsAlgo_PageObject.GLinkedListPage;
import dsAlgo_PageObject.KGraphPage;
import dsAlgo_Utilities.ConfigReader;
import dsAlgo_Utilities.PageUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class KGraphPage_SD {

		private EDataStructurePage dataStructurePage=new  EDataStructurePage(DriverFactory.getDriver());
		private ALandingPage landingPage=new ALandingPage(DriverFactory.getDriver());
		private BHomePage homePage=new BHomePage(DriverFactory.getDriver());
		private DLoginPage loginPage=new DLoginPage(DriverFactory.getDriver());
		private CRegisterPage registerPage=new CRegisterPage(DriverFactory.getDriver());
		private GLinkedListPage linkedListPage=new GLinkedListPage(DriverFactory.getDriver());
		private KGraphPage graphPage=new KGraphPage(DriverFactory.getDriver());
		private WebDriver driver=DriverFactory.getDriver();
		private ConfigReader config=new ConfigReader();
		private SoftAssert softAssert=new SoftAssert();
		private PageUtils pageUtil=new PageUtils();
		private static String actualAlertText;
		private static String errormsg;
		private static String outputresult;
		
		
		
		@Given("user clicks the Graph getstart link")
		public void user_selects_the_linked_list_getstartitem() throws InterruptedException {
		   graphPage=  homePage.graph_getStart();
		   System.out.println(driver.getCurrentUrl());
		}

		@Then("user is on the Graph Page")
		public void user_should_be_in_the_linked_list_page() throws InterruptedException {
		   String url=driver.getCurrentUrl();
		   System.out.println(url);
		   Assert.assertTrue(url.contains("/graph/"));	
		}

		@Then("user checks for the title {string} in the Graph page")
		public void user_checks_for_the_title_in_the_linked_list_page(String title) {	 
			   String url=driver.getCurrentUrl();
			   System.out.println(driver.getTitle());
			   System.out.println(url);
			  
			   Assert.assertTrue(url.contains("/graph/"));	
		       Assert.assertEquals(driver.getTitle(),title);
		}

		
		@When("The user select all option {string} from the graph page and Verifies the tryeditor Page with the valid python code for each option  {string} and {int}")
		public void the_user_select_any_dropdown_menu_and_verifies_the_tryeditor_page_with_the_valid_python_code_for_each_option_and(String option, String sheetName, Integer rownumber) throws InvalidFormatException, IOException, InterruptedException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
			String pCode=pageUtil.getPythonCodefromExcel(sheetName,rownumber);
			String options=option;
			outputresult=graphPage.validPythonCode(pCode,options);		
		}
		
		@Then("user should be presented with the run result in the screen {string}")
		public void user_should_be_presented_with_the_run_result(String result)
		{  try {
			Assert.assertTrue(outputresult.contains(result));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		
//		@When("The user select all option {string} and Verifies the tryeditor Page with the Invalid python code for each option  {string} and {int}  in the graph page  ")
//		public void the_user_select_any_dropdown_menu_and_verifies_the_tryeditor_page_with_the_invalid_python_code_for_each_option_and(String option, String sheetName, Integer rownumber) throws InvalidFormatException, IOException, InterruptedException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
//			    String pCode=pageUtil.getPythonCodefromExcel(sheetName,rownumber);
//				String options=option;
//				outputresult=graphPage.inValidPythonCode(pCode,options);	
//		}
		
		@When("The user select all option {string} and Verifies the tryeditor Page with the Invalid python code for each option  {string} and {int}  in the graph page")
		public void The_user_select_all_option_and_Verifies_the_tryeditor_Page_with_the_Invalid_python_code_for_each_option_string_and_int_in_the_graph_page(String option, String sheetName, Integer rownumber) throws InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException, InterruptedException
		{
			String pCode=pageUtil.getPythonCodefromExcel(sheetName,rownumber);
			String options=option;
			outputresult=graphPage.inValidPythonCode(pCode,options);	
		}
		
	   @Then("user should get the {string} on the screen")
	   public void user_should_get_the_erroroutput(String output)
	   {   System.out.println(outputresult);
	   if(outputresult!=null)
		   Assert.assertTrue(outputresult.contains(output));
	   else System.out.println("outputresult is null");
	   }

	   
//	   @Then("The user select all option {string}")
//	   public void the_user_select_any_dropdown_menu(String menuItem) {
////	     graphPage.drop_downClick(menuItem);
////	     System.out.println(driver.getCurrentUrl());
//	   }
////	   @Then("The User is on the {string} page")
////	   public void the_user_is_on_the_page(String menuitem) {
////	       System.out.println("current title exoepctiing linked list page:  " +driver.getTitle());
////	       System.out.println(driver.getCurrentUrl());
////	   }
////	   
//	   @When ("The user clicks Practice Questions {string} link")
//	   public void the_user_clicks_Practice_Questions_link(String practice)
//	   {
////		  graphPage.practice_link(practice);
////		 System.out.println( driver.getCurrentUrl());
//	   }
////	   
////	   @Then("The user should be redirected to {string} page and verifies the Url {string}")
////	   public void the_user_should_be_redirected_to_page_and_verifies_the_url(String string, String url) {
////	    try {
////		   if(url!=null)
////	     {	 System.out.println(driver.getCurrentUrl());
////		     Assert.assertTrue(driver.getCurrentUrl().contains(url));}}
////		   catch(Exception e) {
////			  System.out.println(e);		  
////		   }
////	      
////	   }

	}


