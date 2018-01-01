package com.bks.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bks.pojo.Player;

public interface PlayerMapper {
	public void add(Player player);  
    
    public void delete(String sid);  
        
    public Player findBySid(String sid);  
      
    public void update(Player player);   
        
    public List<Player> findAllPlayers();
     
    public int count();
    
    public List<Player> search(@Param("sid")String sid, @Param("name")String name,
    		@Param("number")int number, @Param("position")String position,
    		@Param("isCaptain")String isCaptain, @Param("isManager")String isManager);
}
