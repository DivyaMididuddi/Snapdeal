package com.snapdeal.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "F:\\CapAutomationSelenium\\SnapDeal\\src\\test\\java\\com\\snapdeal\\features\\MoveToShortlist.feature",

		glue = "com.snapdeal.stepdefinition",

		dryRun = false, monochrome = true,

		tags = { "@MoveToShortList" })
		
public class MoveToShortListRunner  extends AbstractTestNGCucumberTests{

}
