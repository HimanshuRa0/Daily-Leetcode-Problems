import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if (n == 1) {
            return 0;
        }

        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Tracks the smallest streak already popped for node u.
        // Any later state for u has >= cost, so it must have a strictly smaller streak to be useful.
        int[] minStreakPopped = new int[n];
        Arrays.fill(minStreakPopped, k + 1);

        // PriorityQueue stores: {cost, u, streak}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int u = curr[1];
            int streak = curr[2];

            if (u == n - 1) {
                return cost;
            }

            if (cost > dist[u][streak] || streak >= minStreakPopped[u]) {
                continue;
            }
            minStreakPopped[u] = streak;

            char uLabel = labels.charAt(u);

            for (int[] next : adj[u]) {
                int v = next[0];
                int weight = next[1];
                int nextStreak = (labels.charAt(v) == uLabel) ? streak + 1 : 1;

                if (nextStreak <= k && nextStreak < minStreakPopped[v]) {
                    int newCost = cost + weight;
                    if (newCost < dist[v][nextStreak]) {
                        dist[v][nextStreak] = newCost;
                        pq.offer(new int[]{newCost, v, nextStreak});
                    }
                }
            }
        }

        return -1;
    }
}