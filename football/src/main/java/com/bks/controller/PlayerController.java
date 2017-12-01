package com.bks.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bks.pojo.Player;
import com.bks.service.impl.PlayerServiceImpl;
import com.bks.util.PlayerPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	 * 重定向：之前的request域失效，使用心得request域
	 * 转发：之前的，之后的都有效
	 * @param form
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/loginController")
	public ModelAndView loginController(Player form, HttpServletRequest req) {
		
		ModelAndView mav =new ModelAndView();
		
		String sid =form.getSid();
		Player p =playerServiceImpl.findBySid(sid);
		
		//判断是否有这个学号
		if(p==null){
			mav.addObject("message", "查无此学号");
			System.out.println("没这个学号");
			
			mav.setViewName("redirect:/login.jsp");
			return mav;
		}
		
		
		System.out.println(p.getPassword()+form.getPassword());
		//判断密码对不对
		if(p.getPassword().equals(form.getPassword())) {
			//------------------------------------------------------------------登陆成功
			//mav.addObject("p", p);
			req.getSession().setAttribute("p", p);
			mav.setViewName("main");
			return mav;
		}else {
			String message ="密码错误";
			System.out.println(message);
			mav.addObject("message", message);
			mav.addObject("sid", sid);
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
	
	@RequestMapping("/toInfo")
	public String toInfo(Player p) {
		System.out.println("daoli");
		return "info";
	}
	
	
	@RequestMapping("/infoController")
	public String updateInfo(Player form, HttpServletRequest req) {
		playerServiceImpl.update(form);
		//更新存放到session中的player
		req.getSession().setAttribute("p", form);
		
		return "main";
	}
	
//	@RequestMapping("/showAllPlayersController")
//	public String showAllPlayers(Page page) {
//		
//		
//		return "main";
//	}
	@RequestMapping("/showAllPlayersController")
    public ModelAndView showAllPlayers(PlayerPage page){
        ModelAndView mav = new ModelAndView();
        PageHelper.offsetPage(page.getStart(),5);
        List<Player> allPlayers= playerServiceImpl.findAllPlayers();
        int total = (int) new PageInfo<>(allPlayers).getTotal();
        //计算最后一页的开始
        page.caculateLast(total);
        System.out.println(page.getLast());
        // 放入转发参数
        mav.addObject("page", page);
        mav.addObject("allPlayers", allPlayers);
        // 放入jsp路径
        mav.setViewName("main");
        return mav;
    }
	
}
