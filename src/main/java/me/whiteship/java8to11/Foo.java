package me.whiteship.java8to11;

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
    
    }
}
