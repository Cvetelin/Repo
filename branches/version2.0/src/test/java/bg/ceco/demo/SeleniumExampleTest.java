package bg.ceco.demo;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bg.ceco.demo.selenium.FFScreenShotTestCase;
import bg.ceco.demo.selenium.IEScreenshotTestCase;


public class SeleniumExampleTest  extends FFScreenShotTestCase{	
	
	@Test
	public void testSomethingSimple() throws Exception {

		//WebDriverBackedSelenium selenium = new WebDriverBackedSelenium(driver, "http://www.dir.bg/");		
		//driver = ((WrapsDriver)selenium).getWrappedDriver();
		driver.get("http://en.wikipedia.org/wiki/Main_Page");
		//selenium.open("http://www.dir.bg/");
		//selenium.click("link=������");
		//selenium.waitForPageToLoad("30000");
//		selenium.isElementPresent("//*[@id='textfields']"); 
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Welcome to Wikipedia"));
		 WebElement el = driver.findElement(By.id("searchInput"));
		 el.sendKeys("selenium");
		 el.getAttribute("id");
//		selenium.type("//*[@id='textfields']", "������");
//		element.sendKeys("������");
//		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtil.copyFile(file, new File("c:\\tmp\\screenshot.png"));
		
	//	driver.findElement(By.partialLinkText("�������� �� ����")).click();
//		file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtil.copyFile(file, new File("c:\\tmp\\screenshot.png"));
	//	element = driver.findElement(By.xpath("//a[@title='�����']"));
	//	assertTrue(element.getText().equals("�����"));
		
	}
	
	@Test
	public void testSomethingSimple1() throws Exception {

		//WebDriverBackedSelenium selenium = new WebDriverBackedSelenium(driver, "http://www.dir.bg/");		
		//driver = ((WrapsDriver)selenium).getWrappedDriver();
		driver.get("http://en.wikipedia.org/wiki/Main_Page");
		//selenium.open("http://www.dir.bg/");
		//selenium.click("link=������");
		//selenium.waitForPageToLoad("30000");
//		selenium.isElementPresent("//*[@id='textfields']"); 
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Welcome to Wikipedia"));
		 WebElement el = driver.findElement(By.id("searchInput"));
		 el.sendKeys("selenium");
		 el.getAttribute("id");
//		selenium.type("//*[@id='textfields']", "������");
//		element.sendKeys("������");
//		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtil.copyFile(file, new File("c:\\tmp\\screenshot.png"));
		
	//	driver.findElement(By.partialLinkText("�������� �� ����")).click();
//		file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtil.copyFile(file, new File("c:\\tmp\\screenshot.png"));
	//	element = driver.findElement(By.xpath("//a[@title='�����']"));
	//	assertTrue(element.getText().equals("�����"));
		
	}
}