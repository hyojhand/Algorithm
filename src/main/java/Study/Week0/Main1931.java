package Study.Week0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int pre_end = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(map.containsKey(end)) {
                if(start == end) {
                    count++;
                    continue;
                }
                else if(map.get(end) == end) {
                    count++;
                    map.put(end,start);
                    continue;
                }
                else if(start > map.get(end)) {
                    map.put(end, start);
                    continue;
                }
                else {
                    continue;
                }
            }

            map.put(end,start);
        }


        Integer[] key_sort = map.keySet().toArray(new Integer[0]);
        Arrays.sort(key_sort);

        for(int i = 0; i < map.size(); i++) {
            if(map.get(key_sort[i]) >= pre_end) {
                pre_end = key_sort[i];
                count++;
            }
        }

        System.out.println(count);








//        int[][] arr = new int[N][2];
//
//        for(int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            arr[i][0] = Integer.parseInt(st.nextToken());
//            arr[i][1] = Integer.parseInt(st.nextToken());
//        }
//
//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[1] == o2[1]) {
//                    return o1[0] - o2[0];
//                }
//                return o1[1] - o2[1];
//            }
//        });
//
//        int count = 0;
//        int end_time = 0;
//
//        for(int i = 0; i < N; i++) {
//            if(end_time <= arr[i][0]) {
//                end_time = arr[i][1];
//                count++;
//            }
//
//        }
//
//        System.out.println(count);

    }
}
