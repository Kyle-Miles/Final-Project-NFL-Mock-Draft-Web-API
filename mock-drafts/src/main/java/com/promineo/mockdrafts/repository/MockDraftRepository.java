package com.promineo.mockdrafts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.promineo.mockdrafts.entity.MockDraft;

@Repository
public interface MockDraftRepository extends JpaRepository<MockDraft, Integer>{

}
