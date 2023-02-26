package com.promineo.mockdrafts.config.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	SecurityUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<SecurityUser> user = userRepository.findByUsername(username);

		user.orElseThrow(() -> new UsernameNotFoundException("Not found:" + username));
		return user.map(SecurityUserDetails::new).get();
	}

}
