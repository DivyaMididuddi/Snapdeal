package com.snapdeal.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "F:\\CapAutomationSelenium\\SnapDeal\\src\\test\\java\\com\\snapdeal\\features\\order.feature",

					glue = "com.snapdeal.stepdefinition",

					dryRun = false, monochrome = true,

					tags = { "@Order" })

public class OrderRunner extends AbstractTestNGCucumberTests {

}
