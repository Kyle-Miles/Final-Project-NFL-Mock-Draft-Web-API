package com.promineo.mockdrafts.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineo.mockdrafts.entity.Draft;
import com.promineo.mockdrafts.exception.ResourceNotFoundException;
import com.promineo.mockdrafts.repository.DraftRepository;
import com.promineo.mockdrafts.utils.DraftPick;
import com.promineo.mockdrafts.utils.DraftRound;

@Service
public class DraftServiceImpl implements DraftService {
  
  private DraftRepository draftRepository;
  
  @Autowired
  public DraftServiceImpl(DraftRepository draftRepository) {
    this.draftRepository = draftRepository;
  }


  @Override
  public Draft saveDraft(Draft draft) {
    return draftRepository.save(draft);
  }

  @Override
  public List<Draft> getAllDrafts() {
    return draftRepository.findAll();
  }

  @Override
  public Draft getDraftById(int id) {
    return draftRepository.findById(id).orElseThrow(() -> 
    new ResourceNotFoundException("draft", "Id", id));
  }

  @Override
  public Draft updateDraft(Draft draft, int id) {
    Draft existingDraft = draftRepository.findById(id).orElseThrow(() ->
    new ResourceNotFoundException("draft", "Id", id));
    
    existingDraft.setRound(draft.getRound());
    existingDraft.setPick(draft.getPick());
    draftRepository.save(existingDraft);
    return existingDraft;
  }

  @Override
  public void deleteDraft(int id) {
    @SuppressWarnings("unused")
    Draft existingDraft = draftRepository.findById(id).orElseThrow(() ->
    new ResourceNotFoundException("draft", "Id", id));
    
    draftRepository.deleteById(id);

  }


  @Override
  public List<Draft> getDraftByRoundAndPick(DraftRound round, DraftPick pick) {
    return draftRepository.findByRoundAndPick(round, pick);
  }


  @Override
  public List<Draft> getDraftByRound(DraftRound round) {
    return draftRepository.findByRound(round);  
  }

}
