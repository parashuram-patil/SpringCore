package com.cs.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiDemo {
	
	private final Bean1 bean1;
	private final Bean2 bean2;
	
	@Autowired
	DiDemo(Bean1 bean1, Bean2 bean2) {
		this.bean1 = bean1;
		this.bean2 = bean2;
	}
	
	public void execute() {
		System.out.println(this.bean1.getBeanName() + " : "+ this.bean2.getBeanName());
	}

}
