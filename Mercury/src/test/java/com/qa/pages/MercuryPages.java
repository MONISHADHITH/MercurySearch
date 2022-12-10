package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercuryPages
{
  WebDriver driver;
  
  @FindBy(name="userName")
  WebElement username;
  public WebElement getUserName()
  {
	  return username;
  }
  
  @FindBy(name="password")
  WebElement password;
  public WebElement getPassword()
  {
	  return password;
  }
   @FindBy(name="submit")
   WebElement submit;
   public WebElement getSubmit()
   {
	   return submit;
   }
   
   //Constructor, as every page needs a Webdriver to find elements
  	public MercuryPages(WebDriver driver)
  	{
  		this.driver=driver;
  		PageFactory.initElements(driver,this);
  	}
  
}
