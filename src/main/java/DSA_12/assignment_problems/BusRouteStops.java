package main.java.DSA_12.assignment_problems;

public class BusRouteStops {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node build(String[] stops) {
        if (stops == null || stops.length == 0) {
            return null;
        }

        Node head = new Node(stops[0]);
        Node current = head;

        for (int i = 1; i < stops.length; i++) {
            current.next = new Node(stops[i]);
            current = current.next;
        }

        return head;
    }

    public static void printRoute(Node head) {
        if (head == null) {
            System.out.println("null");
            System.out.println("Stops: 0, First: None, Last: None");
            return;
        }

        Node current = head;
        int count = 0;
        String first = head.data;
        String last = head.data;

        StringBuilder routeOutput = new StringBuilder();

        while (current != null) {
            routeOutput.append(current.data).append(" -> ");
            count++;
            last = current.data;
            current = current.next;
        }
        routeOutput.append("null");

        System.out.println(routeOutput);
        System.out.println("Stops: " + count + ", First: " + first + ", Last: " + last);
    }

    public static void main(String[] args) {
        // Sample 1
        String[] stops1 = {"Tambaram", "Guindy", "TNagar", "Central"};
        Node head1 = build(stops1);
        printRoute(head1);

        System.out.println();

        // Sample 2
        String[] stops2 = {"Potheri"};
        Node head2 = build(stops2);
        printRoute(head2);
    }
}

