public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BinaryTree btree = new BinaryTree();
        btree.add(10);
        btree.add(20);
        btree.add(6);
        btree.add(9);
        System.out.println(btree.root.data);
        Node zaki = btree.search(btree.root, 20);
        btree.deleteKey(200);
        System.out.println(zaki.data);
    }
}