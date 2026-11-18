package main.java.DSA_12.assignment_problems;

public class BookCopyFinder {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node buildTrolley(String[] bookIds) {
        if (bookIds == null || bookIds.length == 0) {
            return null;
        }
        Node head = new Node(bookIds[0]);
        Node current = head;
        for (int i = 1; i < bookIds.length; i++) {
            current.next = new Node(bookIds[i]);
            current = current.next;
        }
        return head;
    }

    public static String find(Node head, String id) {
        Node current = head;
        int position = 1;
        int firstPosition = -1;
        int copies = 0;

        while (current != null) {
            if (current.data.equals(id)) {
                if (firstPosition == -1) {
                    firstPosition = position;
                }
                copies++;
            }
            position++;
            current = current.next;
        }

        if (copies == 0) {
            return id + " not found";
        }
        return id + " first at position " + firstPosition + ", copies: " + copies;
    }

    public static void main(String[] args) {
        String[] books = {"B12", "B07", "B30", "B07", "B45", "B07"};
        Node trolley = buildTrolley(books);

        // Sample 1
        System.out.println(find(trolley, "B07")); // B07 first at position 2, copies: 3

        // Sample 2
        System.out.println(find(trolley, "B99")); // B99 not found
    }
}

