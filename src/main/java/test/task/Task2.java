package test.task;

import java.util.*;
import java.util.function.DoubleBinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task2 {
    enum Op {
        SUM("+", 2, Double::sum), SUB("-", 2, (i1, i2) -> i1 - i2), MUL("*", 1, (i1, i2) -> i1 * i2), DIV("/", 1, (i1, i2) -> {
            if (i2 == 0) throw new ArithmeticException("Zero division");
            return i1 / i2;
        });
        private final String symbol;
        private final int priority;
        private final DoubleBinaryOperator function;
        private static final Map<String, Op> map = Arrays.stream(values()).collect(Collectors.toMap(Op::getSymbol, s -> s));

        static Op fromString(String str) {
            return map.get(str);
        }

        Op(String symbol, int priority, DoubleBinaryOperator function) {
            this.symbol = symbol;
            this.priority = priority;
            this.function = function;
        }

        public String getSymbol() {
            return symbol;
        }

        public int getPriority() {
            return priority;
        }

        public double execute(double i1, double i2) {
            return function.applyAsDouble(i1, i2);
        }
    }

    static final Pattern regex = Pattern.compile("(\\d++|[+\\-*/()])");
    static final Scanner scanner = new Scanner(System.in);

    static Stack<String> toPolish(String equation) {
        Stack<String> stack = new Stack<>();
        Stack<String> export = new Stack<>();
        Matcher matcher = regex.matcher(equation);
        while (matcher.find()) {
            String current = matcher.group(1);
            if (current.matches("\\d++")) {
                export.add(current);
                continue;
            }
            outer:
            switch (current) {
                case "(" -> stack.add("(");
                case ")" -> {
                    String str;
                    while (!stack.isEmpty()) {
                        str = stack.pop();
                        if (str.equals("(")) {
                            break outer;
                        } else {
                            export.add(str);
                        }
                    }
                    throw new RuntimeException();
                }
                case "+", "-", "*", "/" -> {
                    String str;
                    while (!stack.isEmpty()) {
                        str = stack.peek();
                        if (str.equals("(")) {
                            break;
                        } else if (Op.fromString(str).getPriority() < Op.fromString(current).getPriority()) {
                            export.add(stack.pop());
                        } else {
                            break;
                        }
                    }
                    stack.add(current);
                }
            }
        }
        while (!stack.isEmpty()) export.add(stack.pop());
        return export;
    }

    static double execute(Stack<String> polish) {
        Stack<Double> stack = new Stack<>();
        for (String current : polish) {
            if (current.matches("\\d++")) stack.add(Double.parseDouble(current));
            else {
                double b = stack.pop();
                double a = stack.pop();
                stack.add(Op.fromString(current).execute(a, b));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Stack<String> polish = toPolish(scanner.nextLine());
        System.out.println(execute(polish));
    }
}
