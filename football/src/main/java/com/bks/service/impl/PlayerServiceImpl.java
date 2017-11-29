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

	public List<Player> list() {
		return playerMapper.findAllPlayers();
	}
	
	public Player findBySid(int sid) {
		return playerMapper.findBySid(sid);
	}

}
