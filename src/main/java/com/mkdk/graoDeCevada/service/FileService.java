package com.mkdk.graoDeCevada.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import com.mkdk.graoDeCevada.model.Cerveja;

@Component
public class FileService {
	
	private String uploadsDir = "src/main/resources/static/uploads/";
	private String dirCerveja = "cervejas/";
	
	private String getRealPath(){
		File currDir = new File(".");
	    String path = currDir.getAbsolutePath();
	    path = path.substring(0, path.length()-1);
	    
	    return path + uploadsDir;
	}
	
	public String write(MultipartFile file){
		
	    String realPathtoUploads =  this.getRealPath();
	    
		try {
            if(! new File(realPathtoUploads).exists())
            {
                new File(realPathtoUploads).mkdir();
            }

            String orgName = file.getOriginalFilename();
            
            String filePath = realPathtoUploads + orgName;
            File dest = new File(filePath);
            file.transferTo(dest);
            return filePath;
		
		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String uploadFotoCerveja(MultipartFile file){
		
	    String path = this.getRealPath();
	    String realPathtoUploads =  path + dirCerveja;
	    
		try {
            if(! new File(realPathtoUploads).exists())
            {
                new File(realPathtoUploads).mkdir();
            }

            String orgName = file.getOriginalFilename();
            String ext = "." + FilenameUtils.getExtension(orgName);
            String nome = DigestUtils.md5DigestAsHex(file.getInputStream()) + ext;
            
            String filePath = realPathtoUploads + nome;
            File dest = new File(filePath);
            file.transferTo(dest);
            
            return nome;
		
		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
