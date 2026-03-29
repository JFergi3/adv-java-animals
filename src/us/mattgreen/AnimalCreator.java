package us.mattgreen;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class AnimalCreator {
    /*
        - private for controlled access
        - final = reference cant change
        - reuse one scanner, don't recreate
    */

    private final  ArrayList<Talkable> zoo;
    private final Scanner scanner;

    public AnimalCreator(ArrayList<Talkable> zoo) {
        this.zoo = zoo;
        this.scanner = new Scanner(System.in);
    }

    public void addAnimalToList(){
        // Set up to use a break versus a return.
        boolean validChoice = false;

        while (!validChoice) {
            System.out.println("What Animal would you like to create? (dog, cat, or teacher): ");
            String choice = scanner.nextLine().trim().toLowerCase(); //normalize input

            switch (choice) { // clean selection for one variable
                case "dog": zoo.add(createDog()); validChoice = true; break;
                case "cat": zoo.add(createCat()); validChoice = true; break;
                case "teacher": zoo.add(createTeacher()); validChoice = true; break;
                default:
                    System.out.println("Invalid Choice");

            }
        }
    }

    private Dog createDog(){
        String name = readNonEmptyString("Enter the dog's name: ");
        boolean friendly = readBoolean("Is the dog friendly? (true/false): ");
        return new Dog(friendly, name);
    }

    private Cat createCat(){
        String name = readNonEmptyString("Enter the cat's name: ");
        int miceKilled = readInt("Enter a number of mice killed: ");
        return new Cat(miceKilled, name);
    }

    private Teacher createTeacher(){
        String name = readNonEmptyString("Enter the teacher name: ");
        int age = readInt("Enter the teacher's age: ");
        return new Teacher(age, name);
    }

    private String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input; // cannot be blank
            }

            System.out.println("Input cannot be blank. ");
        }
    }

    private int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim()); // safe parse
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter whole number.");
            }
        }
    }

    private boolean readBoolean(String prompt) {
        while(true) {
                System.out.print(prompt);
                String input = scanner.nextLine().trim().toLowerCase();

                if (input.equals("yes") || input.equals("y")) return true;
                if (input.equals("no") || input.equals("n")) return false;
            System.out.println("Enter yer or no.");
        }
    }
}
