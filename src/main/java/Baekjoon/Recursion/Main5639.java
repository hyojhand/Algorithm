package Baekjoon.Recursion;

import java.io.*;
// G5 이진검색트리 (inner class로) - 조건에 맞게 트리 생성 후 후위순회 결과
public class Main5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinaryTree tree = new BinaryTree();

        String input;
        while (true) {
            input = br.readLine();
            if(input == null || input.equals("")) break;
            int num = Integer.parseInt(input);
            tree.createNode(num);
        }
        tree.postorder(tree.root);
    }

    static class BinaryTree {
        BinaryNode root;

        public void createNode(int node) {
            if(root == null) root = new BinaryNode(node);
            else searchNode(root, node);
        }

        public void searchNode(BinaryNode root, int node) {
            if(root == null) return;
            if(root.node > node) {
                if(root.left == null) root.left = new BinaryNode(node);
                else searchNode(root.left, node);
            } else {
                if(root.right == null) root.right = new BinaryNode(node);
                else searchNode(root.right, node);
            }
        }

        // 후위순회 : 좌 -> 우 -> 루트
        public void postorder(BinaryNode root) {
            if(root.left != null) postorder(root.left);
            if(root.right != null) postorder(root.right);
            System.out.println(root.node);
        }
    }

    static class BinaryNode {
        int node;
        BinaryNode left, right;

        public BinaryNode(int node) {
            this.node = node;
        }
    }
}

