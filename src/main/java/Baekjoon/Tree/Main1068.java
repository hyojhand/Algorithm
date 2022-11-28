package Baekjoon.Tree;

import java.io.*;
import java.util.*;
// G5 트리
public class Main1068 {
    static List<Integer>[] tree;
    static int deleteNum, result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        tree = new List[N];
        for(int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for(int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if(parent == -1) root = i;
            else tree[parent].add(i);
        }

        deleteNum = Integer.parseInt(br.readLine());
        if(root != deleteNum) delete(root);

        System.out.println(result);
    }

    static void delete(int num) {
        int deleteCount = 0;
        for(int child : tree[num]) {
            if(deleteNum != child) {
                delete(child);
                deleteCount++;
            }
        }

        if(deleteCount == 0) result++;
    }
}

