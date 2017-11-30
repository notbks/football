package com.bks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bks.mapper.PlayerMapper;
import com.bks.pojo.Player;
import com.bks.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService{
	
	@Autowired
	PlayerMapper playerMapper;

	public Player findBySid(String sid) {
		return playerMapper.findBySid(sid);
	}

	public void add(Player player) {
		playerMapper.add(player);
	}

	public void delete(String sid) {
		playerMapper.delete(sid);
	}

	public void update(Player player) {
		playerMapper.update(player);
	}

	public List<Player> findAllPlayers() {
		try {
			return playerMapper.findAllPlayers();
		}catch(Exception e) {
			return null;
		}
	}

	public int count() {
		try {
			return playerMapper.count();
		}catch(Exception e) {
			return 0;
		}
	}

}
