package com.visionit.automation.stepdefs;

import java.util.Iterator;


import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.visio.it.automation.PageObjects.CmnPgeObject;
import com.visio.it.automation.PageObjects.HomePageObject;
import com.visio.it.automation.PageObjects.ProductDescreption;
import com.visio.it.automation.PageObjects.SearchPageObject;
import com.visio.it.automation.PageObjects.SignInPageObjects;

import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs {
	private static  final  Logger logger= LogManager.getLogger(StepDefs.class);
	WebDriver  driver;
	String base_Url="http://amazon.com";
	int implicit_wait_timeunit_sec=20;
       Scenario scn;
       CmnPgeObject cmnPageObject;
       HomePageObject homePageObjects;
      SearchPageObject  searchPageObjects;
       ProductDescreption productDescreptionPageObjects;
      
          
	@Before
	
		public void setUp(Scenario scn) throws Exception  {
	
		this.scn=scn;
			driver=new ChromeDriver();
		
		
		
			logger.info("Browser invoked");
			
			cmnPageObject =new CmnPgeObject(driver);
			homePageObjects=new HomePageObject(driver);
			searchPageObjects=new SearchPageObject(driver);
			productDescreptionPageObjects=new ProductDescreption(driver);
			
		}
		
	@After
	public void CleanUp()
	{
		
		driver.quit();
		scn.write("browser closed");
	
		}

		@Given("User navigate to the home appliction url")
		public void user_navigate_to_the_home_appliction_url() {
		   driver.get("base_Url");
		   scn.log("Browser navigated to URL: " + base_Url);
			String expected="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	        cmnPageObject.validatePageTitleMatch(expected);

       }

		@When("user search for  product {string}")
		public void user_search_for_product(String productName) { 
			cmnPageObject.SetSearchTextBox(productName);
			cmnPageObject.ClickOnSearchButton();
			scn.log("Product Searched: " + productName);
		    }
		

		@Then("Search result page is display") 
		public void search_result_page_is_display() {
			searchPageObjects.ValidateProductSearchIsSuccessfull();
		}

		@When("User click on any product")
		public void user_click_on_any_product() {
			
			searchPageObjects.ClickOnTheProductLink(0);
			
		}

		@Then("product Descreption is displayed in new tab")
		public void product_Descreption_is_displayed_in_new_tab() {

			Set<String> handles=driver.getWindowHandles();
	        scn.log("list of windows found: " +handles.size());
	        scn.log("window handle: " + handles.toString());

			Iterator<String> it=handles.iterator();
			String original=it.next();
			String proddesp=it.next();
			driver.switchTo().window(proddesp);
	        scn.log("Switched to the new window/tab");

	        productDescreptionPageObjects.validateProductTitlecorrectlyDisplay();
	        productDescreptionPageObjects.validateAddToCartButtonIsCorrectlyDispaly();
			driver.switchTo().window(original);
			scn.log("Switch BACK TO THE ORIGINAL TAB");
			
		}}
