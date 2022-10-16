package Baekjoon.Greedy;

import java.io.*;

public class Main1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String temp = "";
        boolean flag = false;
        int result = 0;
        for(int i = 0; i < str.length(); i++) {

            if(str.charAt(i) == '+' || str.charAt(i) == '-') {
                if(flag) result -= Integer.parseInt(temp);
                else result += Integer.parseInt(temp);

                temp = "";
            }
            else temp += str.charAt(i);

            if(str.charAt(i) == '-') flag = true;
        }

        if(flag) result -= Integer.parseInt(temp);
        else result += Integer.parseInt(temp);

        System.out.println(result);


    }

}


