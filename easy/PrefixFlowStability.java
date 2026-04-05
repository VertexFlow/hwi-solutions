import java.io.*;
import java.util.*;

public class PrefixFlowStability {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        long[] E = new long[N];
        for (int i = 0; i < N; i++) {
            E[i] = Long.parseLong(br.readLine().trim());
        }
        
        int result = 1;
        long[] prefix = new long[N];
        prefix[0] = E[0];
        
        for (int k = 1; k <= N; k++) {
            if (k == 1) {
                result = 1;
                continue;
            }
            
            long[] copy = Arrays.copyOf(prefix, k);
            boolean possible = true;
            
            for (int i = 0; i < k - 1; i++) {
                if (copy[i] > copy[i + 1]) {
                    long diff = copy[i] - copy[i + 1];
                    copy[i] -= diff;
                    copy[i + 1] += diff;
                }
            }
            
            for (int i = 0; i < k - 1; i++) {
                if (copy[i] > copy[i + 1]) {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                result = k;
                if (k < N) {
                    prefix[k] = E[k];
                }
            } else {
                break;
            }
        }
        
        System.out.println(result);
    }
}
