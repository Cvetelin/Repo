package bg.ceco.demo.springmvc;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import bg.ceco.demo.model.ClassInfo;
import bg.ceco.demo.model.Project;
import bg.ceco.demo.model.TestInfo;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class JarLoader {

	@Autowired
	public ClassInfo classInfo;
	
	@Autowired 
	public TestInfo testInfo;
	
	public void loadJar(String pathToJar) throws Exception {
		
		JarFile jarFile = new JarFile("C:\\m2\\bugshot\\test\\bugshot-test\\1.0\\bugshot-test-1.0-tests.jar");
        Enumeration<?> e = jarFile.entries();
        
     
        File f = new File("C:\\m2\\bugshot\\test\\bugshot-test\\1.0\\bugshot-test-1.0-tests.jar");
        URL[] urls = { f.toURI().toURL()};
        URLClassLoader cl = URLClassLoader.newInstance(urls);

        ClassPool cp = ClassPool.getDefault();
        while (e.hasMoreElements()) {
            JarEntry je = (JarEntry) e.nextElement();
            if(je.isDirectory() || !je.getName().endsWith("Test.class")){
                continue;
            }
            // -6 because of .class
            String className = je.getName().substring(0,je.getName().length()-6);
            className = className.replace('/', '.');
            
            CtClass ct = cp.get(className);
            CtMethod [] ctmethod = ct.getMethods();            
            
           
            Class<?> c = cl.loadClass(className);
            System.out.println ("Success!");            
        }
	}
        
        public void loadJar(Project project) throws Exception {
    		FileUtils.writeByteArrayToFile(new File(project.getJarPath()), project.getTestJar());       	
        
    		JarFile jarFile = new JarFile(project.getJarPath());
            Enumeration<?> e = jarFile.entries();            
            
            File f = new File(project.getJarPath());
            URL[] urls = { f.toURI().toURL()};
            URLClassLoader cl = URLClassLoader.newInstance(urls);

            ClassPool cp = ClassPool.getDefault();
            while (e.hasMoreElements()) {
                JarEntry je = (JarEntry) e.nextElement();
                if(je.isDirectory() || !je.getName().endsWith("Test.class")){
                    continue;
                }
                // -6 because of .class
                String className = je.getName().substring(0,je.getName().length()-6);
                className = className.replace('/', '.');
                
                CtClass ct = cp.get(className);
                CtMethod [] ctmethod = ct.getMethods();            
                
               
                Class<?> c = cl.loadClass(className);
                System.out.println ("Success!");            
            }
        
        
		
//	    File f = new File("C:\\m2\\bugshot\\test\\bugshot-test\\1.0\\bugshot-test-1.0-tests.jar");
//	    URLClassLoader urlCl = new URLClassLoader(new URL[] { f.toURI().toURL()},System.class.getClassLoader());
//	    Class<?> cls = urlCl.loadClass("web.test.login.LoginTest");
//	    cls.newInstance();
//	    System.out.println ("Success!");  
	  }
}
