////package org.codehaus.mojo.selenium;
////
////import java.io.IOException;
////import java.io.InputStream;
////import java.text.MessageFormat;
////
////import junit.framework.TestCase;
////
////import org.apache.commons.lang.StringUtils;
////import org.openqa.selenium.By;
////import org.openqa.selenium.JavascriptExecutor;
////import org.openqa.selenium.WebDriver;
////import org.openqa.selenium.WebDriverBackedSelenium;
////import org.openqa.selenium.ie.InternetExplorerDriver;
////import org.openqa.selenium.internal.WrapsDriver;
////import org.springframework.jdbc.support.JdbcUtils;
////
////import com.sun.corba.se.pept.transport.Connection;
////import com.sun.xml.internal.fastinfoset.sax.Properties;
////import com.thoughtworks.selenium.Selenium;
////import com.thoughtworks.selenium.SeleniumException;
////
////public class SeleniumTestCase extends TestCase {
//// 
////		private static final String TEST_WINDOW = "test"; //$NON-NLS-1$
////		
////		protected WebDriver driver;
////		protected WebDriverBackedSelenium selenium;
////		
//////		private static final String SELENIUM_HOST;
//////		private static final int SELENIUM_PORT;
//////		private static final String SELENIUM_BROWSER;
//////		private static final String SELENIUM_TIMEOUT;
//////		protected static final String APP_PROTOCOL;
//////		protected static final String APP_HOST;
//////		protected static final int APP_PORT;
//////		protected static final String APP_CONTEXT;
//////		private static final String CRM_USER;
//////		private static final String CRM_PASSWORD;
//////		private static String userFamilyName;
////		
//////		static {
//////			Properties prop;
//////			try {
//////				prop = loadSeleniumProperties();
//////			} catch (IOException ioe) {
//////				throw new ExceptionInInitializerError(ioe);
//////			}
//////			SELENIUM_HOST = getProperty(prop, "selenium.host", "localhost"); //$NON-NLS-1$ //$NON-NLS-2$
//////			SELENIUM_PORT = Integer.parseInt(getProperty(prop, "selenium.port", "4444")); //$NON-NLS-1$ //$NON-NLS-2$
//////			SELENIUM_BROWSER = getProperty(prop, "selenium.browser", "*iexplore"); //$NON-NLS-1$ //$NON-NLS-2$
//////			SELENIUM_TIMEOUT = getProperty(prop, "selenium.timeout", "3000"); //$NON-NLS-1$ //$NON-NLS-2$
//////			APP_PROTOCOL = getProperty(prop, "app.protocol", "http"); //$NON-NLS-1$ //$NON-NLS-2$
//////			APP_HOST = getProperty(prop, "app.host", "localhost"); //$NON-NLS-1$ //$NON-NLS-2$
//////			APP_PORT = Integer.parseInt(getProperty(prop, "app.port", "80")); //$NON-NLS-1$ //$NON-NLS-2$
//////			APP_CONTEXT = getProperty(prop, "app.context", "/"); //$NON-NLS-1$ //$NON-NLS-2$
//////			CRM_USER = prop.getProperty("crm.user"); //$NON-NLS-1$
//////			CRM_PASSWORD = prop.getProperty("crm.password"); //$NON-NLS-1$
//////		}
////		
////		protected final String getUniqueString() {
////			long current = System.currentTimeMillis();
////			StringBuilder ustr = new StringBuilder();
////			int ostart = 'Z' - 'A';
////			int olen = 'a' - 'Z' - 1;
////			long divisor = 2 * ostart;
////			while (current > 0) {
////				long remainder = current % divisor;
////				ustr.append((char) (remainder + 'A' + ((remainder > ostart) ? olen : 0)));
////				current = current / divisor;
////			}
////			return ustr.toString();
////		}
////		
////		@Override
////		protected void setUp() throws Exception {
////			super.setUp();
////			selenium = openBrowser();
////			goToWelcomePage();
////		}
////
////		protected WebDriverBackedSelenium openBrowser() {
////			driver  = new InternetExplorerDriver();
////			WebDriverBackedSelenium browser = new WebDriverBackedSelenium(driver, getBaseUrl().substring(0, getBaseUrl().indexOf(APP_CONTEXT) + 1));
////			//(SELENIUM_HOST, SELENIUM_PORT, SELENIUM_BROWSER, getBaseUrl().substring(0, getBaseUrl().indexOf(APP_CONTEXT) + 1));
////			browser.setContext(getClass().getName() + '.' + getName());
////			browser.setTimeout(SELENIUM_TIMEOUT);
////			
////			((JavascriptExecutor)driver).executeScript(
////				"window.showModalDialog = function(url, args, opts) { " +
////		        "opts = opts.replace(/dialogWidth\\s*:\\s*(\\d+)\\s*px/, 'width=$1');" +
////		        "opts = opts.replace(/dialogHeight\\s*:\\s*(\\d+)\\s*px/, 'height=$1');" +
////		        "var pwindow = window.open(url, 'test', opts, true);" +
////		        "pwindow.dialogArguments = args;" +
////		        "return pwindow.returnValue;" +
////		    	"};");
////			
////			return browser;
////		}
////		
////		@Override
////		protected void tearDown() throws Exception {		
////			if (selenium != null) {
////				selenium.stop();
////				selenium = null;
////			}
////			super.tearDown();
////		}
////		
////		protected String getBaseUrl() {
////			StringBuilder sb = new StringBuilder();
////			sb.append(APP_PROTOCOL + "://"); //$NON-NLS-1$
////			String user = getUser();
////			if (StringUtils.isNotEmpty(user)) {
////				sb.append(user);
////				String password = getPassword();
////				if (StringUtils.isNotEmpty(password)) {
////					sb.append(':' + password);
////				}
////				sb.append('@');
////			}
////			sb.append(APP_HOST + ':' + APP_PORT + APP_CONTEXT);
////			return sb.toString();
////		}
////		
////		protected void goToWelcomePage() {
////			open("/gestionAdmin/affichageAccueil.do"); //$NON-NLS-1$
////			waitForPageToLoad();
////		}
////		
////		/**
////		 * Opens a path relative the base URL
////		 * @see #getBaseUrl()
////		 * @param path
////		 */
////		protected void open(String path) {
////			if (path.charAt(0) != '/') {
////				throw new IllegalArgumentException("path '" + path + "' does not start with /"); //$NON-NLS-1$ //$NON-NLS-2$
////			}
////			selenium.open(getBaseUrl() + path);
////		}
////		
////		/**
////		 * Uses {@link Selenium#waitForPageToLoad(String)} with default timeout
////		 */
////		protected final void waitForPageToLoad() {
////			selenium.waitForPageToLoad(SELENIUM_TIMEOUT);
////			if(selenium.isTextPresent("Exception Details")) {
////				throw new SeleniumException(selenium.getBodyText());
////			}
////		}
////		
////		/**
////		 * Usable for Selenium 2 web driver. Replaces the modal popup with normal one and selects the popup.
////		 */
////		protected final void openAndSelectPopup(String locator) {
////			driver = ((WrapsDriver)selenium).getWrappedDriver();
////			((JavascriptExecutor)driver).executeScript(
////				"window.showModalDialog = function(url, args, opts) { " + //$NON-NLS-1$
////		        "opts = opts.replace(/dialogWidth\\s*:\\s*(\\d+)\\s*px/, 'width=$1');" + //$NON-NLS-1$
////		        "opts = opts.replace(/dialogHeight\\s*:\\s*(\\d+)\\s*px/, 'height=$1');" + //$NON-NLS-1$
////		        "var pwindow = window.open(url, 'test', opts, true);" + //$NON-NLS-1$
////		        "pwindow.dialogArguments = args;" + //$NON-NLS-1$
////		        "return pwindow.returnValue;" + //$NON-NLS-1$ 
////		    	"};"); //$NON-NLS-1$
////			driver.findElement(By.linkText(locator)).click();
//////			new Wait("No popup has been open") { //$NON-NLS-1$ 
//////				@Override
//////				public boolean until() {
//////					return driver.getWindowHandles().size() > 1;
//////				}
//////			};
////			driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
////			if(selenium.isTextPresent("Exception Details")) {
////				throw new SeleniumException(selenium.getBodyText());
////			}
////		}
////		
////		/**
////		 * Uses {@link Selenium#waitForPopUp(String, String)} with windowId = "test" and default timeout
////		 * then calls {@link Selenium#selectWindow(String)} with windowId = "test"
////		 */
////		protected final void waitForAndSelectPopup() {
////			selenium.waitForPopUp(TEST_WINDOW, SELENIUM_TIMEOUT);
////			selenium.selectWindow(TEST_WINDOW);
////		}
////		
////		/**
////		 * Calls {@link Selenium#waitForPopUp(String, String)} with with the provided <code>windowId</code>
////		 * and default timeout,<br>
////		 * then calls {@link Selenium#selectWindow(String)} with the provided <code>windowId</code>
////		 */
////		protected final void waitForAndSelectPopup(String windowId) {
////			selenium.waitForPopUp(windowId, SELENIUM_TIMEOUT);
////			selenium.selectWindow(windowId);
////		}
////
////		public void verifyTrue(boolean test) {
////			assertTrue(test);
////		}
////		
//////		static Properties loadSeleniumProperties() throws IOException {
//////			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("selenium.properties"); //$NON-NLS-1$
//////			if (is == null) {
//////				throw new ExceptionInInitializerError("Unable to find the selenium.properties file in the classpath"); //$NON-NLS-1$
//////			}
//////			Properties prop = new Properties();
//////			try {
//////				prop.load(is);
//////			} finally {
//////				is.close();
//////			}
//////			return prop;
//////		}
////		
//////		static final String getProperty(Properties prop, String key, String defaultValue) {
//////			String value = prop.getProperty(key);
//////			return StringUtils.isEmpty(value) ? defaultValue : value;
//////		}	
////		
////		protected String getUser() {
////			return CRM_USER;
////		}
////		
//////		public String getUserFamilyName() throws Exception {
//////			if (userFamilyName == null) {
//////				String login = getUser();
//////				Connection conn = JdbcUtils.openConnection();
//////				String userFamiliName = "(select NOM from {0}.crm_utilisateur where login =''{1}'')"; //$NON-NLS-1$
//////				userFamilyName = JdbcUtils.selectSingle(conn,
//////					MessageFormat.format(userFamiliName, JdbcUtils.defaultSchema(), login));
//////				JdbcUtils.closeQuietly(conn);
//////			}
//////			return userFamilyName;
//////		}
////		
////		protected String getPassword() {		
////			return CRM_PASSWORD;
////		}
////		
////		static public boolean isAlertOnloadPresent(Selenium selenium) {
////			selenium.click("//input[@alt='seleinum']"); //$NON-NLS-1$
////			
////			String test = selenium.getEval("javascript:{ selenium.browserbot.hasAlerts()}"); //$NON-NLS-1$
////			Boolean _boolean = new Boolean(test);
////					
////			return _boolean;
////		}
////		
////		/**
////		 * Opens a new browser window allowing logging with a different user.<br>
////		 * It closes the old browser window.
////		 * 
////		 * @param user the CRM user to login
////		 * @param password the user's password
////		 */
////		protected void logWithDifferentUser(String user, String password) {
////			logWithDifferentUser(user, password, true);
////		}
////		
////		/**
////		 * Opens a new browser window allowing logging with a different user
////		 * 
////		 * @param user the CRM user to login
////		 * @param password the user's password
////		 * @param cleanUp set it to <code>true</code> if you want to close the old browser window,<br>
////		 *            <code>false</code> if you want to leave it open.
////		 */
////		protected void logWithDifferentUser(String user, String password, boolean cleanUp) {
////			if (cleanUp) {
////				cleanUp();
////			}
////			selenium = new WebDriverBackedSelenium(driver, getBaseUrlForUser(user, password)
////				.substring(0, getBaseUrlForUser(user, password).indexOf(APP_CONTEXT) + 1));
////			selenium.start();
////			selenium.setContext(getClass().getName() + '.' + getName());
////			selenium.setTimeout(SELENIUM_TIMEOUT);
////			selenium.open(getBaseUrlForUser(user, password) + "/gestionAdmin/affichageAccueil.do"); //$NON-NLS-1$
////		}
////
////		/**
////		 * This method is used only to not throw
////		 */
////		public void cleanUp() {
////			if (selenium != null) {
////				selenium.stop();
////				selenium = null;
////			}
////		}
////		
////		protected String getBaseUrlForUser(String user, String password) {
////			StringBuilder sb = new StringBuilder();
////			sb.append(APP_PROTOCOL + "://"); //$NON-NLS-1$
////			if (StringUtils.isNotEmpty(user)) {
////				sb.append(user);
////				if (StringUtils.isNotEmpty(password)) {
////					sb.append(':' + password);
////				}
////				sb.append('@');
////			}
////			sb.append(APP_HOST + ':' + APP_PORT + APP_CONTEXT);
////			return sb.toString();
////		}
////		
////		protected WebDriver ieDriver() {
////			return driver;
////		}
////}
//
