import java.io.*;
import java.util.*;
import java.math.*;

public class Blocks {
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
        
        Arrays.sort(A);
        for (int i = 0; i < N / 2; i++) {
            long temp = A[i];
            A[i] = A[N - 1 - i];
            A[N - 1 - i] = temp;
        }
        
        Arrays.sort(B);
        
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < A[i]; j++) {
                result = result.shiftLeft(1);
            }
            for (int j = 0; j < B[i]; j++) {
                result = result.shiftLeft(1);
            }
        }
        
        BigInteger two = BigInteger.valueOf(2);
        BigInteger mod = BigInteger.valueOf(1000000007);
        BigInteger answer = result.mod(mod);
        
        System.out.println(answer);
    }
}
