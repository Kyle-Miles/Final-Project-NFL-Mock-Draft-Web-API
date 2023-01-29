package com.promineo.mockdrafts.service;

import java.util.List;
import com.promineo.mockdrafts.entity.Player;
import com.promineo.mockdrafts.utils.Position;

public interface PlayerService {
  public Player savePlayer(Player player);
  
  public List<Player> getAllPlayers();
  
  public List <Player> getPlayersByPosition(Position position);
  
  public Player getPlayerById(int id);
  
  public Player updatePlayer(Player player, int id);
  
  public void deletePlayer(int id);

}
