package me.whiteship.java8to11;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Foo {

    public static void main(String[] args) {
        
        //익명 내부 클래스 annoymous inner Class 
        // RunSometing runSometing = new RunSometing() {
        //     @Override
        //     public void doIt() { //구현
        //         System.out.println("Hello");     
        //     }
        // };

        //단하나만 있는 함수영 인터페이스라면 이렇게 사용 가능 
        RunSometing runSometing = () -> System.out.println("Hello");
        //두 줄 이상이라면, 위의 익명 내부 클래스를 이용. 

        runSometing.doIt();

        /**
         * 
         * 결론 함수가 함수형으로 받는 것, 함수로 리턴하는 것,  함수를 변수로 지정하는 것 모두 가능하다. 
         * 함수 내부에서 쓰는 값 , 함수가 전달받은 파리미터만 가지고 사용해야 함(순수 함수)
         * 
         */

        //방법 1. clase => 만들어서 -> 인스턴스 만들어서 사용
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));

        //방법2 : 람다 익스프레스를 사용
        Function<Integer, Integer> plus11 = (i) -> i+11;
        System.out.println(plus11.apply(1));
        
        Function<Integer, Integer> multiply2 = (i) -> i*2;
        System.out.println(multiply2.apply(1));

        //이 두개의 함수를 더하겠다. compose 
        Function<Integer, Integer> multiply2AndPlus11 = plus11.compose(multiply2); //뒤에오는 값을 먼저 적용 + 그 후 plus11
        System.out.println(multiply2AndPlus11.apply(2)); //2*2+11 이 이루어짐
        System.out.println(plus11.andThen(multiply2).apply(2));//(11+2)*2
        
        //받아서 아무것도 리턴하지 않음
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);


        //Supplier 는 오히려 값을 받아옴. 내가 받아올 값을 명시
        Supplier<Integer> get10 = () -> 10;
        //내가 입력해줄 값이 없어서 () 안에가 비어있음. 
        System.out.println(get10);

        //어떠한 인자를 받아서 t/f 리턴
        Predicate<String> startsWithKeesun = (s) -> s.startsWith("keesun");
        //기선으로 시작하는지 확인
        Predicate<Integer> isEven = (i) -> i%2 == 0;
        //startsWithKeesun.or 등 으로 조합할 수 있다.

        
    }
}
