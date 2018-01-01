package com.bks.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bks.pojo.Player;
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
	
	@RequestMapping("/search")
	public void search(HttpServletRequest req, HttpServletResponse res) {
		String result ="";
		
		String sid;
		if(req.getParameter("sid") =="") {
			sid =null;
		}else {
			sid =req.getParameter("sid");
		}
		String name;
		if(req.getParameter("name") =="") {
			name =null;
		}else {
			name =req.getParameter("name");
		}
		int number;
		if(req.getParameter("number")=="") {
			number =-1;
		}else {
			number =Integer.valueOf(req.getParameter("number"));
		}
		String position;
		if(req.getParameter("position") =="") {
			position =null;
		}else {
			position =req.getParameter("position");
		}
		String isCaptain =req.getParameter("isCaptain");
		if(req.getParameter("isCaptain") =="") {
			isCaptain =null;
		}else {
			isCaptain =req.getParameter("isCaptain");
		}
		String isManager =req.getParameter("isManager");
		if(req.getParameter("isManager") =="") {
			isManager =null;
		}else {
			isManager =req.getParameter("isManager");
		}
		
		System.out.println(sid+ name+ number+ position+ isCaptain+ isManager);
		
		List<Player> list =playerServiceImpl.search(sid, name, number, position, isCaptain, isManager);
		for(Player ex:list) {
			result += ex.toString() + ",,,,";
		}
		
		try {
			System.out.println(result);
			res.getWriter().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/jsonTest")
	public void jsonTest(HttpServletRequest req, HttpServletResponse res) {
		System.out.println(req.getParameter("name")+req.getParameter("age"));
		try {
			res.getWriter().print(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
