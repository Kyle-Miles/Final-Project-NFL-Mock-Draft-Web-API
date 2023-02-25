package com.promineo.mockdrafts.player;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

public interface PlayerService {
	
  @Secured("ROLE_ADMIN")
  public Player savePlayer(Player player);
  
  @Secured("ROLE_USER")
  public List<Player> getAllPlayers();
  
  @Secured("ROLE_USER")
  public List <Player> getPlayersByPosition(Position position);
  
  @Secured("ROLE_USER")
  public Player getPlayerById(int id);
  
  @Secured("ROLE_ADMIN")
  public Player updatePlayer(Player player, int id);
  
  @Secured("ROLE_ADMIN")
  public void deletePlayer(int id);
  
  @Secured("ROLE_USER")
  public List <Player> getPlayersByOvrRank();

}
