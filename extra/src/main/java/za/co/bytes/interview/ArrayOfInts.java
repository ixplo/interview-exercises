package za.co.bytes.interview;

public class ArrayOfInts {
    public int sumEven(int[] ints) {
        int sum = 0;
        for (int number : ints) {
            if (number % 2 == 0) {
                sum += number;
            }
        }
        return sum;
    }
}
