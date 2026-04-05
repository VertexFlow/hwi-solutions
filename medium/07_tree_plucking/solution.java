import java.io.*;
import java.util.*;

public class TreePlucking {
    static class Node {
        long val;
        int deg;
        List<Integer> adj;
        Node() { adj = new ArrayList<>(); deg = 0; val = 0; }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node();
        for (int i = 0; i < n; i++) {
            nodes[i].val = Long.parseLong(br.readLine().trim());
        }
        for (int i = 0; i < n - 1; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            int u = Integer.parseInt(parts[0]) - 1;
            int v = Integer.parseInt(parts[1]) - 1;
            nodes[u].adj.add(v);
            nodes[v].adj.add(u);
            nodes[u].deg++;
            nodes[v].deg++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> nodes[a[0]].val));
        boolean[] removed = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (nodes[i].deg <= 1) {
                pq.offer(new int[]{i, i});
            }
        }
        long totalCost = 0;
        int removedCount = 0;
        while (removedCount < n) {
            int[] curr = pq.poll();
            int u = curr[0];
            if (removed[u]) continue;
            totalCost += nodes[u].val;
            removed[u] = true;
            removedCount++;
            for (int w : nodes[u].adj) {
                if (!removed[w]) {
                    nodes[w].val += nodes[u].val;
                    nodes[w].deg--;
                    if (nodes[w].deg == 1) {
                        pq.offer(new int[]{w, w});
                    }
                }
            }
        }
        System.out.println(totalCost);
    }
}
