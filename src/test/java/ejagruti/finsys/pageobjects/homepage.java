package ejagruti.finsys.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class homepage {
	WebDriver localdriverobject;
	
	public homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.localdriverobject=driver;
		System.out.println("INSIDE CONSTRUCTOR$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Welcome')]")
	public WebElement welcomeMessage;
	
	@FindBy(how=How.XPATH, using="//a[.='LOGOUT']")
	public WebElement logout;
	
	@FindBy(how=How.XPATH, using="//a[@class='layout-button-left']")
	public WebElement leftLayoutChevron;
	
	@FindBy(how=How.XPATH, using="//div[contains(text(),'Financial Analysis')]")
	public WebElement finAnalysisPanel;
		
	@FindBy(how=How.XPATH, using="//div[contains(text(),'Financial Analysis')]/following-sibling::div/a[@class='accordion-collapse accordion-expand']")
	public WebElement finAnaPaneExpandChevron;
	
	@FindBy(how=How.XPATH, using="//div[contains(text(),'Title3')]/following-sibling::div/a[@class='accordion-collapse accordion-expand']")
	public WebElement titlePaneExpandChevron;
	
	@FindBy(how=How.XPATH, using="//a[@class='accordion-collapse']")
	public WebElement finAnaPaneCollapseChevron;
	
	@FindBy(how=How.XPATH, using="//div[@class='panel layout-expand layout-expand-west']/div/div[@class='panel-tool']/a[@class='layout-button-right']")
	public WebElement westPanelOpenChevron;
	
	@FindBy(how=How.XPATH, using="//div[contains(text(),'West')]/following-sibling::div[@class='panel-tool']/a[@class='layout-button-left']")
	public WebElement westPanelCloseChevron;
	
	@FindBy(how=How.XPATH, using="//a[@title='Manage Company']")
	public WebElement manageCompanyLink;
			
}
