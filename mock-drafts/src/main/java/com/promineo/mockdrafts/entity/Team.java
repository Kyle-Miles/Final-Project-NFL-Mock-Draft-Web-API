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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.relational.core.mapping.Column;
import com.promineo.mockdrafts.utils.TeamName;




@Entity
@Table(name = "team")
public class Team {
  
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int team_pk;
  
  //refer to com.promineo.mockdrafts.utils.TeamName for enum values when mapping to API
  @Column(value = "name")
  @Enumerated(EnumType.STRING)
  private TeamName name;
  
  @ManyToMany(fetch = FetchType.EAGER,
      cascade = {
          CascadeType.DETACH
      })
  @Fetch(value=FetchMode.SELECT)
  @JoinTable(name = "team_needs",
      joinColumns = { @JoinColumn(name = "team_pk") },
      inverseJoinColumns = { @JoinColumn(name = "needs_pk")})
  private Set<Needs> needs = new HashSet<>();
  
  @OneToMany(mappedBy = "team")
  private Set <MockDraft> mockDraft;



  public int getTeam_pk() {
    return team_pk;
  }

  public void setTeam_pk(int team_pk) {
    this.team_pk = team_pk;
  }

  public TeamName getTeam_name() {
    return name;
  }

  public void setTeam_name(TeamName team_name) {
    this.name = team_name;
  }

  public Set<Needs> getNeeds() {
    return needs;
  }

  public void setNeeds(Set<Needs> needs) {
    this.needs = needs;
  }

}
