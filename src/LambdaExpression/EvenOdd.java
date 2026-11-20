package LambdaExpression;

@FunctionalInterface
interface CheckNumber {
    boolean check(int n);
}

public class EvenOdd {
    public static void main(String[] args) {

        CheckNumber obj = n -> n % 2 == 0;

        int num = 7;

        if (obj.check(num)) {
            System.out.println(num + " is Even");
        } else {
            System.out.println(num + " is Odd");
        }
    }
}