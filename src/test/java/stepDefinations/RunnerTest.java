package stepDefinations;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/feature",plugin="json:target/jsonReports/cucumber-report.json",tags="@AddPlace",glue={"stepDefinations"})
public class RunnerTest{
}
