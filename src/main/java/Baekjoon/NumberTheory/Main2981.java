package Baekjoon.NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        int[] arr = new int[testcase];
        for(int i = 0; i < testcase; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int gcd_value = arr[1] - arr[0];

        for(int i = 2; i < arr.length; i++) {
            gcd_value = gcd(gcd_value, arr[i] - arr[i-1]);
        }

        for(int i = 2; i <= gcd_value; i++) {
            if(gcd_value % i == 0) {
                System.out.print(i + " ");
            }
        }


    }
    public static int gcd(int x, int y) {
        while(y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }
}
