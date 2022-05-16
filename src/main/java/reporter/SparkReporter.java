package reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.Scenario;

import java.util.HashMap;

public class SparkReporter {

    /**
     * This class is used to initialize/flush SparkReporter
     *
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */

    public static ExtentTest report;
    public  static ExtentReports extent;


    /**
     *Constructor to initialize SparkReporter
     *
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    public SparkReporter(Scenario scenario, HashMap<String,String> config)
    {
        initReporter(scenario,config);
    }

    /**
     * This method is used to initialize report objects and set path and name for .html report
     *
     * @param scenario scenario object
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */

    public void  initReporter(Scenario scenario,HashMap<String,String> config) {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "//target//Extent-Report//" + scenario.getName() + ".html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle(scenario.getName() + " Report");
        extent.attachReporter(spark);
        report = extent.createTest(scenario.getName());
        report.info("Browser: "+config.get("Browser"));
        report.info("URL: "+config.get("url"));

    }


    /**
     * This method is used to flush the reporter object after the completion of scenario
     *
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    public  void flushReporter()
    {
        extent.flush();
    }
}
