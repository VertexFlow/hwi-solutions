# Hard Questions

### Questions - [View PDF](./assets/questions.pdf)

### 1. Weighted Non-Overlapping Intervals - [Solution](./01_weighted_non_overlapping_intervals)

Select exactly K non-overlapping intervals with maximum total weight.

**Problem:** N intervals [L[i], R[i]] with weight W[i]. Activate exactly K intervals that don't overlap. Maximize total weight. Return -1 if impossible.

---

### 2. Minimum Increasing Unique Selection Cost - [Solution](./02_minimum_increasing_unique_selection_cost)

Select K strictly increasing values minimizing position penalty.

**Problem:** Array A of size N. Select K elements where values strictly increase and indices strictly increase. Cost = sum of (ij - j)^2 for j=1 to K. Find minimum cost, or -1 if impossible.

---

### 3. The Crystal Path - [Solution](./03_the_crystal_path)

Find max-energy path in grid where contribution = value \* min_so_far.

**Problem:** N×M grid with crystal values. Path from (0,0) to (N-1,M-1) moving right/down. Contribution at cell = value \* min value on path so far. Maximize total energy.

---

### 4. Spice Blend Sequencing - [Solution](./04_spice_blend_sequencing)

Select exactly K spices from two collections with harmony bonuses.

**Problem:** Collection A (N spices) and B (M spices) with (flavor, intensity). Select exactly K total spices maintaining order. Score = sum of intensities + H per consecutive same-flavor pair. Maximize score.

---

### 5. Emil's Special LCS - [Solution](./05_emils_special_lcs)

Find common subsequence maximizing length × count*of*'e'.

**Problem:** Two strings A and B. Find common subsequence C maximizing Score(C) = length(C) × count*of*'e'\_in_C.

---

### 6. Maximum Weight Independent Set Tree - [Solution](./06_maximum_weight_independent_set_tree)

Select independent set on tree with special scoring rules.

**Problem:** Tree with N nodes, node v has weight W[v]. Select set S where no two adjacent. Base score = sum of W[v]. Apply Kolakoski bonus, Thue-Morse penalty, and Ore constraint multiplier.

---

### 7. Film Festival Programming - [Solution](./07_film_festival_programming)

Schedule D films to maximize appeal minus genre repetition penalty.

**Problem:** N films with genre G[i] and appeal A[i]. Select D films. Same-genre consecutive = penalty P. Score = sum of appeals - penalties. Maximize score.

---

### 8. Terrain Color Trail - [Solution](./08_terrain_color_trail)

Traverse grid with same-color transition bonus.

**Problem:** N×M grid with colors and scenic values. Path from (0,0) to (N-1,M-1) moving right/down. Score = sum of values + B bonus per same-color transition. Maximize score.

---

### 9. Textile Pattern Weaving - [Solution](./09_textile_pattern_weaving)

Interleave two thread spools to maximize harmony bonuses.

**Problem:** Spool A (N threads) and B (M threads) with colors. Weave maintaining order. Same-color adjacent = bonus H. Maximize total beauty.

---

## Summary

| #   | Name                               | Approach                  |
| --- | ---------------------------------- | ------------------------- |
| 1   | Weighted Non-Overlapping Intervals | Sort + DP                 |
| 2   | Minimum Increasing Unique          | LIS variant + BIT         |
| 3   | The Crystal Path                   | Grid DP with min tracking |
| 4   | Spice Blend Sequencing             | 2D DP                     |
| 5   | Emil's Special LCS                 | Weighted LCS              |
| 6   | MWIS Tree                          | Tree DP + scoring         |
| 7   | Film Festival                      | Greedy + DP               |
| 8   | Terrain Color Trail                | Grid DP with color        |
| 9   | Textile Pattern Weaving            | 2D DP                     |
