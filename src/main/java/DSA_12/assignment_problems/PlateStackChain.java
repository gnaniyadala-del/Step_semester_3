package main.java.DSA_12.assignment_problems;

public class PlateStackChain {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int size;

    public PlateStackChain() {
        this.top = null;
        this.size = 0;
    }

    public void push(String plate) {
        Node newNode = new Node(plate);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("push " + plate + " -> top " + top.data + ", size " + size);
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("pop -> stack is empty");
            return null;
        }
        String poppedPlate = top.data;
        top = top.next;
        size--;
        System.out.println("pop -> " + poppedPlate + ", size " + size);
        return poppedPlate;
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("peek -> stack is empty");
            return null;
        }
        System.out.println("peek -> " + top.data);
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void checkEmpty() {
        System.out.println("isEmpty -> " + isEmpty());
    }

    public static void main(String[] args) {
        PlateStackChain stack = new PlateStackChain();

        stack.push("P1");
        stack.push("P2");
        stack.peek();
        stack.pop();
        stack.push("P3");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.checkEmpty();
    }
}

