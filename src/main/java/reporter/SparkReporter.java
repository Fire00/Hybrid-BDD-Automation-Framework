package reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.Scenario;

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
    public SparkReporter(Scenario scenario)
    {
        initReporter(scenario);
    }

    /**
     * This method is used to initialize report objects and set path and name for .html report
     *
     * @param scenario scenario object
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */

    public void  initReporter(Scenario scenario) {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "//target//Extent-Report//" + scenario.getName() + ".html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle(scenario.getName() + " Report");
        extent.attachReporter(spark);
        report = extent.createTest(scenario.getName());
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
