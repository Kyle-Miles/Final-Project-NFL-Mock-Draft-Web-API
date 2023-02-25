package com.promineo.mockdrafts.draft;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DraftRepository extends JpaRepository<Draft, Integer>{
  
  List <Draft> findByRoundAndPick(DraftRound round, DraftPick pick);

  List<Draft> findByRound(DraftRound round);
 
}
