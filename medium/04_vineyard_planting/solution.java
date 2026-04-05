import java.io.*;
import java.util.*;

public class VineyardPlanting {
    static class State {
        long mn, mx, score;
        State(long s, long m1, long m2) { score = s; mn = m1; mx = m2; }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int m = Integer.parseInt(br.readLine().trim());
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = Long.parseLong(br.readLine().trim());
        long[] b = new long[m];
        for (int i = 0; i < m; i++) b[i] = Long.parseLong(br.readLine().trim());
        List<State>[][] dp = new ArrayList[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = new ArrayList<>();
            }
        }
        dp[0][0].add(new State(0, Long.MAX_VALUE, Long.MIN_VALUE));
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (State cur : dp[i][j]) {
                    if (i < n) {
                        long x = a[i];
                        long add, nm, nM;
                        if (cur.mx == Long.MIN_VALUE) {
                            add = 0; nm = x; nM = x;
                        } else {
                            add = Math.max(cur.mx - x, x - cur.mn);
                            add = Math.max(add, 0);
                            nm = Math.min(cur.mn, x);
                            nM = Math.max(cur.mx, x);
                        }
                        addState(dp[i + 1][j], new State(cur.score + add, nm, nM));
                    }
                    if (j < m) {
                        long x = b[j];
                        long add, nm, nM;
                        if (cur.mx == Long.MIN_VALUE) {
                            add = 0; nm = x; nM = x;
                        } else {
                            add = Math.max(cur.mx - x, x - cur.mn);
                            add = Math.max(add, 0);
                            nm = Math.min(cur.mn, x);
                            nM = Math.max(cur.mx, x);
                        }
                        addState(dp[i][j + 1], new State(cur.score + add, nm, nM));
                    }
                }
            }
        }
        long ans = 0;
        for (State s : dp[n][m]) {
            ans = Math.max(ans, s.score);
        }
        System.out.println(ans);
    }
    static void addState(List<State> list, State s) {
        for (int i = 0; i < list.size(); i++) {
            State e = list.get(i);
            if (e.mn <= s.mn && e.mx >= s.mx && e.score >= s.score) return;
            if (s.mn <= e.mn && s.mx >= e.mx && s.score >= e.score) {
                list.remove(i);
                i--;
            }
        }
        list.add(s);
    }
}
