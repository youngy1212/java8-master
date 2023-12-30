package me.whiteship.java8to11;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Mf {

    public static void main(String[] args) {
        
        UnaryOperator<String> hi = Greeting::hi;
        //Greeting 메소드 hi를 사용하겠다.
        
        //특정한 인스턴스를 사용하겠다.
        Greeting greeting = new Greeting();

        //입력값을 받는 생성자
        Function<String, Greeting> kesungGreeting = Greeting::new;
        Supplier<Greeting> newGreeting = Greeting::new;
        newGreeting.get();
        //이 두개는 다른 생성자를 참조함. 위는 인자를 받는 생정자를 참조 
        // 아래는 문자열을 받지 않는 생성자를 참조. 

        //자주사용하는 정렬 (오버라이딩 )Comparator
        //람다로 변환
        String[] names = {"kesun","whith"};
        Arrays.sort(names,(o1,o2)->0);
        Arrays.sort(names, String::compareToIgnoreCase);


    }

}
