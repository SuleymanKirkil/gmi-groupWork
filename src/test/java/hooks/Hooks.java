package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
        //    SKIPPING THE TAG THAT IS IN THE BEFORE ANNOTATION
//    IN THIS EXAMPLE @skip_scenario tagged scenarios will be skipped
        @Before(value = "@skip_scenario")
        public void setUp(Scenario scenario) {
//        RUNS BEFORE EACH SCENARIO
            System.out.println("SKIPPED : " + scenario.getName());
            Assume.assumeTrue(false);//
        }

        @After
        public void tearDown(Scenario scenario) {
//        RUNS AFTER EACH SCENARIO
//        System.out.println("After Hooks");
//        Adding Reports that is generated when a scenario FAILS
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "failed_scenario"); }
            Driver.closeDriver();

        }

    }
