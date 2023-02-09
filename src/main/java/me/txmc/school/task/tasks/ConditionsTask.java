package me.txmc.school.task.tasks;

import me.txmc.school.Main;
import me.txmc.school.task.AbstractTask;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ConditionsTask implements AbstractTask {
    @Override
    public void execute(String[] args) throws Throwable {
        int numb = ThreadLocalRandom.current().nextInt(1,100);
        Scanner scanner = new Scanner(System.in);
        int guess = -1;
        while (guess != numb) {
            if (guess != -1) System.out.printf("Hint you are %d away\n", Math.abs(numb - guess));
            System.out.print("Guess a number between 1 and 100: ");
            guess = Main.parseInt(scanner.nextLine()).orElse(guess);
        }
        System.out.printf("Correct! The number was %d", numb);
    }
}
