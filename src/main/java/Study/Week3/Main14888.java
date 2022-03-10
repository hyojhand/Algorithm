package Study.Week3;

import java.io.*;
import java.util.StringTokenizer;

public class Main14888 {
    static int N;
    static boolean[] check;
    static char[] func;
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        check = new boolean[N - 1];
        func = new char[N - 1];
        int index = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (num > 0) {
                switch (i) {
                    case 0:
                        func[index] = '+';
                        break;
                    case 1:
                        func[index] = '-';
                        break;
                    case 2:
                        func[index] = '*';
                        break;
                    case 3:
                        func[index] = '/';
                        break;
                }
                index++;
                num--;
            }
        }


        dfs(0, arr[0]);
        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int dept, int num) {
        if (dept == N - 1) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (!check[i]) {
                check[i] = true;
                switch (func[i]) {
                    case '+':
                        dfs(dept + 1, num + arr[dept + 1]);
                        break;
                    case '-':
                        dfs(dept + 1, num - arr[dept + 1]);
                        break;
                    case '*':
                        dfs(dept + 1, num * arr[dept + 1]);
                        break;
                    case '/':
                        dfs(dept + 1, num / arr[dept + 1]);
                        break;
                }
                check[i] = false;
            }
        }
    }

}
