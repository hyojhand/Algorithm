package Study.Week9;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
// 플로이드2
public class Main11780 {
    static final int INF = 9999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][N+1];
        int[][] path = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                path[i][j] = INF;
                if(i != j) arr[i][j] = INF;
            }
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(arr[a][b] > c) {
                path[a][b] = a;
                arr[a][b] = c;
            }
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(arr[i][j] == INF) sb.append(0);
                else sb.append(arr[i][j]);
                sb.append(" ");
            }
            sb.append('\n');
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(path[i][j] == INF) sb.append(0);
                else {
                    int pre = j;
                    stack.push(j);
                    while(i != path[i][pre]) {
                        pre = path[i][pre];
                        stack.push(pre);
                    }

                    sb.append((stack.size()+1)+" ");
                    sb.append(i + " ");
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop() + " ");
                    }
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }
}

