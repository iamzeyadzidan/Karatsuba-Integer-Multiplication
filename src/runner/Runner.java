package runner;

import integer_multiplication.Karatsuba;

import java.math.BigInteger;

public class Runner {
    public static void main(String[] args) {
        BigInteger karatsubaResult = new Karatsuba()
                .karatsubaIntegerMultiplication(BigInteger.valueOf(5), BigInteger.valueOf(70));
        System.out.println(karatsubaResult);
    }
}
