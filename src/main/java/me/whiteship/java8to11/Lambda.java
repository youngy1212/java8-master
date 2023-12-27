package me.whiteship.java8to11;

import java.util.function.BinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.Supplier;


public class Lambda {

    public static void main(String[] args) {
        
        //인자가 없는 경우
        Supplier<Integer> get10 = () -> 10;

        //여러개의 인자 타입 생략가능(a,b) 
        BinaryOperator<Integer> sum = (a,b) -> a+b;

        Lambda lambda = new Lambda();
        lambda.run();


    }

    private void run(){
        int baseNumber = 10; //로컬변수 -> 캡처가 됨. 
        //원래면 final인데, 어디서도 변경하지 않기때문에 사실상 final 변수임
        // effective final임. 로컬 클래스, 익명클래스, 람다 셋다 참조 가능

        //로컬 클래스
        class LocalClass {
            void printBaseNumber(){
                int baseNumber = 11;
                System.out.println(baseNumber); //11;
            }
        }

        //람다
        IntConsumer printInt = (i)-> { //여기서 baseNumber를 다시 선언할 수 없음.
            System.out.println(i+baseNumber);
            //람다에서 -> 로컬베리어의 baseNumber를 참조하는 셈
        };

        printInt.accept(10);
    }
}
