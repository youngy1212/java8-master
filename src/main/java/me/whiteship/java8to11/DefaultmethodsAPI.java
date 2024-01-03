package me.whiteship.java8to11;

import java.util.*;
import java.util.stream.Collectors;


public class DefaultmethodsAPI {
    


    public static void main(String[] args) {
         List<String> name = new ArrayList<>();
        name.add("keesun");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");

        name.forEach(System.out::println); //반복문
       
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit(); //쪼갬
        System.out.println("=====");
        while (spliterator1.tryAdvance(System.out::println));

        name.removeIf(s-> s.startsWith("k")); //k로 시작하는것 제외

        Comparable<String> compareToIgnoreCase = String::compareToIgnoreCase; //정렬 
        name.sort(compareToIgnoreCase.reversed().thenComparing());  

        //반대로 정렬 
        //추가 정렬조건을 더하고 싶다. thenComparing()

    


    }
   


}