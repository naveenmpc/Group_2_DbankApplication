package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.TestRetryAnalyzerListener;

@RunWith(Cucumber.class)
@Listeners(value= {TestRetryAnalyzerListener.class})
@CucumberOptions(features="C:\\Users\\mnave\\eclipse-workspace\\RLL-Final-DbankApplication\\src\\test\\java\\features",
glue={"stepDefinitions","pages"},
plugin= {"pretty","html:target/sample.html",
		"json:target/stepdefinition.json","junit:target/stepReport.xml",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:targer/extentsampleReport.html"},
monochrome =true)
public class TestNGRunner extends AbstractTestNGCucumberTests  {
	@Override
	@DataProvider(parallel=false)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
}