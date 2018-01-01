package com.bks.service;

import java.util.List;

import com.bks.pojo.Player;

public interface PlayerService {
	void add(Player player);  
    
    void delete(String sid);  
        
    Player findBySid(String sid);  
      
    void update(Player player);   
        
    List<Player> findAllPlayers();
     
    int count();
    
    List<Player> search(String sid, String name, int number, String position, String isCaptain, String isManager);
}
