import java.io.*;
import java.util.*;

public class EmilsSpecialLCS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine().trim();
        String B = br.readLine().trim();
        
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    int weight = (A.charAt(i - 1) == 'e') ? 2 : 1;
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + weight);
                }
            }
        }
        
        System.out.println(dp[n][m]);
    }
}
