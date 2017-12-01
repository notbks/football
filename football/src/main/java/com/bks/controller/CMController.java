package com.bks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bks.pojo.Player;
import com.bks.service.impl.PlayerServiceImpl;
import com.bks.util.PlayerPage;
import com.bks.util.PlayersList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
	
	@RequestMapping("/transition")
	public ModelAndView transition(PlayersList allPlayers) {
		ModelAndView mav =new ModelAndView();
		for(Player ex:allPlayers.getList()) {
			playerServiceImpl.update(ex);
		}
		System.out.println("sdfadsf");
		mav.setViewName("/showAllPlayersController");
		return mav;
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
