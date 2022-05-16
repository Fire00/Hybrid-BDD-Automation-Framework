import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src//test//features//HealthGraph//NoBroker.feature",},
        glue = {"stepDef","StepInit"},
        tags = "@NoBroker",
        plugin = {"pretty"}
)
public class TestRunner {
}
