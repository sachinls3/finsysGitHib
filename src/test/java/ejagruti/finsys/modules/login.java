package ejagruti.finsys.modules;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.log4j.Logger;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import ejagruti.finsys.pageobjects.baseclass;
import ejagruti.finsys.pageobjects.homepage;
import ejagruti.finsys.pageobjects.loginpage;
import ejagruti.finsys.pageobjects.managecompanytab;
import ejagruti.finsys.config.Config;
import ejagruti.finsys.config.HTMLReportGenerator;
import ejagruti.finsys.config.TakeScreenShot;;

public class login {
	//--------------Operations---------
		loginpage loginpageobj=null;
		homepage homepageobj=null;
		managecompanytab managecompanytabobj=null;
		public static WebDriver Driver=null;
		
		final static Logger logger = Logger.getLogger(login.class);
		int counter=1;
		
		public login(){
			
		}
				
	 @Given("^user opens the \"(.*)\" browser$")
	 public void OpenBrowser(String BrowserName)
	 {
				System.out.println(BrowserName+" -------------------");
				if(BrowserName.equalsIgnoreCase("firefox"))
				{
					baseclass.driver=new FirefoxDriver();
				}
     }
	 
	  @Given("^user enter the url \"(.*)\"$")
	  public void LaunchApplication(String URL) throws IOException
	  {
		try {
		  System.out.println("url:"+URL);
				baseclass.driver.get(URL);
				baseclass.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				baseclass.wait=new WebDriverWait(baseclass.driver, 30);
				baseclass.driver.manage().window().maximize();
				String message = "Step:"+(counter++)+" PASSED: user enter the url as "+URL;
				logger.info(message);
				HTMLReportGenerator.StepDetails("PASS", "LaunchApplication", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
      }
		catch(Exception ex) {
			String message = "Step:"+(counter++)+" FAILED: user enter the url as "+URL+"\nException Details:"+ex.getLocalizedMessage();
			logger.info(message);
			HTMLReportGenerator.StepDetails("FAIL", "LaunchApplication", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
			}
		}
	  
	  @Given("^user is on the application login page$")
	  public void LoginPage() throws IOException
	  {
		  try {
		  loginpageobj=new loginpage(baseclass.driver);
		  String message = "Step:"+(counter++)+" PASSED- user is on the application login page";
		  logger.info(message);
		  HTMLReportGenerator.StepDetails("PASS", "LoginPage", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
	  }
		  catch(Exception ex) {
			  String message = "Step:"+(counter++)+" FAILED- user is on the application login page\nException Details: "+ex.getLocalizedMessage();
			  logger.info(message);
			  HTMLReportGenerator.StepDetails("FAIL", "LoginPage", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
			  }
		  }
	 
	  @When("^user enters \"(.*)\" as username$")
	  public void EnterUserName(String Username1) throws Throwable
	  {
		  try {
			loginpageobj.username.sendKeys(Username1);
			String message = "Step:"+(counter++)+" PASSED- user enters "+Username1+" as username";
			logger.info(message);
			HTMLReportGenerator.StepDetails("PASS", "EnterUserName", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
	  }
		  catch(Exception ex) {
			  String message = "Step:"+(counter++)+" FAILED- user enters "+Username1+" as username\nException Details:"+ex.getLocalizedMessage();
			  logger.info(message);
			  HTMLReportGenerator.StepDetails("FAIL", "EnterUserName", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
			  }
		  }
	  
	  	  
		@When("^user enters \"(.*)\" as password$")
		public void EnterPassword(String Password) throws IOException
		{
			try {
			System.out.println(Password+" ---------------");
			loginpageobj.password.sendKeys(Password);
			String message = "Step:"+(counter++)+" PASSED- user enters "+Password+" as password";
			logger.info(message);
			HTMLReportGenerator.StepDetails("PASS", "EnterPassword", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
		}
			catch(Exception ex) {
				String message = "Step:"+(counter++)+" FAILED- user enters "+Password+" as password\nException Details"+ex.getLocalizedMessage();
				logger.info(message);
				HTMLReportGenerator.StepDetails("FAIL", "EnterPassword", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				}
			}
		
			
		@When("^user clicks on login button$")
		public void LoginButtonClick() throws IOException
		{
			try {
			loginpageobj.loginButton.click();
			String message = "Step:"+(counter++)+" PASSED- user clicks on login button";
			logger.info(message);
			HTMLReportGenerator.StepDetails("PASS", "LoginButtonClick", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
		}
			catch(Exception ex) {
				String message = "Step:"+(counter++)+" FAILED- user clicks on login button\nException Details:"+ex.getLocalizedMessage();
				logger.info(message);
				HTMLReportGenerator.StepDetails("FAIL", "LoginButtonClick", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				}
			}
		
		@Given("^user is on the application home page$")
		  public void HomePage() throws IOException
		  {
				try {
				homepageobj=new homepage(baseclass.driver);
				String message = "Step:"+(counter++)+" PASSED- user is on the application home page";
				logger.info(message);
				HTMLReportGenerator.StepDetails("PASS", "HomePage", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
		  }
				catch(Exception ex) {
					String message = "Step:"+(counter++)+" FAILED- user is on the application home page\nException Details:"+ex.getLocalizedMessage();
					logger.info(message);
					HTMLReportGenerator.StepDetails("FAIL", "HomePage", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
					}
				}
		
		 @Then("^user gets the message starting with \"(.*)\" on the top$")
			public void CheckForHomePageMessage(String message) throws IOException
			{
			 try {
			 baseclass.wait.until(ExpectedConditions.textToBePresentInElement(homepageobj.logout, "LOGOUT"));
			 	String welcomemsg=homepageobj.welcomeMessage.getText();
			 	System.out.println(welcomemsg+" --------------------");
			 	String _message = "Step:"+(counter++)+" PASSED- user gets the message starting with "+message+" on the top";
			 	logger.info(_message);
			 	HTMLReportGenerator.StepDetails("PASS", "CheckForHomePageMessage", _message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
			}
			 catch(Exception ex) {
				 String _message = "Step:"+(counter++)+" FAILED- user gets the message starting with "+message+" on the top"+ex.getLocalizedMessage();
				 logger.info(_message);
				 HTMLReportGenerator.StepDetails("FAIL", "CheckForHomePageMessage", _message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				 }
			 }
		 
		 @Then("user gets message starting with \"(.*)\" at the botton of the Login frame")
			public void CheckForLoginError(String message) throws IOException
			{
			 try {
			 baseclass.wait.until(ExpectedConditions.textToBePresentInElement(loginpageobj.loginError, "Please Enter Valid Username or Password!!!"));
			 	String errormsg=loginpageobj.loginError.getText();
			 	System.out.println(errormsg+" --------------------");
			 	String _message = "Step:"+(counter++)+" PASSED- user gets message starting with "+message+" message at the bottom of the login frame";
			 	logger.info(_message);
			 	HTMLReportGenerator.StepDetails("PASS", "CheckForLoginError", _message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
			}
			 catch(Exception ex) {
				 String _message = "Step:"+(counter++)+" FAILED- user gets message starting with "+message+" message at the bottom of the login frame\nException Details:"+ex.getLocalizedMessage();
				 logger.info(_message);
				 HTMLReportGenerator.StepDetails("FAIL", "CheckForLoginError", _message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				 }
			 }
		 
		 @Given("^temp$")
		 public void delthis()
		 {
			 System.out.println("temp is calling");
		 }
		 
		 @When("^user clicks on logout button$")
			public void ClickOnLogout() throws IOException
			{
			 try {	
			 homepageobj.logout.click();
			 String message = "Step:"+(counter++)+ " PASSED- user clicks on logout button";
			 logger.info(message);
			 HTMLReportGenerator.StepDetails("PASS", "ClickOnLogout", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
			}
			 catch(Exception ex) {
				 String message = "Step:"+(counter++)+ " FAILED- user clicks on logout button\nException Deetails"+ex.getLocalizedMessage();
				 logger.info(message);
				 HTMLReportGenerator.StepDetails("FAIL", "ClickOnLogout", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				 }
			 }
		 
	
		 @Then ("^user gets back to login page$")
		 public void VerifyLoginPage() throws IOException {
			 try {
			 baseclass.wait.until(ExpectedConditions.textToBePresentInElement(loginpageobj.loginpage, "Login to SBDC"));
			 String loginframecaption=loginpageobj.loginpage.getText();
			 System.out.println(loginframecaption);
			 String message = "Step:"+(counter++)+" PASSED- user gets back to login page";
			 logger.info(message);
			 HTMLReportGenerator.StepDetails("PASS", "VerifyLoginPage", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
			 }
			 catch(Exception ex) {
				 String message = "Step:"+(counter++)+" FAILED- user gets back to login page\nException Details:"+ex.getLocalizedMessage();
				 logger.info(message);
				 HTMLReportGenerator.StepDetails("FAIL", "VerifyLoginPage", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
			 }
		 }
		 
		 @Before()
		 public void BeforeSuite() {
			 System.out.println("Printing Done");
		 }
		 
		 @Before()
			public void BeforeEveryScenario(Scenario scenario) throws IOException
			{
				counter = 1;
				if(Config.listofsuite==null)
					{
						Config.listofsuite=scenario.getSourceTagNames();
						HTMLReportGenerator.TestSuiteStart("D:\\smoke.html", "Test1");
					}
				HTMLReportGenerator.TestSuiteStart("D:\\smoke.html", "Sachin");
				HTMLReportGenerator.TestCaseStart(scenario.getName(), scenario.getLines().toString());
				System.out.println("new scenario is started "+scenario.getName());
			}
		 
		@After()
		public void AfterEveryScenario(Scenario scenario) {
			counter = 0;
			baseclass.driver.close();
			HTMLReportGenerator.TestCaseEnd();
			HTMLReportGenerator.TestSuiteEnd();
			
		}
}
