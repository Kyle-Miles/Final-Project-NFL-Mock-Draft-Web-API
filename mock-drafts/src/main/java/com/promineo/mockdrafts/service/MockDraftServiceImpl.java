package com.promineo.mockdrafts.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineo.mockdrafts.entity.MockDraft;
import com.promineo.mockdrafts.repository.MockDraftRepository;

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
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public MockDraft updateMockDraft(MockDraft mockDraft, int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deleteMockDraft(int id) {
    // TODO Auto-generated method stub
    
  }

}
