package com.promineo.mockdrafts.entity;


import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.relational.core.mapping.Column;
import com.promineo.mockdrafts.utils.DraftPick;
import com.promineo.mockdrafts.utils.DraftRound;



@Entity
@Table(name= "draft")
public class Draft {
  
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int draft_pk;
  
  //refer to com.promineo.mockdrafts.utils.DraftRound for enum values when mapping to API
  @Column(value= "round")
  @Enumerated(EnumType.STRING)
  private DraftRound round;
  
  @Column(value= "pick")
  @Enumerated(EnumType.STRING)
  private DraftPick pick;
  
  @OneToMany(mappedBy = "draft")
  private Set <MockDraft> mockDraft;


  public int getDraft_pk() {
    return draft_pk;
  }

  public void setDraft_pk(int draft_pk) {
    this.draft_pk = draft_pk;
  }

  public DraftRound getRound() {
    return round;
  }

  public void setRound(DraftRound round) {
    this.round = round;
  }

  public DraftPick getPick() {
    return pick;
  }

  public void setPick(DraftPick pick) {
    this.pick = pick;
  }

}
