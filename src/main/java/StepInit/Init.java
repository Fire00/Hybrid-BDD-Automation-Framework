package StepInit;

import baseTestSession.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import reporter.SparkReporter;

import java.util.HashMap;

/**
 * Cucumber Hooks Class. This is executed everytime a Cucumber Scenaio is executed
 *
 * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
 */
public class Init {

    public static HashMap<String,String> config=null;
    public static BaseTestSession session=null;
    public static Scenario scenario;
   public static PageObjectManger pageObjectManger;
   public  static SparkReporter reporter;

    private ConfigurationReader configuration=new ConfigurationReader();


    /**
     * Cucumber before hook. This method is executed before each Scenario
     * Here reporter, session,pageobjectmanager objects are Initialized
     *
     * @param scenario Takes cucumber scenario object
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    @Before
    public void beforeScenario(Scenario scenario)
    {
        System.out.println("Scenario :"+scenario.getName());
        session=new BaseTestSession(configuration.config,scenario);
        Init.scenario=scenario;
        pageObjectManger=new PageObjectManger(session,scenario);
        pageObjectManger.initPageObjects();
        reporter=new SparkReporter(scenario,configuration.config);
    }

    /**
     * Cucumber after hook. This method is executed after each Scenario
     * Here Browser is closed and reports are flushed after each scenario
     *
     * @param scenario Takes cucumber scenario object
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */

    @After
    public void AfterScenario(Scenario scenario)
    {
        session.closeBrowser();
        reporter.report.info("Browser Closed");
        reporter.flushReporter();
    }


}
