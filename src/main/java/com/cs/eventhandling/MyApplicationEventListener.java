package com.cs.eventhandling;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationEventListener implements ApplicationListener<MyEvent> {

	@Override
	public void onApplicationEvent(MyEvent event) {
		System.out.println(event.toString() + " and caught by ApplicationListener");
	}

}
