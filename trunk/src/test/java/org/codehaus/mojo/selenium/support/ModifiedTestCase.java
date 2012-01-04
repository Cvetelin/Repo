package org.codehaus.mojo.selenium.support;

import junit.framework.TestCase;

public class ModifiedTestCase extends TestCase {
	protected ModifiedRemoteWebDriver driver;
	
	@Override
	protected void setUp() throws Exception {		
		super.setUp();
		driver = new ModifiedRemoteWebDriver(getName());
	}
}
