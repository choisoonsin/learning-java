package com.java8.exam.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lambdaExam {

    public static void main(String args[]){
        // lambda 표현식
        System.out.println("lambda expression");
        
        List<String> stringList = Arrays.asList("A" , "B" , "C");
        
        Collections.sort(stringList , (o1 , o2) -> o2.compareTo(o1));
        
        stringList.forEach(System.out::println);
        
    }

}
