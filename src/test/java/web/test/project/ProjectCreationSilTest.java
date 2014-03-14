package web.test.project;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import reporting.test.FireFoxRule;
import reporting.test.jdbc.ScreenUtils;

public class ProjectCreationSilTest {

//	private final String START = "24/02/2014";
//	private final String JAVA = "16";
//	private final String PLSQL = "0";
//	private final String DESIGN = "2";
//	private final String TEST = "1";
//	private final String UAT = "0";
//	private final String OTHER = "0";
	
	private static WebDriver driver ;
	
	@Rule
	public FireFoxRule firefoxRule = new FireFoxRule();
	@Before
	public void setUp() throws Exception{
		driver = firefoxRule.getDriver();
	}
	
	
	@Test
	public void projectCreationToTestDeclarationOfConstantsAndAssertReadLabelTest() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//a[@href='/reporting/projects/filter']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("search")).sendKeys("Auchan R1");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[contains(text(),'Auchan R1')]")).click();
		Thread.sleep(1000);

		assertEquals(2,driver.findElements(By.xpath("//a[contains(text(),'171: [Lot R1] Lot R1')]")).size());
		assertEquals("Silyana Bojilova", ScreenUtils.readLabelField(driver,"Manager"));
		assertEquals("Silyana Bojilova", ScreenUtils.readLabelField(driver,"Business Analyst"));
		assertEquals("ANEE", ScreenUtils.readLabelField(driver,"Application"));
		assertEquals("6", ScreenUtils.readLabelField(driver,"Resolved issues"));
		assertEquals("0 (0,00%)", ScreenUtils.readLabelField(driver,"Consumed days"));
		assertEquals("29", ScreenUtils.readLabelField(driver,"Est. days to finish"));
		assertEquals("21", ScreenUtils.readLabelField(driver,"Budget days left"));
		assertEquals("8.0", ScreenUtils.readLabelField(driver,"Delay"));
		assertEquals("-38,1%", ScreenUtils.readLabelField(driver,"Progress"));
		assertEquals("13/03/2014 13:54", ScreenUtils.readLabelField(driver,"Calculated on"));
		assertEquals("24/02/2014", ScreenUtils.readLabelField(driver,"Start", 1));
		assertEquals("07/03/2014", ScreenUtils.readLabelField(driver,"Delivery", 1));
		assertEquals("", ScreenUtils.readLabelField(driver,"Delivery", 2));
		assertEquals("", ScreenUtils.readLabelField(driver,"Delivery VAL",2));
		assertEquals("", ScreenUtils.readLabelField(driver,"Delivery PROD",2));
		assertEquals("16.0", ScreenUtils.readLabelField(driver,"Java"));
		assertEquals("0.0", ScreenUtils.readLabelField(driver,"PL/SQL"));
		assertEquals("2.0", ScreenUtils.readLabelField(driver,"Design"));
		assertEquals("1.0", ScreenUtils.readLabelField(driver,"Test"));
		assertEquals("2.0", ScreenUtils.readLabelField(driver,"Management"));
		assertEquals("21.0", ScreenUtils.readLabelField(driver,"Total before UAT"));
		assertEquals("0.0", ScreenUtils.readLabelField(driver,"UAT"));
		assertEquals("0.0", ScreenUtils.readLabelField(driver,"Other"));
		assertEquals("21.0", ScreenUtils.readLabelField(driver,"Total"));
		assertEquals("1,00", ScreenUtils.readField(driver,"QA Admin"));

		
	}

	
}
