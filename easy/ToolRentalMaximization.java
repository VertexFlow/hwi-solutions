import java.io.*;
import java.util.*;

public class ToolRentalMaximization {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());
        int K = Integer.parseInt(br.readLine().trim());
        
        Integer[] P = new Integer[N];
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(br.readLine().trim());
        }
        Integer[] R = new Integer[M];
        for (int i = 0; i < M; i++) {
            R[i] = Integer.parseInt(br.readLine().trim());
        }
        
        Arrays.sort(P);
        Arrays.sort(R, Collections.reverseOrder());
        
        int count = 0;
        int toolIdx = 0;
        int[] amplified = new int[M];
        Arrays.fill(amplified, 0);
        
        for (int i = 0; i < N && toolIdx < M; i++) {
            int need = P[i];
            boolean matched = false;
            
            for (int j = 0; j < M; j++) {
                if (amplified[j] == 0) {
                    int power = R[j] * 2;
                    if (power >= need) {
                        amplified[j] = 1;
                        K--;
                        count++;
                        matched = true;
                        break;
                    }
                }
            }
            
            if (!matched) {
                for (int j = 0; j < M; j++) {
                    if (amplified[j] == -1 && R[j] >= need) {
                        amplified[j] = 1;
                        count++;
                        matched = true;
                        break;
                    }
                }
            }
        }
        
        System.out.println(count);
    }
}
