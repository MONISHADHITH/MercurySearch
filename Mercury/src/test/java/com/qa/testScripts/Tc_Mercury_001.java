package com.qa.testScripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.MercuryPages;

public class Tc_Mercury_001 extends Testbase {
	
	
	MercuryPages mercurypage;
	@Parameters({"browser","url"})
	@Test
	public void login(String browser,String Url)
	{
		mercurypage=new MercuryPages(driver);
		mercurypage.getUserName().sendKeys(Name);
		mercurypage.getPassword().sendKeys(password);
		mercurypage.getSubmit().click();
	}
	
    
}