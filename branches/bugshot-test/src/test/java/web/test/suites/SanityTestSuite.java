package web.test.suites;

import junit.framework.TestSuite;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import web.test.login.LoginTest;
import web.test.month.reports.CategorizeNonProjectIssueTest;
import web.test.project.ProjectCreationTest;
import web.test.project.SearchProjectTest;
import web.test.reports.DayReportTest;
@RunWith(Categories.class)  
@IncludeCategory(SanityTestSuite.class)   
@SuiteClasses({ 
	LoginTest.class,
	DayReportTest.class,
	ProjectCreationTest.class,
	SearchProjectTest.class,
	CategorizeNonProjectIssueTest.class})  
public class SanityTestSuite extends TestSuite {

}
