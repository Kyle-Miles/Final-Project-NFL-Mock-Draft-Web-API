package com.promineo.mockdrafts.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.promineo.mockdrafts.entity.Team;
import com.promineo.mockdrafts.utils.TeamName;


@Repository
public interface TeamRepository extends JpaRepository <Team, Integer>{

  List<Team> findByName(TeamName name);


}
