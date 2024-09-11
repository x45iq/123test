package test.task;

import java.util.Scanner;

import static java.lang.Math.*;

public class Task3 {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        for (int k = 0; k < log(n) / log(3); k++) {
            for (int l = 0; l < log(n) / log(5); l++) {
                for (int m = 0; m < log(n) / log(7); m++) {
                    double res = pow(3, k) * pow(5, l) * pow(7, m);
                    if (res <= n) {
                        System.out.println((long) res);
                    }
                }
            }
        }
    }
}
