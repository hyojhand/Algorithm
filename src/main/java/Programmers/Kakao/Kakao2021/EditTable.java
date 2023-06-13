package Programmers.Kakao.Kakao2021;

import java.util.*;

// 2021 카카오 채용연계형 인턴십 - 표 편집
// DoubleLinkedList 구현
// 삭제한 노드는 최신부터 다시 꺼내야하기 때문에 LIFO 구조인 Stack에 저장한다.
// 최초 연결되지 않고 삭제되지 않은 노드를 초기화하여 배열에 저장하고, 앞뒤로 연결해준다.
// U, D 명령어: 현재 위치한 노드를 이전, 다음 노드로 값만큼 이동해서 갱신해준다.
// C 명령어: 현재 노드를 삭제 전환하고, 스택에 넣는다. 현재 노드의 이전 노드와 다음 노드를 서로 연결하고, 현재 위치는 다음 노드가 된다.
// 단, 다음 노드가 없는 마지막일경우 이전 노드를 현재 노드로 갱신
// Z 명령어: 스택의 가장 최신 노드를 꺼내오고, 꺼내온 스택의 이전,다음 노드를 다시 꺼내온 노드와 연결해준다.
// Node 객체에서는 이전,다음 노드와 삭제된 노드인지 여부로만 구성한다.
// 최종적으로 모든 노드를 저장한 배열을 탐색하며 삭제여부에 따라 결과값을 더한다.
public class EditTable {
    public String solution(int n, int k, String[] cmd) {
        // 번호만 가지는 노드배열 생성
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }

        // 노드 연결
        for (int i = 1; i < n; i++) {
            Node node = nodes[i];
            node.pre = nodes[i - 1];
            nodes[i - 1].next = node;
        }

        // 삭제 메모리
        Stack<Node> deleteMemory = new Stack<>();
        // 현재 행
        Node now = nodes[k];
        for (String query : cmd) {
            String[] split = query.split(" ");
            String symbol = split[0];
            int count;
            Node pre, next;

            switch (symbol) {
                case "U":
                    count = Integer.parseInt(split[1]);
                    for (int i = 0; i < count; i++) {
                        now = now.pre;
                    }
                    break;
                case "D":
                    count = Integer.parseInt(split[1]);
                    for (int i = 0; i < count; i++) {
                        now = now.next;
                    }
                    break;
                case "C":
                    now.isDeleted = true;
                    deleteMemory.push(now);

                    pre = now.pre;
                    next = now.next;

                    if (pre != null) {
                        pre.next = next;
                    }

                    if (next == null) {
                        now = pre;
                    } else {
                        next.pre = pre;
                        now = next;
                    }
                    break;

                case "Z":
                    Node node = deleteMemory.pop();
                    node.isDeleted = false;
                    pre = node.pre;
                    next = node.next;

                    if (pre != null) {
                        pre.next = node;
                    }

                    if (next != null) {
                        next.pre = node;
                    }
                    break;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (nodes[i].isDeleted) result.append("X");
            else result.append("O");
        }

        return result.toString();
    }

    static class Node {
        Node pre, next;
        boolean isDeleted;

        public Node() {
            this.pre = null;
            this.next = null;
            this.isDeleted = false;
        }
    }
}
