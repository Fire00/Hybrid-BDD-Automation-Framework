package specs;

public interface NoBrokerXPaths {

    /**
     * This interface contains xpaths related to the scenarios/applications
     *
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */

    String NoBrokerHomePage = "//div[contains(text(),'Largest NoBrokerage Property Site')]";
    String Buy = "//div[contains(text(),'&opt')]";
    String searchCity = "//div[@id='searchCity']";
    String selectCityInDropDown = "//div[@class='css-q4imyt nb-select__menu-list']//div[contains(text(),'&city')]";

    String searchArea = "//input[@id='listPageSearchLocality']";

    String aptDropDown = "//div[contains(text(),'Apartment Type')]";

    String aptSuggetions = "//div[@class='css-q4imyt nb-select__menu-list nb-select__menu-list--is-multi']//div//div//span[contains(text(),'&aptType')]//..//input";
    String searchButton = "//button[contains(text(),'Search')]";
    String searchResults="((//button[contains(text(),'Get Owner Details')])[&ind]/parent::div//../../..)[1]";

    String description="//div[@id='description']";
}
