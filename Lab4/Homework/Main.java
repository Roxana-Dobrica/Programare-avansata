package com.mycompany.lab4homework;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Roxana Dobrica
 */
public class Main {

    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 4)
                .mapToObj(i -> new Student(new Faker().name().fullName()))
                .collect(Collectors.toList());

        var projects = IntStream.rangeClosed(0, 4)
                .mapToObj(i -> new Project(new Faker().name().title()))
                .collect(Collectors.toList());

        Problem instance = new Problem(students, projects);
        instance.addToMap(students.get(0), Arrays.asList(projects.get(0), projects.get(1)));
        instance.addToMap(students.get(1), Arrays.asList(projects.get(1), projects.get(2)));
        instance.addToMap(students.get(2), Arrays.asList(projects.get(2), projects.get(3)));
        instance.addToMap(students.get(3), Arrays.asList(projects.get(3), projects.get(4), projects.get(2)));
        instance.addToMap(students.get(4), Arrays.asList(projects.get(4)));

        System.out.println(instance);
        instance.lowerNumOfPref();
        instance.greedyMaxCardMatching();
    }
}
