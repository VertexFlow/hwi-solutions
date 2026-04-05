import java.io.*;
import java.util.*;

public class LazyStudent {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        long m = Long.parseLong(br.readLine().trim());
        int c = Integer.parseInt(br.readLine().trim());
        long[] x = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = Long.parseLong(br.readLine().trim());
        }
        
        Arrays.sort(x);
        for (int i = 0; i < n / 2; i++) {
            long temp = x[i];
            x[i] = x[n - 1 - i];
            x[n - 1 - i] = temp;
        }
        
        double totalScore = 0;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            totalScore += x[i];
            if (totalScore >= m) {
                count = i + 1;
                break;
            }
        }
        
        if (count == 0) {
            for (int i = 0; i < n; i++) {
                totalScore = i * (i + 1) / 2.0;
            }
            for (int i = 0; i < n; i++) {
                totalScore = 0;
                int thinkCount = 0;
                for (int j = 0; j <= i; j++) {
                    totalScore += x[j];
                    thinkCount++;
                    if (totalScore >= m) break;
                }
                for (int j = i + 1; j < n; j++) {
                    totalScore += (double)x[j] / c;
                }
                if (totalScore >= m) {
                    count = thinkCount;
                    break;
                }
            }
        }
        
        System.out.println(count);
    }
}
