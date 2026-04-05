import java.io.*;
import java.util.*;

public class AquariumFishDisplay {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int m = Integer.parseInt(br.readLine().trim());
        int f = Integer.parseInt(br.readLine().trim());
        int[][] s = new int[f + 1][f + 1];
        for (int i = 1; i <= f; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            for (int j = 1; j <= f; j++) {
                s[i][j] = Integer.parseInt(parts[j - 1]);
            }
        }
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(br.readLine().trim());
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = Integer.parseInt(br.readLine().trim());
        long[][][] dp = new long[n + 1][m + 1][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j][0] = dp[i][j][1] = Long.MIN_VALUE / 4;
            }
        }
        if (n > 0 && m > 0) {
            dp[1][1][0] = s[a[0]][b[0]];
            dp[1][1][1] = s[a[0]][b[0]];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;
                if (i > 1) {
                    dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j][0] + s[a[i - 1]][a[i - 2]]);
                    if (j > 0) {
                        dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j][1] + s[a[i - 1]][b[j - 1]]);
                    }
                }
                if (j > 1) {
                    dp[i][j][1] = Math.max(dp[i][j][1], dp[i][j - 1][1] + s[b[j - 1]][b[j - 2]]);
                    if (i > 0) {
                        dp[i][j][1] = Math.max(dp[i][j][1], dp[i][j - 1][0] + s[b[j - 1]][a[i - 1]]);
                    }
                }
            }
        }
        long ans = Math.max(dp[n][m][0], dp[n][m][1]);
        System.out.println(ans);
    }
}
