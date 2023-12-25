package me.whiteship.java8to11;

@FunctionalInterface //funtionnalInterface라고 표시
public interface RunSometing {

    void doIt(); //단 하나의 추상메소드 가 있으면 함수형 인터페이스
    //앞에 abstract(추상) 생략되어있음 

    static void printName(){
        System.out.println("Keesun"); //stati 메소드 정의가능
    }

    default void printAge(){
        System.out.println("40"); //다른 형태의 메소드가 있어도 괜찮
    }

}
