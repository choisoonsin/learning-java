package com.java5.exam.enum_;

public enum Planet {

	MECURY(3.302e+23 , 2.439e6) , 
	VENUS (4.869e+24 , 6.052e6) , 
	EARTH (5.975e+24 , 6.378e6);
	
	private final double mass; 			// 킬로그램 단위
	private final double radius;		// 미터 단위
	private final double surfaceGravity;//m / s^2
	
	Planet(double mass , double radius){
		this.mass = mass;
		this.radius = radius;
		this.surfaceGravity = G * mass / (radius * radius);
	}
	
	// 중력상수 ( m^3 / kg s^2 )
	private static final double G = 6.67300E-11;
	
	public double mass()  {return mass;}
	public double radius(){return radius;}
	public double surfaceGravity() { return surfaceGravity; }
	
	public double surfaceWeight(double mass){
		return mass * surfaceGravity; // F = ma
	}
	
}
