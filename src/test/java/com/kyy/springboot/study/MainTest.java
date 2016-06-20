package com.kyy.springboot.study;

import com.kyy.springboot.study.domain.People;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;

/**
 * Created by yongyeonkim on 2016. 5. 31..
 * java stream study
 */
public class MainTest {

    public static void main(String[] args) throws IOException {

        // file read
        System.out.println(
        Files.lines(Paths.get("/tmp/test.txt")).map(line -> line.split("[\\s]+"))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList())
        );


        List<People> peoples = new ArrayList<>();
        peoples.add(new People("roka", 29, People.PeopleSex.MALE));
        peoples.add(new People("bob", 29, People.PeopleSex.MALE));
        peoples.add(new People("jessy", 29, People.PeopleSex.FEMALE));
        peoples.add(new People("katy", 29, People.PeopleSex.FEMALE));
        peoples.add(new People("mes", 29, People.PeopleSex.MALE));

//        List<People> newList = new ArrayList<>();
//        for(People p : peoples) {
//            if(p.getSexEnum() == People.PeopleSex.MALE) {
//                newList.add(new People(p.getNameStr(), p.getAgeInt(), p.getSexEnum()));
//            }
//        }

        // 1) 중간연산
        // filter : T -> boolean
        List<People> newPeoples = peoples.stream().filter((people)->people.getSexEnum() == People.PeopleSex.FEMALE).collect(Collectors.toList());
        newPeoples.forEach(x -> System.out.println(x));
        newPeoples.forEach(System.out::println);

        // map : T -> R
        List<String> names = peoples.stream().map(People::getNameStr).collect(Collectors.toList());
        names.forEach(System.out::println);

        // flatMap : T -> Stream<R>
        List<String> sentence = Arrays.asList("오늘 밤이 차네요 감기 조심 하세요");
        List<String> token = sentence.stream().map(w -> w.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(token);

        // limit : 해당 index까지만 결과 값을 계산하여 반환한다
        List<String> token2 = sentence.stream().map(w -> w.split(" ")).flatMap(Arrays::stream).limit(2).collect(Collectors.toList());
        System.out.println(token2);

        // skip : index 이전은 스킵하고 이후로 결과값을 반환한다
        List<String> token3 = sentence.stream().map(w -> w.split(" ")).flatMap(Arrays::stream).skip(2).collect(Collectors.toList());
        System.out.println(token3);

        // sorted ((T, T) -> int)
        List<String> newPeoples2 = peoples.stream().map(People::getNameStr).sorted((w1, w2) -> w1.compareTo(w2)).collect(Collectors.toList());
        System.out.println(newPeoples2);

        // forEach : Consumer<T>를 인수로 받으며 반환하지 않는다 (T-> void)
        // Collect : Collect는 Collector<T,A,R>을 인수로 받으며 R을 반환
        // Reduce : BinaryOperator<T> 를 인수로 받으며 Option<T> 를 반환한다 (T,T) -> T
        Optional<Integer> highAge = peoples.stream().map(People::getAgeInt).reduce(Integer::max);
        System.out.println(highAge.get());
        int highAge2 = peoples.stream().map(People::getAgeInt).reduce(0, Integer::max);
        System.out.println(highAge2);
        int result = Arrays.asList(1,2,3,4,5,6,7,8).stream().reduce(0, (a1, a2) -> a1 + a2);
        System.out.println(result);

        // noneMatch, anyMatch, allMatch
        // noneMatch : 해당 요소가 없으면 true
        // anyMatch : 해당되는 요소가 하나라도 있으면 true
        // allMatch : 해당되면 true
        // Predicate<T>를 인수로 받으며 boolean을 반환한다 (T -> boolean)
        boolean check = peoples.stream().map(People::getNameStr).anyMatch(r -> r.equals("roka"));
        System.out.println(check);

        boolean check2 = peoples.stream().map(People::getAgeInt).allMatch(r -> r > 25);
        System.out.println(check2);

        boolean chech3 = peoples.stream().map(People::getNameStr).noneMatch(r -> r.contains("at"));
        System.out.println(chech3);

        // findAny, findFirst
        // findAny : 결과값 중 임의의 요소를 반환
        // findFirst : 결과값 중 첫번째 요소를 반환
        // 반환형식 : Optional<T>
        Optional<Integer> r = Arrays.asList(1,2,3,4,5).stream().filter(x->x>3).findAny();
        System.out.println(r.get());
        Optional<Integer> r2 = Arrays.asList(1,2,3,4,5).stream().filter(x->x>3).findFirst();
        System.out.println(r2.get());

        // count는 해당 결과값의 갯수를 반환
        long count = peoples.stream().filter(p->p.getSexEnum() == People.PeopleSex.FEMALE).count();
        System.out.println(count);


        // 모던 자바 이점
//        final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//
//        StringBuilder stringBuilder = new StringBuilder();
//        for (Integer number : numbers) {
//            stringBuilder.append(number).append(" : ");
//        }
//        final int length;
//        if (stringBuilder.length() > 0 ) {
//            length = stringBuilder.length();
//            stringBuilder.delete(length - 3, length);
//        }

//        final int size = numbers.size();
//        for(int i = 0; i< size; i++) {
//            stringBuilder.append(numbers.get(i + 1));
//            if (i != size - 1) {
//                stringBuilder.append(" : ");
//            }
//        }

//        System.out.println(stringBuilder.toString());

//        final String result = numbers.stream()
//                .map(String::valueOf)
//                .collect(joining(" : "));
//        System.out.println(result);
//
//        List<Integer> arrayList = Arrays.asList(1,2,3,4,5);
//
//        arrayList = arrayList.stream().filter(i -> i.intValue() == 1)
//                .sorted(Comparator.comparing(Integer::intValue))
//                .map(Integer::intValue)
//                .collect(Collectors.toList());
//
//        System.out.println(arrayList);



    }
}
