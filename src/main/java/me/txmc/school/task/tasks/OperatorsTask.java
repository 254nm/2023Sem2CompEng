package me.txmc.school.task.tasks;

import me.txmc.school.Main;
import me.txmc.school.task.AbstractTask;

import java.util.Scanner;

public class OperatorsTask implements AbstractTask {
    @Override
    public void execute(String[] args) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the width: ");
        double width = scanner.nextDouble();
        System.out.print("Please enter the height: ");
        double height = scanner.nextDouble();
        Main.clearTerm();
        System.out.printf("Area = %.2f\n", (height*width));
        System.out.printf("Perimeter = %.2f\n", (height*2) + (width*2));
    }
}
