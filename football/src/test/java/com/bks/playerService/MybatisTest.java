package com.bks.playerService;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bks.pojo.Player;
import com.bks.service.PlayerService;

public class MybatisTest {
	
	@Autowired
	PlayerService playerService;
	
	ApplicationContext context;
	private static SqlSessionFactory factory;
	private static SqlSession session;
	
	@Before
	public void before() {
		context =new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		factory =(SqlSessionFactory) context.getBean("sqlSession");
	}
	
	@Test
	public void test01() {
		session =factory.openSession();
//		Player p =session.selectOne("findBySid","201413030313");
//		System.out.println(p.getName());
		
		List<Player> list =session.selectList("findAllPlayers");
		for(Player ex:list) {
			System.out.println(ex.getName());
		}
	}
	
	@After
	public void after() {
		session.close();
	}
}
