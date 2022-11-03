package com.java5.exam.enum_;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EnumExamSimulator {

	public static void main(String[] args) {
		/*
		 * Ư�� ��ü�� ��ǥ��� ���Ը� �Է� �޾Ƽ� Planet�� ���ǵ� �༺ ǥ�鿡��
		 * ������ ���Է� ��ȯ�� ǥ�� ��� �ϴ� ���α׷�
		 * */
		double earthWeight = Double.parseDouble(args[0]);
		double mass = earthWeight / Planet.EARTH.surfaceGravity();
		// enum class�� values() �� ���� �ش� enum class�� ������ �迭�� ��ȯ�Ѵ�.
		for(Planet p : Planet.values()){
			System.out.printf("Weight on %s is %f%n" , p , p.surfaceWeight(mass));
		}
		
		// Enum in java : java.math.RoundingMode = �Ҽ��� ���� �ø�ó�� 
		java.math.RoundingMode.values();
		
		BigDecimal v1 = new BigDecimal(10);
		BigDecimal v2 = v1.divide(new BigDecimal(3), RoundingMode.CEILING);
		System.out.println("v2:"+v2);
		
		for(RoundingMode x : RoundingMode.values()){
			System.out.println(x);
		}
		
	}

}
