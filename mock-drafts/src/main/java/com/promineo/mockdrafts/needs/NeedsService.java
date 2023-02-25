package com.promineo.mockdrafts.needs;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

public interface NeedsService {

	@Secured("ROLE_USER")	
	public List<Needs> getAllNeeds();


}
