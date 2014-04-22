package bg.ceco.demo.selenium;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javassist.ClassPool;
import javassist.CtClass;

import org.apache.commons.io.FileUtils;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bg.ceco.demo.logic.ProjectService;
import bg.ceco.demo.logic.TestListenerImpl;
import bg.ceco.demo.model.ClassInfo;
import bg.ceco.demo.model.Project;
import bg.ceco.demo.model.TestInfo;

@Controller
public class TestRunner {

	@Autowired
	public ProjectService projectService;

	public Result runClass(ClassInfo classInfo) throws Exception {
		Class<?> cls = loadClassFormJar(classInfo);

		JUnitCore runner = new JUnitCore();
		runner.addListener(new TestListenerImpl(classInfo));

		return runner.run(cls);

	}

	private Class<?> loadClassFormJar(ClassInfo classInfo) throws Exception {
		Class<?> c = null;
		Project project = classInfo.getProject();
		FileUtils.writeByteArrayToFile(new File(project.getJarPath()), project.getTestJar());

		File seleniumApi = new File("C:/Users/Ceco/.m2/repository/org/seleniumhq/selenium/selenium-api/2.40.0/selenium-api-2.40.0.jar");
		File seleniumSupport = new File(
				"C:/Users/Ceco/.m2/repository/org/seleniumhq/selenium/selenium-support/2.40.0/selenium-support-2.40.0.jar");
		File junit = new File("C:/Users/Ceco/.m2/repository/junit/junit/4.10/junit-4.10.jar");

		JarFile jarFile = new JarFile(project.getJarPath());
		Enumeration<?> e = jarFile.entries();
		File f = new File(project.getJarPath());

		URL[] urls = { f.toURI().toURL(), seleniumApi.toURI().toURL(), seleniumSupport.toURI().toURL(), junit.toURI().toURL() };

		URLClassLoader cl = URLClassLoader.newInstance(urls);

		List<CtClass> classes = new ArrayList<CtClass>();

		ClassPool cp = ClassPool.getDefault();
		cp.insertClassPath(project.getJarPath());
		while (e.hasMoreElements()) {
			JarEntry je = (JarEntry) e.nextElement();
			System.out.println("!!!---#---!!! " + je.getName());
			if (je.isDirectory() || !je.getName().endsWith("Test.class")) {
				continue;
			}

			if (je.getName().contains(classInfo.getName())) {

				// -6 because of .class
				// -5 because of .java
				String className = je.getName().substring(0, je.getName().length() - 6);
				className = className.replace('/', '.');

				CtClass ct = cp.get(className);
				ct.getClass().getSuperclass().getName();

				while (ct != null) {
					System.out.println(ct.getName());
					ct = ct.getSuperclass();
				}

				classes.add(ct);
				Set<TestInfo> m = classInfo.getTestInfo();
				List<TestInfo> met = new ArrayList<TestInfo>();
				met.addAll(m);
				c = cl.loadClass(className);
				Method[] me = c.getMethods();
				for (int i = 0; i < me.length; i++) {
					System.out.println(me[i].getName());
				}
				Annotation[] an = c.getAnnotations();
				// cl.getParent().getParent().loadClass(WebDriver.class.getName());
			}
		}
		return c;
	}
}
