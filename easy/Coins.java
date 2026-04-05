import java.io.*;
import java.util.*;

public class Coins {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(br.readLine().trim());
        }
        long[] B = new long[N];
        for (int i = 0; i < N; i++) {
            B[i] = Long.parseLong(br.readLine().trim());
        }
        
        long MOD = 1000000007L;
        long result = 0;
        
        for (int i = 0; i < N; i++) {
            long coins = A[i] % MOD;
            long pow2 = 1;
            for (int j = 0; j < B[i]; j++) {
                pow2 = (pow2 * 2) % MOD;
            }
            coins = (coins * pow2) % MOD;
            result = (result + coins) % MOD;
        }
        
        System.out.println(result);
    }
}
