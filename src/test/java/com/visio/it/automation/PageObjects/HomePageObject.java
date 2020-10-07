package com.visio.it.automation.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class HomePageObject {

private static final Logger logger=LogManager.getLogger(HomePageObject.class);
	
	private WebDriver driver;
	private By  link_sign_in_securaly=By.linkText("sign in securaly");
	public HomePageObject(WebDriver driver )
	{
		this.driver=driver;
	}
	
	public void clickLinkSignInSecurely()
	
	{
		driver.findElement(link_sign_in_securaly).click();
		logger.info("click link:link_sign_in_securaly");
		
	}
}
