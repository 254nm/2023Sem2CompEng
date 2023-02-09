package me.txmc.school.task.tasks;

import me.txmc.school.Main;
import me.txmc.school.task.AbstractTask;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class LoopsTask implements AbstractTask {
    @Override
    public void execute(String[] args) throws Throwable {
        int numb = ThreadLocalRandom.current().nextInt(1, 100);
        Scanner scanner = new Scanner(System.in);
        int guessCount = 0;
        int guess = -1;
        while (guess != numb) {
            if (guess != -1) System.out.printf("Hint you are %d away\n", Math.abs(numb - guess));
            System.out.print("Guess a number between 1 and 100: ");
            if (guessCount >= 3)  {
                System.out.printf("\nFailed due to too many guesses. The number was %d", numb);
                return;
            }
            guess = Main.parseInt(scanner.nextLine()).orElse(guess);
            guessCount++;
        }
        System.out.printf("Correct! The number was %d", numb);
    }
}
