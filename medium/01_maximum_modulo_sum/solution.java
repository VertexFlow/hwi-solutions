import java.io.*;
import java.util.*;

public class MaximumModuloSum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int k = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine().trim());
        }
        long[] dp = new long[k];
        Arrays.fill(dp, Long.MIN_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int rem = a[i] % k;
            long[] newDp = dp.clone();
            for (int r = 0; r < k; r++) {
                if (dp[r] != Long.MIN_VALUE && r != rem) {
                    newDp[rem] = Math.max(newDp[rem], dp[r] + a[i]);
                }
            }
            dp = newDp;
        }
        long ans = 0;
        for (int r = 0; r < k; r++) {
            ans = Math.max(ans, dp[r]);
        }
        System.out.println(ans);
    }
}
