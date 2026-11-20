
package LambdaExpression;

@FunctionalInterface
interface Calculate {
    int calculate(int a, int b);
}

public class Calculator {
    public static void main(String[] args) {

        Calculate add = (a, b) -> a + b;
        Calculate sub = (a, b) -> a - b;
        Calculate mul = (a, b) -> a * b;
        Calculate div = (a, b) -> a / b;
        Calculate mod = (a, b) -> a % b;

        System.out.println("Addition: " + add.calculate(20, 10));
        System.out.println("Subtraction: " + sub.calculate(20, 10));
        System.out.println("Multiplication: " + mul.calculate(20, 10));
        System.out.println("Division: " + div.calculate(20, 10));
        System.out.println("Modulus: " + mod.calculate(20, 10));
    }
}