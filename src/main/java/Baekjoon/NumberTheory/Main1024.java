package Baekjoon.NumberTheory;

import java.io.*;
import java.util.*;
// 처음 시작수 = (총합 / 길이) - (길이-1 / 2)
// 연속된 합 = (처음 시작수  + 끝나는 수) * 길이 / 2;
// S2 수열의 합
public class Main1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = Integer.parseInt(st.nextToken());
        int listLength = Integer.parseInt(st.nextToken());

        while(listLength <= 100) {
            int start =  total / listLength - (listLength-1) / 2;
            if(start < 0) break;

            int sumStartToEnd = start * 2 + listLength - 1;
            if(total == (sumStartToEnd * listLength / 2)) {
                for(int i = 0; i < listLength; i++) {
                    sb.append(start+i).append(" ");
                }

                break;
            }
            listLength++;
        }

        if(sb.length() == 0) sb.append(-1);
        System.out.println(sb);
    }
}

