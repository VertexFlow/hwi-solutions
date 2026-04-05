import java.io.*;
import java.util.*;

public class MinimumCostSwaps {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(br.readLine().trim());
        }
        Set<Long> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!seen.add(a[i])) {
                System.out.println(-1);
                return;
            }
        }
        long[][] pairs = new long[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = a[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, Comparator.comparingLong(o -> o[0]));
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[(int) pairs[i][1]] = i;
        }
        boolean[] visited = new boolean[n];
        long cost = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] || pos[i] == i) {
                visited[i] = true;
                continue;
            }
            int j = i;
            long cycleSum = 0;
            long cycleMin = Long.MAX_VALUE;
            int cycleSize = 0;
            while (!visited[j]) {
                visited[j] = true;
                cycleSum += a[j];
                cycleMin = Math.min(cycleMin, a[j]);
                cycleSize++;
                j = pos[j];
            }
            if (cycleSize > 1) {
                long withoutShortcut = (cycleSize - 1) * cycleSum;
                long withShortcut = cycleSum + cycleMin + (cycleSize + 1) * cycleMin;
                cost += Math.min(withoutShortcut, withShortcut);
            }
        }
        System.out.println(cost);
    }
}
