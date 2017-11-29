package com.bks.service;

import org.junit.Test;

import com.bks.pojo.Player;
import com.bks.service.impl.PlayerServiceImpl;

public class Test01 {

	@Test
	public void test() {
	
		PlayerServiceImpl service =new PlayerServiceImpl();
		int sid =030313;
		Player p =service.findBySid(sid);
		System.out.println(p.getName());
	}

}
