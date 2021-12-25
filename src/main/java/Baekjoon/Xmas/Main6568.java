package Baekjoon.Xmas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main6568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        while(br.readLine() != null) {
            int num = (Integer.parseInt(br.readLine(), 2));
            int cmd = num/32;
            int value = cmd%32;

            switch (num) {
                case 0:
                    break;
                case 1:
                    break;

            }

        }
    }
}