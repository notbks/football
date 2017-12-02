package com.bks.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bks.pojo.Player;
import com.bks.service.impl.PlayerServiceImpl;
import com.bks.util.PlayerPage;

@Controller
@RequestMapping("")
public class CMController {
	@Autowired
	PlayerServiceImpl playerServiceImpl;
	
	@RequestMapping("/toAddMatch")
	public String toAddMatch(Player p) {
		System.out.println("添加比赛信息");
		return "addMatch";
	}
	@RequestMapping("/toAddAnnouncement")
	public String toAddAnnouncement(Player p) {
		System.out.println("发布公告");
		return "addAnnouncement";
	}
	@RequestMapping("/toTransition")
	public String toTransition(Player p) {
		System.out.println("换届");
		return "transition";
	}
	
	@RequestMapping("/transitionCaptain")
	public ModelAndView transitionCaptain(String sid, String isCaptain, HttpServletRequest req) {
		ModelAndView mav =new ModelAndView();
		Player p =playerServiceImpl.findBySid(sid);
		Player admin =(Player) req.getSession().getAttribute("p");
		
		if(isCaptain.equals("是")) {
			//1：修改属性
			p.setIsCaptain("否");
			//2：更新到数据库
			playerServiceImpl.update(p);
			//3：如果修改的是登陆着本身，还需要把属性更新到session
			System.out.println(p.getSid());
			System.out.println(admin.getSid());
			if(p.getSid().equals(admin.getSid())) {
				req.getSession().setAttribute("p", p);
				System.out.println("是本人修改");
			}
			//4：返回到主页，避免权限泄露
			mav.setViewName("/main");
			return mav;
		}else {
			p.setIsCaptain("是");
			playerServiceImpl.update(p);
			mav.setViewName("/main");
			return mav;
		}
	}
	@RequestMapping("/transitionManager")
	public ModelAndView transitionManager(String sid, String isManager, HttpServletRequest req) {
		ModelAndView mav =new ModelAndView();
		Player p =playerServiceImpl.findBySid(sid);
		Player admin =(Player) req.getSession().getAttribute("p");
		
		if(isManager.equals("是")) {
			//1：修改属性
			p.setIsManager("否");
			//2：更新到数据库
			playerServiceImpl.update(p);
			//3：如果修改的是登陆着本身，还需要把属性更新到session
			if(p.getSid()==admin.getSid()) {
				req.getSession().setAttribute("p", p);	
			}
			//4：返回到主页，避免权限泄露
			mav.setViewName("/main");
			return mav;
		}else {
			p.setIsManager("是");
			playerServiceImpl.update(p);
			mav.setViewName("/main");
			return mav;
		}
	}
	
	@RequestMapping("/getAllPlayersForTransition")
    public ModelAndView getAllPlayersForTransition(PlayerPage page){
        ModelAndView mav = new ModelAndView();
        
        List<Player> allPlayers= playerServiceImpl.findAllPlayers();
        mav.addObject("allPlayers", allPlayers);
        // 放入jsp路径
        mav.setViewName("transition");
        return mav;
    }
}
