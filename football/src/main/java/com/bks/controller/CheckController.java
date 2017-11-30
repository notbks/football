package com.bks.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bks.service.impl.PlayerServiceImpl;

@Controller
@RequestMapping("")
public class CheckController {
	@Autowired
	PlayerServiceImpl playerServiceImpl;
	
	@RequestMapping("/checkSid")
	public void checkSid(HttpServletRequest req, HttpServletResponse res) {
		String sid =req.getParameter("sid");
		if(playerServiceImpl.findBySid(sid) ==null) {
			try {
				res.getWriter().print("0");
			} catch (IOException e) {
				System.out.println("虽然没有被注册，但异常了");
				e.printStackTrace();
			}
		}else {
			try {
				res.getWriter().print("1");
			} catch (IOException e) {
				System.out.println("被注册且异常了");
				e.printStackTrace();
			}
		}
	}
}
