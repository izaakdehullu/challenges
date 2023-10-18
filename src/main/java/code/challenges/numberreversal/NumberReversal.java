package main.java.code.challenges.numberreversal;

/**
 * <p>
 * 
 * This one is a technical interview favorite. For a given input number, return
 * the number in reverse. So, an input of 3956 should return 6593.
 * 
 * If you’re ready for a bigger challenge, reverse a decimal number. The decimal
 * point should stay in the same place. So, the number 193.56 should output
 * 653.91.
 */
public class NumberReversal {

    private static final int INPUTNUMBER1 = 3956;
    private static final double INPUTNUMBER2 = 193.56;

    public static void main(String[] args) {

        // getResult1();
        getResult2();

    }

    private static void getResult2() {
        String str = String.valueOf(INPUTNUMBER2);
        char[] charArray = str.toCharArray();
        char[] charArray2 = new char[str.length()];
        int idxDot = str.indexOf(".");
        charArray2[str.indexOf(".")] = '.';

        for (int i = 0; i <= str.length() - 1; i++) {
            if (i < idxDot) {
                if (charArray[str.length() - i - 1] == '.') {
                    charArray2[i] = charArray[str.length() - i - 2];
                } else {
                    charArray2[i] = charArray[str.length() - i - 1];
                }
            }
            if (i > idxDot) {
                charArray2[i] = charArray[str.length() - i - 1] ;
            }
        }
        System.out.println(new String(charArray2));

    }

    private static void getResult1() {
        String str = String.valueOf(INPUTNUMBER1);
        StringBuffer sbr = new StringBuffer(str);
        sbr.reverse();
        int result = Integer.valueOf(sbr.toString());
        System.out.println(result);
    }

}
