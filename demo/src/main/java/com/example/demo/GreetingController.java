package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	private GreetingComponent g;
	
	@Autowired
	public GreetingController(GreetingComponent g) {
		this.g = g;
	}

	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, 
				name));
	}
	
	// test the greeting component
	@GetMapping("/testgreeting")
	public ResponseEntity<String> getMessage() {
		return ResponseEntity.ok(g.getMessage());
	}
	
	// add method to handle POST 
	@PostMapping("/testgreeting")
	public ResponseEntity<String> postMessage() {
		return ResponseEntity.ok(g.postMessage());
	}
	
	@PutMapping("/testgreeting")
	public ResponseEntity<String> putMessage() {
		return ResponseEntity.ok(g.putMessage());
	}
	
	@DeleteMapping("/testgreeting")
	public ResponseEntity<String> deleteMessage() {
		return ResponseEntity.ok(g.deleteMessage());
	}
}

