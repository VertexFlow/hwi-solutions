import java.io.*;
import java.util.*;

public class TheCrystalPath {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());
        int[][] grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        Map<Integer, Long>[][] dp = new Map[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j] = new HashMap<>();
            }
        }
        
        int v = grid[0][0];
        dp[0][0].put(v, (long) v * v);
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) continue;
                if (i > 0) {
                    for (Map.Entry<Integer, Long> entry : dp[i-1][j].entrySet()) {
                        int minPrev = entry.getKey();
                        long energyPrev = entry.getValue();
                        int vCurr = grid[i][j];
                        int minNew = Math.min(minPrev, vCurr);
                        long energyNew = energyPrev + (long) vCurr * minNew;
                        Long existing = dp[i][j].get(minNew);
                        if (existing == null || energyNew > existing) {
                            dp[i][j].put(minNew, energyNew);
                        }
                    }
                }
                if (j > 0) {
                    for (Map.Entry<Integer, Long> entry : dp[i][j-1].entrySet()) {
                        int minPrev = entry.getKey();
                        long energyPrev = entry.getValue();
                        int vCurr = grid[i][j];
                        int minNew = Math.min(minPrev, vCurr);
                        long energyNew = energyPrev + (long) vCurr * minNew;
                        Long existing = dp[i][j].get(minNew);
                        if (existing == null || energyNew > existing) {
                            dp[i][j].put(minNew, energyNew);
                        }
                    }
                }
            }
        }
        
        long ans = 0;
        for (long val : dp[N-1][M-1].values()) {
            if (val > ans) ans = val;
        }
        System.out.println(ans);
    }
}
