package Baekjoon.Recursion;

import java.io.*;
import java.util.*;
// S1 트리순회 (Tree, Node 클래스 생성)
public class Main1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.createNode(root,left,right);
        }

        System.out.println(tree.preorder(tree.root));
        System.out.println(tree.inorder(tree.root));
        System.out.println(tree.postorder(tree.root));
    }

}

class Tree {
    Node root;

    public void createNode(char node, char left, char right) {
        if(root == null) {
            root = new Node(node);

            if(left != '.') root.left = new Node(left);
            if(right != '.') root.right = new Node(right);
        } else {
            searchNode(root, node, left, right);
        }
    }

    public void searchNode(Node root, char node, char left, char right) {
        if(root == null) return;
        else if(root.node == node) {
            if(left != '.') root.left = new Node(left);
            if(right != '.') root.right = new Node(right);
        } else {
            searchNode(root.left, node, left, right);
            searchNode(root.right, node, left, right);
        }
    }

    // 전위순회 : 루트 -> 좌 -> 우
    public String preorder(Node root) {
        String answer = "";
        answer += root.node;
        if(root.left != null) answer += preorder(root.left);
        if(root.right != null) answer += preorder(root.right);
        return answer;
    }

    // 중위순회 : 좌 -> 루트 -> 우
    public String inorder(Node root) {
        String answer = "";
        if(root.left != null) answer += inorder(root.left);
        answer += root.node;
        if(root.right != null) answer += inorder(root.right);
        return answer;
    }

    // 후위순회 : 좌 -> 우 -> 루트
    public String postorder(Node root) {
        String answer = "";
        if(root.left != null) answer += postorder(root.left);
        if(root.right != null) answer += postorder(root.right);
        answer += root.node;
        return answer;
    }
}

class Node {
    char node;
    Node left, right;

    public Node(char node) {
        this.node = node;
    }
}

