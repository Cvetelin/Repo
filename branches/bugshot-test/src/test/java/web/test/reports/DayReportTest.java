package web.test.reports;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import reporting.test.FireFoxRule;
import reporting.test.jdbc.ScreenUtils;
import web.test.suites.SanityTestSuite;
import web.test.suites.SmokeTestSuite;

public class DayReportTest {

	private static WebDriver driver ;
	@Rule
	public FireFoxRule firefoxRule = new FireFoxRule();
	@Before
	public void setUp() throws Exception{
		driver = firefoxRule.getDriver();
	}
	@Test
	@Category({SmokeTestSuite.class,SanityTestSuite.class}) 
	public void aDayReportForTodayIsAddedMantisTracker() throws InterruptedException{
		driver.findElement(By.xpath("//a[@href='/reporting/reports/npetkov']")).click();
		driver.findElement(By.id("datepicker")).clear();
		driver.findElement(By.id("datepicker")).sendKeys(ScreenUtils.formatDate(new Date()));
		driver.findElement(By.id("issueCode")).sendKeys("170");
		driver.findElement(By.id("hours")).sendKeys("2");
		driver.findElement(By.id("add")).click();
		Thread.sleep(2000);
		assertTrue(driver.findElements(By.xpath("//a[contains(text(),'170: [Lot 1] Technical conception')]")).size()>0);
		driver.findElement(By.xpath("//td/a[contains(text(),'170: [Lot 1] Technical conception')]/parent::td/following-sibling::td/a")).click();
		driver.switchTo().alert().accept();
	}
	@Test
	@Category({SmokeTestSuite.class,SanityTestSuite.class}) 
	public void aDayReportForTodayIsAddedJiraTracker() throws InterruptedException{
		driver.findElement(By.xpath("//a[@href='/reporting/reports/npetkov']")).click();
		driver.findElement(By.id("datepicker")).clear();
		driver.findElement(By.id("datepicker")).sendKeys(ScreenUtils.formatDate(new Date()));
		driver.findElement(By.id("issueTrackerId")).sendKeys("Jira Tracker");
		driver.findElement(By.id("issueCode")).sendKeys("DEMO-2869");
		driver.findElement(By.id("hours")).sendKeys("2");
		driver.findElement(By.id("add")).click();
		Thread.sleep(2000);
		assertTrue(driver.findElements(By.xpath("//a[contains(text(),'DEMO-2869: Prueba')]")).size()>0);
		driver.findElement(By.xpath("//td/a[contains(text(),'DEMO-2869: Prueba')]/parent::td/following-sibling::td/a")).click();
		driver.switchTo().alert().accept();
	}
	@Test
	@Category({SmokeTestSuite.class,SanityTestSuite.class}) 
	public void aDayReportForTodayIsAddedBoursoTracker() throws InterruptedException{
		driver.findElement(By.xpath("//a[@href='/reporting/reports/npetkov']")).click();
		driver.findElement(By.id("datepicker")).clear();
		driver.findElement(By.id("datepicker")).sendKeys(ScreenUtils.formatDate(new Date()));
		driver.findElement(By.id("issueTrackerId")).sendKeys("Bourso Mantis");
		driver.findElement(By.id("issueCode")).sendKeys("20492");
		driver.findElement(By.id("hours")).sendKeys("2");
		driver.findElement(By.id("add")).click();
		Thread.sleep(2000);
		assertTrue(driver.findElements(By.xpath("//a[contains(text(),'20492: Waiting for synchronization')]")).size()>0);
		driver.findElement(By.xpath("//td/a[contains(text(),'20492: Waiting for synchronization')]/parent::td/following-sibling::td/a")).click();
		driver.switchTo().alert().accept();
	}
}
