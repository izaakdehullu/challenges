package main.java.code.challenges.armstrongnumbers;

/**
 * <p>
 * An Armstrong number is a whole number that’s equal to the sum of its digits
 * raised to the power of the total number of digits. For example, 153 is an
 * Armstrong number because there are three digits, and 153 = 27 + 125 + 1. The
 * four-digit number 8208 is also an Armstrong number, as 8208 = 4096 + 16 + 0 +
 * 4096.
 * 
 * Create an Armstrong number checker that returns a Boolean TRUE if the input
 * number is an Armstrong number. Hint: to extract each digit from a given
 * number, try using the remainder/modulo operator.
 * 
 * If you’re looking for something a little more challenging, create an
 * Armstrong number calculator that returns all Armstrong numbers between 0 and
 * the input number.
 */
public class ArmstrongNumbers {

    public static void main(String[] args) {
        int number = 153;
        if (isArmstrongNumber2(number)) {
            System.out.println(number + " is a Armstrong Numbers.");
        } else {
            System.out.println(number + " is **not** a Armstrong Numbers.");
        }
        number = 8208;
        if (isArmstrongNumber2(number)) {
            System.out.println(number + " is a Armstrong Numbers.");
        } else {
            System.out.println(number + " is **not** a Armstrong Numbers.");
        }
        number = 370;
        if (isArmstrongNumber2(number)) {
            System.out.println(number + " is a Armstrong Numbers.");
        } else {
            System.out.println(number + " is **not** a Armstrong Numbers.");
        }

        number = 153;
        if (isArmstrongNumber(number)) {
            System.out.println(number + " is a Armstrong Numbers.");
        } else {
            System.out.println(number + " is **not** a Armstrong Numbers.");
        }
        number = 8208;
        if (isArmstrongNumber(number)) {
            System.out.println(number + " is a Armstrong Numbers.");
        } else {
            System.out.println(number + " is **not** a Armstrong Numbers.");
        }

    }

    /**
     * <p>
     * Tweede oplossing met modulo
     * 
     * @param number1
     * @return
     */
    private static boolean isArmstrongNumber2(Integer number1) {
        int modulo = 1;
        int number = 0;
        int lastNumber = 0;
        int sum = 0;
        int pow = countDig(number1);
        while (number1 % modulo != number1) {
            modulo = modulo * 10;
            int calc = number1 % modulo;
            number = (calc - lastNumber) / (modulo / 10);
            sum = sum + (int) Math.pow(number, pow);
            lastNumber = calc;
        }
        return sum == number1;
    }

    /**
     * <p>
     * Gejat van https://www.javatpoint.com/how-to-find-length-of-integer-in-java
     * 
     * @param n
     * @return
     */
    public static int countDig(int n) {
        int len = (int) (Math.log10(n) + 1);
        return len;
    }

    /**
     * <p>
     * Eerste oplossing zonder modulo;
     * 
     * @param number
     * @return
     */
    private static boolean isArmstrongNumber(int number) {
        String strNumber = String.valueOf(number);
        int power = strNumber.length();

        int[] split = new int[power];
        int i = 0;
        for (char character : strNumber.toCharArray()) {
            split[i] = character;
            split[i] = split[i] - 48;
            i++;
        }
        int sum = 0;
        for (int integer : split) {
            sum += Math.pow(integer, power);
        }
        return (number == sum);
    }
}
