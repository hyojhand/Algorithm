package Study.Week10;

import java.io.*;
import java.util.*;
// 스타트 링크
public class Main5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int num = bfs(F,S,G,U,D);
        if(num < 0) System.out.println("use the stairs");
        else System.out.println(num);
    }

    static int bfs(int F,int S,int G,int U,int D) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(S);
        boolean[] check = new boolean[F+1];
        check[S] = true;
        int count = 0;

        while(!que.isEmpty()) {

            int size = que.size();
            if(check[G]) break;
            count++;
            for(int i = 0; i < size; i++) {
                int num = que.poll();

                int nu = num + U;
                int nd = num - D;

                if(nu <= F && !check[nu]) {
                    check[nu] = true;
                    que.offer(nu);
                }

                if(nd > 0 && !check[nd]) {
                    check[nd] = true;
                    que.offer(nd);
                }

            }
        }

        if(!check[G]) return -1;
        return count;
    }
}
