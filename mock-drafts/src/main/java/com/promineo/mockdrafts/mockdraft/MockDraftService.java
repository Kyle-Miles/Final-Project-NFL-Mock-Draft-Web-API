package com.promineo.mockdrafts.mockdraft;

import java.time.LocalDateTime;
import java.util.List;
import com.promineo.mockdrafts.player.Position;
import com.promineo.mockdrafts.team.TeamName;

public interface MockDraftService {
  	
  public MockDraft saveMockDraft(MockDraft mockDraft);
  
  public List<MockDraft> getAllMockDrafts();
  
  public MockDraft getMockDraftsById(int id);
  
  public MockDraft updateMockDraft(MockDraft mockDraft, int id);
  
  public void deleteMockDraft(int id);
  
  public List<MockDraft> getMockDraftByTeamName(TeamName name);
 
  public List<MockDraft> getMockDraftByPosition(Position position);
  
  public List<MockDraft> getMockDraftByPublished(LocalDateTime published);


}
