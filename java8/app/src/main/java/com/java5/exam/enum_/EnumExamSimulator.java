package com.java5.exam.enum_;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EnumExamSimulator {

	public static void main(String[] args) {
		/*
		 * 특정 물체의 지표면상 무게를 입력 받아서 Planet에 정의된 행성 표면에서
		 * 측정한 무게로 변환한 표를 출력 하는 프로그램
		 * */
		double earthWeight = Double.parseDouble(args[0]);
		double mass = earthWeight / Planet.EARTH.surfaceGravity();
		// enum class는 values() 를 통해 해당 enum class의 변수를 배열로 반환한다.
		for(Planet p : Planet.values()){
			System.out.printf("Weight on %s is %f%n" , p , p.surfaceWeight(mass));
		}
		
		// Enum in java : java.math.RoundingMode = 소수점 이하 올림처리 
		java.math.RoundingMode.values();
		
		BigDecimal v1 = new BigDecimal(10);
		BigDecimal v2 = v1.divide(new BigDecimal(3), RoundingMode.CEILING);
		System.out.println("v2:"+v2);
		
		for(RoundingMode x : RoundingMode.values()){
			System.out.println(x);
		}
		
	}

}
