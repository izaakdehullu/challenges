package main.java.code.challenges.primefactorization;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeFactorization {

    public static void main(String[] args) {

        int num = 30951126;
        int org = num;

        List<Integer> factorTree = new ArrayList<>();
        boolean found = false;
        boolean isPrime = false;
        int i = 2;
        while (i <= org -1 && !isPrime && !found) {
            if (i==org-1) {
                isPrime = true;
            }
            if (isPrime(i)) {
                while (num % i == 0) {
                    factorTree.add(i);
                    num = num / i;
                }
                if (num == 1) {
                    found = true;
                }
            }
            i++;
        }
        if (isPrime) {
           System.out.println(org +" is zelf een priemgetal!"); 
        }
        if (found) {
            System.out.println(factorTree.stream().map(String::valueOf).collect(Collectors.joining("*")));
                    
        }

    }

    private static boolean isPrime(int number) {
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
}
