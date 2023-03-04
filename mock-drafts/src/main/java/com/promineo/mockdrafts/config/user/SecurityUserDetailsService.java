package com.promineo.mockdrafts.config.user;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private SecurityUserRepository userRepository;
	
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder(); 
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<SecurityUser> user = userRepository.findByUsername(username);

		user.orElseThrow(() -> new UsernameNotFoundException("Not found:" + username));
		return user.map(SecurityUserDetails::new).get();
	}
	
	public List<SecurityUser> getAllUsers() {
		return userRepository.findAll();
	}
	
	public SecurityUser saveUser(SecurityUser user) {
		String password = getPasswordEncoder().encode(user.getPassword()).toString();;
		user.setPassword(password);
		return userRepository.save(user);	
	}
	


}
