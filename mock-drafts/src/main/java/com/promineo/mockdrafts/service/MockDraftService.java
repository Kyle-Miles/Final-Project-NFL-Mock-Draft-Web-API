package com.promineo.mockdrafts.service;

import java.util.List;
import com.promineo.mockdrafts.entity.MockDraft;
import com.promineo.mockdrafts.entity.Team;
import com.promineo.mockdrafts.utils.TeamName;

public interface MockDraftService {
public MockDraft saveMockDraft(MockDraft mockDraft);
  
  public List<MockDraft> getAllMockDrafts();
  
  public MockDraft getMockDraftsById(int id);
  
  public MockDraft updateMockDraft(MockDraft mockDraft, int id);
  
  public void deleteMockDraft(int id);
  
  public List<MockDraft> getMockDraftByTeamName(TeamName name);


}
