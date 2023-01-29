package com.promineo.mockdrafts.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineo.mockdrafts.entity.Team;
import com.promineo.mockdrafts.exception.ResourceNotFoundException;


import com.promineo.mockdrafts.repository.TeamRepository;
import com.promineo.mockdrafts.utils.TeamName;

@Service
public class TeamServiceImpl implements TeamService {
  
  private TeamRepository teamRepository;

  
  @Autowired
  public TeamServiceImpl(TeamRepository teamRepository) {
    this.teamRepository = teamRepository;
  }

  @Override
  public List<Team> getAllTeams() {
    return teamRepository.findAll();
  }

  @Override
  public Team saveTeam(Team team) {
    return teamRepository.save(team);
  }


  @Override
  public Team updateTeam(Team team, int team_pk) {
    Team existingTeam = teamRepository.findById(team_pk).orElseThrow(() ->
    new ResourceNotFoundException("team", "Id", team_pk));
    
    
    existingTeam.setNeeds(team.getNeeds());
    teamRepository.save(team);
    return existingTeam;
  }

  @Override
  public List<Team> getTeamName(TeamName name) {
    return teamRepository.findByName(name);
  }





}
