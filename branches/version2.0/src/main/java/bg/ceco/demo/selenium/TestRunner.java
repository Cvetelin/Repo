package bg.ceco.demo.selenium;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




public class TestRunner {

	
	public static void runClass () {
		URL gbla =ClassLoader.class.getResource("bg.ceco.test");
	   Reflections reflectionss = new Reflections(ClasspathHelper.forPackage("bg.ceco.demo"));
		  
	//	  reflections.getMethodsAnnotatedWith(Test.class);
		   List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
		   classLoadersList.add(ClasspathHelper.contextClassLoader());
		   classLoadersList.add(ClasspathHelper.staticClassLoader());
		  
		  Reflections reflections = new Reflections(new ConfigurationBuilder()
		    .setScanners(new SubTypesScanner(false /* don't exclude Object.class */), new ResourcesScanner())
		    .setUrls(ClasspathHelper.forJavaClassPath())
		    .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("bg.ceco.test.springmvc"))));
		  Set<Method> methods = reflections.getMethodsAnnotatedWith(RequestMapping.class);
		  int i = 1; 
		  
		  
		  Reflections ref =  new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forJavaClassPath()).setScanners(new ResourcesScanner()));
		  Set<Method> das = ref.getMethodsAnnotatedWith(Test.class);
		  i=2;
	}
//	public static void bla(String[] args) {
//		JUnitCore runner = new JUnitCore();
//		runner.addListener(new TestListener());
//		runner.run(ProjectsIntegrationTest.class);
//	}
}
