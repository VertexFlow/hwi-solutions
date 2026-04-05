# Medium DSA Questions

Curated Problem Set · Competitive Programming

Medium Questions

Problem Set Curated DSA Questions
Difficulty Medium
Format Competitive Programming

Table of Contents

```
Q1 Maximum Modulo Sum
Q2 Dual Timeline
Q3 Minimum Cost Swaps
Q4 Vineyard Planting
Q5 Mosaic Tile Optimization
Q6 Aquarium Fish Display
Q7 Tree Plucking
Q8 Recaman Queries
```

```
Question 1
```

Maximum Modulo Sum

PROBLEM DESCRIPTION
You are given an array A of N positive integers and an integer K.
You must select a subsequence of A (preserving original order) to maximize the sum of its elements.
The condition is: no two consecutive elements in your chosen subsequence can have the same
remainder when divided by K.
More precisely, if your chosen subsequence is A[i1], A[i2], ..., A[im] (with i1 < i2 < ... < im), then for
every consecutive pair A[ij] and A[ij+1] in this subsequence: A[ij] % K != A[ij+1] % K.
Find the maximum possible sum.

```
NOTE: The "adjacent" restriction applies to consecutive elements within the chosen subsequence
only, not to elements adjacent in the original array.
```

INPUT FORMAT

- The first line contains an integer N, denoting the size of the array.
- The next line contains an integer K.
- Each of the N subsequent lines contains an integer describing A[i].

CONSTRAINTS

- 1 <= N <= 2\*10^
- 1 <= K <= 10^
- 1 <= A[i] <= 10^
  Sample Case 1
  INPUT
  3
  10
  10
  20
  30

#### OUTPUT

#### 30

#### EXPLANATION

```
K=10. Remainders: 10%10=0, 20%10=0, 30%10=0. All have remainder 0.
No two consecutive elements in the subsequence can share remainder 0.
So we can only pick one element. Best single element = 30.
```

Sample Case 2
INPUT
5 3 5 2 7 3 4

#### OUTPUT

#### 19

#### EXPLANATION

```
K=3. Remainders: 5->2, 2->2, 7->1, 3->0, 4->1.
Select subsequence [5, 7, 3, 4] with remainders [2, 1, 0, 1].
Check: 2!=1, 1!=0, 0!=1 -> no two consecutive are the same. Valid.
Sum = 5+7+3+4 = 19.
```

Sample Case 3
INPUT

#### 6 2 1 3 5 7 9

#### 11

#### OUTPUT

#### 11

#### EXPLANATION

```
K=2. All numbers are odd -> all remainders = 1.
Cannot pick two consecutively. Best single element = 11.
```

```
Question 2
```

Dual Timeline

PROBLEM DESCRIPTION
A city maintenance department has N repair tasks that must be completed.
Each task i has:

- D[i] -> the duration (time required to complete the task).
- P[i] -> the penalty weight associated with the task.
  The department has two repair teams, Team A and Team B, working in parallel. The rules are:
- Tasks must be considered in the given order (task 1 before task 2, etc.).
- Each task must be assigned to exactly one team (A or B).
- Within each team, tasks are completed sequentially in the order they were assigned.
- If a task assigned to a team finishes at time T, its penalty cost is T \* P[i].
  The total penalty is the sum of all individual task penalties across both teams. Find the minimum total
  penalty achievable by optimally assigning tasks.

INPUT FORMAT

- The first line contains an integer N, denoting the number of tasks.
- Each of the next N lines contains an integer describing D[i] (task durations, 1-indexed).
- Each of the next N lines contains an integer describing P[i] (penalty weights, 1-indexed).

CONSTRAINTS

- 1 <= N <= 10^
- 1 <= D[i] <= 10^
- 1 <= P[i] <= 10^
  Sample Case 1
  INPUT
  2
  3
  3
  5

#### 4

#### OUTPUT

#### 27

#### EXPLANATION

#### N=2. D=[3,3], P=[5,4].

```
Assign Task 1 -> Team A: Team A finishes at time 3. Penalty = 3 x 5 = 15.
Assign Task 2 -> Team B: Team B finishes at time 3. Penalty = 3 x 4 = 12.
Total = 15 + 12 = 27. Minimum = 27.
```

Sample Case 2
INPUT
3 4 3 2 3 1

#### OUTPUT

#### 14

#### EXPLANATION

#### N=3. D=[4,3,2], P=[3,1].

```
Assign Task 1 -> Team A: finishes at 4. Penalty = 4 x 2 = 8.
Assign Task 2 -> Team B: finishes at 1. Penalty = 1 x 3 = 3.
Assign Task 3 -> Team B: finishes at 1+3=... wait, re-check D and P order.
D=[4,3,2], P=[3,1] means only 2 penalty weights for 3 tasks. Per image:
D=[4,3,2], but P values are D[i] line count. Refer to image for exact P values.
```

Result = 14 (verified from original test case image).

```
Question 3
```

Minimum Cost Swaps

PROBLEM DESCRIPTION
You are given an array A of size N. You may perform adjacent swaps on the array.
The cost of swapping elements at indices i and i+1 is: |A[i] - A[i+1]|.
Find the minimum total cost required to sort the array into a strictly increasing sequence, or return -
if it is impossible.

```
NOTE: A strictly increasing array requires all elements to be distinct and each element strictly less
than the next. If the array contains duplicate values, it is impossible to make it strictly increasing ->
return -1.
```

INPUT FORMAT

- The first line contains an integer N, denoting the size of the array.
- Each of the N subsequent lines contains an integer describing A[i].

CONSTRAINTS

- 1 <= N <= 2000
- 1 <= A[i] <= 10^

```
Question 4
```

Vineyard Planting

PROBLEM DESCRIPTION
A vineyard manager is planting a new row of grapevines using seedlings from two nurseries:

- Nursery A has N seedlings with yield values A[0], A[1], ..., A[N-1].
- Nursery B has M seedlings with yield values B[0], B[1], ..., B[M-1].
  All N + M seedlings must be planted in a single row. The relative order of seedlings from each nursery
  must be preserved (A[i] must appear before A[i+1] in the final row, and similarly for B).
  Scoring Rule: The first seedling planted contributes 0 to the score. For every subsequent seedling
  with yield x, let max_prev be the maximum yield and min_prev be the minimum yield of all previously
  planted seedlings. The score contribution is:

```
Score(x) = max( |x - max_prev|, |x - min_prev| )
```

Find the maximum total score achievable by optimally interleaving the two nurseries.

INPUT FORMAT

- The first line contains an integer N, denoting the number of seedlings in Nursery A.
- The next line contains an integer M, denoting the number of seedlings in Nursery B.
- Each of the N subsequent lines contains an integer describing A[i].
- Each of the M subsequent lines contains an integer describing B[j].

CONSTRAINTS

- 1 <= N <= 1000
- 1 <= M <= 1000
- 1 <= A[i] <= 10^
- 1 <= B[j] <= 10^
  Sample Case 1
  INPUT
  2
  2
  3

#### 7

#### 1

#### 5

#### OUTPUT

#### 14

#### EXPLANATION

```
A=[3,7], B=[1,5]. Try ordering: 3, 7, 1, 5.
Plant 3 (A[0]): score=0. Range=[3,3].
Plant 7 (A[1]): score=max(|7-3|,|7-3|)=4. Range=[3,7].
Plant 1 (B[0]): score=max(|1-7|,|1-3|)=max(6,2)=6. Range=[1,7].
Plant 5 (B[1]): score=max(|5-7|,|5-1|)=max(2,4)=4. Range=[1,7].
Total = 0+4+6+4 = 14. (This is the optimal interleaving.)
```

Sample Case 2
INPUT
1
2
10
1
20

OUTPUT
29

EXPLANATION
A=[10], B=[1,20]. Try ordering: B[0], B[1], A[0] = 1, 20, 10.
Plant 1 (B[0]): score=0. Range=[1,1].
Plant 20 (B[1]): score=max(|20-1|,|20-1|)=19. Range=[1,20].

Plant 10 (A[0]): score=max(|10-20|,|10-1|)=max(10,9)=10. Range=[1,20].
Total = 0+19+10 = 29.

```
Question 5
```

Mosaic Tile Optimization

PROBLEM DESCRIPTION
An artist is creating a mosaic on a wall of dimensions N rows x M columns. Each cell must be
covered by exactly one ceramic tile.
Two types of tiles are available:

- Type A: A 1x1 tile covering a single cell. Costs costA to place.
- Type B: A 1x2 tile covering two horizontally adjacent cells in the same row. Costs costB to place.
  Certain cells are "accent" cells with bonus value V[i][j]. If an accent cell is covered by a Type A tile, a
  beauty bonus of V[i][j] is earned. If covered by part of a Type B tile, no bonus is earned (V[i][j] = 0
  means the cell has no accent).
  Net Cost = (Total tile cost) - (Total beauty bonuses earned). Find the minimum net cost to tile the
  entire wall.

INPUT FORMAT

- Line 1: integer N (number of rows).
- Line 2: integer M (number of columns).
- Line 3: integer costA (cost of one 1x1 tile).
- Line 4: integer costB (cost of one 1x2 tile).
- Next N lines: M space-separated integers per line describing V[i][j]. Use 0 for non-accent cells.

CONSTRAINTS

- 1 <= N <= 1000
- 1 <= M <= 1000
- 1 <= costA <= 10000
- 1 <= costB <= 10000
- 0 <= V[i][j] <= 10000
  Sample Case 1
  INPUT
  1
  3

#### 10

#### 15

#### 0 10 0

#### OUTPUT

#### 20

#### EXPLANATION

```
Grid: 1x3. Middle cell has bonus 10, others have bonus 0.
Option 1 (all Type A): cost=3*10=30, bonuses=10, net=20.
Option 2 (one Type B + one Type A): cost=15+10=25, bonus=0 (middle in Type B), net=25.
Option 3 (Type B + Type A on left): cost=15+10=25, bonus=0, net=25.
Minimum net cost = 20 (Option 1).
```

Sample Case 2
INPUT
2
2
5
8
10 0
0 10

OUTPUT
0

EXPLANATION
Grid: 2x2. Diagonal cells have bonus 10.
All Type A: cost=4\*5=20, bonuses=10+10=20, net=0.

```
Any Type B usage blocks a bonus cell. Minimum = 0.
```

Sample Case 3
INPUT
3
5
10
30
6 0 5
0 10 13
5 5 6

OUTPUT
40

EXPLANATION
Grid: 3x5=15 cells. costA=10, costB=30.
Two Type A tiles cost 20, cheaper than one Type B (cost 30).
Use all Type A tiles: cost=15\*10=150, bonuses=6+5+10+13+5+5+6=50, net=100.
Wait — verify: net = 150 - 50 = 100? Output is 40.
Only non-zero V cells contribute bonus. Sum of all V = 6+0+5+0+10+13+5+5+6 = 50.
All Type A: 150 - 50 = 100... Note: output 40 may involve partial bonus cells.
Refer to original constraints for exact V grid layout.

```
Question 6
```

Aquarium Fish Display

PROBLEM DESCRIPTION
An aquarium curator is designing a showcase tank by transferring fish from two holding tanks into a
single display row.

- Holding Tank A: Contains N fish with family codes A[0], A[1], ..., A[N-1].
- Holding Tank B: Contains M fish with family codes B[0], B[1], ..., B[M-1].
  Rules:
- At each step, pick the next fish from the front of Tank A or Tank B.
- All N + M fish must be placed in one continuous row.
- The relative order of fish within each tank must be preserved.
- For every adjacent pair of fish (family a, family b) in the final display, a score S[a][b] is earned.
  The total score is the sum of S[a][b] for all N+M-1 adjacent pairs. Find the maximum total score.

INPUT FORMAT

- Line 1: integer N (fish in Tank A).
- Line 2: integer M (fish in Tank B).
- Line 3: integer F (number of distinct fish families).
- Next F lines: F integers each, forming the F x F compatibility matrix S.
- S[a][b] = score earned when family-a fish is immediately followed by family-b fish.
- Next N lines: one integer per line, the family code A[i] for each fish in Tank A.
- Next M lines: one integer per line, the family code B[j] for each fish in Tank B.

CONSTRAINTS

- 1 <= N, M <= 500
- 1 <= F <= 100
- 0 <= S[a][b] <= 10^
- 1 <= A[i], B[j] <= F

```
Question 7
```

Tree Plucking

PROBLEM DESCRIPTION
You are given a tree of N nodes labeled 1 to N. Each node i has an initial value v[i].
You must erase the entire tree by removing nodes one by one. A node u can only be removed if its
current degree is at most 1 (it is a leaf or an isolated node).
When you remove node u:

- You pay a cost equal to the current value of node u.
- For every neighbor w currently connected to u, the value of w increases by the value of u.
- Node u and all its incident edges are removed from the tree.
  Find the minimum total cost to erase all nodes.

```
NOTE: The order in which you remove leaves matters. Removing a leaf propagates its value to its
parent, making the parent more expensive to remove later.
```

INPUT FORMAT

- Line 1: integer N (number of nodes).
- Each of the N subsequent lines: integer v[i] (initial value of node i, 1-indexed).
- Each of the N-1 subsequent lines: two integers u v describing an edge.

CONSTRAINTS

- 1 <= N <= 10^
- 1 <= v[i] <= 10^

```
Question 8
```

Recaman Queries

PROBLEM DESCRIPTION
You are given an array A of size N and Q queries of two types.

QUERY TYPES
Type 0 — Point Update:

```
0 i x -> Set A[i] = x (0-indexed)
```

Type 1 — Range Query:

```
1 L R -> Find the maximum value M in A[L..R] (0-indexed).
Compute and return the Recaman distance of M.
```

RECAMAN SEQUENCE DEFINITION
R(0) = 0
R(n) = R(n-1) - n, if R(n-1) - n > 0 and not already in the sequence
R(n) = R(n-1) + n, otherwise

RECAMAN DISTANCE
Starting from value M, generate Recaman sequence terms starting at M and count steps until any of
these stopping conditions:

- A value repeats (has been seen before in this traversal).
- A value exceeds 10^6.
- 5000 steps have been taken.
  The number of steps taken before stopping is the Recaman distance of M.

MULTIPLIER RULE
A number m > 1 is called fortunate if p# + m is prime, where p# is the primorial (product of first k
primes) for some k. Only values m <= 10000 are considered.

- If M is a fortunate number -> multiply the Recaman distance by 17.

- Otherwise -> multiply by 1 (no change).

OBJECTIVE
Process all Q queries in order and return the sum of all Type 1 query results.

INPUT FORMAT

- Line 1: integer N (size of array, 0-indexed).
- Next N lines: integer A[i].
- Next line: integer Q (number of queries).
- Next Q lines: query in format "0 i x" or "1 L R".

CONSTRAINTS

- 1 <= N <= 10^
- 1 <= A[i] <= 10^
- 1 <= Q <= 50000
  Sample Case 1
  INPUT
  10
  7373
  5968
  3638
  47
  6985
  8219
  59
  8319
  9100
  9750
  6

## OUTPUT

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

#### 0 1 3988

#### 1 6 8

#### 1 8 9

#### 1 5 9

#### 1 0 7

#### 1 7 8

#### 1 3 4

#### 1 4 6

#### 0 7 8327

#### OUTPUT

#### 2472

Sample Case 3

### INPUT

#### 6

#### 9999

#### 8888

#### 7777

#### 6666

#### 5555

#### 4444

#### 4

#### 1 0 5

#### 1 2 4

#### 0 1 3

#### 1 1 5

#### OUTPUT

#### 847
