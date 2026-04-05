import java.io.*;
import java.util.*;

public class TerrainColorTrail {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());
        int B = Integer.parseInt(br.readLine().trim());
        
        int[][] Color = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Color[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] V = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                V[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        Map<Integer, Long>[][] dp = new Map[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j] = new HashMap<>();
            }
        }
        
        int firstColor = Color[0][0];
        dp[0][0].put(firstColor, (long) V[0][0]);
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) continue;
                
                if (i > 0) {
                    for (Map.Entry<Integer, Long> entry : dp[i-1][j].entrySet()) {
                        int prevColor = entry.getKey();
                        long prevScore = entry.getValue();
                        int currColor = Color[i][j];
                        long newScore = prevScore + V[i][j] + (prevColor == currColor ? B : 0);
                        Long existing = dp[i][j].get(currColor);
                        if (existing == null || newScore > existing) {
                            dp[i][j].put(currColor, newScore);
                        }
                    }
                }
                
                if (j > 0) {
                    for (Map.Entry<Integer, Long> entry : dp[i][j-1].entrySet()) {
                        int prevColor = entry.getKey();
                        long prevScore = entry.getValue();
                        int currColor = Color[i][j];
                        long newScore = prevScore + V[i][j] + (prevColor == currColor ? B : 0);
                        Long existing = dp[i][j].get(currColor);
                        if (existing == null || newScore > existing) {
                            dp[i][j].put(currColor, newScore);
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
