package me.txmc.school.task.tasks;

import me.txmc.school.Main;
import me.txmc.school.task.AbstractTask;

/**
 * @author 254n_m
 * @since 2023/02/07 2:57 PM
 * This file was created as a part of ComputerClass
 */
public class InvalidTask implements AbstractTask {
    @Override
    public void execute(String[] args) throws Throwable {
        System.out.println("The task you selected does not exist. Please try again");
        Main.clearTerm();
        new Main().init(args);
    }
}
