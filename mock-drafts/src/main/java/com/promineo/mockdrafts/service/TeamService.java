package com.promineo.mockdrafts.service;

import java.util.List;
import com.promineo.mockdrafts.entity.Team;
import com.promineo.mockdrafts.utils.TeamName;

public interface TeamService {
  public List<Team> getAllTeams();
  
  public Team saveTeam(Team team);

  public Team updateTeam(Team team, int team_pk);
  
  public List<Team> getTeamName(TeamName name);

}
