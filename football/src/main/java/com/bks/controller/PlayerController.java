package com.bks.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
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
			//
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
	public ModelAndView regist(Player form, HttpServletRequest req) {
		ModelAndView mav =new ModelAndView("main");
		playerServiceImpl.add(form);
		req.getSession().setAttribute("p", form);
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
	
	@RequestMapping("/uploadFile")
	public ModelAndView uploadFile(HttpServletRequest request) {
		ModelAndView mav =new ModelAndView("main"); 
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
						//存放
						try {
							file.transferTo(new File(rootDir, fileName));
							System.out.println(rootPath);
						} catch (IllegalStateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
			}
			return mav;
		}else {
			System.out.println("0");
			mav.addObject("message", "请选择文件");
			return mav;
		}
	}
	
}
