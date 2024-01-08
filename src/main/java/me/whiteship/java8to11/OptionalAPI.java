package me.whiteship.java8to11;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class OptionalAPI {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));


        Optional<OnlineClass> optional = springClasses.stream()
        .filter(oc -> oc.getTitle().startsWith("jpa"))
        .findFirst();

        boolean present = optional.isPresent();
        System.out.println(present);

        OnlineClass onlineClass = optional.get(); //값가져오기
        System.out.println(onlineClass.getTitle());


        optional.ifPresent(oc ->  System.out.println(onlineClass.getTitle()));
        //있을 경우

        OnlineClass onlineClass2 = optional.orElseGet(OptionalAPI::createNewClasss);
        System.out.println(onlineClass2.getTitle()); //없는 경우 class 호출 

    }

    private static OnlineClass createNewClasss() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }


}