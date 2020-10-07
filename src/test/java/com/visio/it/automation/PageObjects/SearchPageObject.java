package com.visio.it.automation.PageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import junit.framework.Assert;

public class SearchPageObject {

	
private static final Logger logger=LogManager.getLogger(SearchPageObject.class);
	
	
	private WebDriver driver;
	
    private By search_refinement_categories_segment  = By.id("s-refinements");
     private By product_link_list = By.xpath("//a[@class='a-link-normal a-text-normal']");

     
     public SearchPageObject(WebDriver driver)
     {
    	 
    	 this.driver=driver;
     }
     public void ValidateProductSearchIsSuccessfull()
     {
    	if(driver.findElement(search_refinement_categories_segment).isDisplayed())
    	{
    		
    		Assert.assertTrue(true);
    		logger.info("search page is display because refinment category is disply");
    	}
    	 
    	else
    	{
    		logger.fatal("search page is not display because refinment category is not disply");
    		Assert.fail("search page is not display because refinment category is not disply");
    		
        }}
    	
    	public String ClickOnTheProductLink(int productIndex)
    	{
    		
    		List<WebElement> listOfProduct=driver.findElements(product_link_list);
    		  logger.info("Number of products searched: " + listOfProduct.size());

    	       
    	        listOfProduct.get(productIndex).click();
    	        logger.info("Clicked on the Link in the List with index: " + productIndex +
    	                ". Link Text: " + listOfProduct.get(productIndex).getText());
				return listOfProduct.get(productIndex).getText();

    		
    		
    		
    	}
    	
     
     
     
}

	

