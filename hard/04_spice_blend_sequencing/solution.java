import java.io.*;
import java.util.*;

public class SpiceBlendSequencing {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());
        int K = Integer.parseInt(br.readLine().trim());
        int H = Integer.parseInt(br.readLine().trim());
        
        int[] flavorA = new int[N];
        int[] intensityA = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            flavorA[i] = Integer.parseInt(st.nextToken());
            intensityA[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] flavorB = new int[M];
        int[] intensityB = new int[M];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            flavorB[i] = Integer.parseInt(st.nextToken());
            intensityB[i] = Integer.parseInt(st.nextToken());
        }
        
        int maxFlavor = 100;
        long NEG = Long.MIN_VALUE / 4;
        
        long[][][][] dp = new long[2][M + 1][K + 1][maxFlavor + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= M; j++) {
                for (int k = 0; k <= K; k++) {
                    Arrays.fill(dp[i][j][k], NEG);
                }
            }
        }
        
        dp[0][0][0][0] = 0;
        
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                for (int k = 0; k <= K; k++) {
                    long bestPrev = NEG;
                    for (int f = 0; f <= maxFlavor; f++) {
                        bestPrev = Math.max(bestPrev, dp[i % 2][j][k][f]);
                    }
                    
                    if (i < N && k < K) {
                        int fNew = flavorA[i];
                        long val = bestPrev + intensityA[i] + H;
                        dp[(i + 1) % 2][j][k + 1][fNew] = Math.max(dp[(i + 1) % 2][j][k + 1][fNew], val);
                    }
                    
                    if (j < M && k < K) {
                        int fNew = flavorB[j];
                        long val = bestPrev + intensityB[j] + H;
                        dp[i % 2][j + 1][k + 1][fNew] = Math.max(dp[i % 2][j + 1][k + 1][fNew], val);
                    }
                }
            }
            
            if (i < N) {
                for (int j = 0; j <= M; j++) {
                    for (int k = 0; k <= K; k++) {
                        Arrays.fill(dp[(i + 1) % 2][j][k], NEG);
                    }
                }
            }
        }
        
        long ans = 0;
        for (int f = 0; f <= maxFlavor; f++) {
            ans = Math.max(ans, dp[N % 2][M][K][f]);
        }
        System.out.println(ans);
    }
}
