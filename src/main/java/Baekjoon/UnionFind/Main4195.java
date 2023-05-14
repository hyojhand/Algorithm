package Baekjoon.UnionFind;

import java.io.*;
import java.util.*;

// G2 친구 네트워크
// 이름을 key로 하고, 몇번째 친구인지 번호를 value로 가지는 HashMap으로 친구 목록을 관리한다.
// 1번부터 시작하여 HashMap에 친구가 없다면, 해당 친구를 등록하고 번호를 + 1 해준다.
// 두 친구의 번호를 저장하는 리스트로 주어진 네트워크를 저장한다.
// 총 친구 수 만큼 분리 집합을 생성하고, 각 번호의 친구가 몇개의 네트워크인지를 나타내는 배열을 1로 초기화해준다.
// 네트워크 리스트를 반복문으로 네트워크를 연결한다.
// A와 B의 루트가 달라 union 할 수 있다면, A의 네트워크 개수에 B의 네트워크 개수를 더하고, A를 루트로 union 해준다.
// 둘의 루트가 같아 union 할 수 없다면 같은 네트워크 이므로, A의 네트워크 개수를 출력한다.
public class Main4195 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            // 해당 이름을 key로 가진 친구의 번호를 value로 하여 HashMap으로 관리
            HashMap<String, Integer> friendNumbers = new HashMap<>();
            // 네트워크를 저장할 리스트
            List<int[]> networks = new ArrayList<>();

            // 1번부터 시작
            int number = 1;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String friend = st.nextToken();
                String otherFriend = st.nextToken();

                // 둘의 번호가 없다면 HashMap에 추가하고 번호 등록
                if (!friendNumbers.containsKey(friend)) {
                    friendNumbers.put(friend, number++);
                }

                if (!friendNumbers.containsKey(otherFriend)) {
                    friendNumbers.put(otherFriend, number++);
                }

                // 네트워크 저장
                networks.add(new int[]{friendNumbers.get(friend), friendNumbers.get(otherFriend)});
            }

            // 총 친구의 수만큼 분리집합 생성
            DisjointSet disjointSet = new DisjointSet(number);
            // 친구가 연결된 수를 저장하는 배열
            int[] numbers = new int[number];
            // 최초 자기 자신만 있기에 1로 초기화
            Arrays.fill(numbers, 1);

            // 모든 네트워크 연결
            for (int[] network : networks) {
                // 친구 관계가 union 되면 친구 개수 갱신
                if (disjointSet.findSet(network[0]) != disjointSet.findSet(network[1])) {
                    numbers[disjointSet.findSet(network[0])] += numbers[disjointSet.findSet(network[1])];
                    disjointSet.union(network[0], network[1]);
                }

                result.append(numbers[disjointSet.findSet(network[0])]).append('\n');
            }
        }

        System.out.println(result);
    }


    static class DisjointSet {
        int[] parents;

        public DisjointSet(int N) {
            parents = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parents[i] = i;
            }
        }

        private int findSet(int number) {
            if (parents[number] == number) {
                return number;
            }

            return parents[number] = findSet(parents[number]);
        }

        private boolean union(int a, int b) {
            int aRoot = findSet(a);
            int bRoot = findSet(b);

            if (aRoot == bRoot) {
                return false;
            }

            parents[bRoot] = aRoot;
            return true;
        }
    }

}
