package com.promineo.mockdrafts.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineo.mockdrafts.entity.MockDraft;
import com.promineo.mockdrafts.exception.ResourceNotFoundException;
import com.promineo.mockdrafts.repository.MockDraftRepository;
import com.promineo.mockdrafts.utils.Position;
import com.promineo.mockdrafts.utils.TeamName;

@Service
public class MockDraftServiceImpl implements MockDraftService{
  
  private MockDraftRepository mockDraftRepository;
  
  @Autowired
  public MockDraftServiceImpl(MockDraftRepository mockDraftRepository) {
    this.mockDraftRepository = mockDraftRepository;
  }

  @Override
  public MockDraft saveMockDraft(MockDraft mockDraft) {
    return mockDraftRepository.save(mockDraft);
  }

  @Override
  public List<MockDraft> getAllMockDrafts() {
    return mockDraftRepository.findAll();
  }

  @Override
  public MockDraft getMockDraftsById(int id) {
	  return mockDraftRepository.findById(id).orElseThrow(() -> 
	    new ResourceNotFoundException("Draft", "Id", id));
  }

  @Override
  public MockDraft updateMockDraft(MockDraft mockDraft, int id) {
    MockDraft existingDraft = mockDraftRepository.findById(id).orElseThrow(() ->
    	new ResourceNotFoundException("Draft", "Id", id));
    
    existingDraft.setTeam(mockDraft.getTeam());
    existingDraft.setDraft(mockDraft.getDraft());
    existingDraft.setPlayer(mockDraft.getPlayer());
    mockDraftRepository.save(existingDraft);
    return existingDraft;
  }

  @Override
  public void deleteMockDraft(int id) {
	  MockDraft existingDraft = mockDraftRepository.findById(id).orElseThrow(() ->
	    new ResourceNotFoundException("Draft", "Id", id));
	    
	  mockDraftRepository.deleteById(id);
    
  }

@Override
public List<MockDraft> getMockDraftByTeamName(TeamName name) {
	return mockDraftRepository.findByTeamName(name);
}

@Override
public List<MockDraft> getMockDraftByPosition(Position position) {
	return mockDraftRepository.findByPlayerPosition(position);
}

}
