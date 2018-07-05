package com.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.util.FileUtils;

@RestController
public class FileController {
    private static Logger logger = LogManager.getLogger(FileController.class);

    @RequestMapping("/upload")
    public String upload(@RequestParam MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空";
        }
        String fileName = file.getOriginalFilename();
        logger.info("上传文件名为：" + fileName);
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传文件后缀名为：" + suffixName);
        String filePath = "E://test//";
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传成功";
    }

    //文件下载相关代码
    @SuppressWarnings("null")
	@RequestMapping("/download")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) {
    	String[] list = request.getParameterValues("filename");
    	List<File> files = new ArrayList<File>();
    	BufferedInputStream bis = null;
	    OutputStream os = null;
    	if (list == null) {
            System.out.println("none list");
    	}else if (list.length == 1){
        	String fileName = list[0].toString(); 
		    response.setHeader("content-type", "application/octet-stream");
		    response.setContentType("application/octet-stream");
		    response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		    byte[] buff = new byte[1024];
		    try {
		         os = response.getOutputStream();
		         bis = new BufferedInputStream(new FileInputStream(new File("E://test//"
		               + fileName)));
		         int j = bis.read(buff);
		         while (j != -1) {
		             	os.write(buff, 0, buff.length);
		             	os.flush();
		             	j = bis.read(buff);
		         	 }
		    } catch (IOException e) {
		         e.printStackTrace();
		    } finally {
		         if (bis != null) {
		              try {
		            	  bis.close();
			          } catch (IOException e) {
			              e.printStackTrace();
			          }
		         }
		    }
        }else {
        	for (int i = 0; i < list.length; i++) {
				File file = new File("E:\\test\\"+list[i]);
				files.add(file);
			}
        	try {
        		response.setHeader("content-type", "application/octet-stream");
    		    response.setContentType("application/octet-stream");
    		    response.setHeader("Content-Disposition", "attachment;filename=" + "tempFile.zip");
				response=FileUtils.downLoadFiles(files, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
    }
    
    //多文件上传
    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File("E://test//"+file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();

                } catch (Exception e) {
                    stream = null;
                    return "You failed to upload " + i + " => "
                            + e.getMessage();
                }
            } else {
                return "You failed to upload " + i
                        + " because the file was empty.";
            }
        }
        return "upload successful";
    }
}
