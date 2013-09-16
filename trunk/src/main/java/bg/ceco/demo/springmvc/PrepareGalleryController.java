package bg.ceco.demo.springmvc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PrepareGalleryController  {
	
	private static final String FORWARD_SUCCESS = "success";
	private static final String GALERY_INDEX_LOCATION = "\\src\\main\\webapp\\WEB-INF\\jsp\\PrepareGallery.jsp";
	private static final String TAB = "\t\t\t\t\t\t\t\t\t\t\t\t\t";
	private static final String URL = "http://localhost:8080/";
	private static final String WEB ="\\src\\main\\webapp\\";	
	private static Logger log = Logger.getLogger(PrepareGalleryController.class.getName());
	
	@RequestMapping(value="/PrepareGallery", method = RequestMethod.GET)
	public String prepareGalery(@RequestParam("filesRoot") String path) {
		try {			
			readWriteGallery(path);
		} catch (Exception e) {
			log.info(e);
		}
		return "PrepareGallery";
	}
	
	
//	public ActionForward execute (ActionMapping mapping, ActionForm form, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		String pathToFiles = request.getParameter("executionTimeAsFolder");
//		readWriteGallery(pathToFiles);
//		return mapping.findForward(FORWARD_SUCCESS);		
//	}
	
	
	private void readWriteGallery(String sceensLocationPath) throws Exception {
		InputStream io = Thread.currentThread().getContextClassLoader().getResourceAsStream("gallery/Gallery.jsp");
		Reader reader = new InputStreamReader(io);
		BufferedReader rader = new BufferedReader(reader);
		FileWriter write = new FileWriter(galery());

		try {
			List<File> listFiles = new ArrayList<File>();
			StringBuilder builder = new StringBuilder();
			File dir = new File(sceensLocationPath);
			for (File filesInDir : dirListByAscendingDate(dir)) {
				if (".".equals(filesInDir.getName()) || "..".equals(filesInDir.getName())) {
					continue; // Ignore the self and parent aliases.\
				}
				listFiles.add(filesInDir);
			}
			for (int i = 0; i < listFiles.size(); i++) {
				String screenShotLocation = listFiles.get(i).toString().replace(sceensLocationPath.concat("\\"),
						constructURL(sceensLocationPath.concat("\\")));
				builder.append(TAB);
				builder.append("{image : '");
				builder.append(screenShotLocation);
				builder.append("'},\n");
			}
			String line = null;
			while ((line = rader.readLine()) != null) {
				if (line.contains("{placeholder}")) {
					line = line.replace("{placeholder}", builder);
				}
				write.write(line + "\n");
			}
		} finally {
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(io);
			IOUtils.closeQuietly(write);
		}
	}
	
	private static String galery() throws Exception {
		File rootDir = new File(".");
		String pathToGalery = rootDir.getCanonicalPath() + GALERY_INDEX_LOCATION;
		return pathToGalery;
	}
	
	private String constructURL(String pathToFiles) throws Exception{
		File rootDir = new File(".");
		String root = rootDir.getCanonicalPath()+ WEB;		
		String replacedPath = pathToFiles.replace(root, "http://localhost:8080/");
		StringBuilder builder = new StringBuilder(replacedPath.replace("\\", "/"));
		return builder.toString();
	}
	
	@SuppressWarnings("unchecked")
	private static File[] dirListByAscendingDate(File folder) {
		if (!folder.isDirectory()) {
			return null;
		}
		File[] files = folder.listFiles();
		Arrays.sort(files, new Comparator() {
			public int compare(final Object o1, final Object o2) {
				return new Long(((File) o1).lastModified()).compareTo(new Long(((File) o2).lastModified()));
			}
		});
		return files;
	}
}
