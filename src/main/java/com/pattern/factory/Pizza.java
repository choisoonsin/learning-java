package com.pattern.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
	
	String name;
	String dough;
	String sauce;
	List<String> toppings = new ArrayList<String>();
	
	void prepare(){
		System.out.println("Prepare :"+name);
		System.out.println("Tossing dough :"+dough);
		System.out.println("Adding sauce :"+sauce);
		for(String topping : toppings){
			System.out.println(topping);
		}
	}
	
	void bake(){
		System.out.println("Bake for 25 min at 350");
	}
	
	void cut(){
		System.out.println("Cutting the pizza");
	}
	
	void box(){
		System.out.println("Place the pizza in the box");
	}
	
	public String getName(){
		return name;
	}
		
}
