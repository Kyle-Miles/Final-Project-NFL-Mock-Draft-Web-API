package com.promineo.mockdrafts.config;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/")
	public String home() {
		return ("<h1>Welcome</h1>" + "<body> You now have general access! </body>");
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/user")
	public String user() {
		return ("<h1>Welcome User</h1>" + "<body> You now have User Access to mockdrafts!! </body>");
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/admin")
	public String admin() {
		return ("<h1>Welcome Admin</h1>" + "<body> You now have Admin Access to mockdrafts!! </body>");
	}
}
