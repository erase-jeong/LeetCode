import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        
        // 1. 문자별 개수 세기
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // 2. 불가능 조건 체크
        int maxCount = 0;
        for (int v : count.values()) {
            maxCount = Math.max(maxCount, v);
        }
        if (maxCount > (n + 1) / 2) {
            return "";
        }

        // 3. 최대 힙 구성 (개수 내림차순)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        // 4. 그리디하게 배치
        StringBuilder sb = new StringBuilder();
        int[] prev = null;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            sb.append((char) curr[0]);
            curr[1]--;

            if (prev != null && prev[1] > 0) {
                pq.offer(prev);
            }
            prev = curr;
        }

        return sb.toString();
    }
}