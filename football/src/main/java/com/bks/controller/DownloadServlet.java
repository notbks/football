package com.bks.controller;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bks.mapper.PFileMapper;
import com.bks.pojo.PFile;
import com.bks.service.impl.PFileServiceImpl;

public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	PFileServiceImpl pfileServiceImpl =new PFileServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int fid=Integer.valueOf(request.getParameter("fid"));
		System.out.println(fid);
		PFile file =pfileServiceImpl.findByFid(fid);
		String path =file.getFpath();
		String frameName =new String(file.getFname().getBytes("GBK"), "ISO8859-1");
		/**
		 * 获取两头一流
		 * Content-Type
		 * Content-Disposition
		 * 流：下载文件数据
		 */
		String contentType =this.getServletContext().getMimeType(path);
		String contentDisposition ="attachment;filename="+frameName;
		FileInputStream input =new FileInputStream(path);
		
		/**
		 * 设置头
		 */
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Disposition", contentDisposition);
		
		//获取绑定了客户端的流
		ServletOutputStream output= response.getOutputStream();
		//用到了commons-io.jar
		IOUtils.copy(input, output);
		input.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			}

}
