package baseTestSession;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * This class contains some pre-written methods for selenium operations
 *This is also where Web-driver is initialized, Browser is opened with Url and broswer is closed etc.
 *
 * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
 */

public class BaseTestSession {
    public WebDriver driver=null;
    private boolean browsereOpened=false;
    private  Scenario scenario=null;
    ConfigurationReader configuration=new ConfigurationReader();

    /**
     * Constructor to initialize BaseTestSession
     *
     * @param config Includes information like browser,
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */

    public BaseTestSession(HashMap<String,String>config, Scenario scenario)
    {
       this.scenario=scenario;
        if((scenario.getSourceTagNames().contains("@UI")))
        {
            openBrowser(config);
            waitForpageToLoad();
        }
    }

    /**
     * This function is used to initialize web-driver, Open browser with Url
     *
     * @param config Includes information like browser,url
     * @return WebDriver returns object of initialized web-driver
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */

    private WebDriver openBrowser(HashMap<String,String>config)
    {
        String browser=config.get("Browser");

        switch (browser)
        {
            case "chrome":
                // System Property for Chrome Driver
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                                                +"//src//main//resources//driver//chromedriver.exe");
                //setup chrome options
                ChromeOptions opt=new ChromeOptions();
                opt.addArguments("start-maximised");
                opt.addArguments("--disable-extensions");


                // Instantiate a ChromeDriver class.
                 driver=new ChromeDriver(opt);
                 driver.manage().window().maximize();
                 driver.get(config.get("url"));

                 browsereOpened=true;
                 break;


            default:
                System.out.println("provide correct browser name in config.yml file");

        }


        return driver;
    }

    /**
     * This function is used to close all the windows and close the browser after completion of scenario
     *
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    public void closeBrowser()
    {
        if(browsereOpened)
        {
            driver.close();
            driver.quit();
            driver=null;
        }
    }

    /**
     * This function waits until the page is loaded in the DOM
     *
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    public void waitForpageToLoad()
    {
        ExpectedCondition<Boolean> condition=new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };

        try {
            WebDriverWait wait =new WebDriverWait(driver,60);
            wait.until(condition);
        }
        catch (Exception e)
        {
            driver.navigate().refresh();
            WebDriverWait wait =new WebDriverWait(driver,60);
            wait.until(condition);
        }
    }

    /**
     * This function is waits until a web element is visible in the browser
     *
     * @param xpath xpath of the element
     * @param time time in seconds until for which user wants to wait
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */

    public void waitForVisibilityOfElements(By xpath, int time)
    {
        WebDriverWait wait=new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpath)));
    }


    /**
     * This function is waits until element is visible, and then it performs click operation on it.
     *
     * @param xpath xpath of the element
     * @param time time in seconds until for which user wants to wait for the element to be visible
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    public void clickVisibleElement(By xpath, int time) {
        WebDriverWait wait=new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpath)));
        driver.findElement(xpath).click();
    }

    /**
     * This function is scroll to the element in the page
     *
     * @param xpath xpath of the element
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    public boolean scrollToElement(By xpath) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(xpath));
        return true;
    }


    /**
     * This function is checks if an element is visible in the page or not
     *
     * @param xpath xpath of the element
     *
     * @return flag returns true if visible else returns false
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    public boolean ElementisVisible(By xpath)
    {
        boolean flag=false;

        try {
            flag = driver.findElement(xpath).isDisplayed();
            return flag;
        }
        catch (Exception e) {
            return flag;
        }

    }
    /**
     * This function waits for the given time
     *
     * @param time time in seconds until for which user wants to wait
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    public  void iWaitForElementToload(int time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    /**
     * This function is waits until element is visible, and then it performs click operation through JS on it.
     *
     * @param xpath xpath of the element
     * @param time time in seconds until for which user wants to wait for the element to be visible
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    public void clickVisibleElementThroughJS(By xpath)
    {
        WebElement element = driver.findElement(xpath);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

}
