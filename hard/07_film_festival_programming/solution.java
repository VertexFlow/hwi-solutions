import java.io.*;
import java.util.*;

public class FilmFestivalProgramming {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int D = Integer.parseInt(br.readLine().trim());
        int K = Integer.parseInt(br.readLine().trim());
        int P = Integer.parseInt(br.readLine().trim());
        
        List<int[]> films = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            films.add(new int[]{g, a});
        }
        
        films.sort((a, b) -> b[1] - a[1]);
        
        long totalAppeal = 0;
        int lastGenre = -1;
        int penalties = 0;
        
        for (int i = 0; i < D; i++) {
            int bestIdx = -1;
            for (int j = 0; j < N; j++) {
                int[] film = films.get(j);
                if (film[0] != lastGenre) {
                    bestIdx = j;
                    break;
                }
            }
            
            if (bestIdx == -1) {
                bestIdx = 0;
            }
            
            int[] chosen = films.get(bestIdx);
            totalAppeal += chosen[1];
            
            if (lastGenre != -1 && chosen[0] == lastGenre) {
                penalties++;
            }
            lastGenre = chosen[0];
            
            films.remove(bestIdx);
        }
        
        long result = totalAppeal - (long) penalties * P;
        System.out.println(result);
    }
}
