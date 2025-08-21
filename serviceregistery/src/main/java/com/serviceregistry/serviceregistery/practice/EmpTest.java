package com.serviceregistry.serviceregistery.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EmpTest {

    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(5,8,9,6,3,15,18,78,24,36,65);

        List<Integer> nums = Arrays.asList(1,2,3,4,2,5,3,6,1);
        List<String> words = Arrays.asList("java", "spring", "microservices", "boot");

        Emp e1 = new Emp(1, "Alice", "IT", 50000);
        Emp e2 = new Emp(2, "Bob", "HR", 40000);
        Emp e3 = new Emp(3, "Charlie", "IT", 55000);
        Emp e4 = new Emp(4, "David", "Finance", 60000);
        Emp e5 = new Emp(5, "Eve", "HR", 45000);
        Emp e6 = new Emp(6, "Frank", "Finance", 65000);

        List<Emp> employees = Arrays.asList(e1, e2, e3, e4, e5, e6);

//        Map<String, Double> collect = employees.stream().collect(Collectors.toMap(Emp::getName, Emp::getSalary));
//        System.out.println(collect);

//        Map<String, List<Emp>> collect1 = employees.stream().collect(Collectors.groupingBy(Emp::getDepartment));
//        System.out.println(collect1);

        //sum total number in given list and find average

//        OptionalDouble average = list.stream().mapToInt(Integer::intValue).average();
//        System.out.println(average);
//        Integer reduce = list.stream().reduce(0, (a, b) -> a + b);
//        System.out.println(reduce);
//
//        employees.stream().filter(emp-> emp.getSalary()>50000).toList()
//                .forEach(System.out::println);
//        Map<String, Double> collect = employees.stream().collect(Collectors.groupingBy(Emp::getDepartment, Collectors.averagingDouble(e -> e.getSalary())));
//        System.out.println(collect);

//        Map<String, Long> collect = employees.stream().collect(Collectors.groupingBy(Emp::getDepartment, Collectors.counting()));
//        System.out.println(collect);
//        Set<Integer> set =new HashSet<>();
//        Set<Integer> collect = nums.stream().filter(n -> !set.add(n)).collect(Collectors.toSet());
//         System.out.println(collect);
//        Set<Integer> collect = nums.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()))
//                .entrySet().stream()
//                .filter(e -> e.getValue() > 1)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toSet());
//        System.out.println(collect);

          String str ="swiss";
//        Character c1 = str.chars().mapToObj(c -> Character.valueOf((char) c))
//                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
//                .entrySet()
//                .stream()
//                .filter(e -> e.getValue() > 1)
//                .map(e -> e.getKey())
//                .findFirst().get();
//        System.out.println(c1);
//        List<String> sorted = words.stream().sorted(Comparator.comparingInt(String::length).reversed()).toList();
//        System.out.println(sorted);
//        Integer i = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
//        System.out.println(i);
//        String collect = words.stream().collect(Collectors.joining(","));
//        System.out.println(collect);
//        Map<Integer, String> collect = employees.stream().collect(Collectors.toMap(Emp::getId, Emp::getName));
//        System.out.println(collect);

//        List<String> list1 = employees.stream().filter(e -> e.getSalary() > 50000)
//                .sorted(Comparator.comparing(Emp::getSalary).reversed())
//                .map(Emp::getName).toList();
//        System.out.println(list1);
//        Set<Integer> collect = nums.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()))
//                .entrySet().stream()
//                .filter(e -> e.getValue() > 1)
//                .map(e -> e.getKey())
//                .collect(Collectors.toSet());
//        System.out.println(collect);

//        Character c1 = str.chars().mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
//                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
//                .entrySet().stream()
//                .filter(e -> e.getValue() == 1)
//                .map(e -> e.getKey())
//                .findFirst().get();
//        System.out.println(c1);
//      employees.stream().sorted(Comparator.comparing(Emp::getSalary).reversed()).skip(1).findFirst()
//                        .ifPresent(System.out::println);
//        Map<String, List<String>> collect = employees.stream()
//                .collect(Collectors.groupingBy(Emp::getDepartment, Collectors.mapping(Emp::getName, Collectors.toList())));
//
//        System.out.println(collect);

//        String freq ="Java Java Spring Boot Boot Spring";
//        Map<Character, Long> collect = freq.chars().mapToObj(s -> Character.toLowerCase((char) s)).filter(ch->ch != ' ')
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(collect);
//        Map<String, Long> collect1 = Arrays.stream(freq.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(collect1);

//        List<List<Integer>> nestedList = Arrays.asList(
//                Arrays.asList(1, 2),
//                Arrays.asList(3, 4),
//                Arrays.asList(5, 6));
//
//        List<Integer> list1 = nestedList.stream().flatMap(List::stream).toList();
//        System.out.println(list1);
//        Map<String, Optional<Emp>> collect = employees.stream().collect(Collectors
//                .groupingBy(Emp::getDepartment, Collectors.maxBy(Comparator.comparing(Emp::getSalary))));
//        System.out.println(collect);

//        String Anagram = "listen";
//        String Anagram1 = "silent";
//
//
//        String collect = Anagram.chars().mapToObj(c -> (char) c).sorted().map(String::valueOf).collect(Collectors.joining());
//        String collect1 = Anagram1.chars().mapToObj(c -> (char) c).sorted().map(String::valueOf).collect(Collectors.joining());
//        System.out.println(collect.equals(collect1));
//        List<Integer> list1 = list.stream().filter(nums::contains).toList();
//        System.out.println(list1);
//        String val="Java 8 is powerful";
//        String reduce = Arrays.stream(val.split("")).reduce("", (a, b) -> b + a);
//        System.out.println(reduce);
//
//        List<String> namefre=Arrays.asList("John"," Alex","John", "Mark"," Alex");
//        Map<String, Long> collect = namefre.stream().filter(n -> Collections.frequency(namefre, n) > 1)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(collect);
//
//        List<String> list1 = list.stream().map(s -> s + " ").filter(s -> s.startsWith("1")).toList();
//        System.out.println(list1);

//        words.stream().max(Comparator.comparing(String::length)).ifPresent(System.out::println);
//        int reduce = IntStream.rangeClosed(0, 100).filter(n->n%2==0).sum();
//        System.out.println(reduce);
//
//        String chart="banana";
//        Map<String, Long> collect = Arrays.stream(chart.split("")).map(s->s.toLowerCase())
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(collect);

//        String collect = list.stream().map(c -> c + "").collect(Collectors.joining(" ,"));
//        System.out.println(collect);

//        Map<Boolean, List<Integer>> collect = list.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
//        System.out.println(collect);


    }
}
