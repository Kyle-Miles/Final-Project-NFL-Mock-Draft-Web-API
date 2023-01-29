package com.promineo.mockdrafts.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.promineo.mockdrafts.entity.Draft;
import com.promineo.mockdrafts.utils.DraftPick;
import com.promineo.mockdrafts.utils.DraftRound;


@Repository
public interface DraftRepository extends JpaRepository<Draft, Integer>{
  
  List <Draft> findByRoundAndPick(DraftRound round, DraftPick pick);

  List<Draft> findByRound(DraftRound round);
 
}
