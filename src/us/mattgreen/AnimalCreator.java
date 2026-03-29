package us.mattgreen;

import java.util.ArrayList;
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
}
