import java.io.*;
import java.util.*;

public class StringStabilityBoost {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int n = S.length();
        
        Set<String> originalPairs = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            originalPairs.add(S.substring(i, i + 2));
        }
        int originalScore = originalPairs.size();
        
        int maxScore = originalScore;
        
        for (int i = 0; i < n - 1; i++) {
            StringBuilder sb = new StringBuilder(S);
            char c1 = sb.charAt(i);
            char c2 = sb.charAt(i + 1);
            sb.setCharAt(i, c2);
            sb.setCharAt(i + 1, c1);
            String swapped = sb.toString();
            
            Set<String> pairs = new HashSet<>();
            for (int j = 0; j < n - 1; j++) {
                pairs.add(swapped.substring(j, j + 2));
            }
            
            maxScore = Math.max(maxScore, pairs.size());
        }
        
        System.out.println(maxScore);
    }
}
