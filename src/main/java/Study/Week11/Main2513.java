package Study.Week11;

import java.io.*;
import java.util.StringTokenizer;
// 통학버스
public class Main2513 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[100001];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
        }

        int sum = 0;
        int res = 0;
        for(int i = 0; i < S; i++) {
            if(arr[i] > 0) {
                if(arr[i] > res) {
                    arr[i] -= res;
                } else if(arr[i] == res) {
                    res = 0;
                    continue;
                } else {
                    res -= arr[i];
                    continue;
                }

                int num = arr[i] / K;
                int mod = arr[i] % K;
                if(num == 0) {
                    sum += (S-i) * 2;
                    res = K-mod;
                }
                else {
                    if (mod > 0) {
                        sum += (num + 1) * (S - i) * 2;
                        res = K-mod;
                    } else {
                        sum += num * (S - i) * 2;
                        res = 0;
                    }
                }
            }
        }

        res = 0;
        for(int i = arr.length-1; i > S; i--) {
            if(arr[i] > 0) {
                if(arr[i] > res) {
                    arr[i] -= res;
                } else if(arr[i] == res) {
                    res = 0;
                    continue;
                } else {
                    res -= arr[i];
                    continue;
                }

                int num = arr[i] / K;
                int mod = arr[i] % K;

                if(num == 0) {
                    sum += (i-S) * 2;
                    res = K-mod;
                } else {
                    if (mod > 0) {
                        sum += (num + 1) * (i - S) * 2;
                        res = K-mod;
                    } else {
                        sum += num * (i - S) * 2;
                        res = 0;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}

