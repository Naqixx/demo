package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class GreetingComponent {
	
	public String getMessage() {
		return "Hello from GreetingComponent";
	}
	
	public String postMessage() {
		return "Post message to GreetingComponent";
	}
	
	public String putMessage() {
		return "Put message to GreetingComponent";
	}
	
	public String deleteMessage() {
		return "Delete message to GreetingComponent";
	}
}
