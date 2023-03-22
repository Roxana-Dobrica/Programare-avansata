package com.mycompany.lab4homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Roxana Dobrica
 */
public class Problem {

    private Map<Student, List<Project>> preferencesMap = new HashMap<>();
    private List<Project> projects = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public Problem(List<Student> students, List<Project> projects) {
        this.students = students;
        this.projects = projects;
    }

    public void addToMap(Student student, List<Project> projects) {
        if(students.contains(student)){
        preferencesMap.put(student, projects);
        }
        else System.out.println("The student" + student + "doesn't exist.");
    }

    public void lowerNumOfPref() {
        Collection<List<Project>> projectsList = preferencesMap.values();
        double average = projectsList.stream()
                .mapToInt(List::size)
                .average()
                .getAsDouble();

        System.out.println("The average number of preferences is : " + average);
        System.out.println("Students that have a number of preferences lower than the average number of preferences : ");
        students.stream()
                .filter(s -> preferencesMap.get(s).size() < average)
                .forEach(System.out::println);
        System.out.println();
    }

    public void greedyMaxCardMatching() {

        Map<Student, Project> maxCardMatching = new HashMap<>();
        
        Map<Project, Boolean> isAvailable = new HashMap<>();
        for (Project proj : projects) {
            isAvailable.put(proj, true);
        }

        for (Student student : preferencesMap.keySet()) {
            int i = 0;
            List<Project> studentProjectsList = new ArrayList<>();
            studentProjectsList = preferencesMap.get(student);
            while (i < studentProjectsList.size() && isAvailable.get(studentProjectsList.get(i)) == false) {
                i++;
            }
            if (i < studentProjectsList.size()) {
                maxCardMatching.put(student, studentProjectsList.get(i));
                isAvailable.put(studentProjectsList.get(i), false);
            } else {
                System.out.println("The student " + student  + " doesn't have a project.");
            }
        }
        System.out.println("The maximum cardinality matching between students and projects is :");
        System.out.println(maxCardMatching);
    }  

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Map.Entry entry : preferencesMap.entrySet()) {
            output.append(entry.getKey());
            output.append(" : ");
            output.append(entry.getValue());
            output.append("\n");
        }
        return output.toString();
    }
    
}
