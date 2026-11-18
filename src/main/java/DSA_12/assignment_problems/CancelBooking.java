package main.java.DSA_12.assignment_problems;

public class CancelBooking {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node buildBookings(String[] list) {
        if (list == null || list.length == 0) {
            return null;
        }
        Node head = new Node(list[0]);
        Node current = head;
        for (int i = 1; i < list.length; i++) {
            current.next = new Node(list[i]);
            current = current.next;
        }
        return head;
    }

    public static Node removeFirst(Node head, String booking) {
        if (head == null) {
            System.out.println(booking + " not found");
            return null;
        }

        // Case 1: The booking to cancel is at the head
        if (head.data.equals(booking)) {
            return head.next;
        }

        // Case 2: Search for the node just before the matching booking
        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(booking)) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }

        // Case 3: Booking was not found in the chain
        System.out.println(booking + " not found");
        return head;
    }

    public static void printBookings(Node head) {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        // Sample 1
        Node b1 = buildBookings(new String[]{"104", "101", "107", "101"});
        b1 = removeFirst(b1, "101");
        printBookings(b1); // 104 -> 107 -> 101 -> null

        System.out.println();

        // Sample 2
        Node b2 = buildBookings(new String[]{"104", "101", "107"});
        b2 = removeFirst(b2, "104");
        printBookings(b2); // 101 -> 107 -> null

        System.out.println();

        // Sample 3
        Node b3 = buildBookings(new String[]{"104", "101"});
        b3 = removeFirst(b3, "200"); // Prints: 200 not found
        printBookings(b3);           // 104 -> 101 -> null
    }
}

