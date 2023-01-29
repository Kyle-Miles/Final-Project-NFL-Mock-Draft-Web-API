package com.promineo.mockdrafts.entity;


import org.springframework.data.relational.core.mapping.Column;
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
  
  private int player_pk;
  
  @Column(value= "player_name")
  private String player_name;
  
  //refer to com.promineo.mockdrafts.utils.Position for enum values when mapping to API
  @Column(value= "position")
  @Enumerated(EnumType.STRING)
  private Position position;
  
  @Column(value= "college")
  private String college;
  
  @Column(value= "ovr_rank")
  private int ovr_rank;

  
  @OneToMany(mappedBy = "player")
  private Set <MockDraft> mockDraft;
 

  public int getPlayer_pk() {
    return player_pk;
  }

  public void setPlayer_pk(int player_pk) {
    this.player_pk = player_pk;
  }

  public String getPlayer_name() {
    return player_name;
  }

  public void setPlayer_name(String player_name) {
    this.player_name = player_name;
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
    return ovr_rank;
  }

  public void setOvr_rank(int ovr_rank) {
    this.ovr_rank = ovr_rank;
  }

}
