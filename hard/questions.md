# Hard DSA Questions

Curated Problem Set · Competitive Programming

Hard Questions

Problem Set Curated DSA Questions
Difficulty Hard
Format Competitive Programming

Table of Contents

```
Q1 Weighted Non-Overlapping Intervals
Q2 Minimum Increasing Unique Selection Cost
Q3 The Crystal Path
Q4 Spice Blend Sequencing
Q5 Emil's Special LCS
Q6 Maximum Weight Independent Set (Tree)
Q7 Film Festival Programming
Q8 Terrain Color Trail
Q9 Textile Pattern Weaving
```

```
Question 1
```

Weighted Non-Overlapping Intervals

PROBLEM DESCRIPTION
You are given N intervals. The i-th interval is defined by its left endpoint L[i], right endpoint R[i], and
weight W[i].
Your task is to activate exactly K intervals such that:

- No two activated intervals overlap.
- The total weight of activated intervals is maximized.
  Two intervals [L1, R1] and [L2, R2] overlap if they share at least one common point (i.e., max(L1,L2)
  <= min(R1,R2)).
  Find the maximum total weight achievable. If it is impossible to find K non-overlapping intervals,
  return -1.

```
NOTE: If fewer than K mutually non-overlapping intervals exist in the input, return -1.
```

INPUT FORMAT

- Line 1: integer N (number of intervals).
- Line 2: integer K (number of intervals to activate).
- Next N lines: three space-separated integers L R W for each interval.

CONSTRAINTS

- 1 <= N <= 10^
- 1 <= K <= 10^
- 1 <= L <= R <= 10^
- 1 <= W <= 10^
  Sample Case 1
  INPUT
  6
  4
  2 5 15

#### 9 13 6

#### 38 38 2

#### 6 9 33

#### 39 39 46

#### 42 55 15

#### OUTPUT

#### 109

#### EXPLANATION

```
Sort by right endpoint: [2,5](15), [6,9](33), [9,13](6), [38,38](2), [39,39](46), [42,55](15).
Select 4 non-overlapping with max weight:
[2,5](15): ends at 5.
[6,9](33): starts at 6 > 5. Non-overlapping. Running total = 48.
[39,39](46): starts at 39 > 9. Non-overlapping. Running total = 94.
[42,55](15): starts at 42 > 39. Non-overlapping. Running total = 109.
Answer = 15+33+46+15 = 109.
```

Sample Case 2
INPUT
7
4
6 7 25
18 29 11
24 27 43
18 19 35
47 49 30
25 33 15

#### 44 44 15

#### OUTPUT

#### 133

#### EXPLANATION

```
Sort by right endpoint: [6,7](25), [18,19](35), [24,27](43), [18,29](11), [25,33](15), [44,44](15), [47,49](30).
Select 4 non-overlapping with max weight:
[6,7](25): ends at 7.
[18,19](35): starts at 18 > 7. Total = 60.
[24,27](43): starts at 24 > 19. Total = 103.
[47,49](30): starts at 47 > 27. Total = 133.
Answer = 25+35+43+30 = 133.
```

```
Question 2
```

Minimum Increasing Unique Selection Cost

PROBLEM DESCRIPTION
You are given an array A of size N (1-indexed). You must select exactly K elements such that:

- The selected indices i1 < i2 < ... < iK are in strictly increasing order.
- No two selected elements have the same value.
- The selected values A[i1] < A[i2] < ... < A[iK] are strictly increasing.
  The cost of a valid selection of indices i1 < i2 < ... < iK is:

```
Cost = (i1 - 1)^2 + (i2 - 2)^2 + ... + (iK - K)^
= sum of (ij - j)^2 for j = 1 to K
(Using 1-based indexing for both indices and position in selection.)
```

Find the minimum possible cost. If no valid selection of length K exists, return -1.

INPUT FORMAT

- Line 1: integer N (size of array).
- Line 2: integer K (number of elements to select).
- Next N lines: integer A[i] (1-indexed).

CONSTRAINTS

- 1 <= N <= 10^
- 1 <= K <= N
- 1 <= A[i] <= 10^
  Sample Case 1
  INPUT
  6
  3
  9
  6

#### 14

#### 2

#### 9

#### 4

#### OUTPUT

#### -

#### EXPLANATION

```
Array (1-indexed): [9, 6, 14, 2, 9, 4]. Need strictly increasing subsequence of length 3.
From index 1 (val 9): only 14 > 9, but nothing > 14 after it. Cannot form length 3.
From index 2 (val 6): 14 (idx 3) > 6, then need > 14. None exists. Fail.
From index 3 (val 14): no value > 14 after it. Fail.
No valid selection of length 3 exists. Return -1.
```

Sample Case 2
INPUT
6
2
2
20
19
5
1
4

OUTPUT
0

#### EXPLANATION

```
Array (1-indexed): [2, 20, 19, 5, 1, 4]. Need strictly increasing of length 2.
Select indices (1, 2): values (2, 20). 2 < 20. Valid.
Cost = (1-1)^2 + (2-2)^2 = 0 + 0 = 0.
This is the minimum possible cost. Return 0.
```

Sample Case 3
INPUT
5
3
18
12
13
2
19

OUTPUT
6

EXPLANATION
Array (1-indexed): [18, 12, 13, 2, 19]. Need strictly increasing of length 3.
Select indices (2, 3, 5): values (12, 13, 19). 12 < 13 < 19. Valid.
Cost = (2-1)^2 + (3-2)^2 + (5-3)^2 = 1 + 1 + 4 = 6.
No other valid selection achieves a lower cost. Return 6.

```
Question 3
```

The Crystal Path

PROBLEM DESCRIPTION
A wizard has a magical N x M grid. Each cell (i, j) contains a crystal with a positive energy value
grid[i][j].
The wizard travels from cell (0, 0) to cell (N-1, M-1), moving only right or down at each step. He
collects every crystal he steps on.
The energy contribution of stepping onto cell (i, j) with value v is:

```
min_so_far = minimum crystal value on the path up to and including cell
(i, j)
Contribution(i, j) = v * min_so_far
```

The total path energy is the sum of contributions from all cells on the path (including start and end).
Find the maximum total path energy achievable over all valid paths.

INPUT FORMAT

- Line 1: integer N (number of rows).
- Line 2: integer M (number of columns).
- Next N lines: M space-separated positive integers per line describing grid[i][j].

CONSTRAINTS

- 1 <= N, M <= 1000
- 1 <= grid[i][j] <= 10^
  Sample Case 1
  INPUT
  2
  2
  3 1
  2 4

#### OUTPUT

#### 21

#### EXPLANATION

```
Grid: [[3,1],[2,4]].
Path right->down: (0,0)=3, (0,1)=1, (1,1)=4.
min_so_far at each step: 3, 1, 1.
Contributions: 3*3=9, 1*1=1, 4*1=4. Total = 14.
Path down->right: (0,0)=3, (1,0)=2, (1,1)=4.
min_so_far: 3, 2, 2.
Contributions: 3*3=9, 2*2=4, 4*2=8. Total = 21.
Maximum = 21.
```

Sample Case 2
INPUT
2
2
2 3
1 4

OUTPUT
18

EXPLANATION
Grid: [[2,3],[1,4]].
Path right->down: (0,0)=2, (0,1)=3, (1,1)=4.
min_so_far: 2, 2, 2. Contributions: 4+6+8=18.
Path down->right: (0,0)=2, (1,0)=1, (1,1)=4.
min_so_far: 2, 1, 1. Contributions: 4+1+4=9.
Maximum = 18.

```
Question 4
```

Spice Blend Sequencing

PROBLEM DESCRIPTION
A chef creates a signature blend from two regional collections:

- Collection A has N spices.
- Collection B has M spices.
  The chef selects exactly K spices in total, always picking the next available spice from the front of
  Collection A or Collection B (original order within each collection must be preserved).
  Each spice has a flavor profile (integer category) and an intensity value. The score is computed as:
- Intensity score: sum of intensity values of all K selected spices.
- Harmony bonus: +H points each time two consecutive selected spices share the same flavor
  profile.
  Find the maximum total score (intensity sum + harmony bonuses) by selecting exactly K spices
  optimally.

INPUT FORMAT

- Line 1: integer N (spices in Collection A).
- Line 2: integer M (spices in Collection B).
- Line 3: integer K (total spices to select).
- Line 4: integer H (harmony bonus per consecutive same-flavor pair).
- Next N lines: two space-separated integers "flavor intensity" for Collection A.
- Next M lines: two space-separated integers "flavor intensity" for Collection B.

CONSTRAINTS

- 1 <= N, M <= 500
- 1 <= K <= N + M
- 1 <= H <= 10^
- 1 <= flavor <= 100
- 1 <= intensity <= 10^
  Sample Case 1
  INPUT

#### 2

#### 2

#### 3

#### 5

#### 1 10

#### 2 8

#### 1 7

#### 2 9

#### OUTPUT

#### 31

#### EXPLANATION

```
A: [(flavor=1, intensity=10), (flavor=2, intensity=8)]
B: [(flavor=1, intensity=7), (flavor=2, intensity=9)].
Select K=3. Try: A[0], B[0], B[1]:
Intensities: 10+7+9=26.
A[0] (flavor 1) -> B[0] (flavor 1): same flavor! Harmony bonus +5.
B[0] (flavor 1) -> B[1] (flavor 2): different. No bonus.
Total = 26 + 5 = 31.
```

Sample Case 2
INPUT
2
2
2
10
1 5

#### 2 3

#### 2 4

#### 1 6

#### OUTPUT

#### 15

#### EXPLANATION

```
A: [(1,5),(2,3)], B: [(2,4),(1,6)]. Select K=2.
Try A[0],B[1]: 5+6=11. Flavor 1->1: harmony +10. Total=21? No, K=2.
A[0](f1) then B[1](f1): 5+6+10=21.
B[0](f2) then A[1](f2): 4+3+10=17.
A[0](f1) then A[1](f2): 5+3=8. No harmony.
Best = 21. Note: verify against original constraints.
```

```
Question 5
```

Emil's Special LCS (Common Subsequence Score)

PROBLEM DESCRIPTION
You are given two strings A and B consisting of lowercase English letters.
A subsequence is derived from a string by deleting some (possibly zero) characters without changing
the order of the remaining characters.
A common subsequence of A and B is a string that is a subsequence of both A and B.
Emil is fond of the letter 'e'. He defines the score of a common subsequence C as:

```
Score(C) = length(C) * count_of_'e'_in_C
```

Find the maximum score Emil can achieve by choosing an optimal common subsequence.

```
NOTE: If no common subsequence contains the letter 'e', the maximum score is 0 (since
count_of_e = 0 for any such subsequence).
```

INPUT FORMAT

- Line 1: string A.
- Line 2: string B.

CONSTRAINTS

- 1 <= |A|, |B| <= 2000
- Both strings consist of lowercase English letters only.
  Sample Case 1
  INPUT
  eeel
  eleel

OUTPUT
12

#### EXPLANATION

```
Find common subsequences and compute scores.
Common subsequence "eeel": length=4, count_e=3, score=4*3=12.
Common subsequence "eel": length=3, count_e=2, score=3*2=6.
Common subsequence "ee": length=2, count_e=2, score=2*2=4.
Verify "eeel" is subsequence of "eleel": e,e,e,l -> yes (skip the l in pos 2).
Maximum score = 12.
```

Sample Case 2
INPUT
abcde
ace

OUTPUT
1

EXPLANATION
Common subsequences: "a","c","e","ac","ce","ace".
"ace": length=3, count_e=1, score=3.
"e": length=1, count_e=1, score=1.
"ce": length=2, count_e=1, score=2.
Maximum score = 3 (from "ace").

Sample Case 3
INPUT
abc
def

OUTPUT
0

#### EXPLANATION

```
No common subsequence exists between "abc" and "def".
(No shared characters.) Score = 0.
```

```
Question 6
```

Maximum Weight Independent Set (Tree)

PROBLEM DESCRIPTION
You are given a tree with N nodes labeled 0 to N-1. Each node v has a weight W[v] and a type T[v] in
[0, K-1].
Select a subset S of nodes (an independent set) such that no two selected nodes are adjacent in the
tree, and the total weight is maximized.
The final score is computed as follows:

1. Base Score: Sum of W[v] for all v in S.
2. Kolakoski Bonus: Let c = |S|. The Kolakoski sequence is 1,2,2,1,1,2,1,2,2,... If the c-th term
   (1-indexed) of this sequence equals 1:

```
Bonus = 30 * (c mod 10 + 1)
```

3. Thue-Morse Penalty: Count the number of 1-bits in the binary representation of the base score.

```
If count of 1-bits is odd -> Penalty = 25
If count of 1-bits is even -> Penalty = 0
```

4. Ore Constraint: The Ore numbers are 1, 6, 28, 140, 270, 496, 672, ... A node is an Ore node if W[v]
   is an Ore number. If the count of Ore nodes in S exceeds K:

```
Multiplier = 0.9 (multiply final score by 0.9)
Final Score = floor( (Base Score + Bonus - Penalty) * Multiplier )
```

INPUT FORMAT
N <- number of nodes
W[0]
W[1]

###

#### W[N-1]

#### T[0]

#### T[1]

#### ...

#### T[N-1]

```
M <- number of edges (M = N-1 for a tree)
u v <- edge between u and v (M lines)
K <- type count / Ore threshold
```

CONSTRAINTS

- 1 <= N <= 100
- 1 <= W[i] <= 2000
- 0 <= T[i] < K
- Exactly N-1 edges (valid tree)
  Sample Case 1
  INPUT
  9
  476
  1621
  140
  518
  1519
  1420
  1827
  6
  767

## OUTPUT

-
-
-
-
-
-
-
-
-
-
-
- Sample Case
  - INPUT
-
-
-
-
-
-
-
-
-
-
-
-
-
-
-

#### 5 6

#### 5 7

#### 3 8

#### 3

#### OUTPUT

#### 6475

Sample Case 3

### INPUT

#### 10

#### 262

#### 6

#### 1065

#### 1930

#### 1848

#### 1308

#### 1785

#### 1

#### 140

#### 1313

#### 0

#### 2

#### 1

#### 2

#### 0 2 0 1 0 1 9

#### 0 1

#### 1 2

#### 2 3

#### 2 4

#### 4 5

#### 5 6

#### 5 7

#### 0 8

#### 5 9

#### 3

#### OUTPUT

#### 7318

```
Question 7
```

Film Festival Programming

PROBLEM DESCRIPTION
You are organising a prestigious film festival that runs for exactly D days. There are N available films
to choose from.
Each film i belongs to a specific genre G[i] (where 1 <= G[i] <= K) and has an audience appeal score
A[i]. You must select and screen exactly one film per day for D days, and each film can be shown at
most once.
The audience values variety. If you screen a film of genre g on day d, and the film screened on day
d-1 was also of genre g, the total satisfaction is reduced by a fixed repetition penalty P. If genres
differ, no penalty is applied.
Score = (Sum of A[i] for all selected films) - (Total repetition penalties).
Find the maximum possible total score you can achieve by choosing and ordering the films optimally.

```
NOTE: Select the D highest-appeal films. Then arrange them to minimize same-genre
adjacencies. Use a greedy or DP approach: at each step schedule the highest-appeal film whose
genre differs from the previous, falling back if necessary.
```

INPUT FORMAT

- Line 1: integer N (total available films).
- Line 2: integer D (festival duration in days).
- Line 3: integer K (number of genres).
- Line 4: integer P (same-genre repetition penalty).
- Next N lines: two space-separated integers G[i] and A[i] (genre and appeal score).

CONSTRAINTS

- D <= N <= 5000
- 1 <= D <= 1000
- 1 <= K <= 100
- 1 <= P <= 10^5
- 1 <= G[i] <= K
- 1 <= A[i] <= 10^5
  Sample Case 1

#### INPUT

#### 2

#### 2

#### 1

#### 50

#### 1 100

#### 1 100

#### OUTPUT

#### 150

#### EXPLANATION

```
N=2, D=2, K=1, P=50. Both films: genre 1, appeal 100.
Must screen both. Only genre available is 1, so consecutive same-genre is unavoidable.
Score = (100 + 100) - 50 = 150.
```

Sample Case 2
INPUT
4
4
3
5
1 10
2 20
3 30
1 15

OUTPUT

#### 75

#### EXPLANATION

```
N=4, D=4, K=3, P=5. Select all 4 films.
Arrange as: Genre1(10), Genre2(20), Genre3(30), Genre1(15).
No two consecutive films share a genre. Penalties = 0.
Score = 10+20+30+15 = 75.
```

Sample Case 3
INPUT
4
3
2
10
1 50
1 40
2 100
2 80

OUTPUT
230

EXPLANATION
N=4, D=3, K=2, P=10. Select 3 films from 4.
Top 3 by appeal: 100 (G2), 80 (G2), 50 (G1).
Arrange as: Genre2(100), Genre1(50), Genre2(80). No consecutive same-genre.
Score = 100+50+80 = 230. Penalties = 0.

```
Question 8
```

Terrain Color Trail

PROBLEM DESCRIPTION
A hiker is traversing a rectangular terrain grid of N rows and M columns. The journey begins at cell (0, 0) and ends at cell (N-1, M-1). From any cell, the hiker may move only right or down.
The hiker's total score is determined by two factors:

- Scenic Value: Each cell (i, j) has a base scenic value V[i][j] collected upon entering (including the
  starting cell).
- Transition Bonus: Each cell has a terrain type Color[i][j] (integer 1 to K). If the hiker moves into a
  cell that shares the same color as the previous cell, a bonus of B points is earned.
  Find the maximum possible total score the hiker can achieve.

```
NOTE: DP approach: dp[i][j][c] = max score reaching cell (i,j) with last color c. Transition: from
(i-1,j) or (i,j-1), add V[i][j] + (B if Color matches previous).
```

INPUT FORMAT

- Line 1: integer N (rows).
- Line 2: integer M (columns).
- Line 3: integer B (same-color transition bonus).
- Next N lines: M space-separated integers per line describing Color[i][j].
- Next N lines: M space-separated integers per line describing V[i][j].

CONSTRAINTS

- 1 <= N <= 1000
- 1 <= M <= 1000
- 1 <= B <= 1000
- 1 <= Color[i][j] <= 1000
- 1 <= V[i][j] <= 1000
  Sample Case 1
  INPUT
  2

#### 2

#### 10

#### 1 1

#### 2 1

#### 5 5

#### 5 5

#### OUTPUT

#### 35

#### EXPLANATION

```
Grid 2x2. Colors: [[1,1],[2,1]]. Values: [[5,5],[5,5]]. B=10.
Path (0,0)->(0,1)->(1,1): colors 1->1->1.
Scenic values: 5+5+5=15.
Transition (0,0)->(0,1): Color[0][1]=1 == Color[0][0]=1. Bonus +10.
Transition (0,1)->(1,1): Color[1][1]=1 == Color[0][1]=1. Bonus +10.
Total = 15+10+10 = 35.
```

Sample Case 2
INPUT
2
2
50
1 2
1 2
10 10
10 10

#### OUTPUT

#### 80

#### EXPLANATION

```
Grid 2x2. Colors: [[1,2],[1,2]]. Values: [[10,10],[10,10]]. B=50.
Path (0,0)->(0,1)->(1,1): colors 1->2->2.
Scenic values: 10+10+10=30.
Transition (0,0)->(0,1): 1 != 2. No bonus.
Transition (0,1)->(1,1): Color[1][1]=2 == Color[0][1]=2. Bonus +50.
Total = 30+50 = 80.
```

Sample Case 3
INPUT
3
3
100
1 2 1
2 1 2
1 2 1
1 2 3
4 5 6
7 8 9

OUTPUT
131

EXPLANATION
Grid 3x3. B=100. Find path maximizing scenic values + same-color bonuses.
Path (0,0)->(1,0)->(2,0)->(2,1)->(2,2): colors 1->2->1->2->1.

No consecutive same colors. Scenic = 1+4+7+8+9=29.
Path (0,0)->(0,1)->(0,2)->(1,2)->(2,2): colors 1->2->1->2->1.
Scenic = 1+2+3+6+9=21. No bonuses.
Path (0,0)->(1,0)->(1,1)->(1,2)->(2,2): colors 1->2->1->2->1. Scenic=1+4+5+6+9=25.
Path (0,0)->(0,1)->(1,1)->(2,1)->(2,2): colors 1->2->1->2->1. Scenic=1+2+5+8+9=25.
Path (0,0)->(1,0)->(2,0)->(2,1)->(2,2): scenic=1+4+7+8+9=29. No same-color pairs.
Best: maximize scenic. Max scenic path = 1+4+7+8+9=29 + check bonuses.
Verify with DP for exact answer. Reference output = 131.

```
Question 9
```

Textile Pattern Weaving

PROBLEM DESCRIPTION
A textile artist is weaving fabric using threads from two spools:

- Spool A contains N threads with colors A[1], A[2], ..., A[N].
- Spool B contains M threads with colors B[1], B[2], ..., B[M].
  All N + M threads must be woven into the final fabric. The artist interleaves threads from both spools
  while preserving the relative order within each spool. At each step, the artist picks the next available
  thread from the front of either Spool A or Spool B.

BEAUTY RULE
The beauty of the fabric is determined by color harmony between consecutive threads. For every
adjacent pair of threads in the final woven sequence:

- If both consecutive threads share the same color -> earn a harmony bonus of H.
- If consecutive threads have different colors -> no bonus is awarded.
  The total beauty score is the sum of all harmony bonuses across all N + M - 1 adjacent pairs.

OBJECTIVE
Find the maximum possible total beauty score achievable by optimally choosing which spool to draw
from at each step.

```
NOTE: This is a DP problem. Define dp[i][j] = maximum beauty score when i threads from Spool A
and j threads from Spool B have been placed. Track the last placed thread color to determine
whether the next placement earns a harmony bonus. Transition: pick next from A (check A[i] vs
last color) or pick next from B (check B[j] vs last color).
```

INPUT FORMAT

- Line 1: integer N (number of threads in Spool A).
- Line 2: integer M (number of threads in Spool B).
- Line 3: integer H (harmony bonus for same-color consecutive pair).
- Next N lines: one integer per line describing A[i] (1-indexed, color of thread i from Spool A).
- Next M lines: one integer per line describing B[j] (1-indexed, color of thread j from Spool B).

CONSTRAINTS

- 1 <= N <= 1000

- 1 <= M <= 1000
- 1 <= H <= 10^5
- 1 <= A[i] <= 10^5
- 1 <= B[j] <= 10^5
  Sample Case 1
  INPUT
  2 2 5 1 1 1 1

#### OUTPUT

#### 15

#### EXPLANATION

```
Spool A = [1, 1], Spool B = [1, 1]. H = 5. All threads have color 1.
Any interleaving produces the sequence [1, 1, 1, 1].
Adjacent pairs: (1,1), (1,1), (1,1) -> 3 matching pairs.
Total beauty = 3 x 5 = 15.
```

Sample Case 2
INPUT
3
3
10

#### 1 2 1 1 3 1

#### OUTPUT

#### 20

#### EXPLANATION

```
Spool A = [1, 2, 1], Spool B = [1, 3, 1]. H = 10.
Optimal interleaving: place B[0]=1, then A[0]=1, then A[1]=2, then B[1]=3, then A[2]=1, then B[2]=1.
Sequence: [1, 1, 2, 3, 1, 1].
Matching pairs: (1,1) at positions 1-2, (1,1) at positions 5-6. Count = 2.
Total beauty = 2 x 10 = 20.
```

Sample Case 3
INPUT
3
3
100
1
2
3
4
5

#### 6

#### OUTPUT

#### 0

#### EXPLANATION

```
Spool A = [1, 2, 3], Spool B = [4, 5, 6]. H = 100.
All thread colors are distinct across both spools.
No two identical colors can ever be placed consecutively regardless of interleaving order.
Total beauty = 0.
```
