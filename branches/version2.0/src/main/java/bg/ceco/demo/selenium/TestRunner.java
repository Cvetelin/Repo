package bg.ceco.demo.selenium;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import bg.ceco.demo.model.ClassInfo;

public class TestRunner {

	public static Result runClass(ClassInfo classInfo) throws Exception {
		
		Class<?> cls = Class.forName(classInfo.getQualifiedName());
	
		JUnitCore runner = new JUnitCore();
		runner.addListener(new TestListener());

		return runner.run(cls);

		}
		
}
