package com.visionit.automation.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:features",
        glue="com.visionit.automation.stepdefs", 
        tags="",
        plugin = {"pretty",
                  "html:target/html/htmlreport.html",
                  "json:target/json/file.json"
                 },
        //publish=true,
        dryRun=false 
        )

	

public class TestRunners {

}
