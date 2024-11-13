package test.task;

import java.util.regex.Pattern;

public class Node {
    private final static Pattern VALUE_REGEX = Pattern.compile("\\d++");
    private final int value;
    private Node leftChild = null;
    private Node rightChild = null;

    public Node(String expression) {
        var matcher = VALUE_REGEX.matcher(expression);
        if (!matcher.find()) throw new IllegalArgumentException(expression);
        this.value = Integer.parseInt(matcher.group(0));
        int index = findIndex(expression);
        if (index == -1) return;
        int startBracerIndex = expression.indexOf("(");
        int endBracerIndex = expression.lastIndexOf(")");
        if (index - startBracerIndex != 1) {
            leftChild = new Node(expression.substring(startBracerIndex + 1, index));
        }
        if (endBracerIndex - index != 1) {
            rightChild = new Node(expression.substring(index + 1, endBracerIndex));
        }
    }

    public String preOrder() {
        StringBuilder buffer = new StringBuilder(String.valueOf(value));
        if (leftChild != null) {
            buffer.append(" ").append(leftChild.preOrder());
        }
        if (rightChild != null) {
            buffer.append(" ").append(rightChild.preOrder());
        }
        return buffer.toString().trim();
    }

    public String inOrder() {
        StringBuilder buffer = new StringBuilder();
        if (leftChild != null) {
            buffer.append(leftChild.inOrder());
        }
        buffer.append(" ").append(value);
        if (rightChild != null) {
            buffer.append(" ").append(rightChild.inOrder());
        }
        return buffer.toString().trim();
    }

    public String postOrder() {
        StringBuilder buffer = new StringBuilder();
        if (leftChild != null) {
            buffer.append(leftChild.postOrder());
        }
        if (rightChild != null) {
            buffer.append(" ").append(rightChild.postOrder());
        }
        buffer.append(" ").append(value);
        return buffer.toString().trim();
    }

    private static int findIndex(String expression) {
        if (!expression.contains("(")) return -1;
        for (int i = expression.indexOf("("), count = 0; i < expression.length(); ++i) {
            switch (expression.charAt(i)) {
                case '(' -> count++;
                case ')' -> count--;
                case ',' -> {
                    if (count == 1) {
                        return i;
                    }
                }
            }
        }
        throw new IllegalArgumentException(expression);
    }
    public boolean hasLeftChild(){
        return leftChild != null;
    }
    public boolean hasRightChild(){
        return rightChild != null;
    }

    public int getValue() {
        return value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }
}
