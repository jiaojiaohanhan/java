package com.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.MyException;

public class FileUtils {
	private static Logger logger = LogManager.getLogger(FileUtils.class);
	private static final String ROOT = setRootDirectory();
	/**
	 * 获取应用当前绝对根路径，并基于根路径创建应用上传目录
	 * @return
	 */
	private static String setRootDirectory() {
		String webapp = System.getProperty("SEWeb.root");
		logger.debug("SEWeb.root: " + webapp);
		String uploadDirectory = webapp + "/WEB-INF/jsp/upload/";
		logger.debug("Upload Directory: " + uploadDirectory);
		Path path = Paths.get(uploadDirectory);
		// 判断路径是否为目录
		if (!Files.isDirectory(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new MyException("创建上传文件目录错误！" + e.getMessage());
			}
		}
		return uploadDirectory;
	}
	/**
	 * 应用通用的上传文件处理
	 * @param bytes
	 * @param path
	 */
	public static void copy(byte[] bytes, Path path) {
		try {
			path = Paths.get(ROOT + path);
			logger.debug(path);
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new MyException("文件写入错误！" + e.getMessage());
		}
	}
	
	public static ResponseEntity<byte[]> toResponseEntity(Path path) {
		ResponseEntity<byte[]> entity = null;
		try {
			path = Paths.get(ROOT + path);
			// 声明附件名称
			String fileName = URLEncoder.encode(path.getFileName().toString(), "UTF-8");
			HttpHeaders headers = new HttpHeaders();
			// 声明响应类型为流
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			// 声明返回文件名称
			headers.setContentDispositionFormData("attachment", fileName);
			// 创建封装文件二进制字节数组、HTTP状态码、HTTP头的响应实体
			entity = new ResponseEntity<byte[]>(Files.readAllBytes(path), 
					headers, 
					HttpStatus.OK);
			return entity;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new MyException("文件加载错误！" + e.getMessage());
		}
	}
	
	public static List<String> getAllFile(String directoryPath,Boolean isAddDirectory) {
        List<String> list = new ArrayList<String>();
        File baseFile = new File(directoryPath);
        if (baseFile.isFile() || !baseFile.exists()) {
            return list;
        }
        File[] files = baseFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                if(isAddDirectory){
                    list.add(file.getAbsolutePath());
                }
                list.addAll(getAllFile(file.getAbsolutePath(),isAddDirectory));
            } else {
                list.add(file.getName());
            }
        }
        return list;
    }
	
//	public static void zipFile(File inputFile,ZipOutputStream zipoutputStream) {  
//        try {  
//            if(inputFile.exists()) { //判断文件是否存在  
//                if (inputFile.isFile()) {  //判断是否属于文件，还是文件夹  
//
//                    //创建输入流读取文件  
//                    FileInputStream fis = new FileInputStream(inputFile);  
//                    BufferedInputStream bis = new BufferedInputStream(fis);  
//
//                    //将文件写入zip内，即将文件进行打包  
//                    ZipEntry ze = new ZipEntry(inputFile.getName()); //获取文件名  
//                    zipoutputStream.putNextEntry(ze);     
//
//                    //写入文件的方法，同上                  
//                    byte [] b=new byte[1024];  
//                long l=0;  
//                while(l<inputFile.length()){  
//                    int j=bis.read(b,0,1024);  
//                    l+=j;  
//                    zipoutputStream.write(b,0,j);  
//                }  
//                    //关闭输入输出流  
//                    bis.close();  
//                    fis.close();  
//                } else {  //如果是文件夹，则使用穷举的方法获取文件，写入zip  
//                    try {  
//                        File[] files = inputFile.listFiles();  
//                        for (int i = 0; i < files.length; i++) {  
//                            zipFile(files[i], zipoutputStream);  
//                        }  
//                    } catch (Exception e) {  
//                        e.printStackTrace();  
//                    }  
//                }  
//            }  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        }  
//	}  
	
	public static HttpServletResponse downLoadFiles(List<File> files,HttpServletResponse response)throws Exception {
        try {
           //List<File> 作为参数传进来，就是把多个文件的路径放到一个list里面
           //创建一个临时压缩文件
           //临时文件可以放在CDEF盘中，但不建议这么做，因为需要先设置磁盘的访问权限，最好是放在服务器上，方法最后有删除临时文件的步骤

            String zipFilename =  "E:/tempFile.zip" ;
            File file = new File(zipFilename); 
            if (!file.exists()){   
                file.createNewFile();   
            }
            response.reset();
            //response.getWriter()
            //创建文件输出流
            FileOutputStream fous = new FileOutputStream(file);   
            ZipOutputStream zipOut = new ZipOutputStream(fous);
            zipFile(files, zipOut);
            zipOut.close();
            fous.close();
            return downloadZip(file,response);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
	 /**
     * 把接受的全部文件打成压缩包 
     * @param List<File>;  
     * @param org.apache.tools.zip.ZipOutputStream  
     */
    public static void zipFile (List files,ZipOutputStream outputStream) {
        int size = files.size();
        for(int i = 0; i < size; i++) {
            File file = (File) files.get(i);
            zipFile(file, outputStream);
        }
    }
    /**  
     * 根据输入的文件与输出流对文件进行打包
     * @param File
     * @param org.apache.tools.zip.ZipOutputStream
     */
    public static void zipFile(File inputFile,  ZipOutputStream ouputStream) {
        try {
            if(inputFile.exists()) {
                if (inputFile.isFile()) {
                    FileInputStream IN = new FileInputStream(inputFile);
                    BufferedInputStream bins = new BufferedInputStream(IN, 512);
                    ZipEntry entry = new ZipEntry(inputFile.getName());
                    ouputStream.putNextEntry(entry);
                    // 向压缩文件中输出数据   
                    int nNumber;
                    byte[] buffer = new byte[512];
                    while ((nNumber = bins.read(buffer)) != -1) {
                        ouputStream.write(buffer, 0, nNumber);
                    }
                    // 关闭创建的流对象   
                    bins.close();
                    IN.close();
                } else {
                    try {
                        File[] files = inputFile.listFiles();
                        for (int i = 0; i < files.length; i++) {
                            zipFile(files[i], ouputStream);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static HttpServletResponse downloadZip(File file,HttpServletResponse response) {
        if(file.exists() == false){  
            System.out.println("待压缩的文件目录："+file+"不存在.");  
        }else{ 
            try {
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
    
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
    
            //如果输出的是中文名的文件，在此处就要用URLEncoder.encode方法进行处理
            response.setHeader("Content-Disposition", "attachment;filename="
                    + new String(file.getName().getBytes("GB2312"), "ISO8859-1"));
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
            } catch (IOException ex) {
            ex.printStackTrace();
            }finally{
                 try {
                        File f = new File(file.getPath());
                        f.delete();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }
        return response;
    }
}
