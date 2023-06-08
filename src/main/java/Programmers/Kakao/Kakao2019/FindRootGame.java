package Programmers.Kakao.Kakao2019;

import java.util.*;

// 2019 KAKAO BLIND RECRUITMENT - 길 찾기 게임
// 좌표값과 번호를 가지는 Point 객체 & Point,좌,우측의 노드를 가지는 Node 객체
// y좌표값으로 정렬된 Point를 루트순으로 insert한다.
// x좌표보다 작으면 left Node에 새로운 노드를 추가해주며, 크다면 right Node에 새로운 노드를 추가해서 트리를 구성한다.
// 전위순회, 후위순회로 각 결과를 배열에 저장해 해결
public class FindRootGame {
    int[][] answer;
    int index;

    public int[][] solution(int[][] nodeinfo) {
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < nodeinfo.length; i++) {
            pq.offer(new Point(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }

        Node root = new Node(pq.poll(), null, null);
        while (!pq.isEmpty()) {
            insertNode(root, pq.poll());
        }

        answer = new int[2][nodeinfo.length];
        index = 0;
        preOrder(root);
        index = 0;
        postOrder(root);

        return answer;
    }

    private void insertNode(Node parent, Point childPoint) {
        if (parent.point.x > childPoint.x) { // left
            if (parent.left == null) {
                parent.left = new Node(childPoint, null, null);
            } else {
                insertNode(parent.left, childPoint);
            }
        } else {
            if (parent.right == null) {
                parent.right = new Node(childPoint, null, null);
            } else {
                insertNode(parent.right, childPoint);
            }
        }
    }

    private void preOrder(Node root) {
        if (root != null) {
            answer[0][index++] = root.point.value;
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            answer[1][index++] = root.point.value;
        }
    }

    class Node {
        Point point;
        Node right, left;

        public Node(Point point, Node right, Node left) {
            this.point = point;
            this.right = right;
            this.left = left;
        }
    }

    class Point implements Comparable<Point> {
        int x, y, value;

        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Point p) {
            if (this.y == p.y) {
                return this.x - p.x;
            }

            return p.y - this.y;
        }
    }
}
