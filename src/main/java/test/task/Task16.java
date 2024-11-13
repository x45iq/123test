package test.task;

import java.util.Stack;

public class Task16 {
    public static void main(String[] args) {
        Node node = new Node("8(3(1,6(4,7)),10(,14(13,)))");
        Stack<Node> stack = new Stack<>();
        Node curr = node;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                System.out.print(stack.peek().getValue() + " ");

                curr = curr.getLeftChild();
            }
            curr = stack.pop();
            curr = curr.getRightChild();
        }
    }
}
