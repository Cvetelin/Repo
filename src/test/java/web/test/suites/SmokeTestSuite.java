package web.test.suites;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import web.test.login.LoginTest;
import web.test.reports.DayReportTest;

@RunWith(Categories.class)  
@IncludeCategory(SmokeTestSuite.class)
@SuiteClasses({ 
	LoginTest.class,
	DayReportTest.class})  
public class SmokeTestSuite {

}
