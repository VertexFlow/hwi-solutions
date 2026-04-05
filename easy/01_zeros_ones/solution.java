import java.io.*;
import java.util.*;

public class ZerosOnes {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());
        int[] flips = new int[M];
        for (int i = 0; i < M; i++) {
            flips[i] = Integer.parseInt(br.readLine().trim()) - 1;
        }
        int[] A = new int[N];
        Arrays.fill(A, 0);
        long result = 1;
        int mod = 1000000007;
        
        for (int idx = 0; idx < M; idx++) {
            int pos = flips[idx];
            A[pos] = 1 - A[pos];
            int cost = findMaxSubarray(N, A);
            result = (result * cost) % mod;
        }
        
        System.out.println(result);
    }
    
    static int findMaxSubarray(int N, int[] A) {
        int left = 0;
        int right = 0;
        int transitions = 0;
        int valueBeforeTransition = -1;
        int maxLen = 0;
        
        while (right < N) {
            if (right == left) {
                right++;
                if (right < N) {
                    transitions = 0;
                    valueBeforeTransition = A[left];
                }
                continue;
            }
            
            if (transitions == 0) {
                if (A[right] != A[right - 1]) {
                    transitions = 1;
                    valueBeforeTransition = A[right - 1];
                }
            } else if (transitions == 1) {
                if (A[right] != valueBeforeTransition && A[right] != A[right - 1]) {
                    maxLen = Math.max(maxLen, right - left);
                    left++;
                    right = left;
                    transitions = 0;
                    valueBeforeTransition = -1;
                    continue;
                }
            }
            right++;
        }
        
        maxLen = Math.max(maxLen, right - left);
        return maxLen;
    }
}
