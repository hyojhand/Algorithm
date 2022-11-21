package Baekjoon.NumberTheory;

import java.io.*;
import java.util.*;
// G5 공약수
public class Main2436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long gcd = Long.parseLong(st.nextToken());
        long lcm = Long.parseLong(st.nextToken());

        long num = gcd * lcm;

        long a = gcd;
        long b = lcm;
        for(long i = 2 * gcd; i * i <= num; i += gcd) {
            if(num % i == 0 && getGcd(i,num/i) == gcd) {
                if(a + b > i + num/i) {
                    a = i;
                    b = num/i;
                }
            }
        }

        System.out.println(a + " " + b);
    }

    static long getGcd (long a,long b) {
        long r = a % b;

        if(r == 0) return b;
        else return getGcd(b, r);
    }
}

