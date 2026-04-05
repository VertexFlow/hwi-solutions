import java.io.*;
import java.util.*;

public class StableTemperatureSystem {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        long[] T = new long[N];
        for (int i = 0; i < N; i++) {
            T[i] = Long.parseLong(br.readLine().trim());
        }
        
        long totalOps = 0;
        long[] effective = Arrays.copyOf(T, N);
        
        for (int i = 1; i < N; i++) {
            if (effective[i] > effective[i - 1] + 1) {
                totalOps += effective[i] - (effective[i - 1] + 1);
                effective[i] = effective[i - 1] + 1;
            }
        }
        
        System.out.println(totalOps);
    }
}
