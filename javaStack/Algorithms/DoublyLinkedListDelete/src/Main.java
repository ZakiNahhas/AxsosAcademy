public class Main {
    public static void main(String[] args) {
        DeleteNodeFromList obj = new DeleteNodeFromList();

        obj.addNewNode("Laith");
        obj.addNewNode("Zaki");
        obj.addNewNode("Yosef");
        obj.addNewNode("Izzzz");
        obj.addNewNode("SpongeBoob");
        System.out.println();
        obj.showData();
        System.out.println();
        obj.deleteNodeAtSpecifiedLocation(4);
        obj.deleteNodeAtSpecifiedLocation(1);
        obj.deleteNodeAtSpecifiedLocation(6);

        obj.showData();
    }

    public static class DeleteNodeFromList {

        int  size = 0;
        Node head = null;
        Node tail = null;

        public void addNewNode(String data) {

            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                tail = newNode;
                head.prev = null;
                tail.next = null;
            } else {

                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                tail.next = null;
            }
            size++;
        }

        public void deleteFirstNode() {
            head = head.next;
        }

        public void deleteLastNode() {
            tail = tail.prev;
        }

        //Create deleteNodeAtSpecifiedLocation() method for deleting a node from DDL
        public void deleteNodeAtSpecifiedLocation(int position) {

            if (head == null || position > size) {
                System.out.println("\n" + position + "th position is not available\n");
            } else {
                if (position == 1) {

                    deleteFirstNode();
                    size--;
                } else if (position == size) {
                    deleteLastNode();

                    size--;
                } else {
                    Node current = head;

                    for (int i = 1; i < position; i++) {
                        current = current.next;
                    }

                    current.next.prev = current.prev;
                    current.prev.next = current.next;
                }
                System.out.println(position + " node is deleted successfully from DDL");
            }
        }

        public void showData() {
            Node current = head;
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            System.out.println("Nodes of doubly linked list: ");
            while (current != null) {
                System.out.print(current.data + "\n");
                current = current.next;
            }
        }

        class Node {
            String data;
            Node   prev;
            Node   next;

            public Node(String data) {
                this.data = data;
            }
        }
    }
}
