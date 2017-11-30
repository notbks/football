package com.bks.service;

import java.util.Date;

import org.junit.Test;

import com.bks.pojo.Player;
import com.bks.service.impl.PlayerServiceImpl;

public class Test01 {

	@Test
	public void test() {
	
		PlayerServiceImpl service =new PlayerServiceImpl();
		int sid =30313;
		Player p =service.findBySid(sid);
		System.out.println(p.getName());
		
		Date year =new Date(2014);
		System.out.println(year);
		
	}
	@Test
	public void test01() {
	
		PlayerServiceImpl service =new PlayerServiceImpl();
		Player p =new Player();
		
		p.setCaptain(false);
		p.setManager(false);
		p.setJoinYear(2014);
		p.setMajors(6);
		p.setName("xihaha");
		p.setNumbers(475);
		p.setPassword("123");
		p.setPosition("前锋");
		p.setSid(030312);
		p.setSpecialty("特别帅");
		System.out.println(p.toString());
		service.add(p);
	}

}
