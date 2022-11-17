package integer_multiplication;

import java.math.BigInteger;

public class Splitter {

    private Splitter() {}

    /**
     * Splitter method splits a number into two halves and returns one of the halves.
     * @param bigInteger the integer to be split.
     * @param half which half to return.
     * @param length number of bits in the number.
     * */
    public static BigInteger split(BigInteger bigInteger, boolean half, int length) {
        // The half indicates which half is required. True stands for left, false stands for right.
        int mid = (length - 1) / 2;

        if (half) {
            BigInteger left = bigInteger;
            for (int i = 0 ; i <= mid; i++)
                left = left.shiftRight(1);
            return left;
        }

        BigInteger right = BigInteger.ZERO;
        for (int i = 0; i <= mid; i++) {
            if (bigInteger.testBit(i))
                right = right.setBit(i);
        }
        return right;
    }
}
