package dsAlgo_PageObject;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsAlgo_Driverfactory.DriverFactory;
import dsAlgo_Utilities.PageUtils;


import org.openqa.selenium.WebDriver;

public class KGraphPage {
	 private  WebDriver driver=DriverFactory.getDriver();
	    private PageUtils pageUtil=new PageUtils();
	    private static String graph_url;
	    private static String graph_title;
	    private String alertText;
	    private String alert;
	    private String result;

	public KGraphPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		    
	  @FindBy(xpath="//a[@data-toggle='dropdown']")private WebElement drop_down;
	  @FindBy(xpath="//div[@class='dropdown-menu']/a")private WebElement menu_List;
	  @FindBy(xpath="//h4[contains(@class,'bg-secondary text-white')]")private WebElement title_header;
	  @FindBy(xpath="//a[text()='Try here>>>']")private WebElement try_Btn;
	  @FindBy(xpath="//*[@id='answer_form']/div/div/div[1]/textarea")private WebElement tryEditor;
	  @FindBy(xpath="//button[text()='Run']")private WebElement runBtn;
	  @FindBy(xpath="//pre[@id='output']")private WebElement output;
	  @FindBy(xpath="//div[@class='dropdown-menu']/a") private List<WebElement> list;
	  @FindBy(xpath="//a[text()='Practice Questions']") private WebElement practice_QuestionsLink;
	  @FindBy(xpath="//ul/a[@class='list-group-item']") private  List<WebElement> topics; 
		

		public void drop_downClick(String menuitem) {
			drop_down.click();	
			pageUtil.menu_click(driver, topics,menuitem);
		}	
		
		public String get_url()
		{ 
			return graph_url;		
		}
		
		public String get_title()
		{				
			return graph_title;
		}


//		public String validPythonCode(String pCode, String options ) throws InterruptedException {
//		
//			for (int i=1; i<=topics.size(); i++) {
//			 WebElement topicselt = driver.findElement(By.xpath("/html/body/div[2]/ul["+i+"]/a "));		 
//			 String str=topicselt.getText();		
//				if(str.equalsIgnoreCase(options))
//				{  
//				    topicselt.click();
//					try_Btn.click();			
//					Thread.sleep(3000);
//					tryEditor.sendKeys(pCode);
//					runBtn.click();		       
//					Thread.sleep(3000);	
//					result=output.getText();
//					System.out.println("outprut result is"+result);
//					driver.navigate().back();
//					driver.navigate().back();
//					break;
//				}	
//				Thread.sleep(3000);
//				
//			}
//		  return result;
//		}
		public String validPythonCode(String pCode, String options ) throws InterruptedException {
			
		            pageUtil.menu_click(driver, topics, options);
			    	try_Btn.click();			
					Thread.sleep(3000);
					tryEditor.sendKeys(pCode);
					runBtn.click();		       
					Thread.sleep(3000);	
					result=output.getText();
					System.out.println("outprut result is"+result);
					//driver.navigate().back();
					//driver.navigate().back();					
				    return result;
			}
		  
	
		
		public String inValidPythonCode(String pCode, String options ) throws InterruptedException {		
			
			       pageUtil.menu_click(driver, topics, options);
				 
					try_Btn.click();			
					Thread.sleep(3000);
					tryEditor.sendKeys(pCode);
					runBtn.click();		       
					Thread.sleep(3000);	
					alert=isAlertPresent();
					return alert;
			}
			

		public String isAlertPresent() {
		   
		    try {	       
		        Alert alert = driver.switchTo().alert();	       
		        alertText=alert.getText();
		        alert.accept();    
		    } catch (NoAlertPresentException ex) {	      
		        ex.printStackTrace();
		    }
		    return alertText;
		}

		public void practice_link(String practice) {
			
			pageUtil.practice_click(practice_QuestionsLink);
		}
	}


