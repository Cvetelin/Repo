package bg.ceco.demo.selenium;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;




public class TestRunner {

	public static Result runClass(String classQualifiedName) {
		JUnitCore runner = new JUnitCore();
		runner.addListener(new TestListener());
		Class cls = null;
		try {
			cls = Class.forName(classQualifiedName);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return runner.run(cls);

	}
}
