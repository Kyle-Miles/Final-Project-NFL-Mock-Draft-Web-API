package com.promineo.mockdrafts.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineo.mockdrafts.entity.Needs;
import com.promineo.mockdrafts.repository.NeedsRepository;

@Service
public class NeedsServiceImpl implements NeedsService {
  
private NeedsRepository needsRepository;
  
  @Autowired
  public NeedsServiceImpl(NeedsRepository needsRepository) {
    this.needsRepository = needsRepository;
  }

  @Override
  public List<Needs> getAllNeeds() {
    return needsRepository.findAll();
  }

  @Override
  public Needs saveNeeds(Needs needs) {
    return needsRepository.save(needs);
  }

}
