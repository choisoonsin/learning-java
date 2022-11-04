package com.pattern.factory;

public class Simulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PizzaStore nyStore = new NYPizzaStore();
		// 시카고 풍 피자 스토어 추가~
		
		Pizza nyPizza = nyStore.orderPizza("cheese");
		System.out.println(nyPizza.getName());
	}

}
