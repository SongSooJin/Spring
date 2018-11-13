package com.example.demo.hw;

import org.springframework.stereotype.Component;

@Component
public class Car {
	private Engine engine;

	public void start() {
		engine.run();
		
	}

	public void stop() {
		engine.stop();
		
	}
}
