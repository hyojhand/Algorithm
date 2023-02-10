package Programmers.Level2;

import java.util.*;

// 2023 KAKAO BLIND RECRUITMENT - 택배 배달과 수거하기
// 1 ≤ cap ≤ 50
// 1 ≤ n ≤ 100,000
// 그리디 방식으로 가장 먼 배송,픽업 거리의 최대값을 왕복으로 더해준다
// 이때 2개의 스택을 이용해 가장 먼 거리부터 계산할 수 있다 (2개의 스택이 모두 빌때까지 반복)
// 스택을 사용하지 않고 먼 거리부터 누적합을 사용하는 방법도 가능하다.
public class DeliveryPickup {
    class Solution {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = 0;

            // 배달, 수거용 스택 생성
            Stack<Point> deliveryStack = new Stack<>();
            Stack<Point> pickupStack = new Stack<>();

            // 배송 Delivery 스택 (가까운 거리부터 스택에 담는다)
            for (int i = 0; i < deliveries.length; i++) {
                if (deliveries[i] == 0) {
                    continue;
                }
                deliveryStack.push(new Point(i + 1, deliveries[i]));
            }

            // 돌아오는 Pickup 스택 (가까운 거리부터 스택에 담는다)
            for (int i = 0; i < pickups.length; i++) {
                if (pickups[i] == 0) {
                    continue;
                }
                pickupStack.push(new Point(i + 1, pickups[i]));
            }

            // 배송과 픽업을 끝마칠때까지 반복
            while (!deliveryStack.isEmpty() || !pickupStack.isEmpty()) {

                // 배송 최대거리
                int deliveryDistance = getDeliveryDistance(cap, deliveryStack);
                // 픽업 최대거리
                int pickupDistance = getDeliveryDistance(cap, pickupStack);

                // 배송, 수거 최대거리
                int maxDistance = Math.max(deliveryDistance, pickupDistance);

                // 배송, 수거 이동거리 중 최대값을 왕복으로 더한다.
                answer += (maxDistance * 2L);
            }

            return answer;
        }

        private int getDeliveryDistance(int cap, Stack<Point> stack) {
            // 배송이나 픽업을 완료했다면 0 반환
            if (stack.isEmpty()) {
                return 0;
            }

            // 배송,픽업할때 총 들고가는 갯수
            int totalDelivery = cap;

            // 배달,픽업 이동거리는 가장 멀리있는집 = 가장 위의 스택에 있는 거리
            int moveDistance = stack.peek().position;

            // 배송,픽업 가능갯수가 남아있고, 배송 스택이 비어있지 않다면
            while (totalDelivery > 0 && !stack.isEmpty()) {
                Point point = stack.pop();

                // 배송,픽업
                totalDelivery -= point.count;

                // 배송갯수가 부족하다면 스택에 다시 넣는다.
                if (totalDelivery < 0) {
                    stack.push(new Point(point.position, Math.abs(totalDelivery)));
                    totalDelivery = 0;
                    break;
                }
            }

            return moveDistance;
        }

        class Point {
            int position, count;

            public Point(int position, int count) {
                this.position = position;
                this.count = count;
            }
        }
    }
}
