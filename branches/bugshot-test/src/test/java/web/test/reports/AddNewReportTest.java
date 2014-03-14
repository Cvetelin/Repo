package web.test.reports;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import reporting.test.FireFoxRule;

public class AddNewReportTest {
	private static WebDriver driver ;
	@Rule
	public FireFoxRule firefoxRule = new FireFoxRule();
	@Before
	public void setUp() throws Exception{
		driver = firefoxRule.getDriver();
		driver.findElement(By.xpath("//a[@href='/reporting/reports/npetkov']")).click();
	}

	@Test
	public void testAddReportForToday() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("datePickSelect")).sendKeys("Single");
		driver.findElement(By.id("issueCode")).sendKeys("269");
		driver.findElement(By.id("issueTrackerId")).sendKeys("MantisTracker");
		driver.findElement(By.id("hours")).sendKeys("1");
		driver.findElement(By.id("add")).click();
		Thread.sleep(2000L);
		assertTrue(driver.findElements(By.xpath("//a[contains(text(),'269: Add report to active project  test case')]")).size() >0);
		driver.findElement(By.xpath("//a[contains(text(),'Delete')][1]")).click();
		Thread.sleep(2000L);
		Alert javascriptAlert = driver.switchTo().alert();
		javascriptAlert.accept();
		
	}
	
}
