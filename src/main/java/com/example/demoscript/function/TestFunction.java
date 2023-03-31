package com.example.demoscript.function;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author cookie jarvsi
 */
public class TestFunction {
    static class Student {
        String name;
        Integer id;

        public Student(String name, Integer id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public Integer getId() {
            return id;
        }
    }

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(new Student("jack", 1), new Student("tom", 2));
        Function<Student, Integer> function = Student::getId;
        list.stream().map(function).forEach(System.out::println);


    }

}
