package main.java.code.challenges.reversal;

public class Reversal {

    private final static String LINE1 = "Dog bites man";
    private final static String LINE2 = "Codecademy is the best!";
    

    public static void main(String[] args) {
        reversal(LINE1);
        reversal(LINE2);
    }

    private static void reversal(String line) {
        String lastChar = "";
        if ("?.!".endsWith(String.valueOf(line.charAt(line.length()-1)))) {
            lastChar = line.substring(line.length()-1, line.length());
            line = line.substring(0, line.length()-1);
        }
        
        String[] splitString = line.split("\\s");
        int size = splitString.length;

        for (int i=0 ; i < size ; i++ ) {
            System.out.print(splitString[size-i-1]);
            if (i!=size-1) {
                System.out.print(" ");
            } else {
                System.out.println(lastChar);
            }
        }
    }
    
}
