package com.bks.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		String sid =request.getParameter("sid");
		Player player =playerServiceImpl.findBySid(sid);
		
		mav.addObject("player", player);
		System.out.println("controller3");
		return mav;
	}
	/**
	 * redirect:/index这样使message无效
	 * @param form
	 * @return
	 */
	@RequestMapping("/loginController")
	public ModelAndView loginController(Player form, RedirectAttributes ra, ModelMap mm) {
		
		ModelAndView mav =new ModelAndView();
		
		String sid =form.getSid();
		Player p =playerServiceImpl.findBySid(sid);
		
		//判断是否有这个学号
		if(p==null){
//			mav.addObject("message", "查无此学号");
//			System.out.println("没这个学号");
			mm.addAttribute("message", "查无此学号");
			
			mav.setViewName("redirect:/login.jsp");
			return mav;
		}
		
		
		System.out.println(p.getPassword()+form.getPassword());
		//判断密码对不对
		if(p.getPassword().equals(form.getPassword())) {
			//登陆成功
			mav.addObject(p);
			mav.setViewName("main");
			return mav;
		}else {
			String message ="密码错误";
			System.out.println(message);
//			mav.addObject("message", message);
			ra.addFlashAttribute("sid", p.getSid());
			ra.addFlashAttribute(message);
			
			mav.setViewName("redirect:/login.jsp");
			return mav;
		}
	}
	
	@RequestMapping("/registController")
	public ModelAndView regist(Player form) {
		ModelAndView mav =new ModelAndView("main");
		
		playerServiceImpl.add(form);
		mav.addObject(form);
		return mav;
	}
	
	@RequestMapping("/infoController")
	public String updateInfo() {
		
		return "info";
	}
	
}
