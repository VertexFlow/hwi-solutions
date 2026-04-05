import java.io.*;
import java.util.*;

public class MinimumIncreasingUniqueSelectionCost {
    static class BIT {
        long[] tree;
        BIT(int n) {
            tree = new long[n + 2];
            Arrays.fill(tree, Long.MAX_VALUE);
        }
        void update(int idx, long val) {
            while (idx < tree.length) {
                if (val < tree[idx]) tree[idx] = val;
                idx += idx & -idx;
            }
        }
        long query(int idx) {
            long res = Long.MAX_VALUE;
            while (idx > 0) {
                if (tree[idx] < res) res = tree[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int K = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine().trim());
        }
        
        int[] sorted = A.clone();
        Arrays.sort(sorted);
        int maxVal = 0;
        for (int i = 0; i < N; i++) {
            if (sorted[i] != sorted[Math.max(0, i - 1)]) {
                maxVal++;
                sorted[i] = maxVal;
            } else {
                sorted[i] = maxVal;
            }
        }
        
        for (int i = 0; i < N; i++) {
            A[i] = sorted[i];
        }
        
        BIT[] bits = new BIT[K + 1];
        for (int k = 0; k <= K; k++) {
            bits[k] = new BIT(maxVal + 2);
        }
        
        bits[0].update(1, 0);
        
        for (int i = 0; i < N; i++) {
            for (int k = 1; k <= K; k++) {
                long prev = bits[k - 1].query(A[i] - 1);
                if (prev != Long.MAX_VALUE) {
                    long cost = prev + (long)(i + 1 - k) * (i + 1 - k);
                    bits[k].update(A[i], cost);
                }
            }
        }
        
        long ans = bits[K].query(maxVal + 1);
        System.out.println(ans == Long.MAX_VALUE ? -1 : ans);
    }
}
