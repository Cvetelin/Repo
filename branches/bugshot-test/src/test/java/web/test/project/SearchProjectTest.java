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

public class SearchProjectTest {
	private static WebDriver driver ;
	@Rule
	public FireFoxRule firefoxRule = new FireFoxRule();
	@Before
	public void setUp() throws Exception{
		driver = firefoxRule.getDriver();
	}

	@Test
	@Category({SmokeTestSuite.class,SanityTestSuite.class}) 
	public void aSearchForExistingProjectIsPerformed() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='/reporting/projects/filter']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("search")).sendKeys("FATCA alerts");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[contains(text(),'FATCA')]")).click();
		Thread.sleep(1000);
		assertEquals(1,driver.findElements(By.xpath("//a[contains(text(),'19533: [FATCA] FATCA...')]")).size());
		assertEquals("Nikolay Petkov", ScreenUtils.readLabelField(driver,"Manager"));
		assertEquals("Frédéric Constant", ScreenUtils.readLabelField(driver,"Business Analyst"));
		assertEquals("", ScreenUtils.readLabelField(driver,"Application"));
		assertEquals("14", ScreenUtils.readLabelField(driver,"Resolved issues"));
		assertEquals("56 (118.88%)", ScreenUtils.readLabelField(driver,"Consumed days"));
		assertEquals("-9", ScreenUtils.readLabelField(driver,"Est. days to finish"));
		assertEquals("-9", ScreenUtils.readLabelField(driver,"Budget days left"));
		assertEquals("0.0", ScreenUtils.readLabelField(driver,"Delay"));
		assertEquals("118.88%", ScreenUtils.readLabelField(driver,"Progress"));
		assertEquals("17/01/2014 13:40", ScreenUtils.readLabelField(driver,"Calculated on"));
		assertEquals("02/01/2014", ScreenUtils.readLabelField(driver,"Delivery", 2));
		assertEquals("15/01/2014", ScreenUtils.readLabelField(driver,"Delivery VAL",2));
		assertEquals("29/01/2014", ScreenUtils.readLabelField(driver,"Delivery PROD",2));
		assertEquals("19.0", ScreenUtils.readLabelField(driver,"Java"));
		assertEquals("8.0", ScreenUtils.readLabelField(driver,"PL/SQL"));
		assertEquals("5.0", ScreenUtils.readLabelField(driver,"Design"));
		assertEquals("8.0", ScreenUtils.readLabelField(driver,"Test"));
		assertEquals("7.0", ScreenUtils.readLabelField(driver,"Management"));
		assertEquals("47.0", ScreenUtils.readLabelField(driver,"Total before UAT"));
		assertEquals("5.0", ScreenUtils.readLabelField(driver,"UAT"));
		assertEquals("0.0", ScreenUtils.readLabelField(driver,"Other"));
		assertEquals("52.0", ScreenUtils.readLabelField(driver,"Total"));
		assertEquals("25.25", ScreenUtils.readField(driver,"Stanimir Todorov"));
		assertEquals("10.50", ScreenUtils.readField(driver,"Marie Nigohossian"));
		assertEquals("8.25", ScreenUtils.readField(driver,"Nikolay Petkov"));
		assertEquals("6.38", ScreenUtils.readField(driver,"Nonka Hristova"));
		assertEquals("3.00", ScreenUtils.readField(driver,"Kiril Atanasov"));
		assertEquals("2.50", ScreenUtils.readField(driver,"Stanislav Slavkov"));
	}
	@Test
	@Category({SmokeTestSuite.class,SanityTestSuite.class}) 
	public void aSearchByPartialNameIsPerformed(){
		
		driver.findElement(By.xpath("//a[@href='/reporting/projects/filter']")).click();
		driver.findElement(By.id("search")).sendKeys("alerts");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		assertEquals(1,driver.findElements(By.xpath("//td[contains(text(),'FATCA alerts')]")).size());
		assertEquals(1,driver.findElements(By.xpath("//td[contains(text(),'SFG RISK - BANK ALERTS MODIFICATIONS')]")).size());
		assertEquals(2,driver.findElements(By.xpath("//td[contains(text(),'Market Abuse Alerts')]")).size());
		
	}

}
