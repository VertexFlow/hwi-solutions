import java.io.*;
import java.util.*;

public class VaultDigitAlignment {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().trim().split("\\s+");
        int N = Integer.parseInt(firstLine[0]);
        int[] Arr = new int[N];
        
        if (firstLine.length > 1) {
            for (int i = 0; i < N && i < firstLine.length - 1; i++) {
                Arr[i] = Integer.parseInt(firstLine[i + 1]);
            }
            for (int i = firstLine.length - 1; i < N; i++) {
                String line = br.readLine();
                if (line != null && !line.trim().isEmpty()) {
                    Arr[i] = Integer.parseInt(line.trim());
                }
            }
        } else {
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                if (line != null && !line.trim().isEmpty()) {
                    Arr[i] = Integer.parseInt(line.trim());
                }
            }
        }
        
        long totalCost = 0;
        int target = Arr[0];
        
        for (int i = 1; i < N; i++) {
            if (Arr[i] < target) {
                totalCost += (target - Arr[i]);
                Arr[i] = target;
            } else {
                target = Arr[i];
            }
        }
        
        System.out.println(totalCost);
    }
}
