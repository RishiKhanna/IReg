package org.testng.pages;

import org.testng.actions.BrowserActions;
import org.testng.actions.Verifications;
import org.testng.utilities.Utilities;

public class PageBase {
	
	BrowserActions action=new BrowserActions();
	Utilities util=new Utilities();
	Verifications verify=new Verifications();
	
	public PageBase closeBrowser(){
		action.closeBrowser();
		return this;	
	}
	
	public PageBase openBrowser(){
		action.openURL();
		return this;
	}
}
