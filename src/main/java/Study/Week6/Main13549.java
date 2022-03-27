package Study.Week6;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13549 {
    static int count = 0;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        check = new boolean[100001];

        bfs(N,K);
        System.out.println(count);
    }

    static int[] dx = {1,-1};
    public static void bfs(int N,int K) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(N);
        check[N] = true;

        while(!que.isEmpty()) {
            if(check[K]) break;
            count++;

            int size = que.size();
            for(int k = 0; k < size; k++) {
                int num = que.poll();

                for(int i = 0; i < 2; i++) {
                    if(num+dx[i] <= 100000 && num+dx[i] >= 0 && !check[num+dx[i]]) {
                        check[num+dx[i]] = true;
                        que.offer(num+dx[i]);
                    }
                }

                int temp = num;
                while(true) {
                    temp *= 2;
                    if(temp > K+1 || temp == 0) break;
                    check[temp] = true;
                    if(temp == K) count--;
                    for(int i = 0; i < 2; i++) {
                        if(temp+dx[i] <= 100000 && temp+dx[i] >= 0 && !check[temp+dx[i]]) {
                            check[temp+dx[i]] = true;
                            que.offer(temp+dx[i]);
                        }
                    }
                }

            }
        }

    }
}

