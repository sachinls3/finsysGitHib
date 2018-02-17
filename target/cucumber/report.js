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
  "name": "user selects a company named \"TestCompanySachinS15\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateNewCompany.selectCompanyNameFromTheList(String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\".//div[@class\u003d\u0027datagrid-cell datagrid-cell-c1-name\u0027][text()\u003d\u0027TestCompanySachinS15\u0027]\"}\nCommand duration or timeout: 121 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LAPTOP-S9QV7E96\u0027, ip: \u0027192.168.0.8\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities [{applicationCacheEnabled\u003dtrue, rotatable\u003dfalse, handlesAlerts\u003dtrue, databaseEnabled\u003dtrue, version\u003d45.0.2, platform\u003dWINDOWS, nativeEvents\u003dfalse, acceptSslCerts\u003dtrue, webStorageEnabled\u003dtrue, locationContextEnabled\u003dtrue, browserName\u003dfirefox, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 90a58a6d-151b-4772-bdb2-fd19841d4f6f\n*** Element info: {Using\u003dxpath, value\u003d.//div[@class\u003d\u0027datagrid-cell datagrid-cell-c1-name\u0027][text()\u003d\u0027TestCompanySachinS15\u0027]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:500)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat ejagruti.finsys.modules.CreateNewCompany.selectCompanyNameFromTheList(CreateNewCompany.java:725)\r\n\tat ✽.user selects a company named \"TestCompanySachinS15\"(src/test/resources/FeatureCollections/CreateCompany.feature:47)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\".//div[@class\u003d\u0027datagrid-cell datagrid-cell-c1-name\u0027][text()\u003d\u0027TestCompanySachinS15\u0027]\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LAPTOP-S9QV7E96\u0027, ip: \u0027192.168.0.8\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: driver.version: unknown\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElementInternal_(file:///C:/Users/Sachin/AppData/Local/Temp/anonymous2698292045066257785webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10770)\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElement(file:///C:/Users/Sachin/AppData/Local/Temp/anonymous2698292045066257785webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10779)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_/h(file:///C:/Users/Sachin/AppData/Local/Temp/anonymous2698292045066257785webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12661)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_(file:///C:/Users/Sachin/AppData/Local/Temp/anonymous2698292045066257785webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12666)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.execute/\u003c(file:///C:/Users/Sachin/AppData/Local/Temp/anonymous2698292045066257785webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12608)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "user clicks on Destroy button",
  "keyword": "And "
});
formatter.match({
  "location": "CreateNewCompany.clickOnDestroyButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user clicks Ok on Confirm popup",
  "keyword": "And "
});
formatter.match({
  "location": "CreateNewCompany.clickOnOkButtonOnDestroyCompanyConfirmPopUp()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "selected company gets deleted from the Manage Company tab with a message saying \"Company Has Been Successfully Deleted!!!\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateNewCompany.verifyCompanyDeleted(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});