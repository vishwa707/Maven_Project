package javaRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/hrmlogin.feature",
		glue = {"steps"},
		plugin = {"pretty","html:target/loginreport.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
