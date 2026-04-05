import java.io.*;
import java.util.*;

public class Threshold1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int X = Integer.parseInt(br.readLine().trim());
        int K = Integer.parseInt(br.readLine().trim());
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(br.readLine().trim());
        }
        
        int currentK = K;
        int maxIndex = 0;
        
        for (int i = 0; i < N - 1; i++) {
            long threshold = A[i] + X;
            if (A[i + 1] <= threshold) {
                continue;
            } else {
                if (currentK > 0) {
                    currentK--;
                } else {
                    maxIndex = i;
                    break;
                }
            }
            maxIndex = i + 1;
        }
        
        if (maxIndex < N - 1) {
            maxIndex = N - 1;
        }
        
        System.out.println(maxIndex);
    }
}
