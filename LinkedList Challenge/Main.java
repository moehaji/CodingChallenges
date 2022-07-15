import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 4 -> 1 -> 8 -> 4 -> 5
        // ^
        // |
        // 5 -> 6 -> 1-> 5

        // Created linked list for intersection questions
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(8, node4);
        Node node2 = new Node(1, node3);
        Node node1 = new Node(4, node2); // headA

        Node node9 = new Node(5, node4); // intersects at node4
        Node node8 = new Node(1, node9);
        Node node7 = new Node(6, node8);
        Node node6 = new Node(5, node7); // headB

        Node intersection = getIntersectionNode(node6, node1);
        System.out.println("Intersecting Node at node value of: " + intersection.value);

        // Created linked list for loop detection question
        Node a, b, c, d, e;
        a = new Node(1);
        b = new Node(2);
        c = new Node(3);
        d = new Node(4);
        e = new Node(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = c;

        Node looIspDetected = loopDetection(a);
        System.out.println("Loop is detected at node value of: " + looIspDetected.value);
    }

    public static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null)
            return null;

        Node a_pointer = headA;
        Node b_pointer = headB;

        while (a_pointer != b_pointer) {

            if (a_pointer == null) {
                a_pointer = headB;
            } else {
                a_pointer = a_pointer.next;
            }

            if (b_pointer == null) {
                b_pointer = headA;
            } else {
                b_pointer = b_pointer.next;
            }

        }

        return a_pointer;
    }

    public static Node loopDetection(Node head) {
        ArrayList<Node> nodes = new ArrayList<>();
        Node pointer = head;

        while (pointer != null) {
            if (nodes.contains(pointer)) {
                return pointer;
            } else {
                nodes.add(pointer);
                pointer = pointer.next;
            }
        }

        return null;
    }
}