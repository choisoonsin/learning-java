package com.pattern.factory;

public class NYStyleCheesePizza extends Pizza {
	
	public NYStyleCheesePizza() {
		// TODO Auto-generated constructor stub
		this.name = "NYStyleCheesePizza";
		this.dough = "Thin Crust Dough";
		this.sauce = "Marinara Sauce";
		this.toppings.add("Reggiaano Cheese");
		this.toppings.add("double Cheese");
	}
	
	@Override
	// cut 방식이 틀리므로 오버라이딩
	void cut() {
		// TODO Auto-generated method stub
		System.out.println("Cutting the pizza into square slices");
	}
}
