package web.test.project;

import static org.junit.Assert.*;

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

public class ProjectCreationTest {
	private final String ISSUE_NUMBER = ScreenUtils.generateRandomDigit();
	private final String ISSUE_NAME = "Project" +ISSUE_NUMBER;
	private final String ISSUE_CODE = "PR" + ISSUE_NUMBER;
	private static WebDriver driver ;
	@Rule
	public FireFoxRule firefoxRule = new FireFoxRule();
	@Before
	public void setUp() throws Exception{
		driver = firefoxRule.getDriver();
	}
	@Test
	@Category({SmokeTestSuite.class,SanityTestSuite.class}) 
	public void anAdminCreatesNewProject() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='/reporting/projects/filter']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@href='/reporting/projects/new']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("name")).sendKeys(ISSUE_NAME);
		driver.findElement(By.id("code")).sendKeys(ISSUE_CODE);
		driver.findElement(By.id("issueCode")).sendKeys(ISSUE_NUMBER);
		driver.findElement(By.id("issueTrackerId")).sendKeys("bourso-mantis");
		driver.findElement(By.id("manager")).sendKeys("npetkov");
		driver.findElement(By.id("businessAnalist")).sendKeys("Brice Galand");
		driver.findElement(By.id("application")).sendKeys("CRM-FR");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.xpath("//td[contains(text(),'" + ISSUE_CODE + "')]")).size() == 1) ;
		assertTrue(driver.findElements(By.xpath("//td[contains(text(),'" + ISSUE_NAME + "')]")).size() == 1) ;
		
		
	}
	
	
	
}
