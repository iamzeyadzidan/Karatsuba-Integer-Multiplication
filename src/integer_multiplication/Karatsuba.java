package integer_multiplication;

import java.math.BigInteger;

public class Karatsuba {

    /**
     * Returns the result of multiplying two n-bits and m-bits numbers.
     * @param x first n-bits number.
     * @param y second m-bits number.
     * */
    public BigInteger karatsubaIntegerMultiplication(BigInteger x, BigInteger y) {
        if (x.equals(BigInteger.ZERO) || y.equals(BigInteger.ZERO))
            return BigInteger.ZERO;

        if (x.equals(BigInteger.ONE))
            return y;
        else if (y.equals(BigInteger.ONE))
            return x;

        int n = Math.max(x.bitLength(), y.bitLength());
        int halfN = n - n/2;

        BigInteger xZero = Splitter.split(x, false, n);
        BigInteger xOne = Splitter.split(x, true, n);
        BigInteger yZero = Splitter.split(y, false, n);
        BigInteger yOne = Splitter.split(y, true, n);

        BigInteger x0y0 = karatsubaIntegerMultiplication(xZero, yZero);
        BigInteger x1y1 = karatsubaIntegerMultiplication(xOne, yOne);

        // X by Y = x0y0 + (2 to the power of n/2) x middleElement + (2 to the power of n) x1y1
        BigInteger auxiliary = karatsubaIntegerMultiplication(xZero.add(xOne), yZero.add(yOne));

        BigInteger middle = auxiliary.subtract(x0y0).subtract(x1y1);

        return x0y0
                .add(middle.multiply(BigInteger.valueOf(1L << halfN)))
                .add(x1y1.multiply(BigInteger.valueOf(1L << (halfN * 2))));
    }
}
