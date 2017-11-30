package com.bks.service;

import java.util.List;

import com.bks.pojo.Player;

public interface PlayerService {
	void add(Player player);  
    
    void delete(int sid);  
        
    Player findBySid(int sid);  
      
    void update(Player player);   
        
    List<Player> findAllPlayers();
     
    int count();
}
