package aula05;

public class Fibonacci {

    public static long fibRecursivo(int n) {
        if (n <= 1) return n;
        return fibRecursivo(n - 1) + fibRecursivo(n - 2);
    }

    public static long fibIterativo(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        //Exercício - faça para 10, 20, 50, 100, 1000
        int[] valores = {10, 20, 50, 100, 1000};

        for (int n : valores) {
            System.out.println("Iterativo(" + n + ") = " + fibIterativo(n));

            if (n <= 35) {
                System.out.println("Recursivo(" + n + ") = " + fibRecursivo(n));
            }
        }
    }
}