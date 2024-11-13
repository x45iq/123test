package test.task;

public class Task15 {
    public static void main(String[] args) {
        Node node = new Node("8(3(1,6(4,7)),10(,14(13,)))");
        System.out.println(node.preOrder());
        System.out.println(node.inOrder());
        System.out.println(node.postOrder());
    }
}
