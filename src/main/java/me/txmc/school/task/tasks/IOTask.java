package me.txmc.school.task.tasks;

import me.txmc.school.task.AbstractTask;

import java.util.Scanner;

/**
 * @author 254n_m
 * @since 2023/02/07 2:42 PM
 * This file was created as a part of ComputerClass
 */
public class IOTask implements AbstractTask {
    @Override
    public void execute(String[] args) throws Throwable {
        System.out.println("Press Enter to Continue");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("Thank You");
    }
}
