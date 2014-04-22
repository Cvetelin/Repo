package bg.ceco.demo.springmvc;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javassist.ClassPool;
import javassist.CtClass;

import org.apache.commons.io.FileUtils;

import bg.ceco.demo.model.Project;

public class ProjectTreeGenerator {

	public List<CtClass> loadJar(Project project) throws Exception {

		FileUtils.writeByteArrayToFile(new File(project.getJarPath()), project.getTestJar());

		JarFile jarFile = new JarFile(project.getJarPath());
		Enumeration<?> e = jarFile.entries();

		File f = new File(project.getJarPath());
		URL[] urls = { f.toURI().toURL() };
		URLClassLoader cl = URLClassLoader.newInstance(urls);

		List<Class<?>> testClasses = new ArrayList<Class<?>>();

		List<CtClass> classes = new ArrayList<CtClass>();

		ClassPool cp = ClassPool.getDefault();
		cp.insertClassPath(project.getJarPath());
		while (e.hasMoreElements()) {
			JarEntry je = (JarEntry) e.nextElement();
			if (je.isDirectory() || !je.getName().endsWith("Test.class")) {
				continue;
			}
			// -6 because of .class
			// -5 because of .java
			String className = je.getName().substring(0, je.getName().length() - 6);
			className = className.replace('/', '.');

			CtClass ct = cp.get(className);
			ct.getClass().getSuperclass().getName();

			classes.add(ct);
			// loadClassFormJar(project);
			// Class<?> c = cl.loadClass(className);
			// testClasses.add(c);
		}
		return classes;
	}

	public List<CtClass> loadClassFormJar(Project project) throws Exception {

		FileUtils.writeByteArrayToFile(new File(project.getJarPath()), project.getTestJar());

		JarFile jarFile = new JarFile(project.getJarPath());
		Enumeration<?> e = jarFile.entries();

		File f = new File(project.getJarPath());
		URL[] urls = { f.toURI().toURL() };
		URLClassLoader cl = URLClassLoader.newInstance(urls);

		List<Class<?>> testClasses = new ArrayList<Class<?>>();

		List<CtClass> classes = new ArrayList<CtClass>();

		ClassPool cp = ClassPool.getDefault();
		cp.insertClassPath(project.getJarPath());
		while (e.hasMoreElements()) {
			JarEntry je = (JarEntry) e.nextElement();
			if (je.isDirectory() || !je.getName().endsWith("Test.class")) {
				continue;
			}
			// -6 because of .class
			// -5 because of .java
			String className = je.getName().substring(0, je.getName().length() - 6);
			className = className.replace('/', '.');

			CtClass ct = cp.get(className);
			ct.getClass().getSuperclass().getName();

			// loadClassDependencyJar(project);

			while (ct != null) {
				System.out.println(ct.getName());
				ct = ct.getSuperclass();
			}

			classes.add(ct);
			// Class<?> c = cl.loadClass(className);
			// c.getSuperclass().getName();
			// testClasses.add(c);
			int i = 3;
		}
		return classes;
	}

	private List<CtClass> loadClassDependencyJar(Project project) throws Exception {

		FileUtils.writeByteArrayToFile(new File(project.getDependencyJarPath()), project.getDependencyJar());

		JarFile jarFile = new JarFile(project.getDependencyJarPath());
		Enumeration<?> e = jarFile.entries();

		File f = new File(project.getDependencyJarPath());
		URL[] urls = { f.toURI().toURL() };
		URLClassLoader cl = URLClassLoader.newInstance(urls);

		List<Class<?>> testClasses = new ArrayList<Class<?>>();

		List<CtClass> classes = new ArrayList<CtClass>();

		ClassPool cp = ClassPool.getDefault();
		cp.insertClassPath(project.getDependencyJarPath());
		while (e.hasMoreElements()) {
			JarEntry je = (JarEntry) e.nextElement();
			if (je.isDirectory() || !je.getName().endsWith(".class")) {
				continue;
			}

			// if (je.getName().equals("org/junit/Before.class") ||
			// je.getName().equals("org/junit/After.class")
			// || je.getName().equals("org/junit/AfterClass.class") ||
			// je.getName().equals("org/junit/Rule.class")
			// || je.getName().equals("org/junit/BeforeClass.class") ||
			// je.getName().equals("org/junit/ClassRule.class")
			// || je.getName().equals("org/junit/Ignore.class") ||
			// je.getName().equals("org/junit/package-info.class")
			// || je.getName().equals("org/junit/Test.class")) {
			// continue;
			// }

			if (je.getName().contains("FirefoxDriver") || je.getName().contains("FFScreenShotTestCase")) {

				// -6 because of .class
				// -5 because of .java
				String className = je.getName().substring(0, je.getName().length() - 6);
				className = className.replace('/', '.');

				CtClass ct = cp.get(className);
				ct.getClass().getSuperclass().getName();
				System.out.println("##### CLASS NAME: " + ct.getName());

				// cLoader.getSystemClassLoader().loadClass("org.openqa.selenium.firefox.FirefoxDriver");
				// ClassLoader.getSystemClassLoader().loadClass("org.openqa.selenium.ie.InternetExplorerDriver");
				// ClassLoader.getSystemClassLoader().loadClass("org.openqa.selenium.chrome.ChromeDriver");
				// while (ct != null) {
				// System.out.println(ct.getName());
				// ClassLoader.getSystemClassLoader().loadClass("org.openqa.selenium.firefox.FirefoxDriver");
				// ct = ct.getSuperclass();
				// }

				classes.add(ct);
				Class<?> c = cl.loadClass(className);
				c.getSuperclass().getName();
				// testClasses.add(c);
				int i = 3;
			}
		}
		return classes;
	}

}
