public class BinaryTree {
    public Node root;

    public BinaryTree(int y) {
        root = new Node(y);
    }

    public BinaryTree() {
        root = null;
    }

    public Node add(int data) {
        Node newNode = new Node(data);
        Node current = this.root;
        Node prev = null;

        while (current != null) {
            prev = current;
            if (data == current.data) {
                System.out.println("The key: " + data + "already exists");
                return null;
            } else if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
            if (prev == null) {
                this.root = newNode;
            } else if (data < prev.data) {
                prev.left = newNode;
            } else {
                prev.right = newNode;
            }

        return null;
    }
    public Node search(Node root, int data) {
        if(root == null){
            return null;}
        if(root.data == data){
            return root;}
        if(data < root.data){
            return search(root.left, data);}
        else if (data > root.data){
            return search(root.right, data);}
        return null;
    }

    void deleteKey(int data) { root = deleteRec(root, data); }

    /* A recursive function to
      delete an existing data in BST
     */
    Node deleteRec(Node root, int data)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;

        /* Otherwise, recur down the tree */
        if (data < root.data)
            root.left = deleteRec(root.left, data);
        else if (data > root.data)
            root.right = deleteRec(root.right, data);

            // if data is same as root's
            // data, then This is the
            // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    int minValue(Node root)
    {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

}
