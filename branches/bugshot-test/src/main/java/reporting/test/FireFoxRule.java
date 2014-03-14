package reporting.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxRule extends TestWatchman {

	
	
	protected WebDriver driver = new FirefoxDriver();
	private static  String userName;
	private static  String password ;
	private static  String reportinUrl;
	
	static{
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("test-context.properties");
			prop.load(input);
			userName = prop.getProperty("USER_ADMIN");
			password= prop.getProperty("PASSWORD_ADMIN");
			reportinUrl = prop.getProperty("REPORTING_BETA_URL");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
    @Override
	public void starting(FrameworkMethod method) {
    	super.starting(method);
    	try {
    		 driver.get(reportinUrl);
    		 driver.findElement(By.name("username")).sendKeys(userName);
    		 driver.findElement(By.name("password")).sendKeys(password);
    		 driver.findElement(By.id("loginform")).submit();
		} catch (Exception e) {
			throw new java.lang.IllegalStateException("Can't navigate to login page", e);
		}
    }
    @Override
    public void finished(FrameworkMethod method) {
    	try {
    		driver.close();
    	} catch (Exception e) {
    		throw new java.lang.IllegalStateException("Can't destroy Selenium", e);
    	} finally {
    		super.finished(method);
    	}
    }
	@Override
	 public void failed(Throwable e, FrameworkMethod method) {
	      File scrFile = ((TakesScreenshot) driver).getScreenshotAs(
	                      OutputType.FILE);
	      String scrFilename = method.getName() + "-FailedTest-Screenshot.png";
	      File outputFile = new File("C:\\Temp", scrFilename);
	      try {
	           FileUtils.copyFile(scrFile, outputFile);
	      } catch (IOException ioe) {
	    	  ioe.printStackTrace();
	      }
	 }
	  public WebDriver getDriver(){
	    	return driver;
	    	
	    }
}
