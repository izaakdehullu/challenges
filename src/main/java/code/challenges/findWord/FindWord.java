package main.java.code.challenges.findWord;

import java.util.Scanner;

public class FindWord {

    private static final String LINE1 = "I love Codecademy";

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        String indexStr = myObj.nextLine(); // Read user input
        int index = Integer.valueOf(indexStr);
        findWord(index,LINE1); 
    }

    private static void findWord(int index, String line) {
        String[] splitString = line.split("\\s");

        if (index > splitString.length -1 ) {
            System.err.println("index klopt niet.");
            return;
        }
        int size = splitString.length;

        System.out.print(splitString[index-1]);
        System.out.println("");

    }
}

