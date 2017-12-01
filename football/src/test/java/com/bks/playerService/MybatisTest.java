package com.bks.playerService;

import org.junit.Test;

import com.bks.service.impl.PlayerServiceImpl;

public class MybatisTest {
	
	@Test
	public void test01() {
		PlayerServiceImpl service=new PlayerServiceImpl();
		
		System.out.println(service.findAllPlayers());
	}
}
