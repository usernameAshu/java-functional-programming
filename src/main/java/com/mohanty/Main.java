package com.mohanty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private int globalVariable = 5;

    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Alice", GENDER.FEMALE),
                new Person("Max", GENDER.MALE),
                new Person("Tintin", GENDER.MALE),
                new Person("Johhny", GENDER.MALE),
                new Person("Alice", GENDER.MALE)
        );
        List<Person> personList = new ArrayList<>();

        Person p1 = new Person("Alice", GENDER.FEMALE);
        Person p2 = new Person("Max", GENDER.FEMALE);
        personList.add(p1);
        personList.add(p2);
        personList.add(new Person("Tintin", GENDER.FEMALE));
        personList.add(new Person("Johhny", GENDER.FEMALE));

        persons.stream()
                .filter(person -> person.getSex().equals(GENDER.MALE))
                .map(person -> person.getName())
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("\n");

        personList.add(p1);
        personList.add(5, new Person("Jam", GENDER.MALE));
        Iterator<Person> personIterator = personList.iterator();
        while (personIterator.hasNext()) {
            System.out.println(personIterator.next().getName());
        }
        synchronized (personList) {
            personList.remove(p1);
        }
        System.out.println("\n");
        Iterator<Person> personIterator2 = personList.iterator();
        while (personIterator2.hasNext()) {
            System.out.println(personIterator2.next().getName());

        }

    }

    static class Person {
        private String name;
        private GENDER sex;

        public Person(String name, GENDER sex) {
            this.name = name;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public static void test() {
            //System.out.println(globalVariable);
            //InnerClass innerClass = new InnerClass();
            Person2.id();
        }

        public GENDER getSex() {
            return sex;
        }
    }

    public enum GENDER {
        MALE, FEMALE;
    }

    static class Person2 {
        private static int id() {
            return 10;
        }
    }


    class InnerClass {
        public void test() {
            System.out.println(globalVariable);
            Person.test();
            Person2.id();
        }
    }

}

class A {
    {
        System.out.println("1");
    }

    public A() {
        System.out.println("A");
    }

}

class B extends A {
    {
        System.out.println("2");
    }

    public B() {
        System.out.println("B");
    }

}

class C extends B {
    private static int a;
    private static StringBuilder b;
    private static char c;

    static {
        System.out.println("3");
        a = 10;
        b = new StringBuilder("Hi");
        c = 'A';
    }

    public static void main(String[] args) {
        change(a, b, c);
        System.out.println(a + " " + b + " " + c);
    }

    static void change(int a, StringBuilder b, char c) {
        a = 100;
        b = b.append(" Ashutosh");
        c = 'B';
    }
}