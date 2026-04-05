import java.io.*;
import java.util.*;

public class TextilePatternWeaving {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] parts = line.trim().split("\\s+");
        int N, M, H;
        
        if (parts.length == 3) {
            N = Integer.parseInt(parts[0]);
            M = Integer.parseInt(parts[1]);
            H = Integer.parseInt(parts[2]);
        } else if (parts.length == 1) {
            N = Integer.parseInt(parts[0]);
            line = br.readLine();
            M = Integer.parseInt(line.trim());
            line = br.readLine();
            H = Integer.parseInt(line.trim());
        } else {
            N = Integer.parseInt(parts[0]);
            M = Integer.parseInt(parts[1]);
            H = Integer.parseInt(parts[2]);
        }
        
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine().trim());
        }
        
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(br.readLine().trim());
        }
        
        int maxColorA = 0, maxColorB = 0;
        for (int x : A) maxColorA = Math.max(maxColorA, x);
        for (int x : B) maxColorB = Math.max(maxColorB, x);
        int maxColor = Math.max(maxColorA, maxColorB) + 1;
        
        long NEG = Long.MIN_VALUE / 4;
        
        Map<Integer, Long>[][] dp = new Map[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                dp[i][j] = new HashMap<>();
            }
        }
        
        dp[0][0].put(0, 0L);
        
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (i > 0) {
                    int newColor = A[i - 1];
                    for (Map.Entry<Integer, Long> entry : dp[i - 1][j].entrySet()) {
                        int prevColor = entry.getKey();
                        long prevScore = entry.getValue();
                        long newScore = prevScore + (prevColor == newColor ? H : 0);
                        Long existing = dp[i][j].get(newColor);
                        if (existing == null || newScore > existing) {
                            dp[i][j].put(newColor, newScore);
                        }
                    }
                }
                
                if (j > 0) {
                    int newColor = B[j - 1];
                    for (Map.Entry<Integer, Long> entry : dp[i][j - 1].entrySet()) {
                        int prevColor = entry.getKey();
                        long prevScore = entry.getValue();
                        long newScore = prevScore + (prevColor == newColor ? H : 0);
                        Long existing = dp[i][j].get(newColor);
                        if (existing == null || newScore > existing) {
                            dp[i][j].put(newColor, newScore);
                        }
                    }
                }
            }
        }
        
        long ans = 0;
        for (long val : dp[N][M].values()) {
            if (val > ans) ans = val;
        }
        System.out.println(ans);
    }
}
