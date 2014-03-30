package bg.ceco.demo.springmvc;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;

import bg.ceco.demo.logic.ClassInfoService;
import bg.ceco.demo.model.ClassInfo;
import bg.ceco.demo.model.Project;
import bg.ceco.demo.model.TestInfo;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class JarLoader {

	
	public List<Class<?>> loadJar(Project project) throws Exception {

//		if(!StringUtils.isEmpty(project.getDependencyJarName()) && project.getDependencyJar() != null) {
//			loadDependencies(project);
//		}
		
		FileUtils.writeByteArrayToFile(new File(project.getJarPath()),
				project.getTestJar());
		
		JarFile jarFile = new JarFile(project.getJarPath());
		Enumeration<?> e = jarFile.entries();

		File f = new File(project.getJarPath());
		URL[] urls = { f.toURI().toURL() };
		URLClassLoader cl = URLClassLoader.newInstance(urls);

		List<Class<?>> testClasses = new ArrayList<Class<?>>();
		ClassPool cp = ClassPool.getDefault();
		cp.insertClassPath(project.getJarPath());
		while (e.hasMoreElements()) {
			JarEntry je = (JarEntry) e.nextElement();
			if (je.isDirectory() || !je.getName().endsWith("Test.class")) {
				continue;
			}
			// -6 because of .class
			// -5 because of .java
			String className = je.getName().substring(0,
					je.getName().length() - 6);
			className = className.replace('/', '.');
			
			CtClass ct = cp.get(className);
			Collection<CtClass> refClassess = ct.getRefClasses();
			CtMethod[] ctmethod = ct.getMethods();

			Class<?> c = cl.loadClass(className);
			testClasses.add(c);
			System.out.println("Success!");
		}
		
		
		return testClasses;
		// File f = new
		// File("C:\\m2\\bugshot\\test\\bugshot-test\\1.0\\bugshot-test-1.0-tests.jar");
		// URLClassLoader urlCl = new URLClassLoader(new URL[] {
		// f.toURI().toURL()},System.class.getClassLoader());
		// Class<?> cls = urlCl.loadClass("web.test.login.LoginTest");
		// cls.newInstance();
		// System.out.println ("Success!");
	}
	
	private List<Class<?>> loadDependencies (Project project) throws Exception {
		FileUtils.writeByteArrayToFile(new File(project.getDependencyJarPath()),
				project.getDependencyJar());
		
		JarFile jarFile = new JarFile(project.getDependencyJarPath());
		Enumeration<?> e = jarFile.entries();

		File f = new File(project.getDependencyJarPath());
		URL[] urls = { f.toURI().toURL() };
		URLClassLoader cl = URLClassLoader.newInstance(urls);
		List<Class<?>> depClasses = new ArrayList<Class<?>>();
		ClassPool cp = ClassPool.getDefault();
		cp.insertClassPath(project.getDependencyJarPath());
		
		
		while (e.hasMoreElements()) {
			JarEntry je = (JarEntry) e.nextElement();
			if (je.isDirectory() || !je.getName().endsWith(".class")) {
				continue;
			}
			// -6 because of .class
			// -5 because of .java
			String className = je.getName().substring(0,
					je.getName().length() - 6);
			className = className.replace('/', '.');
			
			
			
			CtClass ct = cp.get(className);			
			Class<?> c = cl.loadClass(className);
			depClasses.add(c);		
		}		
		return depClasses;
	}
}
