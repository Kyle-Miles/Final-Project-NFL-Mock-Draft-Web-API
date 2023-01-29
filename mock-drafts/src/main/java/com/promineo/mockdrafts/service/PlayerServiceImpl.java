package com.promineo.mockdrafts.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineo.mockdrafts.entity.Player;
import com.promineo.mockdrafts.exception.ResourceNotFoundException;
import com.promineo.mockdrafts.repository.PlayerRepository;
import com.promineo.mockdrafts.utils.Position;


@Service
public class PlayerServiceImpl implements PlayerService {
  
  private PlayerRepository playerRepository;
  
  @Autowired
  public PlayerServiceImpl(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

  @Override
  public Player savePlayer(Player player) {
    return playerRepository.save(player);
  }

  @Override
  public List<Player> getAllPlayers() {
    return playerRepository.findAll();
  }

  @Override
  public Player getPlayerById(int id) {
    return playerRepository.findById(id).orElseThrow(() -> 
    new ResourceNotFoundException("player", "Id", id));
  }

  @Override
  public Player updatePlayer(Player player, int id) {
    Player existingPlayer = playerRepository.findById(id).orElseThrow(() ->
    new ResourceNotFoundException("player", "Id", id));
    
    existingPlayer.setPlayer_name(player.getPlayer_name());
    existingPlayer.setPosition(player.getPosition());
    existingPlayer.setCollege(player.getCollege());
    existingPlayer.setOvr_rank(player.getOvr_rank());
    playerRepository.save(existingPlayer);
    return existingPlayer;
  }

  @Override
  public void deletePlayer(int id) {
    @SuppressWarnings("unused")
    Player existingPlayer = playerRepository.findById(id).orElseThrow(() ->
    new ResourceNotFoundException("player", "Id", id));
    
    playerRepository.deleteById(id);
  }

  @Override
  public List <Player> getPlayersByPosition(Position position) {
    return playerRepository.findByPosition(position);
   
  }
  

}
