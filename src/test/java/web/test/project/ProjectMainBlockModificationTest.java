package web.test.project;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import reporting.test.FireFoxRule;

public class ProjectMainBlockModificationTest {
	
	private static WebDriver driver ;
	@Rule
	public FireFoxRule firefoxRule = new FireFoxRule();
	@Before
	public void setUp() throws Exception{
		driver = firefoxRule.getDriver();

}

	@Test
	public void theProjectsNameOfMainBlockIsModified() throws InterruptedException{
	//Navigate to Project panel and edit fields to ensure that field keeps the new entries

		driver.findElement(By.xpath("//a[@href='/reporting/projects/filter']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("search")).sendKeys("TEST project update");		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//td[contains(text(),'TEST project update')]")).click();	
		Thread.sleep(1000);
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("TEST project update2");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("TEST project update1");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.xpath("//div/h1[contains(text(),'TEST project update1')]")).size() == 1) ;		
		
	
			
		
	}
	
	@Test
	public void theProjectsCodeOfMainBlockIsModified() throws InterruptedException{
		//Navigate to Project panel and edit fields to ensure that field keeps the new entries
		
		driver.findElement(By.xpath("//a[@href='/reporting/projects/filter']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("search")).sendKeys("TEST project update1");		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//td[contains(text(),'TEST project update1')]")).click();	
		Thread.sleep(1000);
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("code")).clear();
		driver.findElement(By.id("code")).sendKeys("test2");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("code")).clear();
		driver.findElement(By.id("code")).sendKeys("test1");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
			
		
		
	}
	
	@Test
	public void theProjectsManagerOfMainBlockIsModified() throws InterruptedException{
		//Navigate to Project panel and edit fields to ensure that field keeps the new entries
		
		driver.findElement(By.xpath("//a[@href='/reporting/projects/filter']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("search")).sendKeys("TEST project update");		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//td[contains(text(),'TEST project update')]")).click();	
		Thread.sleep(1000);
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);

		//driver.findElement(By.id("managerSelect")).click();
		//Thread.sleep(1000);
		driver.findElement(By.id("managerSelect")).sendKeys("npetkov");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		//assertTrue(driver.findElement(By.id("managerSelect")).getText().equals("npetkov"));
		assertTrue(driver.getPageSource().contains("ikatsaro"));
		
		driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);

		//driver.findElement(By.id("managerSelect")).click();
		//Thread.sleep(1000);
		driver.findElement(By.id("managerSelect")).sendKeys("ikatsaro");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		//assertTrue(driver.findElement(By.id("managerSelect")).getText().equals("ikatsaro"));
		assertTrue(driver.getPageSource().contains("ikatsaro"));
		
	}


	@Test
	public void theProjectsBusinessAnalystOfMainBlockIsModified() throws InterruptedException{
		//Navigate to Project panel and edit fields to ensure that field keeps the new entries
		
		driver.findElement(By.xpath("//a[@href='/reporting/projects/filter']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("search")).sendKeys("TEST project update1");		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//td[contains(text(),'TEST project update1')]")).click();	
		Thread.sleep(1000);
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("analyst")).clear();
		driver.findElement(By.id("analyst")).sendKeys("analyst1");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("analyst")).clear();
		driver.findElement(By.id("analyst")).sendKeys("analyst2");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		
		
	}
	
	@Test
	public void theProjectsMainIssueOfMainBlockIsModified() throws InterruptedException{
		//Navigate to Project panel and edit fields to ensure that field keeps the new entries
		
		driver.findElement(By.xpath("//a[@href='/reporting/projects/filter']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("search")).sendKeys("TEST project update1");		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//td[contains(text(),'TEST project update1')]")).click();	
		Thread.sleep(1000);
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("issueCode")).clear();
		driver.findElement(By.id("issueCode")).sendKeys("1");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("issueCode")).clear();
		driver.findElement(By.id("issueCode")).sendKeys("2");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		
		
		
	}
	@Test
	public void theProjectsApplicationOfMainBlockIsModified() throws InterruptedException{
		//Navigate to Project panel and edit fields to ensure that field keeps the new entries
		
		driver.findElement(By.xpath("//a[@href='/reporting/projects/filter']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("search")).sendKeys("TEST project update1");		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//td[contains(text(),'TEST project update1')]")).click();	
		Thread.sleep(1000);
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		//driver.findElement(By.id("applicationSelect")).clear();
		driver.findElement(By.id("applicationSelect")).sendKeys("CRM-FR");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		//driver.findElement(By.id("applicationSelect")).clear();
		driver.findElement(By.id("applicationSelect")).sendKeys("CRM-DE");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		//driver.findElement(By.id("applicationSelect")).clear();
		driver.findElement(By.id("applicationSelect")).sendKeys("CRM-UK");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		//driver.findElement(By.id("applicationSelect")).clear();
		driver.findElement(By.id("applicationSelect")).sendKeys("IRA");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		//driver.findElement(By.id("applicationSelect")).clear();
		driver.findElement(By.id("applicationSelect")).sendKeys("Reporting tool");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		//driver.findElement(By.id("applicationSelect")).clear();
		driver.findElement(By.id("applicationSelect")).sendKeys("IRS");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		//driver.findElement(By.id("applicationSelect")).clear();
		driver.findElement(By.id("applicationSelect")).sendKeys("RISK-FR");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		//driver.findElement(By.id("applicationSelect")).clear();
		driver.findElement(By.id("applicationSelect")).sendKeys("RISK-UK");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		//driver.findElement(By.id("applicationSelect")).clear();
		driver.findElement(By.id("applicationSelect")).sendKeys("New Pricing");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		//driver.findElement(By.id("applicationSelect")).clear();
		driver.findElement(By.id("applicationSelect")).sendKeys("Bug Monitoring");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		//driver.findElement(By.id("applicationSelect")).clear();
		driver.findElement(By.id("applicationSelect")).sendKeys("SQL tools");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editProjectBtn")).size() == 1) ;		
	    driver.findElement(By.id("editProjectBtn")).click();	
	    Thread.sleep(1000);
		//driver.findElement(By.id("applicationSelect")).clear();
		driver.findElement(By.id("applicationSelect")).sendKeys("ANNEE");
		driver.findElement(By.id("submitModifyProjectBtn")).click();
		Thread.sleep(1000);
		
	}
}
	
	
//	@After
//	public void tearDown() throws Exception {
//			//tearDown();
//		}
//}