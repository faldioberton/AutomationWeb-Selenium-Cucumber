package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "resources/features/product.feature",
        glue = "stepdefinition",
        plugin = "html:target/HTML_report.html",
        tags = "@SecondRelease"
)
public class runproduct {
}
