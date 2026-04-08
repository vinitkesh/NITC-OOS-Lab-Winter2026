import java.math.BigInteger;

// 3. Use Stream.iterate and reduce to calculate the factorial of a given integer n without using 
// any traditional loops.



public class Q3 {
    public static void main(String[] args) {
        int n = 5; // Change this value to calculate factorial for different integers
        BigInteger factorial = java.util.stream.Stream.iterate(BigInteger.ONE, i -> i.add(BigInteger.ONE))
                .limit(n)
                .reduce(BigInteger.ONE, BigInteger::multiply);

        System.out.println("Factorial of " + n + " is: " + factorial);
    }
}