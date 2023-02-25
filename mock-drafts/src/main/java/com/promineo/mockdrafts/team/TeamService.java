package com.promineo.mockdrafts.team;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.promineo.mockdrafts.player.Position;

public interface TeamService {
	
  @Secured("ROLE_USER")	
  public List<Team> getAllTeams();
  
  @Secured("ROLE_ADMIN")
  public Team saveTeam(Team team);

  @Secured("ROLE_ADMIN")
  public Team updateTeam(Team team, int team_pk);
  
  @Secured("ROLE_USER")
  public List<Team> getTeamName(TeamName name);
  
  @Secured("ROLE_USER")
  public List<Team> getTeamNeeds(Position needs);

}
