package com.bks.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bks.pojo.Player;
import com.bks.service.impl.PlayerServiceImpl;
/**
 * mav默认转发方式 forword
 * 用重定向redirect：冲破view Resolver舒服
 * @author whj82
 *
 */
@Controller
@RequestMapping("")
public class PlayerController {
	
	@Autowired
	PlayerServiceImpl playerServiceImpl;
	
	@RequestMapping("/findPlayer")
	public ModelAndView getAllPlayer(HttpServletRequest request) {
		
		ModelAndView mav =new ModelAndView("regist");
		String id =request.getParameter("sid");
		int sid =Integer.valueOf(id);
		System.out.println("controller2");
		
		Player player =playerServiceImpl.findBySid(sid);
		
		mav.addObject("player", player);
		System.out.println("controller3");
		return mav;
	}
	
	@RequestMapping("/loginController")
	public ModelAndView loginController(Player form) {
		
		ModelAndView mav =new ModelAndView();
		
		int sid =form.getSid();
		Player p =playerServiceImpl.findBySid(sid);
		//判断是否有这个学号
		if(p==null){
			String message ="查无此学号";
			mav.addObject("message", message);
			System.out.println(message);
			mav.setViewName("redirect:/login.jsp");
			return mav;
		}
		//判断密码对不对
		if(p.getPassword()==form.getPassword() && p.getName()==form.getName()) {
			mav.setViewName("main");
			return mav;
		}else if(p.getPassword()!=form.getPassword()) {
			String message ="密码错误";
			System.out.println(message);
			mav.addObject("message", message);
			mav.setViewName("redirect:/login.jsp");
			return mav;
		}
		return mav;
	}
	
	@RequestMapping("/registController")
	public ModelAndView regist(Player form) {
		ModelAndView mav =new ModelAndView("main");
		
		playerServiceImpl.add(form);
		mav.addObject(form);
		return mav;
	}
}
