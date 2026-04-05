import java.io.*;
import java.util.*;

public class MosaicTileOptimization {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int m = Integer.parseInt(br.readLine().trim());
        int costA = Integer.parseInt(br.readLine().trim());
        int costB = Integer.parseInt(br.readLine().trim());
        int[][] v = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            for (int j = 0; j < m; j++) {
                v[i][j] = Integer.parseInt(parts[j]);
            }
        }
        long totalCost = 0;
        for (int i = 0; i < n; i++) {
            long[] dp = new long[m + 1];
            Arrays.fill(dp, Long.MAX_VALUE / 4);
            dp[0] = 0;
            for (int j = 1; j <= m; j++) {
                dp[j] = dp[j - 1] + costA - v[i][j - 1];
                if (j >= 2) {
                    int pairCost = costB;
                    int noBonus = 0;
                    dp[j] = Math.min(dp[j], dp[j - 2] + pairCost - noBonus);
                }
            }
            totalCost += dp[m];
        }
        System.out.println(totalCost);
    }
}
