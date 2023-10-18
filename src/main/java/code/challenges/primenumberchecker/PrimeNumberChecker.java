package main.java.code.challenges.primenumberchecker;

public class PrimeNumberChecker {
    
    static int i = 2;

        // Function check whether a number
    // is prime or not
    public static boolean isPrime(int n)
    {
 
        // Corner cases
        if (n == 0 || n == 1) {
            return false;
        }
 
        // Checking Prime
        if (n == i)
            return true;
 
        // Base cases
        if (n % i == 0) {
            return false;
        }
        i++;
        return isPrime(n);
    }

    private static boolean isPrime2(int number) {
        if (number ==1|| number==2 || number==3) {
            return true;
        }
        for (int i = 3; i < Math.abs(Math.sqrt(number));i++) {
            if (number % i == 0 ) {
                return false;
            }
        }
        return true;
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        if (isPrime2((int)(Math.pow(2,31)-1))){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }


}
