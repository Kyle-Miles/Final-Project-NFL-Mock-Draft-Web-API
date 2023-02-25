package com.promineo.mockdrafts.needs;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
