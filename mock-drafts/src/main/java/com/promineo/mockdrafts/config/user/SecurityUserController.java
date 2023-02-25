package com.promineo.mockdrafts.config.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityUserController {

	@GetMapping("/")
	public String home() {
		return ("<style>\r\n"
				+ "h1 {text-align: center;}\r\n"
				+ "body {text-align: center;}\r\n"
				+ "</style>"
				+ "<h1 style=\"color:white;\">Welcome</h1>" 
				+ "<body> "
				+ "<body style=\"background-color:black;\">"
				+ "<button id =\"loginButton\" class=\float-left submit-button\" >Log In</button>"
				+ "<script type=\"text/javascript\">"
				+ "document.getElementById(\"loginButton\").onclick = function () {"
				+ "location.href = \"http://localhost:8080/login\";"
				+ "};"
				+ "</script>"
				+ "<button id =\"userButton\" class=\float-left submit-button\" >User</button>"
				+ "<script type=\"text/javascript\">"
				+ "document.getElementById(\"userButton\").onclick = function () {"
				+ "location.href = \"http://localhost:8080/user\";"
				+ "};"
				+ "</script>"
				+ "<button id =\"adminButton\" class=\float-left submit-button\" >Admin</button>"
				+ "<script type=\"text/javascript\">"
				+ "document.getElementById(\"adminButton\").onclick = function () {"
				+ "location.href = \"http://localhost:8080/admin\";"
				+ "};"
				+ "</script>"
				+ "</body>");
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/user")
	public String user() {
		return ("<style>\r\n"
				+ "h1 {text-align: center;}\r\n"
				+ "body {text-align: center;}\r\n"
				+ "</style>"
				+ "<h1 style=\"color:white;\">Welcome User</h1>" 
				+ "<body> "
				+ "<body style=\"background-color:black;\">"
				+ "<p style=\"color:white;\">"
				+ "You now have </p>"
				+ "<p style=\"color:#5099ff;\">"
				+ "GET </p>"
				+ "<p style=\"color:white;\">"
				+ "Access to the API!! </p> "
				+ "<button id =\"loginButton\" class=\float-left submit-button\" >Log In</button>"
				+ "<script type=\"text/javascript\">"
				+ "document.getElementById(\"loginButton\").onclick = function () {"
				+ "location.href = \"http://localhost:8080/login\";"
				+ "};"
				+ "</script>"
				+ "<button id =\"logoutButton\" class=\float-left submit-button\" >Log Out</button>"
				+ "<script type=\"text/javascript\">"
				+ "document.getElementById(\"logoutButton\").onclick = function () {"
				+ "location.href = \"http://localhost:8080/logout\";"
				+ "};"
				+ "</script>"
				+ "<button id =\"apiButton\" class=\float-left submit-button\" >API</button>"
				+ "<script type=\"text/javascript\">"
				+ "document.getElementById(\"apiButton\").onclick = function () {"
				+ "location.href = \"http://localhost:8080/swagger-ui/index.html\";"
				+ "};"
				+ "</script>"
				+ "<button id =\"adminButton\" class=\float-left submit-button\" >Admin</button>"
				+ "<script type=\"text/javascript\">"
				+ "document.getElementById(\"adminButton\").onclick = function () {"
				+ "location.href = \"http://localhost:8080/admin\";"
				+ "};"
				+ "</script>"
				+ "</body>");
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/admin")
	public String admin() {
		return ("<style>\r\n"
				+ "h1 {text-align: center;}\r\n"
				+ "body {text-align: center;}\r\n"
				+ "</style>"
				+ "<h1 style=\"color:white;\">Welcome Admin</h1>" 
				+ "<body> "
				+ "<body style=\"background-color:black;\">"
				+ "<p style=\"color:white;\">"
				+ "You now have </p>"
				+ "<p style=\"color:#5099ff;\">"
				+ "GET </p>"
				+ "<p style=\"color:#50c878;\">"
				+ "POST </p>"
				+ "<p style=\"color:#e1ad21;\">"
				+ "PUT </p>"
				+ "<p style=\"color:#b22222;\">"
				+ "DELETE </p>"
				+ "<p style=\"color:white;\">"
				+ "Access to the API!! </p> "
				+ "<button id =\"logoutButton\" class=\float-left submit-button\" >Log Out</button>"
				+ "<script type=\"text/javascript\">"
				+ "document.getElementById(\"logoutButton\").onclick = function () {"
				+ "location.href = \"http://localhost:8080/logout\";"
				+ "};"
				+ "</script>"
				+ "<button id =\"apiButton\" class=\float-left submit-button\" >API</button>"
				+ "<script type=\"text/javascript\">"
				+ "document.getElementById(\"apiButton\").onclick = function () {"
				+ "location.href = \"http://localhost:8080/swagger-ui/index.html\";"
				+ "};"
				+ "</script>"
				+ "</body>");
	}
}
