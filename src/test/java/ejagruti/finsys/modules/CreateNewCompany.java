package ejagruti.finsys.modules;


import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ejagruti.finsys.config.Config;
import ejagruti.finsys.config.HTMLReportGenerator;
import ejagruti.finsys.config.TakeScreenShot;
import ejagruti.finsys.pageobjects.baseclass;
import ejagruti.finsys.pageobjects.homepage;
import ejagruti.finsys.pageobjects.loginpage;
import ejagruti.finsys.pageobjects.managecompanytab;



public class CreateNewCompany {
	//--------------Operations---------
			loginpage loginPageObj=null;
			homepage homePageObj=null;
			int counter=1;
			managecompanytab manageCompanyTabObj=null;
			final static Logger logger = Logger.getLogger(CreateNewCompany.class);
//			Robot objRobot = null; //Robot class is used for taking screen shot of prompt; TakeScreenShot fails to take screen shots with prompts
			 
			@Given("^user is on the application Home page$")
			public void HomePage() {
			
			}
			
			@When ("^user clicks on Manage Company link under Financial Analysis tab$") 
			public void openManageCompanyTab() throws IOException{
				try
				{
				homePageObj = new homepage(baseclass.driver);
				homePageObj.manageCompanyLink.click();
				String message="Step:"+(counter++)+"-PASS-user clicks on Manage Company link under Financial Analysis tab";
				logger.info(message);
				HTMLReportGenerator.StepDetails("PASS", "openManageCompanyTab", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				}
				catch(Exception ex)
				{
					String message="Step:"+(counter++)+"FAIL- user clicks on Manage Company link under Financial Analysis tab.\nException Details:"+ex.getLocalizedMessage();
					logger.info(message);
					HTMLReportGenerator.StepDetails("FAIL", "openManageCompanyTab", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				}
			 }
			 
			 @And ("^user clicks on the New button under Manage Company tab$")
			 public void clickOnNewButton() throws InterruptedException, IOException{
				 try {
				 Thread.sleep(1000);
				 manageCompanyTabObj = new managecompanytab(baseclass.driver);
				 baseclass.driver.switchTo().frame("actionid");
				 manageCompanyTabObj.newCompanyButton.click();
				 String message = "Step:"+(counter++)+" PASSED- user clicks on the New button under Manage Company tab";
				 logger.info(message);
				 HTMLReportGenerator.StepDetails("PASS", "clickOnNewButton", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				 }
				 catch(Exception ex) {
					 String message = "Step:"+(counter++)+" FAILED- user clicks on the New button under Manage Company tab. \n Exception Details:"+ex.getLocalizedMessage();
					 logger.info(message);
					 HTMLReportGenerator.StepDetails("FAIL", "clickOnNewButton", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
					 }
				 }
				 
			 			 
			 @And ("^user enters Company Name as \"(.*)\"$")
			 public void enterCompanyName(String companyName) throws InterruptedException, IOException{
				 try {
				 Thread.sleep(1000);
				 manageCompanyTabObj.companyName.sendKeys(companyName);
				 String message = "Step:"+(counter++)+" PASSED- user enters Company Name as "+companyName;
				 logger.info(message);
				 HTMLReportGenerator.StepDetails("PASS", "enterCompanyName", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				 }
				 catch(Exception ex) {
					 String message = "Step:"+(counter++)+" FAILED- user enters Company Name as" +companyName+"\nException Details:" +ex.getLocalizedMessage();
					 logger.info(message);
					 HTMLReportGenerator.StepDetails("FAIL", "enterCompanyName", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
					 }
				 }
			 
			@And ("^user selects Company Type as \"(.*)\"$")
			 public void selectCompanyType(String CompanyType) throws InterruptedException, IOException{
				try {
				Thread.sleep(1000);
				manageCompanyTabObj.companyType.sendKeys(CompanyType);
				String message = "Step:"+(counter++)+" PASSED- user selects Company Type";
				
				logger.info(message);
				
				HTMLReportGenerator.StepDetails("PASS", "selectCompanyType", "user selects Company Type", 
						 TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				}
				catch(Exception ex) {
					String message = "Step:"+(counter++)+" FAILED- user selects Company Type \nException Details:" +ex.getLocalizedMessage();
					logger.info(message);
					HTMLReportGenerator.StepDetails("FAIL", "selectCompanyType", "user selects Company Type", 
							 TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
					}
				}
			
			@And ("^user validates values in CompanyType drop down$")
			public void verifyCompanyTypeDropDownValues(List<String> expectedDropDownValues) throws Throwable {
				try {
				for (String str:expectedDropDownValues);
				int expectedDropDownSize = expectedDropDownValues.size();
				
				Select se = new Select (manageCompanyTabObj.companyType); 
				List <WebElement> options = se.getOptions();
				
				for (int i = 0; i<expectedDropDownSize; i++) {
					String actualCompanyTypeDropDownValue = options.get(i+1).getText();
					String expectedDropDownValue = expectedDropDownValues.get(i);
					Assert.assertEquals(expectedDropDownValue, actualCompanyTypeDropDownValue);
					}
				String message = "Step:"+(counter++)+" PASSED- user validates values in CompanyType in drop down";					
				logger.info(message);
				
				HTMLReportGenerator.StepDetails("PASS", "selectCompanyType", "user selects Company Type", 
						 TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				}
				catch(AssertionError ex) {
					String message = "Step:"+(counter++)+" FAILED- user validates values in CompanyType in drop down/nException Details: "+ex.getLocalizedMessage();
					logger.info(message);
					
					HTMLReportGenerator.StepDetails("FAIL", "selectCompanyType", message, 
							 TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
					}
				catch(Exception ex) {
					String message = "Step:"+(counter++)+" FAILED- user validates values in CompanyType in drop down/nException Details: "+ex.getLocalizedMessage();
					logger.info(message);
					
					HTMLReportGenerator.StepDetails("FAIL", "selectCompanyType", message, 
							 TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
					}
				}
			
			@And ("^user selects Company Subtype as \"(.*)\"$")
			public void selectCompanySubType(String companySubType) throws InterruptedException, IOException{
				try {
				Thread.sleep(1000);
				manageCompanyTabObj.companySubType.sendKeys(companySubType);
				String message = "Step:"+(counter++)+" PASSED- user selects Company SubType as "+companySubType;
				logger.info(message);
				HTMLReportGenerator.StepDetails("PASS", "selectCompanySubType", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				
			}
				catch(Exception ex) {
					String message = "Step:"+(counter++)+" FAILED- user selects Company SubType as "+companySubType+ "\nException Details" +ex.getLocalizedMessage();
					logger.info(message);
					HTMLReportGenerator.StepDetails("FAIL", "selectCompanySubType", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
					}
				}
			
			
			@And ("^user enters Address as \"(.*)\"$")
			public void enterAddress(String _address) throws IOException{
				try {
					Thread.sleep(1000);
					manageCompanyTabObj.address.sendKeys(_address);
					String message = "Step:"+(counter++)+" PASSED- user selects address as "+_address;
					logger.info(message);
					HTMLReportGenerator.StepDetails("PASS", "enterAddress", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
			}
				catch(Exception ex) {
				String message = "Step:"+(counter++)+" FAILED- user selects address as "+_address+"\nException Details:"+ex.getLocalizedMessage();
				logger.info(message);
				HTMLReportGenerator.StepDetails("FAIL", "enterAddress", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				}
				
			}
			
			@And("^user enters Phone as \"(.*)\"$")
			public void enterPhone(String phone) throws IOException{
				try {
					Thread.sleep(1000);
					manageCompanyTabObj.phone.sendKeys(phone);
					String message = "Step:"+(counter++)+" PASSED- user enters phone as "+phone;
					logger.info(message);
					HTMLReportGenerator.StepDetails("PASS", "enterPhone", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
			}
				catch(Exception ex) {
					String message = "Step:"+(counter++)+" FAILED- user enters phone as "+phone+"\n Exception Details:"+ex.getLocalizedMessage();
					logger.info(message);
					HTMLReportGenerator.StepDetails("FAIL", "enterPhone", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
					}
				}
			
			@And("^user enters Email as \"(.*)\"$")
			public void enterEmail(String email) throws IOException{
				try {
					Thread.sleep(1000);
					manageCompanyTabObj.email.sendKeys(email);
					String message ="Step:"+(counter++)+" PASSED- user enters email as "+email;
					logger.info(message);
					HTMLReportGenerator.StepDetails("PASS", "enterEmail", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
						}
				catch(Exception ex) {
					String message ="Step:"+(counter++)+" FAILED- user enters email as "+email+"\nException Details:"+ex.getLocalizedMessage();
					logger.info(message);
					HTMLReportGenerator.StepDetails("FAIL", "enterEmail", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
					}
				}
			
			@And("^user enters Pan Details as \"(.*)\"$")
			public void enterPan(String pan) throws IOException{
				try {
					Thread.sleep(1000);
					manageCompanyTabObj.panDetails.sendKeys(pan);
					String message = "Step:"+(counter++)+" PASSED- user enters pan as "+pan;
					logger.info(message);
					HTMLReportGenerator.StepDetails("PASS", "enterPan", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
			}
				catch(Exception ex){
					String message = "Step:"+(counter++)+" FAILED- user enters pan as "+pan+"\nException Details: "+ex.getLocalizedMessage();
					logger.info(message);
					HTMLReportGenerator.StepDetails("FAIL", "enterPan", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
					}
				}
			
			@And("^user enters Tin Details as \"(.*)\"$")
			public void enterTin(String tin) throws IOException{
				try {
					Thread.sleep(1000);
					manageCompanyTabObj.tinDetails.sendKeys(tin);
					String message = "Step:"+(counter++)+" PASSED- user enters Tin Details as "+tin;
					logger.info(message);
					HTMLReportGenerator.StepDetails("PASS", "enterTin", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
			}
				catch(Exception ex) {
					String message = "Step:"+(counter++)+" FAILED- user enters Tin Details as "+tin+"\nException Details:"+ex.getLocalizedMessage();
					logger.info(message);
					HTMLReportGenerator.StepDetails("FAIL", "enterTin", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
					}
				}
			
			@And("^user enters Mobile as \"(.*)\"$")
			public void enterMobile(String mobile) throws IOException{
				try {
					Thread.sleep(1000);
					manageCompanyTabObj.mobile.sendKeys(mobile);
					String message = "Step:"+(counter++)+" PASSED - user enters mobile as "+mobile;
					logger.info(message);
					HTMLReportGenerator.StepDetails("PASS", "enterMobile", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
			}
			catch(Exception ex) {
				String message = "Step:"+(counter++)+" FAILED - user enters mobile as "+mobile+"\nException Details:"+ex.getLocalizedMessage();
				logger.info(message);
				HTMLReportGenerator.StepDetails("FAIL", "enterMobile", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				}
			}
			
			@And("^user enters Web Site as \"(.*)\"$")
			public void enterWebSite(String website) throws IOException{
				try {
					Thread.sleep(1000);
					manageCompanyTabObj.webSite.sendKeys(website);
					String message = "Step:"+(counter++)+" PASSED- user enters Web Site as "+website;
					logger.info(message);
					HTMLReportGenerator.StepDetails("PASS", "enterWebSite", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
			}
				catch(Exception ex) {
					String message = "Step:"+(counter++)+" FAILED- user enters Web Site as "+website+"\nException"+ex.getLocalizedMessage();
					logger.info(message);
					HTMLReportGenerator.StepDetails("FAIL", "enterWebSite", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				}
			}
			
			@And("^user selects Country as \"(.*)\"$")
			public void selectCountry(String country) throws IOException{
				try {
					Thread.sleep(2000);
					manageCompanyTabObj.countryid.sendKeys(country);
					String message = "Step:"+(counter++)+" PASSED - user selects Country as "+country;
					manageCompanyTabObj.countryid.sendKeys(Keys.TAB);
					logger.info(message);
					HTMLReportGenerator.StepDetails("PASS", "selectCountry", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				}
				catch(Exception ex) {
					String message = "Step:"+(counter++)+" FAILED- user selects Country as "+country+"\nException"+ex.getLocalizedMessage();
					logger.info(message);
					HTMLReportGenerator.StepDetails("FAIL", "selectCountry", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
					}
				}
				
			@And("user selects State as \"(.*)\"$")
			public void selectState(String state) throws InterruptedException, IOException{
				try {
					Thread.sleep(2000);
					Select _state = new Select (manageCompanyTabObj.state);
					_state.selectByVisibleText(state);
					manageCompanyTabObj.state.sendKeys(Keys.TAB);
					String message = "Step:"+(counter++)+" PASSED- user selects State as "+state;
					logger.info(message);
					HTMLReportGenerator.StepDetails("PASS", "selectState", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
			}
				catch(Exception ex) {
					String message = "Step:"+(counter++)+" FAILED- user selects State as "+state+"\nException Details: "+ex.getLocalizedMessage();
					logger.info(message);
					HTMLReportGenerator.StepDetails("FAIL", "selectState", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
					}
				}
			
			@And("^user selects City as \"(.*)\"$")
			public void selectCity(String city) throws InterruptedException, IOException{
				try {
					Thread.sleep(1000);
					Select _city = new Select (manageCompanyTabObj.cityName);
					_city.selectByVisibleText(city);
					manageCompanyTabObj.cityName.sendKeys(Keys.TAB);
					String message = "Step:"+(counter++)+" PASSED- user selects City as "+city;
					logger.info(message);
					HTMLReportGenerator.StepDetails("PASS", "selectCity", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
			}
				catch(Exception ex) {
					String message = "Step:"+(counter++)+" PASSED- user selects City as "+city+"\nException Details:"+ex.getLocalizedMessage();
					logger.info(message);
					HTMLReportGenerator.StepDetails("FAIL", "selectCity", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
					}
				}
			
			@And("^user enters Total Employee as \"(.*)\"$")
			public void enterEmployees(String _totalEmployee) throws IOException{
				try {
					Thread.sleep(1000);
					manageCompanyTabObj.totalEmployee.sendKeys(_totalEmployee);
					String message = "Step:"+(counter++)+" PASSED- user enters Total Employee as "+_totalEmployee;
					logger.info(message);
					HTMLReportGenerator.StepDetails("PASS", "enterEmployees", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
			}
				catch(Exception ex) {
					String message = "Step:"+(counter++)+" FAILED- user enters Total Employee as "+_totalEmployee+ex.getLocalizedMessage();
					logger.info(message);
					HTMLReportGenerator.StepDetails("FAIL", "enterEmployees", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
					}
				}
			
			@And("^user clicks on Save button$")
			public void clickSave() throws InterruptedException, IOException {
				try {
					Thread.sleep(2000);
					manageCompanyTabObj.saveButton.click();
					String message = "Step:"+(counter++)+" PASSED- user clicks on Save button";
					logger.info(message);
					HTMLReportGenerator.StepDetails("PASS", "clickSave", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
			}
				catch(Exception ex) {
					String message = "Step:"+(counter++)+" FAILED- user clicks on Save button\nException Details:"+ex.getLocalizedMessage();
					logger.info(message);
					HTMLReportGenerator.StepDetails("FAIL", "clickSave", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
					}
				}
			
			@Then("^new company gets created and listed on the first row of the first page as \"(.*)\"$")
			public void verifyNewlyAddedCompany(String expectedCompanyName) throws InterruptedException, IOException {
				try {
					Thread.sleep(3000);
					String _actualCompanyName = manageCompanyTabObj.newCompanyTopRow.getText();
					Assert.assertEquals(expectedCompanyName, _actualCompanyName);
						System.out.println("Company created successfully");
						String message = "Step:"+(counter++)+" PASSED- Company created succesfully";
						logger.info(message);
						HTMLReportGenerator.StepDetails("PASS", "verifyNewlyAddedCompany", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
						}
				catch(Exception ex) {
					System.out.println("Company creation failed");
					String message = "Step:"+(counter++)+" FAILED - Company created succesfully";
					logger.info(message);
					HTMLReportGenerator.StepDetails("FAIL", "verifyNewlyAddedCompany", message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
					}
				}
			
			@Then("^a modal dialog prompts saying \"(.*)\" with Ok button for missing CompanyType value$")
			public void verifyMissingCompanyTypeModalDialog(String expectedAlertMessage) throws InterruptedException, IOException, AWTException {
				try {
					Thread.sleep(1000);	
					manageCompanyTabObj.saveButton.click();
					Alert missingCompanyTypeAlert = baseclass.driver.switchTo().alert();
					String actualAlertMessage = missingCompanyTypeAlert.getText(); 
					System.out.println(actualAlertMessage);
					Thread.sleep(1000);
					Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
					String _message = "Step:"+(counter++)+" PASSED- a modal dialog prompts saying Please Select a Company Type!!!! with Ok button";
					logger.info(_message);
					
//					Robot objRobot = null; 
					Robot objRobot = new Robot();// Creating object of Robot class
			        Dimension screenDim =  Toolkit.getDefaultToolkit().getScreenSize();
			        BufferedImage exportImage =objRobot.createScreenCapture(new Rectangle(0, 0, (int)screenDim.getWidth(), (int)screenDim.getHeight())); //Create the image
			        			        
			        Graphics2D imageGraphics = (Graphics2D) exportImage.getGraphics();//Get graphics - Get the layer we can actually draw on
			        
			        imageGraphics.dispose();//Cleanup after ourselves
			        
			        //Setup to write the BufferedImage to a file
			        String pathToFile = "dir";
			        File outputDirectory = new File(pathToFile);
			        String promptImageFilePath = Config.getImageFilePathForPrompts();
			        File outputFile = new File(promptImageFilePath);

			        //Here we make sure the directory exists.Returns TRUE if: The directory is MISSING and/or the directory IS NOT a directory
			        if(!outputDirectory.exists() || !outputDirectory.isDirectory()){
			        	outputDirectory.mkdirs(); //Make the directory
			        	} // Else do nothing
			        	ImageIO.write(exportImage, "png", outputFile);
			        
			        HTMLReportGenerator.StepDetails("PASS", "verifyMissingDataModalDialog", _message, promptImageFilePath);
			        missingCompanyTypeAlert.accept();
					}
				catch(AssertionError ex) {
					Robot objRobot = new Robot();
//					Robot objRobot = null; 
					Dimension screenDim =  Toolkit.getDefaultToolkit().getScreenSize();
			        
			        BufferedImage exportImage =objRobot.createScreenCapture(new Rectangle(0, 0, (int)screenDim.getWidth(), (int)screenDim.getHeight()));//Create the image
			        Graphics2D imageGraphics = (Graphics2D) exportImage.getGraphics(); //Get graphics - Get the layer we can actually draw on
			        
			        imageGraphics.dispose(); //Cleanup after ourselves
			        
			        //Setup to write the BufferedImage to a file
			        String pathToFile = "dir";
			        File outputDirectory = new File(pathToFile);
			        String promptImageFilePath = Config.getImageFilePathForPrompts();
			        File outputFile = new File(promptImageFilePath);

			        //Here we make sure the directory exists.Returns TRUE if: The directory is MISSING and/or the directory IS NOT a directory
			        if(!outputDirectory.exists() || !outputDirectory.isDirectory()){
			        	outputDirectory.mkdirs(); //Make the directory
			        	} //Else do nothing
			        	ImageIO.write(exportImage, "png", outputFile); //Write the file
			        	String _message = "Step:"+(counter++)+
								" FAILED- a modal dialog prompts saying Please Select a Company Type!!!! with Ok button"+ "/nException Details"+
								ex.getLocalizedMessage();
						logger.info(_message);
			        	HTMLReportGenerator.StepDetails("FAIL", "verifyMissingDataModalDialog", _message, promptImageFilePath);
			        	baseclass.driver.switchTo().alert().dismiss();
					}
				catch(Exception ex) {
					Robot objRobot = new Robot();
//					Robot objRobot = null; 
					Dimension screenDim =  Toolkit.getDefaultToolkit().getScreenSize();
			        
			        BufferedImage exportImage =objRobot.createScreenCapture(new Rectangle(0, 0, (int)screenDim.getWidth(), (int)screenDim.getHeight()));//Create the image
			        Graphics2D imageGraphics = (Graphics2D) exportImage.getGraphics(); //Get graphics - Get the layer we can actually draw on
			        
			        imageGraphics.dispose(); //Cleanup after ourselves
			        
			        //Setup to write the BufferedImage to a file
			        String pathToFile = "dir";
			        File outputDirectory = new File(pathToFile);
			        String promptImageFilePath = Config.getImageFilePathForPrompts();
			        File outputFile = new File(promptImageFilePath);

			        //Here we make sure the directory exists.Returns TRUE if: The directory is MISSING and/or the directory IS NOT a directory
			        if(!outputDirectory.exists() || !outputDirectory.isDirectory()){
			        	outputDirectory.mkdirs(); //Make the directory
			        	} //Else do nothing
			        	ImageIO.write(exportImage, "png", outputFile); //Write the file
			        	String _message = "Step:"+(counter++)+
								" FAILED- a modal dialog prompts saying Please Select a Company Type!!!! with Ok button"+ "/nException Details"+
								ex.getLocalizedMessage();
						logger.info(_message);
			        	HTMLReportGenerator.StepDetails("FAIL", "verifyMissingDataModalDialog", _message, promptImageFilePath);
			        	baseclass.driver.switchTo().alert().dismiss();
					}

				}
			
			
			@Then("^a modal dialog prompts saying \"(.*)\" with Ok button for missing Country value selection$")
			public void verifyMissingCountryDialog(String expectedAlertMessage) throws InterruptedException, IOException, AWTException {
				try {
					Thread.sleep(1000);	
					manageCompanyTabObj.saveButton.click();
					Alert missingCountryAlert = baseclass.driver.switchTo().alert();
					String actualAlertMessage = missingCountryAlert.getText(); 
					System.out.println(actualAlertMessage);
					Thread.sleep(1000);
					Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
					
					Robot objRobot = null; 
					objRobot = new Robot();// Creating object of Robot class
			        Dimension screenDim =  Toolkit.getDefaultToolkit().getScreenSize();
			        BufferedImage exportImage =objRobot.createScreenCapture(new Rectangle(0, 0, (int)screenDim.getWidth(), (int)screenDim.getHeight())); //Create the image
			        			        
			        Graphics2D imageGraphics = (Graphics2D) exportImage.getGraphics();//Get graphics - Get the layer we can actually draw on
			        
			        imageGraphics.dispose();//Cleanup after ourselves
			        
			        //Setup to write the BufferedImage to a file
			        String pathToFile = "dir";
			        File outputDirectory = new File(pathToFile);
			        String promptImageFilePath = Config.getImageFilePathForPrompts();
			        File outputFile = new File(promptImageFilePath);

			        //Here we make sure the directory exists.Returns TRUE if: The directory is MISSING and/or the directory IS NOT a directory
			        if(!outputDirectory.exists() || !outputDirectory.isDirectory()){
			        	outputDirectory.mkdirs(); //Make the directory
			        	} // Else do nothing
			        	ImageIO.write(exportImage, "png", outputFile);
			        
			        	String _message = "Step:"+(counter++)+" PASSED- a modal dialog prompts saying Please Select a Country!!!! with Ok button";
						logger.info(_message);
						HTMLReportGenerator.StepDetails("PASS", "verifyMissingDataModalDialog", _message, promptImageFilePath);
						missingCountryAlert.accept();
					}
				catch(AssertionError ex) {
//					Robot objRobot = null; 
					Robot objRobot = new Robot();
					Dimension screenDim =  Toolkit.getDefaultToolkit().getScreenSize();
			        BufferedImage exportImage =objRobot.createScreenCapture(new Rectangle(0, 0, (int)screenDim.getWidth(), (int)screenDim.getHeight())); //Create the image
			        			        
			        Graphics2D imageGraphics = (Graphics2D) exportImage.getGraphics();//Get graphics - Get the layer we can actually draw on
			        
			        imageGraphics.dispose();//Cleanup after ourselves
			        
			        //Setup to write the BufferedImage to a file
			        String pathToFile = "dir";
			        File outputDirectory = new File(pathToFile);
			        String promptImageFilePath = Config.getImageFilePathForPrompts();
			        File outputFile = new File(promptImageFilePath);

			        //Here we make sure the directory exists.Returns TRUE if: The directory is MISSING and/or the directory IS NOT a directory
			        if(!outputDirectory.exists() || !outputDirectory.isDirectory()){
			        	outputDirectory.mkdirs(); //Make the directory
			        	} // Else do nothing
			        	ImageIO.write(exportImage, "png", outputFile);
			        	
			        	String _message = "Step:"+(counter++)+
								" FAILED- a modal dialog prompts saying Please Select a Country!!!! with Ok button\nException Details"+
								ex.getLocalizedMessage();
						logger.info(_message);
						
						HTMLReportGenerator.StepDetails("FAIL", "verifyMissingDataModalDialog", _message, promptImageFilePath);
						baseclass.driver.switchTo().alert().dismiss();
					}
				catch(Exception ex) {
//					Robot objRobot = null; 
					Robot objRobot = new Robot();
					Dimension screenDim =  Toolkit.getDefaultToolkit().getScreenSize();
			        BufferedImage exportImage =objRobot.createScreenCapture(new Rectangle(0, 0, (int)screenDim.getWidth(), (int)screenDim.getHeight())); //Create the image
			        			        
			        Graphics2D imageGraphics = (Graphics2D) exportImage.getGraphics();//Get graphics - Get the layer we can actually draw on
			        
			        imageGraphics.dispose();//Cleanup after ourselves
			        
			        //Setup to write the BufferedImage to a file
			        String pathToFile = "dir";
			        File outputDirectory = new File(pathToFile);
			        String promptImageFilePath = Config.getImageFilePathForPrompts();
			        File outputFile = new File(promptImageFilePath);

			        //Here we make sure the directory exists.Returns TRUE if: The directory is MISSING and/or the directory IS NOT a directory
			        if(!outputDirectory.exists() || !outputDirectory.isDirectory()){
			        	outputDirectory.mkdirs(); //Make the directory
			        	} // Else do nothing
			        	ImageIO.write(exportImage, "png", outputFile);
			        	
			        	String _message = "Step:"+(counter++)+
								" FAILED- a modal dialog prompts saying Please Select a Country!!!! with Ok button\nException Details"+
								ex.getLocalizedMessage();
						logger.info(_message);
						
						HTMLReportGenerator.StepDetails("FAIL", "verifyMissingDataModalDialog", _message, promptImageFilePath);
						baseclass.driver.switchTo().alert().dismiss();
					}
				}
			
			@Then("^a modal dialog prompts saying \"(.*)\" with Ok button for missing State value selection$")
			public void verifyMissingStateDialog(String expectedAlertMessage) throws InterruptedException, IOException, AWTException {
				try {
					Thread.sleep(1000);	
					manageCompanyTabObj.saveButton.click();
					Alert missingStateAlert = baseclass.driver.switchTo().alert();
					String actualAlertMessage = missingStateAlert.getText(); 
					System.out.println(actualAlertMessage);
					Thread.sleep(1000);
					Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
					
					Robot objRobot = null; 
					objRobot = new Robot();// Creating object of Robot class
			        Dimension screenDim =  Toolkit.getDefaultToolkit().getScreenSize();
			        BufferedImage exportImage =objRobot.createScreenCapture(new Rectangle(0, 0, (int)screenDim.getWidth(), (int)screenDim.getHeight())); //Create the image
			        			        
			        Graphics2D imageGraphics = (Graphics2D) exportImage.getGraphics();//Get graphics - Get the layer we can actually draw on
			        
			        imageGraphics.dispose();//Cleanup after ourselves
			        
			        //Setup to write the BufferedImage to a file
			        String pathToFile = "dir";
			        File outputDirectory = new File(pathToFile);
			        String promptImageFilePath = Config.getImageFilePathForPrompts();
			        File outputFile = new File(promptImageFilePath);

			        //Here we make sure the directory exists.Returns TRUE if: The directory is MISSING and/or the directory IS NOT a directory
			        if(!outputDirectory.exists() || !outputDirectory.isDirectory()){
			        	outputDirectory.mkdirs(); //Make the directory
			        	} // Else do nothing
			        	ImageIO.write(exportImage, "png", outputFile);
					
			        	String _message = "Step:"+(counter++)+" PASSED- a modal dialog prompts saying Please Select a State!!!! with Ok button";
						logger.info(_message);
			        	HTMLReportGenerator.StepDetails("PASS", "verifyMissingDataModalDialog", _message, promptImageFilePath);
			        	missingStateAlert.accept();
					}
				catch(AssertionError ex) {
					Robot objRobot = new Robot();// Creating object of Robot class
//					Robot objRobot = null; 
					Dimension screenDim =  Toolkit.getDefaultToolkit().getScreenSize();
			        BufferedImage exportImage =objRobot.createScreenCapture(new Rectangle(0, 0, (int)screenDim.getWidth(), (int)screenDim.getHeight())); //Create the image
			        			        
			        Graphics2D imageGraphics = (Graphics2D) exportImage.getGraphics();//Get graphics - Get the layer we can actually draw on
			        
			        imageGraphics.dispose();//Cleanup after ourselves
			        
			        //Setup to write the BufferedImage to a file
			        String pathToFile = "dir";
			        File outputDirectory = new File(pathToFile);
			        String promptImageFilePath = Config.getImageFilePathForPrompts();
			        File outputFile = new File(promptImageFilePath);

			        //Here we make sure the directory exists.Returns TRUE if: The directory is MISSING and/or the directory IS NOT a directory
			        if(!outputDirectory.exists() || !outputDirectory.isDirectory()){
			        	outputDirectory.mkdirs(); //Make the directory
			        	} // Else do nothing
			        	ImageIO.write(exportImage, "png", outputFile);
			        	
			        	String _message = "Step:"+(counter++)+
								" FAILED- a modal dialog prompts saying Please Select a State!!!! with Ok button\nException Details"+
								ex.getLocalizedMessage();
						logger.info(_message);
						
						HTMLReportGenerator.StepDetails("FAIL", "verifyMissingDataModalDialog", _message, promptImageFilePath);
						baseclass.driver.switchTo().alert().dismiss();
					}
				catch(Exception ex) {
					Robot objRobot = new Robot();// Creating object of Robot class
//					Robot objRobot = null; 
					Dimension screenDim =  Toolkit.getDefaultToolkit().getScreenSize();
			        BufferedImage exportImage =objRobot.createScreenCapture(new Rectangle(0, 0, (int)screenDim.getWidth(), (int)screenDim.getHeight())); //Create the image
			        			        
			        Graphics2D imageGraphics = (Graphics2D) exportImage.getGraphics();//Get graphics - Get the layer we can actually draw on
			        
			        imageGraphics.dispose();//Cleanup after ourselves
			        
			        //Setup to write the BufferedImage to a file
			        String pathToFile = "dir";
			        File outputDirectory = new File(pathToFile);
			        String promptImageFilePath = Config.getImageFilePathForPrompts();
			        File outputFile = new File(promptImageFilePath);

			        //Here we make sure the directory exists.Returns TRUE if: The directory is MISSING and/or the directory IS NOT a directory
			        if(!outputDirectory.exists() || !outputDirectory.isDirectory()){
			        	outputDirectory.mkdirs(); //Make the directory
			        	} // Else do nothing
			        	ImageIO.write(exportImage, "png", outputFile);
			        	
			        	String _message = "Step:"+(counter++)+
								" FAILED- a modal dialog prompts saying Please Select a State!!!! with Ok button\nException Details"+
								ex.getLocalizedMessage();
						logger.info(_message);
						
						HTMLReportGenerator.StepDetails("FAIL", "verifyMissingDataModalDialog", _message, promptImageFilePath);
						baseclass.driver.switchTo().alert().dismiss();
					}
				}
			
			@Then ("^system shows a tooltip saying \"(.*)\"$")
			public void verifyIncompleteCompanyNameTooltipMessage(String _companyNameInvalidToolTipExpectedMessage) throws InterruptedException, IOException {
				try {
					Thread.sleep(2000);
					String companyNameInvalidtoolTipActualMessage = manageCompanyTabObj.invalidCompanyNameToolTip.getText();
					Assert.assertEquals(_companyNameInvalidToolTipExpectedMessage, companyNameInvalidtoolTipActualMessage);
					String _message = "Step:"+(counter++)+" PASSED- system shows a tooltip saying, 'Please enter a value between 3 and 20'";
					logger.info(_message);
					HTMLReportGenerator.StepDetails("PASS", "verifyIncompleteCompanyNameTooltipMessage", 
							"system shows a tooltip saying, 'Please enter a value between 3 and 20'",
							TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				}
				catch(Exception ex) {
					String _message = "Step:"+(counter++)+
							" FAILED - system shows a tooltip saying, 'Please enter a value between 3 and 20'/nException Details"
							+ex.getLocalizedMessage();
					logger.info(_message);
					HTMLReportGenerator.StepDetails("FAIL", "verifyIncompleteCompanyNameTooltipMessage", 
							"system shows a tooltip saying, 'Please enter a value between 3 and 20'",
							TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				}
				
			}
			
			@And ("^user selects a company named \"(.*)\"$") 
			public void selectCompanyNameFromTheList(String selectedCompanyName) throws IOException {
				try {
					Thread.sleep(1000);
					baseclass.driver.switchTo().frame("actionid");
					WebElement companyName = baseclass.driver.findElement(By.xpath(".//div[@class='datagrid-cell datagrid-cell-c1-name'][text()='"+selectedCompanyName+"']"));
					companyName.click();
					
					String _message = "Step:"+(counter++)+" PASSED- user selects a company named "+selectedCompanyName;
					logger.info(_message);
					HTMLReportGenerator.StepDetails("PASS", "selectCompanyNameFromTheList", 
							"user selects a company named "+selectedCompanyName, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				} catch (InterruptedException ex) {
					String _message = "Step:"+(counter++)+" FAILED - user selects a company named "+selectedCompanyName+"/nException Details: "+ex.getLocalizedMessage();
					logger.info(_message);
					HTMLReportGenerator.StepDetails("FAIL", "selectCompanyNameFromTheList",_message, 
							TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));					
				}
			}
			
			@And ("^user clicks on Destroy button$")
			public void clickOnDestroyButton() throws InterruptedException, IOException {
				try {
				Thread.sleep(1000);
//				baseclass.driver.switchTo().frame("actionid");
				manageCompanyTabObj = new managecompanytab(baseclass.driver); 
				manageCompanyTabObj.destroyCompanyButton1.click();
				
				String _message = "Step:"+(counter++)+" PASSED- user clicks on Destroy Button";
				logger.info(_message);
				HTMLReportGenerator.StepDetails("PASS", "clickOnDestroyButton", 
						_message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				}
				catch(Exception ex) {
					String _message = "Step:"+(counter++)+" FAILED- user clicks on Destroy Button";
					logger.info(_message);
					HTMLReportGenerator.StepDetails("FAIL", "clickOnDestroyButton",_message+"/nException Details: "
							+ex.getLocalizedMessage(), TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				}
			}
			
			@And ("^user clicks Ok on Confirm popup$")
			public void clickOnOkButtonOnDestroyCompanyConfirmPopUp() throws InterruptedException, IOException {
				try {
				Thread.sleep(1000);
//				Alert DestroyCompanyConfirmPopup = baseclass.driver.switchTo().alert();
				manageCompanyTabObj.okButtonOnConfirmDestroyCompanyPopUp.click();
				
				String _message = "Step:"+(counter++)+" PASSED- user clicks on Ok on Confirm popup";
				logger.info(_message);
				HTMLReportGenerator.StepDetails("PASS", "clickOnOkButtonOnDestroyCompanyConfirmPopUp", 
						_message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				
				}
				catch(Exception ex) {
					String _message = "Step:"+(counter++)+" FAILED - user clicks on Ok on Confirm popup/nException Details: "+ex.getLocalizedMessage();
					logger.info(_message);
					HTMLReportGenerator.StepDetails("FAIL", "clickOnOkButtonOnDestroyCompanyConfirmPopUp", 
							_message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
					}
				
			}
			
			@Then ("^selected company gets deleted from the Manage Company tab with a message saying \"(.*)\"$")
			public void verifyCompanyDeleted(String expectedCompanyDeletionMessage) throws InterruptedException, IOException {
				try {
				Thread.sleep(1000);//added a comment
				String actualCompanyDeletionMessage = manageCompanyTabObj.companyDeletedResult.getText();
				Assert.assertEquals(expectedCompanyDeletionMessage, actualCompanyDeletionMessage);
				
				String _message = "Step:"+(counter++)+" PASSED- selected company gets deleted from the Manage Company tab";
				logger.info(_message);
				HTMLReportGenerator.StepDetails("PASS", "verifyCompanyDeleted", 
						_message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				}
				catch(AssertionError ex) {
					String _message = "Step:"+(counter++)+" FAILED- selected company gets deleted from the Manage Company tab/nException Details: "+ex.getLocalizedMessage();
					logger.info(_message);
					HTMLReportGenerator.StepDetails("FAIL", "verifyCompanyDeleted", 
							_message, TakeScreenShot.TakeScreenShot(Config.getImageFilePath(), baseclass.driver));
				}
				
			}
			
			@Before()
			public void BeforeEveryScenario(Scenario scenario)
			{
				counter = 1;
				System.out.println("new scenario is started "+scenario.getName());
			}
			
			@After()
			public void AfterEveryScenario(Scenario scenario) {
				counter = 0;
				baseclass.driver.close();
			}
}
