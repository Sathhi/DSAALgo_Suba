package dsAlgo_TestRunner;

	import org.testng.annotations.DataProvider;

	import io.cucumber.junit.CucumberOptions;
	import io.cucumber.testng.AbstractTestNGCucumberTests;

	@io.cucumber.testng.CucumberOptions(
	plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, //reporting purpose
	monochrome=false,  //console output color
	 //tags from feature file
	features = {"classpath:Features/EDataStructurePage.feature"},
	//tags = " @Tag",	
	//tags={"@Login"}, //location of feature files (should be in src/test/reso
	glue={"dsAlgo_StepDefinition","hooks"})//location of  step definition files
	public class TestRunner  extends AbstractTestNGCucumberTests{
		
		@Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
					
			return super.scenarios();
	    }
	}	
	
	
	
	
	
	
	
	
	

	//features = {"classpath:Features/BHomePage.feature:pageno."},// to run specific scenarion from line no
	//"src/main/resources/publish", tags="@Login, @Sendemail", (using tags to run specific sceanrion file)
	//tags = {"@currentTest"},//(add multiple tags to run like this)