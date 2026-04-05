import java.io.*;
import java.util.*;

public class RecamanQueries {
    static int MAXM = 10000;
    static int MAXVAL = 1000000;
    static int MAXSTEP = 5000;
    static boolean[] fortunate = new boolean[MAXM + 1];
    static int[] primes = new int[1300];
    static int primeCount = 0;
    static boolean[] isPrime = new boolean[MAXVAL + MAXM + 10];
    static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= MAXVAL + MAXM; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAXVAL + MAXM; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
    static void computeFortunate() {
        sieve();
        long primorial = 1;
        for (int i = 0; i < primes.length; i++) {
            if (i > 0) primorial *= primes[i - 1];
            for (int m = 2; m <= MAXM; m++) {
                if (!fortunate[m]) {
                    long val = primorial + m;
                    if (val <= MAXVAL + MAXM && isPrime[(int) val]) {
                        fortunate[m] = true;
                    }
                }
            }
        }
    }
    static int recamanDistance(int M) {
        if (M <= 1) return 0;
        boolean[] seen = new boolean[MAXVAL + 1];
        int cur = M;
        int steps = 0;
        for (int i = 1; i <= MAXSTEP; i++) {
            int next = cur - i;
            if (next <= 0 || seen[next]) {
                next = cur + i;
            }
            if (next > MAXVAL || seen[next]) {
                break;
            }
            seen[cur] = true;
            cur = next;
            steps++;
        }
        return steps;
    }
    static class SegTree {
        int n;
        int[] tree;
        SegTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            build(1, 0, n - 1, arr);
        }
        void build(int node, int l, int r, int[] arr) {
            if (l == r) {
                tree[node] = arr[l];
            } else {
                int mid = (l + r) / 2;
                build(node * 2, l, mid, arr);
                build(node * 2 + 1, mid + 1, r, arr);
                tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
            }
        }
        void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }
        void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                tree[node] = val;
            } else {
                int mid = (l + r) / 2;
                if (idx <= mid) {
                    update(node * 2, l, mid, idx, val);
                } else {
                    update(node * 2 + 1, mid + 1, r, idx, val);
                }
                tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
            }
        }
        int query(int ql, int qr) {
            return query(1, 0, n - 1, ql, qr);
        }
        int query(int node, int l, int r, int ql, int qr) {
            if (qr < l || ql > r) return Integer.MIN_VALUE;
            if (ql <= l && r <= qr) return tree[node];
            int mid = (l + r) / 2;
            return Math.max(query(node * 2, l, mid, ql, qr), query(node * 2 + 1, mid + 1, r, ql, qr));
        }
    }
    public static void main(String[] args) throws Exception {
        primes[primeCount++] = 2;
        primes[primeCount++] = 3;
        primes[primeCount++] = 5;
        primes[primeCount++] = 7;
        primes[primeCount++] = 11;
        primes[primeCount++] = 13;
        primes[primeCount++] = 17;
        primes[primeCount++] = 19;
        primes[primeCount++] = 23;
        primes[primeCount++] = 29;
        primes[primeCount++] = 31;
        primes[primeCount++] = 37;
        primes[primeCount++] = 41;
        primes[primeCount++] = 43;
        primes[primeCount++] = 47;
        computeFortunate();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(br.readLine().trim());
        SegTree seg = new SegTree(a);
        int q = Integer.parseInt(br.readLine().trim());
        long totalSum = 0;
        for (int i = 0; i < q; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            int type = Integer.parseInt(parts[0]);
            if (type == 0) {
                int idx = Integer.parseInt(parts[1]);
                int val = Integer.parseInt(parts[2]);
                seg.update(idx, val);
            } else {
                int l = Integer.parseInt(parts[1]);
                int r = Integer.parseInt(parts[2]);
                int mx = seg.query(l, r);
                int dist = recamanDistance(mx);
                if (fortunate[mx]) {
                    dist *= 17;
                }
                totalSum += dist;
            }
        }
        System.out.println(totalSum);
    }
}
