package com.visio.it.automation.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class ProductDescreption {

	private static final Logger logger=LogManager.getLogger(ProductDescreption.class);
    private WebDriver driver;
    
    private By product_title=By.id("productTitle");
    private By add_to_cart_button=By.id("add_to_cart_button");
    
    public ProductDescreption(WebDriver driver)
    {
    	this.driver=driver;
    }
    
    public void validateProductTitlecorrectlyDisplay()
    {
    	if(driver.findElement(product_title).isDisplayed())
    	{
    		
    		Assert.assertTrue(true);
    		logger.info("product title is display");}
    		else
    		{
    			logger.fatal("product title is not display");
    			Assert.fail("product title is not display");
    			
    		}}
    		
    	
    
    
    public void validateAddToCartButtonIsCorrectlyDispaly()
    {
    	if(driver.findElement(add_to_cart_button).isDisplayed())
    			{
    		Assert.assertTrue(true);
    		logger.info("Add to cart button is display");
    			}
    	else
    	{
    		logger.fatal("Add to cart button is display");
    		Assert.fail("Add to cart button is display");
    		
    		
    	
	
    	}}}
