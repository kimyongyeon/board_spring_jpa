package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;

/**
 * Created by yongyeonkim on 2016. 5. 31..
 */
public class MainTest {

    class Person {
        String name;
        Integer age;
    }

    public static void main(String[] args) {

        // 모던 자바 이점
        final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer number : numbers) {
            stringBuilder.append(number).append(" : ");
        }
        final int length;
        if (stringBuilder.length() > 0 ) {
            length = stringBuilder.length();
            stringBuilder.delete(length - 3, length);
        }

//        final int size = numbers.size();
//        for(int i = 0; i< size; i++) {
//            stringBuilder.append(numbers.get(i + 1));
//            if (i != size - 1) {
//                stringBuilder.append(" : ");
//            }
//        }

        System.out.println(stringBuilder.toString());

        final String result = numbers.stream()
                .map(String::valueOf)
                .collect(joining(" : "));
        System.out.println(result);




        List<Integer> arrayList = Arrays.asList(1,2,3,4,5);

        arrayList = arrayList.stream().filter(i -> i.intValue() == 1)
                .sorted(Comparator.comparing(Integer::intValue))
                .map(Integer::intValue)
                .collect(Collectors.toList());

        System.out.println(arrayList);



    }
}
