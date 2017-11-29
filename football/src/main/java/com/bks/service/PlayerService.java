package com.bks.service;

import java.util.List;

import com.bks.pojo.Player;

public interface PlayerService {
	List<Player> list();
	Player findBySid(int sid);
}
