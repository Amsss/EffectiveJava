package com.zhuzz.enumd;

public enum Planet {
	MERCURY(3.0, 2.4), 
	VENUS(3.02, 2.49);
	private final double mass;
	private final double radius;
	private final double surfaceGravity;
	private final double G = 6.67;

	private Planet(double mass, double radius) {
		this.mass = mass;
		this.radius = radius;
		this.surfaceGravity = G * mass / (radius * radius);
	}
	
	public double mass() {
		return mass;
	}
	
	public double radius() {
		return radius;
	}
	
	public double surfaceGravity() {
		return surfaceGravity;
	}
	
	public double surfaceWeight(double mass) {
		return mass*surfaceGravity;
	}
}
