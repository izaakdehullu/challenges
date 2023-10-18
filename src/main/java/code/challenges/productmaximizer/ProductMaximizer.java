package main.java.code.challenges.productmaximizer;

import java.util.Arrays;

/**
 * <p>
 * For a given input array of numbers, find the two that result in the largest
 * product. The output should include the two numbers in the array along with
 * their product.
 */
public class ProductMaximizer {

    static int[] numbers = new int[] { 410, 747, 965, 332, 334, 462, 233, 902, 33, 272, 293, 996, 237, 662, 191, 588,
            341, 55,
            516, 253, 162, 839, 780, 563, 201, 897, 991, 332, 861, 438, 227, 545, 86, 676, 184, 76, 422, 162, 154, 690,
            966, 670, 99, 852, 646, 641, 287, 566, 757, 391 };

    public static void main(String[] args) {
        Arrays.sort(numbers);
        System.out.println(numbers[numbers.length - 1] + " * " + numbers[numbers.length - 2] + " = "
                + numbers[numbers.length - 1] * numbers[numbers.length - 2]);
    }

}
