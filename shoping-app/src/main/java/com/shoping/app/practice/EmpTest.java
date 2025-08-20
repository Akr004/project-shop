package com.shoping.app.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class EmpTest {

    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(5,8,9,6,3,15,78,24,36,65);

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
    }
}
