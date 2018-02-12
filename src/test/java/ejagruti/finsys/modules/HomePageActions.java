package ejagruti.finsys.modules;

import cucumber.api.java.en.And;
import ejagruti.finsys.pageobjects.baseclass;
import ejagruti.finsys.pageobjects.homepage;
import ejagruti.finsys.pageobjects.loginpage;
import ejagruti.finsys.pageobjects.managecompanytab;

public class HomePageActions {
	//--------------Operations---------
	loginpage loginpageobj=null;
	homepage homepageobj=null;
	managecompanytab managecompanytabobj=null;
	
	@And ("user opens West Pane tab on home page if not already open$")
	public void openWestPanel() throws InterruptedException {
		homepage homepageobj = new homepage(baseclass.driver);
		boolean westPaneDisplayed = homepageobj.finAnalysisPanel.isDisplayed();
		Thread.sleep(4000);
		if(westPaneDisplayed==true) {
			System.out.println("West Pane is expanded already");
		}
		else {
			homepageobj.westPanelOpenChevron.click();
		}
	}
	
	
	@And ("^user expands Financial Analysis tab if not already expanded$")
	public void expandFinAnalysisPane() throws InterruptedException {
		Thread.sleep(4000);
		homepage homepageobj = new homepage(baseclass.driver);
		boolean _finAnalPanelExpanded = homepageobj.finAnalysisPanel.isDisplayed();
		boolean _finAnaPanelCollpaseChevron = homepageobj.finAnaPaneCollapseChevron.isDisplayed();
		if(_finAnalPanelExpanded==true && _finAnaPanelCollpaseChevron==true) {
			Thread.sleep(1000);
			System.out.println("Financial Analysis Panel already expanded!");
		}
		
		else {
			Thread.sleep(1000);
			homepageobj.finAnaPaneExpandChevron.click();
		}
	}
}
