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

import com.bks.pojo.PFile;
import com.bks.service.impl.PFileServiceImpl;
import com.bks.service.impl.PlayerServiceImpl;

public class MybatisTest {
	
	@Autowired
	PlayerServiceImpl playerService;
	@Autowired
	PFileServiceImpl pfileServiceImpl;
	
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
		
		PFile file =session.selectOne("findByFid", 3);
		System.out.println(file.getFid());
		
		
//		List<PFile> list =session.selectList("findAllFiles");
//		for(PFile ex:list) {
//			System.out.println(ex.getFname());
//		}
		
//		List<Player> allPlayers= session.selectList("findAllPlayers");
//		for(Player ex:allPlayers) {
//			System.out.println(ex.getName());
//		}
		
//		Player p =new Player();
//		p.setSid("12345678");
//		session.insert("add", p);
		
//		Player p =session.selectOne("findBySid","201413030313");
//		System.out.println(p.getName());
		
//		List<Player> list =session.selectList("findAllPlayers");
//		for(Player ex:list) {
//			System.out.println(ex.getName());
//		}
	}
	
	@After
	public void after() {
		session.close();
	}
}
