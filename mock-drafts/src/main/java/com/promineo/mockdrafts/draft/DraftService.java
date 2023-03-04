package com.promineo.mockdrafts.draft;

import java.util.List;

public interface DraftService {
  
  public Draft saveDraft(Draft draft);
  
  public List<Draft> getAllDrafts();
  
  public List <Draft> getDraftByRoundAndPick(DraftRound round, DraftPick pick);
  
  public Draft getDraftById(int id);
  
  public Draft updateDraft(Draft draft, int id);
  
  public void deleteDraft(int id);

  public List<Draft> getDraftByRound(DraftRound round);


}
