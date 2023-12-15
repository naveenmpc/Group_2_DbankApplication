package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\mnave\\eclipse-workspace\\RLL-Final-DbankApplication\\src\\test\\java\\features",
				glue= {"stepDefinitions","pages"},
						plugin= {"html:target/Cucumberreport.html",
								 "pretty",
								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
								"timeline:test-output-thread/"}
						
				//tags="@all"
			
		)

public class JUnitRunner {

}
