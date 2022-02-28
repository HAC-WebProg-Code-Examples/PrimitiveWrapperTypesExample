package il.ac.hac.cs;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    // Primitive wrapper types are mandatory in order to use primitives in generic types:
//        ArrayList<int> listOfNums; // This does not compile
        ArrayList<Integer> listOfNums;

        // Wrapper classes are also responsible for parsing string representations of primitives, which is not
        // very SRP - single responsibility principle, at least in my opinion. But it has been this way for a
        // very long time and people are used to it, so it does not make things complicated.
        int five = Integer.parseInt("5");
        double six = Double.parseDouble("6");
        boolean trueThat = Boolean.parseBoolean("true");

        // Wrapper types also contain constant data about the way the primitive type is represented in Java:
        System.out.printf("int is represented using %d bits in Java%n", Integer.SIZE);
        System.out.printf("Number of bytes in int representation is %d%n", Integer.BYTES);
        System.out.printf("The biggest number that can be represented by an int is %d%n", Integer.MAX_VALUE);
        System.out.printf("The smallest number that can be represented by an in is %d%n", Integer.MIN_VALUE);
        // Try to ctrl+lmb (left mouse button) on MAX_VALUE or MIN_VALUE to see the way they are defined,
        // using hex notation: MIN_VALUE = 0x80000000, MAX_VALUE = 0x7fffffff


        // Unsigned operations:
        int one = 1;
        int negOne = -1;
        System.out.printf("Signed division of 1 by -1: %d%n", one / negOne);    // result: -1
        System.out.printf("Unsigned division of 1 by -1: %d%n", Integer.divideUnsigned(one, negOne));   // result: 0
        // The reason for the result of the last division being zero is as follows:
        // the 2's complement representation of -1 is 1111...1111 (32 times), which, when interpreted as
        // an unsigned int, represents a very large number: 2^32 - 1. So the result of this division would be:
        // 1 / (2^32 - 1), which is a positive number, smaller than zero. Since when dividing two integers in java
        // the result is also an integer, we only get the integer part of this number, which is zero.
    }
}
