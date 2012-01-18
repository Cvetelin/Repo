package bg.ceco.demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bg.ceco.demo.selenium.IEScreenshotTestCase;


public class SeleniumExampleTest extends IEScreenshotTestCase {	

	public void testSomethingSimple() throws Exception {

		//WebDriverBackedSelenium selenium = new WebDriverBackedSelenium(driver, "http://www.dir.bg/");		
		//driver = ((WrapsDriver)selenium).getWrappedDriver();
		driver.get("http://www.dir.bg/");
		//selenium.open("http://www.dir.bg/");
		//selenium.click("link=Бургас");
		//selenium.waitForPageToLoad("30000");
//		selenium.isElementPresent("//*[@id='textfields']"); 
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("ДНЕС"));
		 WebElement el = driver.findElement(By.id("textfields"));
		 el.sendKeys("новини");
		 el.getAttribute("id");
//		selenium.type("//*[@id='textfields']", "новини");
//		element.sendKeys("новини");
//		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtil.copyFile(file, new File("c:\\tmp\\screenshot.png"));
		
	//	driver.findElement(By.partialLinkText("Новините от Деня")).click();
//		file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtil.copyFile(file, new File("c:\\tmp\\screenshot.png"));
	//	element = driver.findElement(By.xpath("//a[@title='Селен']"));
	//	assertTrue(element.getText().equals("Селен"));
		
	}
}