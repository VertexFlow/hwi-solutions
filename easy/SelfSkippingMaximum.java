import java.io.*;
import java.util.*;

public class SelfSkippingMaximum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(br.readLine().trim());
        }
        
        long[] dp = new long[N + 1];
        Arrays.fill(dp, 0);
        
        for (int i = N - 1; i >= 0; i--) {
            int nextIdx = i + (int)A[i] + 1;
            long take = A[i];
            if (nextIdx <= N) {
                take += dp[nextIdx];
            }
            long skip = dp[i + 1];
            dp[i] = Math.max(take, skip);
        }
        
        System.out.println(dp[0]);
    }
}
