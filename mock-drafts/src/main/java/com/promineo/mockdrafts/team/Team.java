package com.promineo.mockdrafts.team;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.promineo.mockdrafts.mockdraft.MockDraft;
import com.promineo.mockdrafts.needs.Needs;

@Entity
@Table(name = "team")
public class Team {
  
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int teamPk;
  
  //refer to com.promineo.mockdrafts.utils.TeamName for enum values when mapping to API
  @Enumerated(EnumType.STRING)
  private TeamName teamName; 
  
  @Enumerated(EnumType.STRING)
  private TeamConference teamConference;
  
  @Enumerated(EnumType.STRING)
  private TeamDivision teamDivision;

@ManyToMany(
	fetch = FetchType.EAGER,
    cascade = {CascadeType.DETACH})
  @Fetch(value=FetchMode.SELECT)
  @JoinTable(name = "team_needs",
    joinColumns = { @JoinColumn(name = "team_pk") },
    inverseJoinColumns = { @JoinColumn(name = "needs_pk")})
  private Set<Needs> needs = new HashSet<>();
  
  @OneToMany(mappedBy = "team")
  private Set <MockDraft> mockDraft;

  public int getTeam_pk() {
    return teamPk;
  }

  public void setTeam_pk(int team_pk) {
    this.teamPk = team_pk;
  }

  public TeamName getTeam_name() {
    return teamName;
  }

  public void setTeam_name(TeamName team_name) {
    this.teamName = team_name;
  }
  
  public TeamConference getTeamConference() {
	return teamConference;
}

public void setTeamConference(TeamConference team_conference) {
	this.teamConference = team_conference;
}

public TeamDivision getTeamDivision() {
	return teamDivision;
}

public void setTeamDivision(TeamDivision team_division) {
	this.teamDivision = team_division;
}

  public Set<Needs> getNeeds() {
    return needs;
  }

  public void setNeeds(Set<Needs> needs) {
    this.needs = needs;
  }

}
