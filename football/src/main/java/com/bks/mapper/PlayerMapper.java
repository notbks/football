package com.bks.mapper;

import java.util.List;

import com.bks.pojo.Player;

public interface PlayerMapper {
	public void add(Player player);  
    
    public void delete(int sid);  
        
    public Player findBySid(int sid);  
      
    public void update(Player player);   
        
    public List<Player> findAllPlayers();
     
    public int count();
}
