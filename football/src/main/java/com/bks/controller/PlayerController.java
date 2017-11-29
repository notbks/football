package com.bks.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bks.pojo.Player;
import com.bks.service.impl.PlayerServiceImpl;

@Controller
@RequestMapping("")
public class PlayerController {
	
	@Autowired
	PlayerServiceImpl playerServiceImpl;
	
	@RequestMapping("/findPlayer")
	public ModelAndView getAllPlayer(HttpServletRequest request) {
		
		System.out.println("controller1");
		ModelAndView mav =new ModelAndView("showPlayer");
		String id =request.getParameter("sid");
		int sid =Integer.valueOf(id);
		System.out.println("controller2");
		Player player =playerServiceImpl.findBySid(sid);
		
		mav.addObject("player", player);
		System.out.println("controller3");
		return mav;
	}
}
