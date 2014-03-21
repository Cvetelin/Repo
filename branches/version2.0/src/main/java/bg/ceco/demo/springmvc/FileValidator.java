package bg.ceco.demo.springmvc;

import org.apache.commons.io.FilenameUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

public class FileValidator implements Validator{

	 @Override
	 public boolean supports(Class<?> arg0) {  
	  // TODO Auto-generated method stub  
	  return false;  
	 }  
	  
	 @Override  
	public void validate(Object uploadedFile, Errors errors) {

		MultipartFile file = (MultipartFile) uploadedFile;

		if (file.getSize() == 0) {
			errors.rejectValue("file", "uploadForm.salectFile",
					"Please select a file!");
		}

		if (!file.isEmpty()
				|| !FilenameUtils.getExtension(file.getName()).equals("jar")) {
			errors.rejectValue("file", "uploadForm.salectFile",
					"File upload faild! File " + file.getName() + " is not jar or it is empty");
		}

	}

}
