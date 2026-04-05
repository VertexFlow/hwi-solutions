# Medium Questions

### Questions - [View PDF](./assets/questions.pdf)

### 1. Maximum Modulo Sum - [Solution](./01_maximum_modulo_sum)

Select subsequence to maximize sum with no consecutive same-remainder elements.

**Problem:** Given array A of N positive integers and K. Select subsequence preserving order where no two consecutive elements have same remainder mod K. Maximize sum.

---

### 2. Dual Timeline - [Solution](./02_dual_timeline)

Assign tasks to two parallel teams to minimize total penalty.

**Problem:** N tasks with duration D[i] and penalty P[i]. Assign to Team A or B (sequential within team). If task finishes at time T, penalty = T \* P[i]. Minimize total penalty.

---

### 3. Minimum Cost Swaps - [Solution](./03_minimum_cost_swaps)

Sort array with adjacent swaps where cost = absolute difference.

**Problem:** Given array A of size N. Adjacent swap cost = |A[i] - A[i+1]|. Find minimum cost to sort into strictly increasing sequence, or return -1 if impossible.

---

### 4. Vineyard Planting - [Solution](./04_vineyard_planting)

Interleave two nursery seedlings to maximize score based on range.

**Problem:** Two nurseries A (N seedlings) and B (M seedlings). Plant all in order. Score of seedling x = max(|x - max_prev|, |x - min_prev|). First seedling scores 0. Maximize total score.

---

### 5. Mosaic Tile Optimization - [Solution](./05_mosaic_tile_optimization)

Tile N×M grid with 1×1 (costA) or 1×2 (costB) tiles.

**Problem:** N×M grid. Type A: 1×1 tile costs costA, earns bonus V[i][j] if accent cell. Type B: 1×2 horizontal costs costB, no bonus. Find minimum net cost.

---

### 6. Aquarium Fish Display - [Solution](./06_aquarium_fish_display)

Merge two fish tanks maintaining order to maximize adjacency scores.

**Problem:** Tank A (N fish) and B (M fish) with family codes. Interleave maintaining order. Score for adjacent pair (a,b) = S[a][b]. Maximize total score for N+M-1 pairs.

---

### 7. Tree Plucking - [Solution](./07_tree_plucking)

Remove tree nodes one by one where removal cost = node value, neighbor values increase.

**Problem:** Tree with N nodes, node i has value v[i]. Remove nodes with degree ≤ 1 only. Cost = current value of removed node. When node u removed, each neighbor's value += v[u]. Find minimum total cost.

---

### 8. Recaman Queries - [Solution](./08_recaman_queries)

Process point updates and range queries with Recaman sequence distance.

**Problem:** Array A of size N. Q queries: Type 0: set A[i]=x. Type 1: find max in A[L..R], compute its Recaman distance, multiply by 17 if "fortunate number". Return sum of all Type 1 results.

---

## Summary

| #   | Name                     | Approach                  |
| --- | ------------------------ | ------------------------- |
| 1   | Maximum Modulo Sum       | 1D DP with remainders     |
| 2   | Dual Timeline            | Greedy scheduling         |
| 3   | Minimum Cost Swaps       | Graph/cycle decomposition |
| 4   | Vineyard Planting        | 2D DP with pruning        |
| 5   | Mosaic Tile Optimization | 1D DP per row             |
| 6   | Aquarium Fish Display    | 2D DP sequence merging    |
| 7   | Tree Plucking            | Greedy leaf removal       |
| 8   | Recaman Queries          | Segment tree + math       |
