package com.bks.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.bks.pojo.PFile;
import com.bks.service.impl.PFileServiceImpl;

@Controller
@RequestMapping("")
public class PFileController {
	
	@Autowired
	PFileServiceImpl pfileServiceImpl;
	
	@RequestMapping("/toUpload")
	public String toUpload() {
		System.out.println("到上传文件");
		return "upload";
	}
	
	@RequestMapping("/uploadFile")
	public ModelAndView uploadFile(HttpServletRequest request) {
		ModelAndView mav =new ModelAndView("redirect:/showFiles"); 
		// @RequestParam("file") MultipartFile file,  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext()); 
		//判断有没有文件上传
        if(multipartResolver.isMultipart(request)) {
        	//将请求强转为multipart请求
			MultipartHttpServletRequest req =(MultipartHttpServletRequest) request;
			//获取请求中的所有文件名
			Iterator<String> iter =req.getFileNames();
			//遍历所有文件，
			System.out.println("1");
			while(iter.hasNext()) {
				//取得上传的文件
				MultipartFile file =req.getFile(iter.next());
				System.out.println("1");
				if(file != null) {
					String fileName =file.getOriginalFilename();
					if(fileName.trim() != "") {
						//定义文件存放地址
						String rootPath =req.getSession().getServletContext().getRealPath("/")+"WEB-INF/upload/";
						File rootDir =new File(rootPath);
						rootDir.mkdirs();
						try {
							//存放
							file.transferTo(new File(rootDir, fileName));
							//把上传的文件的信息保存到数据库中
							PFile pfile =new PFile();
							pfile.setFname(fileName);
							pfile.setFpath(rootPath+fileName);
							pfile.setFdate(new Date());
							pfileServiceImpl.add(pfile);
							System.out.println(rootPath);
							
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}else {
						System.out.println("003");
						mav.addObject("message", "请选择文件");
						return mav;
					}
				}else {
					System.out.println("002");
					mav.addObject("message", "002请选择文件");
					return mav;
				}
			}
			return mav;
		}else {
			System.out.println("001");
			mav.addObject("message", "001请选择文件");
			return mav;
		}
	}
	
	@RequestMapping("/showFiles")
	public ModelAndView showFiles() {
		ModelAndView mav =new ModelAndView("showFile");
		List<PFile> list =pfileServiceImpl.findAllFiles();
		mav.addObject("files", list);
		return mav;
	}
	
	@RequestMapping("/DownloadServlet")
	public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
		int fid=Integer.valueOf(request.getParameter("fid"));
		System.out.println(fid);
		PFile file =pfileServiceImpl.findByFid(fid);
		String path =file.getFpath();
		File down =new File(path);
		String frameName =new String(file.getFname().getBytes("GBK"), "ISO8859-1");
		/**
		 * 获取两头一流
		 * Content-Type
		 * Content-Disposition
		 * 流：下载文件数据
		 */
		HttpHeaders headers =new HttpHeaders();
		headers.setContentDispositionFormData("attachment", frameName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(down),headers,HttpStatus.CREATED);
	}
}
