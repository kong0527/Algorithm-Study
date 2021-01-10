import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1991 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        for (int i = 0; i < num; i++) {
            String st[] = br.readLine().split(" ");
            tree.add(st[0].charAt(0), st[1].charAt(0), st[2].charAt(0));
        }

        Tree.preorder(tree.root);
        System.out.println();
        Tree.inorder(tree.root);
        System.out.println();
        Tree.postorder(tree.root);
    }
}

class Node {
    char data;
    Node left, right;

    public Node(char data) {
        this.data = data;
    }
}

class Tree {
    Node root;

    public void add(char data, char leftData, char rightData){
        if (root == null) {
            if (data != '.') {
                root = new Node(data);
            }
            if (leftData != '.') {
                root.left = new Node(leftData);
            }
            if (rightData != '.') {
                root.right = new Node(rightData);
            }
        }
        else search(root, data, leftData, rightData);
    }

    private void search(Node root, char data, char leftData, char rightData){
        if (root == null) {
            return;
        }
        else if (root.data == data){
            if (leftData != '.') {
                root.left = new Node(leftData);
            }
            if (rightData != '.') {
                root.right = new Node(rightData);
            }
        }
        else {
            search(root.left, data, leftData, rightData);
            search(root.right, data, leftData, rightData);
        }
    }

    public static void preorder(Node root) {
        System.out.print(root.data);
        if (root.left != null) {
            preorder(root.left);
        }
        if (root.right != null) {
            preorder(root.right);
        }
    }

    public static void inorder(Node root) {
        if (root.left != null) {
            inorder(root.left);
        }
        System.out.print(root.data);
        if (root.right != null) {
            inorder(root.right);
        }
    }

    public static void postorder(Node root) {
        if (root.left != null) {
            postorder(root.left);
        }
        if (root.right != null) {
            postorder(root.right);
        }
        System.out.print(root.data);
    }
}