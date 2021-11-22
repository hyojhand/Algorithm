package Programmers.Level2;

import java.util.*;

public class PrimeNumber {
    public static void main(String[] args) {
        int num = solution("011");
        System.out.println(num);
    }

    static int answer;
    static boolean[] check;
    static ArrayList<Integer> arr = new ArrayList<Integer>();

    public static int solution(String numbers) {
        String tmp ="";
        check = new boolean[numbers.length()];

        for(int i = 1; i <= numbers.length(); i++){
            dfs(numbers, tmp, i);
        }

        for(int i = 0; i < arr.size(); i++){
            isPrime(arr.get(i));
        }

        return answer;
    }

    static void dfs(String str, String tmp, int dept){
        for(int i = 0; i < str.length(); i++){
            if(tmp.length() == dept){
                if(!arr.contains(Integer.parseInt(tmp)))
                    arr.add(Integer.parseInt(tmp));
                return;
            }
            else{
                if(!check[i]){
                    check[i] = true;
                    tmp += str.charAt(i);

                    dfs(str,tmp,dept);

                    check[i] = false;
                    tmp = tmp.substring(0, tmp.length()-1);

                }
            }
        }
    }

    static void isPrime(int x){
        if(x == 0) return;
        if(x == 1) return;
        for(int i = 2; i < x; i++){
            if(x % i == 0) return;
        }
        answer++;
    }
}

