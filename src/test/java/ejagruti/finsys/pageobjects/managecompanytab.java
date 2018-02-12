package ejagruti.finsys.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class managecompanytab {	
	WebDriver localdriverobject1;

	private WebDriver localdriverobject;
	
	public managecompanytab(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.localdriverobject=driver;
		System.out.println("INSIDE CONSTRUCTOR$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}
	
	@FindBy(how=How.XPATH, using="//span[text()='Manage Company']")
	public WebElement manageCompanyTab;
	
	@FindBy(how=How.XPATH, using=".//*[@class='l-btn-icon icon-add']")
	public WebElement newCompanyButton;
	
	@FindBy(how=How.XPATH, using=".//*[@class='l-btn-icon icon-remove']")
	public WebElement destroyCompanyButton;
	
	@FindBy(how=How.XPATH, using=".//*[@class='l-btn-text'] [text()='Destroy']")
	public WebElement destroyCompanyButton1;
	
	@FindBy(how=How.XPATH, using=".//input[@name='name']")
	public WebElement companyName;
	
	@FindBy(how=How.XPATH, using=".//select[@id='companytype']")
	public WebElement companyType;
	
	@FindBy(how=How.XPATH, using="//input[@name='subtype']")
	public WebElement companySubType;
	
	@FindBy(how=How.XPATH,using="//textarea[@class='textbox-text validatebox-text textbox-prompt']")
	public WebElement address;
	
	@FindBy(how=How.XPATH,using="//input[@name='phone']/preceding-sibling::input")
	public WebElement phone;
	
	@FindBy(how=How.XPATH, using=".//input[@name='email']")
	public WebElement email;
	
	@FindBy(how=How.XPATH, using=".//input[@name='pan']")
	public WebElement panDetails;
	
	@FindBy(how=How.XPATH, using=".//input[@name='tin']")
	public WebElement tinDetails;
	
	@FindBy(how=How.XPATH, using="//input[@name='mobile']/preceding-sibling::input")
	public WebElement mobile;
	
	@FindBy(how=How.XPATH, using=".//input[@name='website']")
	public WebElement webSite;
	
	@FindBy(how=How.XPATH, using=".//select[@id='countryid']")
	public WebElement countryid;
	
	@FindBy(how=How.XPATH, using=".//select[@id='stateidlist']")
	public WebElement state;
	
	@FindBy(how=How.XPATH, using=".//select[@id='citylist']")
	public WebElement cityName;
	
	@FindBy(how=How.XPATH, using="//input[@name='totalemployee']/preceding-sibling::input")
	public WebElement totalEmployee;
	
	@FindBy(how=How.XPATH, using="//span[text()='Save']")
	public WebElement saveButton;
	
	@FindBy(how=How.XPATH, using="//span[text()='Cancel']")
	public WebElement cancelButton;
	
	@FindBy(how=How.XPATH, using="//tr[@id='datagrid-row-r1-2-0']/td/div[@class='datagrid-cell datagrid-cell-c1-name']")
	public WebElement newCompanyTopRow;
	
	public WebElement alert;
	
	@FindBy(how=How.XPATH, using="//div[text()='Please enter a value between 3 and 20.']")
	public WebElement invalidCompanyNameToolTip;
	
	@FindBy(how=How.XPATH, using=".//div[@id='result']/h1")
	public WebElement companyDeletedResult;
	
	@FindBy(how=How.XPATH, using="//span[text()='Ok']")
	public WebElement okButtonOnConfirmDestroyCompanyPopUp; 
}