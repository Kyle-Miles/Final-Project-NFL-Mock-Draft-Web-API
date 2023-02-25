package com.promineo.mockdrafts.config.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityUserRepository extends JpaRepository<SecurityUser, Integer> {
	Optional<SecurityUser> findByUsername(String username);

}
