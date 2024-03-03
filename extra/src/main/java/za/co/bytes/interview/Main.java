package za.co.bytes.interview;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ints = {1,2,4,6,7,8};
        System.out.printf("Sum of even from %s is %d", Arrays.toString(ints), new ArrayOfInts().sumEven(ints));
    }
}