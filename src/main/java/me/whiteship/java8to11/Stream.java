package me.whiteship.java8to11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream {
    


    public static void main(String[] args) {
         List<String> name = new ArrayList<>();
        name.add("keesun");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");

        //name.stream().map(String::toUpperCase);
    
        name.stream().map((s)-> {
            System.out.println(s);
            return s.toUpperCase();
        }); //sys 찍히지않음. 이런 중개형 오퍼레이션은 터미널(종료형) 오퍼레이션이 오기전까지는 실행되지 않음. 


        //Stream API 
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));


        System.out.println("spring 으로 시작하는 수업");
        springClasses.stream().filter(oc -> oc.getTitle().startsWith("spring")).forEach(oc -> System.out.println(oc.getId()));
    
        System.out.println("close 되지 않은 수업");
        springClasses.stream().filter(oc -> !oc.isClosed()).forEach(oc-> System.out.println(oc.getId()));
        //단축시키는 방법
        springClasses.stream().filter(Predicate.not(OnlineClass::isClosed))
        .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream().map(oc -> oc.getTitle())
            .forEach(System.out::println);

            //여기 forEach는 oc클래스가 아님 String 타입이 들어감. -> map으로 변경했으니까.



        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        keesunEvents.stream()
                .flatMap(Collection::stream)
                .forEach(oc -> System.out.println(oc.getId()));
        //stream을 flatMap으로 받으면 list화 -> Collection으로 stram -> oc 로 받을 수 있게됨 

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        //Stream.iterate(10, i-> i+1); //이것은 아무일도 하지않음 중계형이기 때문 

        Stream.iterate(10, i -> i + 1)
            .skip(10)
            .limit(10)
            .forEach(System.out::println);


        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println(test);

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기");
        List<String> spring = springClasses.stream()
                .map(OnlineClass::getTitle)
                .filter(t -> t.contains("spring"))
                .collect(Collectors.toList());
        spring.forEach(System.out::println);

    }
   


}