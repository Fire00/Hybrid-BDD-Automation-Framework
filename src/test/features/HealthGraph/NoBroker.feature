@HealthGraph

Feature: HealthGraph QA Automation Assignment

  @UI
  Scenario: Verify search functionality for the multiple locality and description tag for the property
    Given User Opened "NOBROKER" site
    Then I select "Mumbai" city from the drop down
    And  I select "Buy" option
    Then I enter "Malad" in the search bar
      | Area1 | Malad East,Mumbai,Maharashtra,India |
      | Area2 | Malad West,Sundar Ln, Kanchpada |
    Then I select "2 BHK" and "3 BHK" in apartment Type DropDown
    Then I click on "Search" button
    And I scroll down to "4" search result and select it
    Then I validate if description section is available





