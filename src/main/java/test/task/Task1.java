package test.task;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Task1 {
    static final Stack<Character> stack = new Stack<>();
    static final Map<Character, Character> map = Map.of('(', ')', '{', '}', '[', ']');
    static final Scanner scanner = new Scanner(System.in);

    static boolean isValid(String line) {
        for (char ch : line.toCharArray()) {
            if (map.containsKey(ch)) {
                stack.push(ch);
            } else if (!stack.isEmpty() && map.get(stack.peek()) == ch) {
                stack.removeLast();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid(scanner.nextLine()) ? "Success" : "Failure");
    }
}
