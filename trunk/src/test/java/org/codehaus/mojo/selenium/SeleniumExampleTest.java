package org.codehaus.mojo.selenium;


import java.util.concurrent.TimeUnit;

import org.codehaus.mojo.selenium.support.ModifiedTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class SeleniumExampleTest extends ModifiedTestCase{	

	public void testSomethingSimple() throws Exception {

		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		edriver.register(new ListenerThatHiglilightsElements("#FFFF00", 1, 500, TimeUnit.NANOSECONDS));
		//WebDriverBackedSelenium selenium = new WebDriverBackedSelenium(driver, "http://www.dir.bg/");		
		//driver = ((WrapsDriver)selenium).getWrappedDriver();
		edriver.get("http://www.dir.bg/");
		//driver.get("http://www.dir.bg/");
		//selenium.open("http://www.dir.bg/");
		//selenium.click("link=Бургас");
		//selenium.waitForPageToLoad("30000");
//		selenium.isElementPresent("//*[@id='textfields']"); 
		assertTrue(edriver.findElement(By.tagName("body")).getText().contains("ДНЕС"));
		 WebElement el = edriver.findElement(By.id("textfields"));
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