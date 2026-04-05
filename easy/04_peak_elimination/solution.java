import java.io.*;
import java.util.*;

public class PeakElimination {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().trim().split("\\s+");
        int N = Integer.parseInt(firstLine[0]);
        int[] A = new int[N];
        
        if (firstLine.length > 1) {
            for (int i = 0; i < N && i < firstLine.length - 1; i++) {
                A[i] = Integer.parseInt(firstLine[i + 1]);
            }
            for (int i = firstLine.length - 1; i < N; i++) {
                A[i] = Integer.parseInt(br.readLine().trim());
            }
        } else {
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(br.readLine().trim());
            }
        }
        
        int removed = 0;
        boolean changed = true;
        
        while (changed) {
            changed = false;
            List<Integer> toRemove = new ArrayList<>();
            
            for (int i = 1; i < N - 1; i++) {
                if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                    toRemove.add(i);
                }
            }
            
            if (!toRemove.isEmpty()) {
                changed = true;
                removed += toRemove.size();
                int[] newA = new int[N - toRemove.size()];
                int idx = 0;
                int skipIdx = 0;
                for (int i = 0; i < N; i++) {
                    if (skipIdx < toRemove.size() && i == toRemove.get(skipIdx)) {
                        skipIdx++;
                        continue;
                    }
                    newA[idx++] = A[i];
                }
                A = newA;
                N = A.length;
            }
        }
        
        System.out.println(removed);
    }
}
