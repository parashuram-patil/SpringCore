package com.cs.eventhandling;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

	public MyEvent(Object source) {
		super(source);
	}
	
	public String toString() {
		return "My Event Occured";
	}
}
