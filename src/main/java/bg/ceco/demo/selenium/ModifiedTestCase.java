package bg.ceco.demo.selenium;

import junit.framework.TestCase;

public class ModifiedTestCase extends TestCase {
	protected ModifiedInternetExplorerDriver driver;
	
	@Override
	protected void setUp() throws Exception {		
		super.setUp();
		driver = new ModifiedInternetExplorerDriver(getName());
	}
}
