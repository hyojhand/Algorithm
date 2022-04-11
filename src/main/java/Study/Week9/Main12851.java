package Study.Week9;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 숨바꼭질2
public class Main12851 {
    static int N,K;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int t = bfs();
        System.out.println(t);
        System.out.println(count);
    }

    public static int bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.offer(N);
        boolean[] check = new boolean[100001];
        check[N] = true;

        int time = 0;
        while(!que.isEmpty()) {
            if(N == K) {
                count++;
                break;
            }

            int size = que.size();
            for(int i = 0; i < size; i++) {
                int num = que.poll();
                check[num] = true;

                int[] next = {num-1, num+1, num*2};
                for(int k = 0; k < 3; k++) {
                    if(next[k]>=0 && next[k]<= 100000 && !check[next[k]]) {
                        if (next[k] == K) {
                            count++;
                            continue;
                        }
                        que.offer(next[k]);
                    }
                }

            }

            time++;
            if(count != 0) break;
        }
        return time;
    }
}

