package com.pattern.factory;

public class NYPizzaStore extends PizzaStore{

	@Override
	protected Pizza createPizza(String type) {
		// TODO Auto-generated method stub
		if("cheese".equals(type)){
			return new NYStyleCheesePizza();
		}else if("clam".equals(type)){
			return new NYStyleClamPizza();
		}
		return null;
	}
	
}
