package com.promineo.mockdrafts.player;

import java.util.List;

public interface PlayerService {
	
  public Player savePlayer(Player player);
  
  public List<Player> getAllPlayers();
  
  public List <Player> getPlayersByPosition(Position position);
  
  public Player getPlayerById(int id);
  
  public Player updatePlayer(Player player, int id);
  
  public void deletePlayer(int id);
  
  public List <Player> getPlayersByOvrRank();

}
