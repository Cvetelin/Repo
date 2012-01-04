package bg.ceco.demo.struts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import bg.ceco.demo.logic.AdministrationService;
import bg.ceco.demo.model.Person;

public class ShowMembersAction extends Action {
	
	private static final String SCREENS_LOCATION = "\\src\\main\\webapp\\screenshots";
	private static final String GALERY_INDEX_LOCATION = "\\src\\main\\webapp\\Galery.html";
	private static final String TAB= "\t\t\t\t\t\t\t\t\t\t\t\t\t";
	private static final String URL = "http://localhost:8080/screenshots/";
	private static final String FORWARD_SUCCESS = "success";
	
	@Autowired
	private AdministrationService adminService;

	private String message;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Collection<Person> listMembers = adminService.listMembers();
		for (Person person : listMembers) {
			System.out.println(person.getPermission());
		}
		request.setAttribute("members", listMembers);
		message = "Message";
		newMethod(mapping, 6);
		return mapping.findForward(FORWARD_SUCCESS);
	}
	
	private void newMethod(ActionMapping mapping, int i) {
		System.out.println("The newly created method showMemebers -- " + i);
		System.out.println("Message (showMemebers)=" + message);
		System.out.println(message);
		print(message);
	}
	
	public static void print(String str) {
		System.out.println("(showMemebers) -Eto go i meg=ssage-to" + str);
	}
	
public void checkFiles () throws Exception{
		
		InputStream  io = Thread.currentThread().getContextClassLoader().getResourceAsStream("galery/Galery.jsp");
		Reader reader = new InputStreamReader(io);
		BufferedReader rader = new BufferedReader(reader);
		FileWriter write = new FileWriter(galery()); 
		
		try {		
			List <File> listFiles = new ArrayList<File>();			
			File dir = new File(sceensLocationPath());
			  for (File child : dirListByAscendingDate(dir)) {			  
			    if (".".equals(child.getName()) || "..".equals(child.getName())) {
			      continue;  // Ignore the self and parent aliases.\
			     }		    
			    listFiles.add(child);
			  }			  
			  
			  StringBuilder builder = new StringBuilder();		 
			  for (int i=0; i<listFiles.size(); i++){			 
				  String screenShot = listFiles.get(i).toString().replace(sceensLocationPath()+"\\", URL);
				  builder.append(TAB+"{image : '"+ screenShot+"'},\n");	
			  }
			  
			 String line = null;			
			 while ((line = rader.readLine()) !=null){
				 if (line.contains("{placeholder}")){
					 line = line.replace("{placeholder}", builder);
				 }
				 write.write(line+"\n");
			 }	
		 } finally {
			 IOUtils.closeQuietly(reader);
			 IOUtils.closeQuietly(io);
			 IOUtils.closeQuietly(reader);
			 IOUtils.closeQuietly(write);
		 }
	}
		
	private static String sceensLocationPath() throws Exception{
		File rootDir = new File (".");
		String pathToFiles  =  rootDir.getCanonicalPath() + SCREENS_LOCATION;
		return pathToFiles;
	}
	
	private static String galery() throws Exception{
		File rootDir = new File (".");
		String pathToGalery  =  rootDir.getCanonicalPath() + GALERY_INDEX_LOCATION;
		return pathToGalery;
	}
		
	@SuppressWarnings("unchecked")
	private static File[] dirListByAscendingDate(File folder) {
	   if (!folder.isDirectory()) {
	     return null;
	   }
	   File [] files = folder.listFiles();
	   Arrays.sort( files, new Comparator()
	   {
	     public int compare(final Object o1, final Object o2) {
	       return new Long(((File)o1).lastModified()).compareTo
	            (new Long(((File) o2).lastModified()));
	     }
	   }); 
	   return files;
	}  
	
}
