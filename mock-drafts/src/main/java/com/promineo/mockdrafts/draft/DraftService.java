package com.promineo.mockdrafts.draft;

import java.util.List;

import org.springframework.security.access.annotation.Secured;


public interface DraftService {
  
  @Secured("ROLE_ADMIN")
  public Draft saveDraft(Draft draft);
  
  @Secured("ROLE_USER")
  public List<Draft> getAllDrafts();
  
  @Secured("ROLE_USER")
  public List <Draft> getDraftByRoundAndPick(DraftRound round, DraftPick pick);
  
  @Secured("ROLE_USER")
  public Draft getDraftById(int id);
  
  @Secured("ROLE_ADMIN")
  public Draft updateDraft(Draft draft, int id);
  
  @Secured("ROLE_ADMIN")
  public void deleteDraft(int id);

  @Secured("ROLE_USER")
  public List<Draft> getDraftByRound(DraftRound round);


}
