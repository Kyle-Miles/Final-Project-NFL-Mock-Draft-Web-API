package com.promineo.mockdrafts.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.promineo.mockdrafts.entity.Needs;


@Repository
public interface NeedsRepository extends JpaRepository<Needs, Integer>{
  

}
