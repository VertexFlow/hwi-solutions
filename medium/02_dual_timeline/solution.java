import java.io.*;
import java.util.*;

public class DualTimeline {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        long[] d = new long[n];
        for (int i = 0; i < n; i++) {
            d[i] = Long.parseLong(br.readLine().trim());
        }
        long[] p = new long[n];
        for (int i = 0; i < n; i++) {
            p[i] = Long.parseLong(br.readLine().trim());
        }
        long timeA = 0, timeB = 0;
        long totalPenalty = 0;
        for (int i = 0; i < n; i++) {
            if (timeA <= timeB) {
                timeA += d[i];
                totalPenalty += timeA * p[i];
            } else {
                timeB += d[i];
                totalPenalty += timeB * p[i];
            }
        }
        System.out.println(totalPenalty);
    }
}
