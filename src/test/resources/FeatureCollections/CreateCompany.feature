#StyoryType=WEB
#Owner=ejagruti
#CreationDate=24-12-2017 Sunday
@CreateComapny
Feature: Create Company

  Background: user is successfully logged in
    When user opens the "firefox" browser
    And user enter the url "http://localhost:90/finsys"
    Then user is on the application login page
    When user enters "dummyfm" as username
    And user enters "passw0rd" as password
    And user clicks on login button
    Then user is on the application home page
    And user gets the message starting with "Welcome" on the top

  @EndToEnd
  Scenario: Create Company with all valid inputs
    Given user is on the application home page
    And user opens West Pane tab on home page if not already open
    And user expands Financial Analysis tab if not already expanded
    When user clicks on Manage Company link under Financial Analysis tab
    And user clicks on the New button under Manage Company tab
    And user enters Company Name as "TestCompanySachinS34"
    And user selects Company Type as "Manufacturing"
    And user selects Company Subtype as "Automobile"
    And user enters Address as "Pune"
    And user enters Phone as "9970365091"
    And user enters Email as "test@gmail.com"
    And user enters Pan Details as "AYRPDS2234H"
    And user enters Tin Details as "BYRPDS2234H"
    And user enters Mobile as "9970365092"
    And user enters Web Site as "www.abcderf.com"
    And user selects Country as "INDIA"
    And user selects State as "ANDHRA PRADESH"
    And user selects City as "NIRMAL"
    And user enters Total Employee as "1234"
    And user clicks on Save button
    Then new company gets created and listed on the first row of the first page as "TestCompanySachinS33"

  @SmokeTest
  Scenario: Delete a given Company from the list
    Given user is on the application home page
    And user opens West Pane tab on home page if not already open
    And user expands Financial Analysis tab if not already expanded
    When user clicks on Manage Company link under Financial Analysis tab
    And user selects a company named "TestCompanySachinS15"
    And user clicks on Destroy button
    And user clicks Ok on Confirm popup
    Then selected company gets deleted from the Manage Company tab with a message saying "Company Has Been Successfully Deleted!!!"

  @EndToEnd
  Scenario: Create Company with missing Company Type
    Given user is on the application home page
    And user opens West Pane tab on home page if not already open
    And user expands Financial Analysis tab if not already expanded
    When user clicks on Manage Company link under Financial Analysis tab
    And user clicks on the New button under Manage Company tab
    And user enters Company Name as ""
    And user selects Company Type as ""
    And user selects Company Subtype as ""
    And user enters Address as ""
    And user enters Phone as ""
    And user enters Email as ""
    And user enters Pan Details as ""
    And user enters Tin Details as ""
    And user enters Mobile as ""
    And user enters Web Site as ""
    And user selects Country as ""
    And user enters Total Employee as ""
    Then a modal dialog prompts saying "Please Select Company Type!!!" with Ok button for missing CompanyType value

  @EndToEnd
  Scenario: Create Company with partial valid & partial invalid inputs with Company Name under 3 characters
    Given user is on the application home page
    And user opens West Pane tab on home page if not already open
    And user expands Financial Analysis tab if not already expanded
    When user clicks on Manage Company link under Financial Analysis tab
    And user clicks on the New button under Manage Company tab
    And user enters Company Name as "ss"
    Then system shows a tooltip saying "Please enter a value between 3 and 20."

  @EndToEnd
  Scenario: Create Company by passing only mandatory details
    Given user is on the application home page
    And user opens West Pane tab on home page if not already open
    And user expands Financial Analysis tab if not already expanded
    When user clicks on Manage Company link under Financial Analysis tab
    And user clicks on the New button under Manage Company tab
    And user enters Company Name as "SachinTestCompany20"
    And user selects Company Type as "Manufacturing"
    And user selects Company Subtype as "Automobile"
    And user enters Address as ""
    And user enters Phone as ""
    And user enters Email as "email@email.com"
    And user enters Pan Details as "AYRPS2279J"
    And user enters Tin Details as "AYPRS2239J"
    And user enters Mobile as ""
    And user enters Web Site as ""
    And user selects Country as "India"
    And user selects State as "ANDHRA PRADESH"
    And user selects City as "NIRMAL"
    And user clicks on Save button
    Then new company gets created and listed on the first row of the first page as "SachinTestCompany20"

  @EndToEnd
  Scenario: Create Company with missing Country
    Given user is on the application home page
    And user opens West Pane tab on home page if not already open
    And user expands Financial Analysis tab if not already expanded
    When user clicks on Manage Company link under Financial Analysis tab
    And user clicks on the New button under Manage Company tab
    And user enters Company Name as "TestCompany"
    And user selects Company Type as "Manufacturing"
    And user selects Company Subtype as ""
    And user selects Country as ""
    Then a modal dialog prompts saying "Please Select Country!!!" with Ok button for missing Country value selection

  @EndToEnd
  Scenario: Create Company with missing State
    Given user is on the application home page
    And user opens West Pane tab on home page if not already open
    And user expands Financial Analysis tab if not already expanded
    When user clicks on Manage Company link under Financial Analysis tab
    And user clicks on the New button under Manage Company tab
    And user enters Company Name as "TestCompany"
    And user selects Company Type as "Manufacturing"
    And user selects Country as "INDIA"
    And user selects State as "ANDHRA PRADESH"
    Then a modal dialog prompts saying "Please Select State!!!" with Ok button for missing Country value selection

  @EndToEnd
  Scenario: Verify available Company Type while creation of a New Company
    Given user is on the application home page
    And user opens West Pane tab on home page if not already open
    And user expands Financial Analysis tab if not already expanded
    When user clicks on Manage Company link under Financial Analysis tab
    And user clicks on the New button under Manage Company tab
    And user enters Company Name as "TestCompany"
    And user validates values in CompanyType drop down
      |Manufacturing|
      |IT|
      |Consultancy Services1|
      |Marketing|
      |FMCG|
