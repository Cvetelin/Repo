package web.test.login;

import static org.junit.Assert.assertTrue;




import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import reporting.test.FireFoxRule;
import web.test.suites.SanityTestSuite;
import web.test.suites.SmokeTestSuite;


public class LoginTest{
	private static WebDriver driver ;
	
	@Before
	public void setUp() throws Exception{
		driver = new FirefoxDriver();
	}
	@Test
	@Category({SmokeTestSuite.class,SanityTestSuite.class}) 
	public void aSuccesfullLoginOfAdminIsPerformed() throws Exception {	
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.xpath("//a[@href='/reporting/reports']")).size() == 1);
		assertTrue(driver.findElements(By.xpath("//a[@href='/reporting/projects/filter']")).size() == 1);
		assertTrue(driver.findElements(By.xpath("//a[@href='/reporting/reports/monthly']")).size() == 1);
		assertTrue(driver.findElements(By.xpath("//a[@href='/reporting/reports/npetkov']")).size() == 1);
		assertTrue(driver.findElements(By.xpath("//a[@href='/reporting/calendar']")).size() == 1);
		assertTrue(driver.findElements(By.id("datepicker")).size() == 1);
	}
	@Test
	@Category({SmokeTestSuite.class,SanityTestSuite.class}) 
	public void adminNavigatesToMonthReports() throws InterruptedException{
		driver.findElement(By.xpath("//a[@href='/reporting/reports/monthly']")).click();
		Thread.sleep(1000);
		assertTrue(driver.findElements(By.id("datepicker")).size() == 1);
	}
	@After
	public void after(){
	}
}
