package com.promineo.mockdrafts.team;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.promineo.mockdrafts.player.Position;

@Repository
public interface TeamRepository extends JpaRepository <Team, Integer>{

  List<Team> findByTeamName(TeamName name);

  List<Team> findByNeedsPosition(Position needs);


}
