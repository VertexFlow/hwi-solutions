import java.io.*;
import java.util.*;

public class FabricWeavingBeautyScore {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());
        int H = Integer.parseInt(br.readLine().trim());
        
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine().trim());
        }
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(br.readLine().trim());
        }
        
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                int bonus = 0;
                if (i > 1 && dp[i][j] == dp[i - 1][j]) {
                    if (A[i - 1] == A[i - 2]) bonus = H;
                }
                if (j > 1 && dp[i][j] == dp[i][j - 1]) {
                    if (B[j - 1] == B[j - 2]) bonus = H;
                }
                if (A[i - 1] == B[j - 1]) {
                    bonus = H;
                }
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + bonus);
            }
        }
        
        System.out.println(dp[N][M]);
    }
}
