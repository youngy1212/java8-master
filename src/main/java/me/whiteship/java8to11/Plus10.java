package me.whiteship.java8to11;

import java.util.function.Function;

public class Plus10 implements Function<Integer,Integer>{

        @Override
        public Integer apply(Integer t) {
            return t+10;
        }

}
