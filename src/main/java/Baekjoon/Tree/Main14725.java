package Baekjoon.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

// 개미굴
public class Main14725 {
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            Node current = root;
            for(int j = 0; j < K; j++) {
                String name = st.nextToken();
                if(!current.childNode.containsKey(name)) {
                    current.childNode.put(name, new Node());
                }
                current = current.childNode.get(name);
            }
        }

        print(root, "");

        System.out.println(result);
    }

    static void print(Node current, String dept) {
        ArrayList<String> keyList = new ArrayList<>(current.childNode.keySet());
        Collections.sort(keyList);
        for(String name : keyList) {
            result.append(dept).append(name).append('\n');
            print(current.childNode.get(name), dept + "--");
        }
    }

    static class Node {
        HashMap<String, Node> childNode = new HashMap<>();

        public Node() {
        }
    }
}

