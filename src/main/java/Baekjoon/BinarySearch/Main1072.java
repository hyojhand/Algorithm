package Baekjoon.BinarySearch;

import java.io.*;
import java.util.StringTokenizer;
// 게임 S3
public class Main1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = getScore(X,Y);

        if (X == Y || Z == 99) {
            System.out.println(-1);
            return;
        }

        System.out.println(find(X,Y,Z));
    }

    static int find(int X,int Y,int Z) {
        int start = 0;
        int end = 1000000000;

        while(start < end) {
            int mid = (start+end)/2;

            if(getScore(X + mid,Y + mid) <= Z) start = mid+1;
            else end = mid;
        }

        return start;
    }

    static int getScore(int x,int y) {
//        return (int) (((long) y / x) * 100);  // ????
        return (int) (((long) y * 100) / x);
    }
}

