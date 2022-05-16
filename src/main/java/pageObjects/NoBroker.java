package pageObjects;

import baseTestSession.BaseTestSession;
import specs.NoBrokerXPaths;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reporter.SparkReporter;
import StepInit.Init;

import java.util.ArrayList;
import java.util.Map;

public class NoBroker implements NoBrokerXPaths {

    /**
     * This class contains all the functionality related to nobroker.in application
     *
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */

    private BaseTestSession session = null;
    private WebDriver driver = null;
    private ArrayList<String> apts = new ArrayList<>();
    int count = 0;
    public static SparkReporter reporter;

    /**
     *Constructor to initialize NoBroker, session(BaseTestSession) and reporter objects
     *
     * @param session Object of BaseTestSession class
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    public NoBroker(BaseTestSession session) {
        this.session = session;
        this.driver = session.driver;
        this.reporter= Init.reporter;
    }

    /**
     * This Method is used to check if website is opened or not
     *
     * @param website name of the website
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    public void userOpenedSiteAndSelectedOption(String website) {
        session.iWaitForElementToload(4);
        session.waitForVisibilityOfElements(By.xpath(NoBrokerHomePage), 60);
        reporter.report.info("Website Opened"+website);

    }

    /**
     * This Method is used to select city from drop down menu on homepage
     *
     * @param city name of the city
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    public void iSelectCityFromTheDropDown(String city) throws InterruptedException {
        session.iWaitForElementToload(4);
        session.clickVisibleElement(By.xpath(searchCity), 30);
        session.clickVisibleElement(By.xpath(selectCityInDropDown.replaceAll("&city", city)), 60);
        reporter.report.info("Selected "+city+" city from the drop down");
    }

    /**
     * This Method is used to select Buy/Rent/Commercial
     *
     * @param opt Buy/Rent/Commercial
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */

    public void iSelectOption(String opt) {
        session.iWaitForElementToload(4);
        session.clickVisibleElement(By.xpath(Buy.replaceAll("&opt",opt)), 30);
        reporter.report.info("Selected "+opt+" Option");
    }

    /**
     * This Method is used to enter areas in the search bar
     *
     * @param area name of the area
     * @param areaList Datatable of areas and addressed
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    public void iEnterInTheSearchBar(String area, DataTable areaList) throws InterruptedException {
        session.iWaitForElementToload(4);
        Map<String, String> data = areaList.asMap(String.class, String.class);
        System.out.println(data);

        for (String str : data.values()) {
            WebElement search = driver.findElement(By.xpath(searchArea));
            search.click();
            search.sendKeys(str);
            Thread.sleep(1000);
            search.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1000);
            search.sendKeys(Keys.ENTER);
            session.iWaitForElementToload(2);
            reporter.report.info("Entered "+str+" in Search bar");
        }

    }

    /**
     * This Method is used to select Apartment type checkboxes from drop dowm
     *
     * @param aptType1 name of 1st apartment type(ex 1 BHK)
     * @param aptType2 name of 2st apartment type(ex 1 BHK)
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */

    public void iSelectInAprtmentTypeDropDown(String aptType1, String aptType2) {
            session.iWaitForElementToload(4);
            session.clickVisibleElement(By.xpath(aptDropDown), 30);
            session.clickVisibleElement(By.xpath(aptSuggetions.replaceAll("&aptType", aptType1)), 30);
            session.clickVisibleElement(By.xpath(aptSuggetions.replaceAll("&aptType", aptType2)), 30);
            reporter.report.info("Selected "+aptType1+" & "+aptType2 +" checkboxes");
    }

    /**
     * This Method is used to click on the button
     *
     * @param button name of button
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */

    public void iClickOnButton(String button) throws InterruptedException {
        session.iWaitForElementToload(4);
        session.clickVisibleElement(By.xpath(searchButton), 30);
        reporter.report.info("Clicked of "+button+" button");

    }

    /**
     * This Methos is used to scroll down to the results and clicks on it after searching is completed
     *
     * @param ind Number of the reult you want to go to(ex: 4 for scrolling to 4th result)
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    public void iScrollDownToSearchResultAndSelectIt(String ind) throws InterruptedException {
        session.iWaitForElementToload(4);
        session.waitForVisibilityOfElements(By.xpath(searchResults.replaceAll("&ind", ind)),30);
        session.scrollToElement(By.xpath(searchResults.replaceAll("&ind", ind)));
        session.clickVisibleElement(By.xpath(searchResults.replaceAll("&ind", ind)), 30);
        reporter.report.info("Scrolled to the "+ind+"th result after search and clicked on it");
    }


    /**
     * This Method is used to validate if Description is available or not for that Result
     *
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    public void iValidateIfDescriptionSectionIsAvailable() throws InterruptedException {
        session.iWaitForElementToload(4);
        for (String handle : driver.getWindowHandles()) {
            if (!(handle.equals(driver.getWindowHandle()))) {
                driver.switchTo().window(handle);
            }
        }
        session.scrollToElement(By.xpath(description));
        if (session.ElementisVisible(By.xpath(description))) {
            System.out.println("Description is available Hence Test case is Passed");
            reporter.report.pass("Description is available");
            reporter.report.info(driver.findElement(By.xpath(description)).getText());
        } else {
            System.out.println("Description is unavailable Hence Test case is Failed");
            reporter.report.fail("Description is unavailable");
        }
    }
}
