package com.promineo.mockdrafts.entity;


import com.promineo.mockdrafts.utils.Position;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "player")
public class Player {
  
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  
  private int playerPk;
  
  private String playerName;
  
  //refer to com.promineo.mockdrafts.utils.Position for enum values when mapping to API
  @Enumerated(EnumType.STRING)
  private Position position;
  
  private String college;
  
  private int ovrRank;

  
  @OneToMany(mappedBy = "player")
  private Set <MockDraft> mockDraft;
 

  public int getPlayer_pk() {
    return playerPk;
  }

  public void setPlayer_pk(int player_pk) {
    this.playerPk = player_pk;
  }

  public String getPlayer_name() {
    return playerName;
  }

  public void setPlayer_name(String player_name) {
    this.playerName = player_name;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public String getCollege() {
    return college;
  }

  public void setCollege(String college) {
    this.college = college;
  }

  public int getOvr_rank() {
    return ovrRank;
  }

  public void setOvr_rank(int ovr_rank) {
    this.ovrRank = ovr_rank;
  }

}
