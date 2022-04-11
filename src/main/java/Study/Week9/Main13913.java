package Study.Week9;

import java.io.*;
import java.util.*;
// 숨바꼭질 4
public class Main13913 {
    static int N,K;
    static int[] path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        path = new int[100001];

        int t = bfs();
        sb.append(t).append('\n');
        Stack<Integer> stack = new Stack<>();
        int num = K;
        while(num != N) {
            stack.push(path[num]);
            num = path[num];
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        sb.append(K);

        System.out.println(sb);
    }

    public static int bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.offer(N);
        boolean[] check = new boolean[100001];
        check[N] = true;

        int time = 0;
        while(!que.isEmpty()) {
            if(N == K) break;

            if(check[K]) break;
            time++;

            int size = que.size();
            for(int i = 0; i < size; i++) {
                int num = que.poll();

                int[] next = {num-1, num+1, num*2};
                for(int k = 0; k < 3; k++) {
                    if(next[k]>=0 && next[k]<= 100000 && !check[next[k]]) {
                        que.offer(next[k]);
                        check[next[k]] = true;
                        path[next[k]]=num;
                    }
                }
            }
        }
        return time;
    }
}


