package com.promineo.mockdrafts.service;

import java.util.List;
import com.promineo.mockdrafts.entity.Needs;

public interface NeedsService {
public List<Needs> getAllNeeds();
  
  public Needs saveNeeds(Needs needs);

}
