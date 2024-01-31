class BST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(" \t" + root.data);
        inorder(root.right);

    }

    // function for cheking valid BST or Not :-

    public static boolean check(Node root) {
        if (root.left == null || root.right == null) {
            return true;
        }

        else if (root.data > root.left.data && root.data < root.right.data) {
            return check(root.right) && check(root.left);

        }
        return false;
    }



    public static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.data < data) {
            root.right = insert(root.right, data);
        } else {
            root.left = insert(root.left, data);
        }

        return root;

    }



    public static Node inordersucc(Node root) {

        if (root.left == null) {
            return root;
        }
        return inordersucc(root.left);

    }

    
    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(7);

        root.left.right = new Node(3);
        root.left.right.left = new Node(2);
        root.left.right.right = new Node(4);

        inorder(root);
        System.out.println();
        System.out.println(check(root));
        insert(root, 10);
        insert(root, 20);
        inorder(root);
    }

}
