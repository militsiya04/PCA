import java.util.Scanner;

public class Lab7 {
    // (root -> left -> right)
    public static void preOrder (Node root) {
        if (root == null)
            return;
        System.out.print (root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void task1(Node root) {
        if (root == null)
            return;
        if (root.left != null)
            if (root.data == root.left.data) {
                root.data = 0;
                if (root.left.left != null) {
                    if (root.left.left.data != root.left.data)
                        root.left.data = 0;
                } else
                if (root.data == 0)
                    root.left.data = 0;
            }
        if (root.right != null)
            if (root.data == root.right.data) {
                root.data = 0;
                if (root.right.right != null) {
                    if (root.right.right.data != root.right.data)
                        root.right.data = 0;
                } else
                if (root.data == 0)
                    root.right.data = 0;
            }


        task1(root.left);
        task1(root.right);
    }

    public static void task2 (Node root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        if (root.left != null)
            task2(root.left);
        else
            root.left = insert(root.left, 0);
        if (root.right != null)
            task2(root.right);
        else
            root.right = insert(root.right, 0);
        int temp = root.data;
        root.data += (root.right.data - root.left.data);
        if (root.data > 20)
            System.out.print("\n" +root.data +  " = " +temp + " + " +(root.right.data - root.left.data));
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Task 1: ");
        System.out.print("How many elements in the tree: ");
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            System.out.print("Enter the element: ");
            int data = scan.nextInt();
            root = insert(root, data);
        }
        preOrder(root);
        task1(root);
        System.out.println();
        preOrder(root);
        System.out.println("\n\nTask 2: ");
        System.out.print("How many elements in the second tree: ");
        t = scan.nextInt();
        root = null;
        while (t-- > 0) {
            System.out.print("Enter the elemenent: ");
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
        task2(root);
    }
}
