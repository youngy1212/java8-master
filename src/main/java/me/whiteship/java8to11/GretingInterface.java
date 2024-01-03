package me.whiteship.java8to11;

public interface GretingInterface {

    void printName();

    //차후 인터페이스를 구현할때 구현할 인터페이스들에 공통적으로 제공해줬으면 하는 기능들이 생김

    void printNameUpperCase();
    //이렇게 추가할 경우.. 이 인터페이스를 만든 모든 메소드에서 컴파일 오류가 남(미구현 오류)

    default void printNameUpperCase2(){
        System.out.println("FOO");
    }

}
