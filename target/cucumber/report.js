$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/FeatureCollections/CreateCompany.feature");
formatter.feature({
  "name": "Create Company",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@CreateComapny"
    }
  ]
});
formatter.background({
  "name": "user is successfully logged in",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user opens the \"firefox\" browser",
  "keyword": "When "
});
formatter.match({
  "location": "login.OpenBrowser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter the url \"http://localhost:90/finsys\"",
  "keyword": "And "
});
formatter.match({
  "location": "login.LaunchApplication(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is on the application login page",
  "keyword": "Then "
});
formatter.match({
  "location": "login.LoginPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters \"dummyfm\" as username",
  "keyword": "When "
});
formatter.match({
  "location": "login.EnterUserName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters \"passw0rd\" as password",
  "keyword": "And "
});
formatter.match({
  "location": "login.EnterPassword(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on login button",
  "keyword": "And "
});
formatter.match({
  "location": "login.LoginButtonClick()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is on the application home page",
  "keyword": "Then "
});
formatter.match({
  "location": "login.HomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user gets the message starting with \"Welcome\" on the top",
  "keyword": "And "
});
formatter.match({
  "location": "login.CheckForHomePageMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete a given Company from the list",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@CreateComapny"
    },
    {
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "name": "user is on the application home page",
  "keyword": "Given "
});
formatter.match({
  "location": "login.HomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user opens West Pane tab on home page if not already open",
  "keyword": "And "
});
formatter.match({
  "location": "HomePageActions.openWestPanel()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user expands Financial Analysis tab if not already expanded",
  "keyword": "And "
});
formatter.match({
  "location": "HomePageActions.expandFinAnalysisPane()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on Manage Company link under Financial Analysis tab",
  "keyword": "When "
});
formatter.match({
  "location": "CreateNewCompany.openManageCompanyTab()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user selects a company named \"TestCompanySachinS14\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateNewCompany.selectCompanyNameFromTheList(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on Destroy button",
  "keyword": "And "
});
formatter.match({
  "location": "CreateNewCompany.clickOnDestroyButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks Ok on Confirm popup",
  "keyword": "And "
});
formatter.match({
  "location": "CreateNewCompany.clickOnOkButtonOnDestroyCompanyConfirmPopUp()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "selected company gets deleted from the Manage Company tab with a message saying \"Company Has Been Successfully Deleted!!!\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateNewCompany.verifyCompanyDeleted(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});