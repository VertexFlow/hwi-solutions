import java.io.*;
import java.util.*;

public class MaximumWeightIndependentSetTree {
    static List<List<Integer>> adj;
    static int[] W;
    static int N;
    static long bestScore = 0;
    static Set<Integer> bestSet = new HashSet<>();
    
    static long kolakoskiBonus(int c) {
        if (c <= 0) return 0;
        int[] seq = generateKolakoski(c + 5);
        if (seq[c - 1] == 1) {
            return 30L * ((c % 10) + 1);
        }
        return 0;
    }
    
    static int[] generateKolakoski(int n) {
        int[] seq = new int[n];
        seq[0] = 1;
        int i = 1, j = 0;
        while (i < n) {
            int val = seq[j];
            for (int k = 0; k < val && i < n; k++) {
                seq[i++] = (j % 2 == 0) ? 1 : 2;
            }
            j++;
        }
        return seq;
    }
    
    static int countBits(long x) {
        return Long.bitCount(x);
    }
    
    static boolean isOreNumber(int w) {
        if (w <= 0) return false;
        int[] ore = {1, 6, 28, 140, 270, 496, 672, 1086, 2202, 3784, 6128, 8128, 10656, 14400, 18630, 27216, 56160, 64496, 71316, 100128, 144240, 184752, 214272, 231840, 303744, 315036, 384384, 413952, 536400, 551376, 579600, 635046, 715428, 783072, 876624, 1027680, 1155648, 1244160, 1384176, 1552320, 1682208, 1761600, 1987200, 2099136, 2176200, 2374272, 2520000, 2730780, 2919180, 3193536, 3424896};
        for (int o : ore) {
            if (o == w) return true;
            if (o > w) break;
        }
        return false;
    }
    
    static long[][] dp;
    
    static long dfs(int v, int parent, boolean take) {
        long res = 0;
        List<int[]> options = new ArrayList<>();
        
        if (take) {
            res = W[v];
            for (int nb : adj.get(v)) {
                if (nb != parent) {
                    res += dfs(nb, v, false);
                }
            }
        } else {
            for (int nb : adj.get(v)) {
                if (nb != parent) {
                    long incl = dfs(nb, v, true);
                    long excl = dfs(nb, v, false);
                    res += Math.max(incl, excl);
                }
            }
        }
        return res;
    }
    
    static void findBest(int v, int parent, boolean take, Set<Integer> current) {
        if (take) {
            current.add(v);
            for (int nb : adj.get(v)) {
                if (nb != parent) {
                    findBest(nb, v, false, current);
                }
            }
        } else {
            for (int nb : adj.get(v)) {
                if (nb != parent) {
                    long incl = dp[nb][1];
                    long excl = dp[nb][0];
                    if (incl >= excl) {
                        current.add(nb);
                        findBest(nb, v, true, current);
                    } else {
                        findBest(nb, v, false, current);
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        W = new int[N];
        for (int i = 0; i < N; i++) {
            W[i] = Integer.parseInt(br.readLine().trim());
        }
        int[] T = new int[N];
        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(br.readLine().trim());
        }
        
        int M = Integer.parseInt(br.readLine().trim());
        adj = new ArrayList<>();
        for (int i = 0; i < N; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int K = Integer.parseInt(br.readLine().trim());
        
        dp = new long[N][2];
        for (int i = 0; i < N; i++) {
            dp[i][0] = dfs(i, -1, false);
            dp[i][1] = W[i] + dfs(i, -1, true) - dfs(i, -1, false);
        }
        
        long baseWith0 = 0;
        Set<Integer> set0 = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (dp[i][0] >= dp[i][1]) {
                set0.add(i);
                baseWith0 += dp[i][0];
            } else {
                baseWith0 += dp[i][1];
            }
        }
        
        findBest(0, -1, false, set0);
        long baseScore = 0;
        for (int v : set0) {
            baseScore += W[v];
        }
        int count = set0.size();
        
        int oreCount = 0;
        for (int v : set0) {
            if (isOreNumber(W[v])) oreCount++;
        }
        
        long bonus = kolakoskiBonus(count);
        int bits = countBits(baseScore);
        long penalty = (bits % 2 == 1) ? 25 : 0;
        
        long finalScore = baseScore + bonus - penalty;
        if (oreCount > K) {
            finalScore = (long)(finalScore * 0.9);
        }
        
        System.out.println(finalScore);
    }
}
