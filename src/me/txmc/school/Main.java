package me.txmc.school;

import me.txmc.school.task.AbstractTask;
import me.txmc.school.task.tasks.*;

import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private HashMap<Integer, AbstractTask> tasks = new HashMap<Integer, AbstractTask>() {{
        put(1, new IOTask());
    }};
    public static void main(String[] args) throws Throwable {
        new Main().init(args);
    }
    public void init(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Please select a task from the list: ");
        tasks.forEach((i, t) -> sb.append(i).append(" (").append(t.getClass().getSimpleName()).append("), "));
        System.out.println(sb.substring(0, sb.length() - 2));
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        parseInt(input).ifPresentOrElse(i -> {
            AbstractTask task = Optional.ofNullable(tasks.get(i)).orElse(new InvalidTask());
            try {
                clearTerm();
                System.out.printf("The following output is from task %d\n", i);
                task.execute(args);
            } catch (Throwable e) {
                System.out.printf("The task failed due to %s. Please see the stacktrace below for more info", e.getClass().getSimpleName());
                e.printStackTrace();
            }
        }, () -> {
            System.out.printf("'%s' is not a valid input. Please try again.", input);
            init(args);
        });
    }
    private Optional<Integer> parseInt(String input) {
        try {
            return Optional.of(Integer.parseInt(input));
        } catch (NumberFormatException nfe) {
            return Optional.empty();
        }
    }
    public static void clearTerm() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}