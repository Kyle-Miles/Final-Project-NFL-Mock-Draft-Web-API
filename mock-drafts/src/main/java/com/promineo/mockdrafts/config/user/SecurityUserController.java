package com.promineo.mockdrafts.config.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/nfldraft/user")
public class SecurityUserController {
	
	private SecurityUserDetailsService userService;
	@Autowired
	  private SecurityUserController(SecurityUserDetailsService userService) {
	    super();
	    this.userService = userService;
	  }
	
	@GetMapping
	public ResponseEntity <List<SecurityUser>> getAllUsers() {
		return new ResponseEntity <List<SecurityUser>>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	@PostMapping()
	  public ResponseEntity<SecurityUser> saveUser(@RequestBody SecurityUser user) {
	      return new ResponseEntity<SecurityUser>(userService.saveUser(user),HttpStatus.CREATED);
	  }
}
