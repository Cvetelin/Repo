package web.test.project;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import reporting.test.FireFoxRule;

public class ProjectBudgetModificationTest {
	private static WebDriver driver ;
	@Rule
	public FireFoxRule firefoxRule = new FireFoxRule();
	@Before
	public void setUp() throws Exception{
		driver = firefoxRule.getDriver();

	

	}
	
	
	
	@Test
	public void theJavaOfProjectBudgetIsModified() throws InterruptedException{
	//Set budget to 10
		//click save and assert 10 in correct field
		
		driver.findElement(By.xpath("//a[@href='/reporting/projects/filter']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("search")).sendKeys("TEST project update");		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//td[contains(text(),'TEST project update')]")).click();	
		Thread.sleep(1000);
		
		driver.findElement(By.id("editBudgetBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("java")).clear();
		driver.findElement(By.id("java")).sendKeys("10");
		driver.findElement(By.id("submitModifyBudgetBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editBudgetBtn")).size() == 1) ;		
	    driver.findElement(By.id("editBudgetBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("java")).clear();
		driver.findElement(By.id("java")).sendKeys("20");
		driver.findElement(By.id("submitModifyBudgetBtn")).click();
		Thread.sleep(1000);
			
		
	}
	
	@Test
	public void thePlsqlOfProjectBudgetIsModified() throws InterruptedException{
	//Set budget to 20
		//click save and assert 20 in correct field
		
		driver.findElement(By.xpath("//a[@href='/reporting/projects/filter']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("search")).sendKeys("TEST project update");		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//td[contains(text(),'TEST project update')]")).click();	
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editBudgetBtn")).size() == 1) ;		
		driver.findElement(By.id("editBudgetBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("plsql")).clear();
		driver.findElement(By.id("plsql")).sendKeys("20");
		driver.findElement(By.id("submitModifyBudgetBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editBudgetBtn")).size() == 1) ;		
	    driver.findElement(By.id("editBudgetBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("plsql")).clear();
		driver.findElement(By.id("plsql")).sendKeys("30");
		driver.findElement(By.id("submitModifyBudgetBtn")).click();
		Thread.sleep(1000);
		
	}
	
	@Test
	public void theDesignOfProjectBudgetIsModified() throws InterruptedException{
	//Set budget to 30
		//click save and assert 30 in correct field
		
		driver.findElement(By.xpath("//a[@href='/reporting/projects/filter']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("search")).sendKeys("TEST project update");		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//td[contains(text(),'TEST project update')]")).click();	
		Thread.sleep(1000);
		
		driver.findElement(By.id("editBudgetBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("design")).clear();
		driver.findElement(By.id("design")).sendKeys("30");
		driver.findElement(By.id("submitModifyBudgetBtn")).click();
		Thread.sleep(1000);
		
		//assertTrue(driver.findElements(By.id("editBudgetBtn")).size() == 1) ;		
	    driver.findElement(By.id("editBudgetBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("design")).clear();
		driver.findElement(By.id("design")).sendKeys("40");
		driver.findElement(By.id("submitModifyBudgetBtn")).click();
		Thread.sleep(1000);
		
	}
	

	
	@Test
	public void theTestOfProjectBudgetIsModified() throws InterruptedException{
	//Set budget to 40
		//click save and assert 40 in correct field
		
		driver.findElement(By.xpath("//a[@href='/reporting/projects/filter']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("search")).sendKeys("TEST project update");		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//td[contains(text(),'TEST project update')]")).click();	
		Thread.sleep(1000);
		
		driver.findElement(By.id("editBudgetBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("test")).clear();
		driver.findElement(By.id("test")).sendKeys("40");
		driver.findElement(By.id("submitModifyBudgetBtn")).click();
		Thread.sleep(1000);
		
		//assertTrue(driver.findElements(By.id("editBudgetBtn")).size() == 1) ;		
	    driver.findElement(By.id("editBudgetBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("test")).clear();
		driver.findElement(By.id("test")).sendKeys("50");
		driver.findElement(By.id("submitModifyBudgetBtn")).click();
		Thread.sleep(1000);
		
		
	}
	
	
	@Test
	public void theUatOfProjectBudgetIsModified() throws InterruptedException{
	//Set budget to 50
		//click save and assert 50 in correct field
		
		driver.findElement(By.xpath("//a[@href='/reporting/projects/filter']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("search")).sendKeys("TEST project update");		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//td[contains(text(),'TEST project update')]")).click();	
		Thread.sleep(1000);
		
		driver.findElement(By.id("editBudgetBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("uat")).clear();
		driver.findElement(By.id("uat")).sendKeys("50");
		driver.findElement(By.id("submitModifyBudgetBtn")).click();
		Thread.sleep(1000);
		
		//assertTrue(driver.findElements(By.id("editBudgetBtn")).size() == 1) ;		
	    driver.findElement(By.id("editBudgetBtn")).click();	
	    Thread.sleep(1000);
//		driver.findElement(By.id("uat")).clear();
		driver.findElement(By.id("uat")).sendKeys("60");
		driver.findElement(By.id("submitModifyBudgetBtn")).click();
		Thread.sleep(1000);
		
		
	}
	

	
	@Test
	public void theManagementOfProjectBudgetIsModified() throws InterruptedException{
	//Set budget to 60
		//click save and assert 60 in correct field
		
		driver.findElement(By.xpath("//a[@href='/reporting/projects/filter']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("search")).sendKeys("TEST project update");		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//td[contains(text(),'TEST project update')]")).click();	
		Thread.sleep(1000);
		
		driver.findElement(By.id("editBudgetBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("management")).clear();
		driver.findElement(By.id("management")).sendKeys("60");
		driver.findElement(By.id("submitModifyBudgetBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editBudgetBtn")).size() == 1) ;		
	    driver.findElement(By.id("editBudgetBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("management")).clear();
		driver.findElement(By.id("management")).sendKeys("70");
		driver.findElement(By.id("submitModifyBudgetBtn")).click();
		Thread.sleep(1000);
		
	}
	
	@Test
	public void theOtherOfProjectBudgetIsModified() throws InterruptedException{
	//Set budget to 70
		//click save and assert 70 in correct field
		
		driver.findElement(By.xpath("//a[@href='/reporting/projects/filter']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("search")).sendKeys("TEST project update");		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//td[contains(text(),'TEST project update')]")).click();	
		Thread.sleep(1000);
		
		driver.findElement(By.id("editBudgetBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("other")).clear();
		driver.findElement(By.id("other")).sendKeys("70");
		driver.findElement(By.id("submitModifyBudgetBtn")).click();
		Thread.sleep(1000);
		
		assertTrue(driver.findElements(By.id("editBudgetBtn")).size() == 1) ;		
	    driver.findElement(By.id("editBudgetBtn")).click();	
	    Thread.sleep(1000);
		driver.findElement(By.id("other")).clear();
		driver.findElement(By.id("other")).sendKeys("80");
		driver.findElement(By.id("submitModifyBudgetBtn")).click();
		Thread.sleep(1000);
		
	}
	
	
//	@After
//	public void tearDown(){
//		//Clear all fields
//	}
//	
	

}

 	
 
