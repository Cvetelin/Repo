package bg.ceco.demo.selenium;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javassist.ClassPool;
import javassist.CtClass;

import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.springframework.stereotype.Controller;

import bg.ceco.demo.logic.listener.TestListenerImpl;
import bg.ceco.demo.model.ClassInfo;
import bg.ceco.demo.model.ExecInfo;
import bg.ceco.demo.model.Project;
import bg.ceco.demo.model.TestInfo;

@Controller
public class TestRunner {

	public Result runClass(ClassInfo classInfo) throws Exception {
		Class<?> cls = loadClassFormJar(classInfo);
		TestInfo testInfo = new TestInfo();
		ExecInfo execInfo = new ExecInfo();

		JUnitCore runner = new JUnitCore();
		runner.addListener(new TestListenerImpl(classInfo, testInfo, execInfo));

		return runner.run(cls);

	}

	public Result runMethod(ClassInfo classInfo, TestInfo testInfo) throws Exception {
		Class<?> cls = loadClassFormJar(classInfo);
		ExecInfo execInfo = new ExecInfo();
		Request request = Request.method(cls, testInfo.getName());

		JUnitCore runner = new JUnitCore();
		runner.addListener(new TestListenerImpl(classInfo, testInfo, execInfo));

		return runner.run(request);

	}

	private Class<?> loadClassFormJar(ClassInfo classInfo) throws Exception {
		Class<?> c = null;

		ClassLoader currentClassLoader = Thread.currentThread().getContextClassLoader();
		Project project = classInfo.getProject();
		// FileUtils.writeByteArrayToFile(new File(project.getJarPath()),
		// project.getTestJar());

		JarFile jarFile = new JarFile(project.getJarPath());
		try {
			Enumeration<?> e = jarFile.entries();
			File f = new File(project.getJarPath());

			URL[] urls = { f.toURI().toURL() };

			URLClassLoader cl = URLClassLoader.newInstance(urls, currentClassLoader);

			ClassPool cp = ClassPool.getDefault();
			cp.insertClassPath(project.getJarPath());
			while (e.hasMoreElements()) {
				JarEntry je = (JarEntry) e.nextElement();

				if (je.getName().contains(classInfo.getName())) {

					// -6 because of .class
					// -5 because of .java
					String className = je.getName().substring(0, je.getName().length() - 6);
					className = className.replace('/', '.');

					CtClass ct = cp.get(className);
					ct.getClass().getSuperclass().getName();

					c = cl.loadClass(className);
				}
			}
		} finally {
			jarFile.close();
		}
		return c;
	}
}