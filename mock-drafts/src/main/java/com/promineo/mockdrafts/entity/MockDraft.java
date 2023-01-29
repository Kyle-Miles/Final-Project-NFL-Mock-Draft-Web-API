package com.promineo.mockdrafts.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mock_draft")
public class MockDraft {
  
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int mock_draft_pk;
  
  @ManyToOne(cascade=CascadeType.DETACH)
  @JoinColumn(name= "team_pk")
  private Team team;
  
  @ManyToOne(cascade=CascadeType.DETACH)
  @JoinColumn(name= "player_pk")
  private Player player;
  
  @ManyToOne(cascade=CascadeType.DETACH)
  @JoinColumn(name= "draft_pk")
  private Draft draft;

  public int getMock_draft_pk() {
    return mock_draft_pk;
  }

  public void setMock_draft_pk(int mock_draft_pk) {
    this.mock_draft_pk = mock_draft_pk;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public Draft getDraft() {
    return draft;
  }

  public void setDraft(Draft draft) {
    this.draft = draft;
  }

}
