package web.test.month.reports;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import reporting.test.FireFoxRule;
import web.test.suites.SanityTestSuite;
import web.test.suites.SmokeTestSuite;

public class CategorizeNonProjectIssueTest {
	
	private static WebDriver driver ;
	@Rule
	public FireFoxRule firefoxRule = new FireFoxRule();
	@Before
	public void setUp() throws Exception{
		driver = firefoxRule.getDriver();
	}

	@Test
	@Category({SmokeTestSuite.class,SanityTestSuite.class}) 
	public void aCategoryIsGivenToAnonProjectIssue() throws InterruptedException{
		driver.findElement(By.xpath("//a[@href='/reporting/reports/monthly']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'By non project')]")).click();
		driver.findElement(By.xpath("//td/a[contains(text(),'123: Ivan Katerkov mentoring')]/parent::td/following-sibling::td/a[contains(text(),'O')]")).click();
		Thread.sleep(1000);
		assertEquals(1, driver.findElements(By.xpath("//td[contains(text(),'Non Bourso')]/parent::tr/following-sibling::tr/td/a[contains(text(),'123: Ivan Katerkov mentoring')]")).size());
		driver.findElement(By.xpath("//td/a[contains(text(),'123: Ivan Katerkov mentoring')]/parent::td/following-sibling::td/a[contains(text(),'E')]")).click();
		Thread.sleep(1000);
		assertEquals(1, driver.findElements(By.xpath("//td[contains(text(),'Estimation')]/parent::tr/following-sibling::tr/td/a[contains(text(),'123: Ivan Katerkov mentoring')]")).size());
		
	}
	

}
