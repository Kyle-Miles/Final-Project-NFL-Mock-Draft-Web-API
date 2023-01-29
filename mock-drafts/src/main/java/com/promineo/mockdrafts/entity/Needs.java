package com.promineo.mockdrafts.entity;

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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.relational.core.mapping.Column;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.promineo.mockdrafts.utils.Position;


@Entity
@Table(name= "needs")
public class Needs {
  
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int needs_pk;
  
//refer to com.promineo.mockdrafts.utils.Position for enum values when mapping to API
  @Column(value= "position_needs")
  @Enumerated(EnumType.STRING)
  private Position position_needs;

  
  @ManyToMany(fetch = FetchType.EAGER,
      cascade = {
          CascadeType.DETACH
      },
      mappedBy = "needs")
  @Fetch(value=FetchMode.SELECT)
  @JsonIgnore
  private Set<Team> team = new HashSet<>();


  public int getNeeds_pk() {
    return needs_pk;
  }


  public void setNeeds_pk(int needs_pk) {
    this.needs_pk = needs_pk;
  }


  public Position getPosition_needs() {
    return position_needs;
  }


  public void setPosition_needs(Position position_needs) {
    this.position_needs = position_needs;
  }


  public Set<Team> getTeam() {
    return team;
  }


  public void setTeam(Set<Team> team) {
    this.team = team;
  }
  

}
