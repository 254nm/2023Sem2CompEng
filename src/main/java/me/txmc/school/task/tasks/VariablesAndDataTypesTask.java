package me.txmc.school.task.tasks;

import me.txmc.school.Main;
import me.txmc.school.task.AbstractTask;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.Scanner;

public class VariablesAndDataTypesTask implements AbstractTask {
    @Override
    public void execute(String[] args) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Please enter your age: ");
        int age = scanner.nextInt();
        System.out.print("Please enter your height (Centimeters): ");
        int height = scanner.nextInt();
        System.out.print("Please enter your favourite colour: ");
        String colour = scanner.next();
        System.out.print("Please enter your favourite animal: ");
        String animal = scanner.next();
        Main.clearTerm();
        Person person = new Person(name,age,height,colour,animal);
        System.out.println(person);
    }

    private static class Person {
        private final String name;
        private final int age;
        private final int height;
        private final String favColour;
        private final String favAnimal;

        public Person(String name, int age, int height, String favColour, String favAnimal) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.favColour = favColour;
            this.favAnimal = favAnimal;
        }

        @Override
        public String toString() {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("Person(");
                int i = 0;
                for (Field field : getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    if (i >= 1) sb.append(" ");
                    sb.append(field.getName()).append(": ").append(field.get(this));
                    i++;
                }
                sb.append(")");
                return sb.toString();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
