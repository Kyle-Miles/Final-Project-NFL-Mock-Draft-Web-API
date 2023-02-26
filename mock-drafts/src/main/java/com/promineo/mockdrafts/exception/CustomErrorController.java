package com.promineo.mockdrafts.exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class CustomErrorController implements ErrorController {


  @RequestMapping("/error")
  @ResponseBody
  String error(HttpServletRequest request) {
    return ( "<style>\r\n"
			+ "h1 {text-align: center;}\r\n"
			+ "body {text-align: center;}\r\n"
			+ "h1 {\r\n"
			+ "  font-size: 150px;\r\n"
			+ "}"
			
			+ ".buttonLogin {\r\n"
			+ "  display: inline-block;\r\n"
			+ "  border-radius: 4px;\r\n"
			+ "  background-color: #50c878;\r\n"
			+ "  border: none;\r\n"
			+ "  color: #FFFFFF;\r\n"
			+ "  text-align: center;\r\n"
			+ "  font-size: 28px;\r\n"
			+ "  padding: 20px;\r\n"
			+ "  width: 200px;\r\n"
			+ "  transition: all 0.5s;\r\n"
			+ "  cursor: pointer;\r\n"
			+ "  margin: 5px;\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ ".buttonLogin span {\r\n"
			+ "  cursor: pointer;\r\n"
			+ "  display: inline-block;\r\n"
			+ "  position: relative;\r\n"
			+ "  transition: 0.5s;\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ ".buttonLogin span:after {\r\n"
			+ "  content: '\\00bb';\r\n"
			+ "  position: absolute;\r\n"
			+ "  opacity: 0;\r\n"
			+ "  top: 0;\r\n"
			+ "  right: -20px;\r\n"
			+ "  transition: 0.5s;\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ ".buttonLogin:hover span {\r\n"
			+ "  padding-right: 25px;\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ ".buttonLogin:hover span:after {\r\n"
			+ "  opacity: 1;\r\n"
			+ "  right: 0;\r\n"
			+ "}"
			
			+ "</style>"
			+ "<h1 style=\"color:red;\">"+ HttpStatus.FORBIDDEN +"</h1>" 
			+ "<body> "
			+ "<body style=\"background-color:black;\">"
			+ "<button id =\"loginButton\" class=\"buttonLogin\" ><span>Log In</span></button>"
			+ "<script type=\"text/javascript\">"
			+ "document.getElementById(\"loginButton\").onclick = function () {"
			+ "location.href = \"http://localhost:8080/login?logout\";"
			+ "};"
			+ "</script>"
			+ "</body>");
  }

  public String getErrorPath() {
    return "/error";
  }
}
