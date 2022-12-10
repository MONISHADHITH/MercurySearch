package com.qa.testScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.qa.pages.MercuryPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	MercuryPages mercury;
	WebDriver driver;
	FileInputStream stream;
	Properties prop;
	String Name;
	String password;
	String location ="C:\\Users\\monis\\eclipse-workspace\\Mercury\\src\\test\\java\\com\\qa\\testData\\Credentials.Properties";
    @Parameters({"browser","url"})
    @BeforeClass
    public void setUp(String browser,String url)throws IOException
    {
    	 stream = new FileInputStream(location);
    	 prop = new Properties();
    	 prop.load(stream);
    	 Name=prop.getProperty("username");
    	 password = prop.getProperty("password");
   	 if(browser.equalsIgnoreCase("chrome"))
   	 {
   		 WebDriverManager.chromedriver().setup();
   		 driver=new ChromeDriver();
   		 
   	 }
   	 else if(browser.equalsIgnoreCase("firefox"))
   	 {
   	       WebDriverManager.firefoxdriver().setup();
   	         driver = new FirefoxDriver();
   	 }
   	 else if(browser.equalsIgnoreCase("edge"))
   	 {
   		 WebDriverManager.edgedriver().setup();
   		 driver= new EdgeDriver();
   	 }
    	mercury=new MercuryPages(driver);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.get(url);
   	 
    }
    
    @AfterClass
    public void tearDown()
    {
   	 driver.manage().deleteAllCookies();
   	 driver.close();
    }


}