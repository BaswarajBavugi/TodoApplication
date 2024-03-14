package com.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello, what are you learning today?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuilder sb=new StringBuilder();
		sb.append(
				"<html>"
				  + "<head>"
				    + "<title> html call </title>"
				  + "</head>"
				  + "<body>"
				    + "<p> Hello, welcome to html</p>"
				  + "</body>"
			+ "</html>"
				);
		
		return sb.toString();
	}
		
		@RequestMapping("say-hello-jsp")
//		@ResponseBody
		public String sayHelloJsp() {
			return "sayHello";
		}
	
}
