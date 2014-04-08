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
			loadClassFormJar(project);
			// Class<?> c = cl.loadClass(className);
			// testClasses.add(c);
		}
		return classes;
	}

	private List<CtClass> loadClassFormJar(Project project) throws Exception {

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

			Class<?> c = cl.loadClass(className);
			c.getSuperclass().getName();
			// testClasses.add(c);
			int i = 3;
		}
		return classes;
	}

}
