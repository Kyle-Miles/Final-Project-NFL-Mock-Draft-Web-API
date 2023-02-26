package com.promineo.mockdrafts.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class CustomErrorController implements ErrorController {


  @RequestMapping("/error")
  @ResponseBody
  String error(HttpServletRequest request) {
    return ("<style>\r\n"
			+ "h1 {text-align: center;}\r\n"
			+ "body {text-align: center;}\r\n"
			+ "</style>"
			+ "<h1 style=\"color:red;\">An error occurred...</h1>" 
			+ "<body> "
			+ "<body style=\"background-color:black;\">"
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

  public String getErrorPath() {
    return "/error";
  }
}
