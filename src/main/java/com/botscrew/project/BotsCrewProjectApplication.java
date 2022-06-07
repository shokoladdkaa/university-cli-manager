package com.botscrew.project;

import com.botscrew.project.command.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class BotsCrewProjectApplication implements CommandLineRunner {

    @Autowired
    private CommandHandler commandHandler;

    public static void main(String[] args) {
        SpringApplication.run(BotsCrewProjectApplication.class, args);
    }

    @Override
    public void run(String... args) {
        while (true) {
            showMenu();
            String command = new Scanner(System.in).nextLine();
            commandHandler.handle(command);
        }
    }

    private void showMenu() {
        System.out.println("\nPlease choose command!\n");

        System.out.println(">> LIST OF COMMANDS <<");
        System.out.println("1. Who is head of department {department_name}");
        System.out.println("2. Show {department_name} statistics");
        System.out.println("3. Show the average salary for the department {department_name}");
        System.out.println("4. Show count of employee for {department_name}");
        System.out.println("5. Global search by {template}");
        System.out.println("\n");
        System.out.println("Enter your command: ");
    }
}
