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
import javassist.CtMethod;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.ceco.demo.logic.ClassInfoService;
import bg.ceco.demo.logic.TestInfoService;
import bg.ceco.demo.model.ClassInfo;
import bg.ceco.demo.model.Project;
import bg.ceco.demo.model.TestInfo;

public class ProjectTreeGenerator {
	
	@Autowired
	public ClassInfoService classInfoService;
	
	@Autowired
	public TestInfoService testInfoService;
	
	public List<CtClass> loadJar(Project project) throws Exception {


		FileUtils.writeByteArrayToFile(new File(project.getJarPath()),
				project.getTestJar());
		
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
			String className = je.getName().substring(0,
					je.getName().length() - 6);
			className = className.replace('/', '.');
			
			CtClass ct = cp.get(className);
			classes.add(ct);
//			generateClassSturcture(classes, project);

//			Class<?> c = cl.loadClass(className);
//			testClasses.add(c);
			
		}
		
		return classes;	 
		
	}
	
	
	private void generateClassSturcture (List<CtClass> classes, Project project) throws Exception {
		
		List<ClassInfo> classInfos = new ArrayList<ClassInfo>();	
		List<TestInfo> testInfos = new ArrayList<TestInfo>();
		for (CtClass class1 : classes) {
			CtMethod[] methods = class1.getMethods();
			ClassInfo classInfo = new ClassInfo();
			
			classInfo.setName(class1.getSimpleName());
			classInfo.setQualifiedName(class1.getName());
			classInfo.setProjectId(project.getId());
			classInfos.add(classInfo);	
			
			classInfoService.save(classInfo);
			
			for (int i = 0; i < methods.length; i++) {
				TestInfo testInfo = new TestInfo();
				testInfo.setName(methods[i].getName());
				testInfo.setClassId(classInfoService.loadBy(class1.getName()).getId());
				testInfos.add(testInfo);	
			}
			testInfoService.saveAll(testInfos);					
		}	
	}
}
