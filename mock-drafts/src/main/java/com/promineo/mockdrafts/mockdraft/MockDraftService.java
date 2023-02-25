package com.promineo.mockdrafts.mockdraft;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.promineo.mockdrafts.player.Position;
import com.promineo.mockdrafts.team.TeamName;

public interface MockDraftService {
  
  @Secured("ROLE_ADMIN")	
  public MockDraft saveMockDraft(MockDraft mockDraft);
  
  @Secured("ROLE_USER")
  public List<MockDraft> getAllMockDrafts();
  
  @Secured("ROLE_USER")
  public MockDraft getMockDraftsById(int id);
  
  @Secured("ROLE_ADMIN")
  public MockDraft updateMockDraft(MockDraft mockDraft, int id);
  
  @Secured("ROLE_ADMIN")
  public void deleteMockDraft(int id);
  
  @Secured("ROLE_USER")
  public List<MockDraft> getMockDraftByTeamName(TeamName name);
  
  @Secured("ROLE_USER")
  public List<MockDraft> getMockDraftByPosition(Position position);
  
  @Secured("ROLE_USER")
  public List<MockDraft> getMockDraftByPublished(LocalDateTime published);


}
