package com.promineo.mockdrafts.service;

import java.util.List;
import com.promineo.mockdrafts.entity.Draft;
import com.promineo.mockdrafts.utils.DraftPick;
import com.promineo.mockdrafts.utils.DraftRound;


public interface DraftService {
public Draft saveDraft(Draft draft);
  
  public List<Draft> getAllDrafts();
  
  public List <Draft> getDraftByRoundAndPick(DraftRound round, DraftPick pick);
  
  public Draft getDraftById(int id);
  
  public Draft updateDraft(Draft draft, int id);
  
  public void deleteDraft(int id);

  public List<Draft> getDraftByRound(DraftRound round);


}
