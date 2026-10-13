package LambdaExpression;

import java.util.function.Predicate;

public class PredicateEvenOdd {
    public static void main(String[] args) {

        Predicate<Integer> isEven = n -> n % 2 == 0;

        int n = 25;

        if (isEven.test(n)) {
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }
    }
}