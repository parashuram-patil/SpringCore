package com.cs.implementations;

import com.cs.interfaces.Shape;

public class Triangle implements Shape {

	private Points point;
	private String type;


	/*Triangle(String type, Points point) {
		this.type = type;
		this.point = point;
	}*/
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setPoint(Points point) {
		this.point = point;
	}

	@Override
	public void draw() {
		System.out.println("Drawing Triangle ---> " + type);
		System.out.println("Points ---> X:" + point.getX() + ", Y:" + point.getY());
	}
}
