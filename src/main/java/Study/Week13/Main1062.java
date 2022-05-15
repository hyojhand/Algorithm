package Study.Week13;

import java.io.*;
import java.util.StringTokenizer;
// 가르침
public class Main1062 {
    static boolean[] arr,word;
    static int N,K;
    static int max = 0;
    static String[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new boolean[26];
        arr['a'-97] = true;
        arr['n'-97] = true;
        arr['t'-97] = true;
        arr['i'-97] = true;
        arr['c'-97] = true;

        word = new boolean[26];
        word['a'-97] = true;
        word['n'-97] = true;
        word['t'-97] = true;
        word['i'-97] = true;
        word['c'-97] = true;

        result = new String[N];
        int learn = 0;
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            result[i] = str.substring(4,str.length()-4);
            for(int j = 0; j < result[i].length(); j++) {
                char ch = result[i].charAt(j);
                if(!word[ch-97]) {
                    word[ch-97] = true;
                    learn++;
                }
            }
        }

        K-=5;
        StringBuilder sb = new StringBuilder();
        if(K < 0) sb.append(0);
        else if(K >= learn) sb.append(N);
        else {
            dfs(0,0);
            sb.append(max);
        }
        System.out.println(sb);
    }

    static void dfs(int cnt,int x) {
        if(cnt == K) {
            int count = 0;
            for(int i = 0; i < N; i++) {
                boolean flag = true;
                for(int j = 0; j < result[i].length(); j++) {
                    char ch = result[i].charAt(j);
                    if(!arr[ch-97]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) count++;
            }
            max = Math.max(max, count);
            return;
        }

        for(int i = x; i < 26; i++) {
            if(word[i] && !arr[i]) {
                arr[i] = true;
                dfs(cnt+1, i+1);
                arr[i] = false;
            }
        }

    }
}

