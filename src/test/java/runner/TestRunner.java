package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features= "src/test/java/features",
		glue= {"step_definitions"},
		plugin = {
				"pretty",
				"html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/re-run.txt"
		},
		monochrome=true
		)

public class TestRunner {
	
	private TestNGCucumberRunner  testNGCucumberRunner;
	
	@BeforeClass(alwaysRun=true)
	public void setUpClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}
	
	@Test(groups="cucumber",dataProvider="features")
	public void feature(CucumberFeatureWrapper cucumberFeatureWrapper) {
		testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() throws Exception{
		testNGCucumberRunner.finish();
	}
	
}