package com.promineo.mockdrafts.team;

import java.util.List;
import com.promineo.mockdrafts.player.Position;

public interface TeamService {
	
  public List<Team> getAllTeams();
  
  public Team saveTeam(Team team);

  public Team updateTeam(Team team, int team_pk);
  
  public List<Team> getTeamName(TeamName name);
  
  public List<Team> getTeamNeeds(Position needs);

}
