package stepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.NoBroker;

import static StepInit.Init.pageObjectManger;

public class NoBrokerStepDef {



    NoBroker noBroker = pageObjectManger.getNoBroker();


    @Given("I select {string} and {string}")
    public void IselectandSearch(String arg1, String arg2) {
        System.out.println("Hello");
    }

    @Given("User Opened {string} site")
    public void userOpenedSiteAndSelectedOption(String website) {
        noBroker.userOpenedSiteAndSelectedOption(website);
    }

    @Then("I select {string} city from the drop down")
    public void iSelectCityFromTheDropDown(String city) throws InterruptedException {
        noBroker.iSelectCityFromTheDropDown(city);
    }

    @And("I select {string} option")
    public void iSelectOption(String opt) {
        noBroker.iSelectOption(opt);
    }

    @Then("I enter {string} in the search bar")
    public void iEnterInTheSearchBar(String area, DataTable areaList) throws InterruptedException {
        noBroker.iEnterInTheSearchBar(area, areaList);
    }

    @Then("I select {string} and {string} in apartment Type DropDown")
    public void iSelectInAprtmentTypeDropDown(String aptType1, String aptType2) throws InterruptedException {
        noBroker.iSelectInAprtmentTypeDropDown(aptType1, aptType2);
    }

    @Then("I click on {string} button")
    public void iClickOnButton(String button) throws InterruptedException {
        noBroker.iClickOnButton(button);
    }

    @And("I scroll down to {string} search result and select it")
    public void iScrollDownToSearchResultAndSelectIt(String ind) throws InterruptedException {
        noBroker.iScrollDownToSearchResultAndSelectIt(ind);
    }

    @Then("I validate if description section is available")
    public void iValidateIfDescriptionSectionIsAvailable() throws InterruptedException {
        noBroker.iValidateIfDescriptionSectionIsAvailable();
    }
}
