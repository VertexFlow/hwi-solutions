import java.io.*;
import java.util.*;

public class WeightedNonOverlappingIntervals {
    static class Interval {
        int l, r, w;
        Interval(int l, int r, int w) {
            this.l = l;
            this.r = r;
            this.w = w;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int K = Integer.parseInt(br.readLine().trim());
        Interval[] intervals = new Interval[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            intervals[i] = new Interval(l, r, w);
        }
        
        Arrays.sort(intervals, (a, b) -> a.r - b.r);
        
        int[] right = new int[N];
        for (int i = 0; i < N; i++) {
            right[i] = intervals[i].r;
        }
        
        long[][] dp = new long[N + 1][K + 1];
        for (long[] row : dp) {
            Arrays.fill(row, Long.MIN_VALUE);
        }
        dp[0][0] = 0;
        
        for (int i = 1; i <= N; i++) {
            for (int k = 0; k <= K; k++) {
                dp[i][k] = dp[i - 1][k];
            }
            
            int idx = binarySearch(right, intervals[i - 1].l - 1);
            
            for (int k = 1; k <= K; k++) {
                if (idx >= 0 && dp[idx + 1][k - 1] != Long.MIN_VALUE) {
                    long val = dp[idx + 1][k - 1] + intervals[i - 1].w;
                    dp[i][k] = Math.max(dp[i][k], val);
                }
            }
        }
        
        long ans = dp[N][K];
        System.out.println(ans == Long.MIN_VALUE ? -1 : ans);
    }
    
    static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1, ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] <= target) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}
