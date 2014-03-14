package web.test.reports;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import reporting.test.FireFoxRule;

public class AddReportToInactiveProjectTest {
	private static WebDriver driver ;
	@Rule
	public FireFoxRule firefoxRule = new FireFoxRule();
	@Before
	public void setUp() throws Exception{
		driver = firefoxRule.getDriver();
		driver.findElement(By.xpath("//a[@href='/reporting/reports/npetkov']")).click();
	}

	
	@Test
	public void addReportToInactiveProject() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("datePickSelect")).sendKeys("Single");
		driver.findElement(By.id("issueCode")).sendKeys("285");
		driver.findElement(By.id("issueTrackerId")).sendKeys("MantisTracker");
		driver.findElement(By.id("hours")).sendKeys("1");
		driver.findElement(By.id("add")).click();
		Thread.sleep(2000L);
		assertTrue(driver.findElements(By.id("myReportsForm.errors")).size() ==1);
		Thread.sleep(1000);
		
		assertTrue(driver.getPageSource().contains("Issue 285 is linked to the inactive project"));
		System.out.print("Issue 285 is linked to the inactive project found on the page");

		
	}





	}

