package com.feng.util.qiniu;

import java.io.File;
import java.io.IOException;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@RestController
public class UploadUtils {
	
	@Autowired
	private UploadService uploadService;
	
	@RequestMapping(value="/api/upload/normal",method=RequestMethod.POST)
	public void uploadInNormal(@RequestParam MultipartFile file) throws IOException{
		
		CommonsMultipartFile ommonsMultipartFile= (CommonsMultipartFile)file; 
        DiskFileItem diskFileItem = (DiskFileItem)ommonsMultipartFile.getFileItem(); 
        File newFile = diskFileItem.getStoreLocation();
        uploadService.uploadInNormal(newFile);
	}
	
}