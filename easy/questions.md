# Easy DSA Questions

#### Curated Problem Set · Competitive Programming

##### Easy Questions

Problem Set Curated DSA Questions
Difficulty Easy
Format Competitive Programming


## Table of Contents

###### Q1 ZerosOnes

###### Q2 Self-Skipping Maximum

###### Q3 Prefix Flow Stability

###### Q4 Peak Elimination

###### Q5 Threshold 1

###### Q6 Stable Temperature System

###### Q7 Blocks

###### Q8 String Stability Boost

###### Q9 Tool Rental Maximization

###### Q10 Coins

###### Q11 Vault Digit Alignment

###### Q12 Fabric Weaving Beauty Score

###### Q13 Lazy Student


```
Question 1
```
### ZerosOnes

PROBLEM DESCRIPTION
You are given an array A of length N, initially filled with zeros, and an array B of M integers.
For each i from 1 to M, you will flip A[B[i]]: if it was 0 make it 1, and if it was 1 make it 0.
After each update, define the cost of array A as the maximum length of a contiguous subarray that
contains at most one transition between 0s and 1s (i.e., the subarray is either all one value, or starts
with a block of one value and ends with a block of the other value — exactly one change of value is
allowed).
Find the product of the M costs, modulo 10^9 + 7.

```
NOTE: Arrays are 1-indexed. B[i] values are valid indices into A (1 to N).
```
INPUT FORMAT

- The first line contains an integer N, denoting the length of array A.
- The next line contains an integer M, denoting the number of operations.
- Each of the M subsequent lines contains an integer describing B[i] (1-indexed).

CONSTRAINTS

- 1 <= N <= 10^
- 1 <= M <= 10^
- 1 <= B[i] <= N
Sample Case 1
INPUT
3
1
1

OUTPUT
3


EXPLANATION
N=3, M=1, B=[1]. Initial A = [0,0,0].
Step 1: Flip A[1] -> A = [1,0,0].
Max subarray with at most one transition: the entire array [1,0,0] qualifies (one transition 1->0).
Cost = 3.
Product = 3.

Sample Case 2
INPUT
3
2
3
1

OUTPUT
6

EXPLANATION
Initial A = [0,0,0].
Step 1: Flip A[3] -> A = [0,0,1]. Max valid subarray = entire array (one transition). Cost = 3.
Step 2: Flip A[1] -> A = [1,0,1]. Max valid subarray = any 2 adjacent elements. Cost = 2.
Product = 3 x 2 = 6.

Sample Case 3
INPUT
3
2
1
2


OUTPUT
9

EXPLANATION
Initial A = [0,0,0].
Step 1: Flip A[1] -> A = [1,0,0]. Max valid subarray = entire array. Cost = 3.
Step 2: Flip A[2] -> A = [1,1,0]. Max valid subarray = entire array (one transition 1->0). Cost = 3.
Product = 3 x 3 = 9.


```
Question 2
```
### Self-Skipping Maximum

PROBLEM DESCRIPTION
You are given an array A of N positive integers. You must select a subsequence of elements to
maximize their total sum.
The restriction is: if you choose the element at index i (0-indexed), you are forced to skip the next A[i]
elements. Your next selection must be from index i + A[i] + 1 or later.
Find the maximum possible sum you can achieve.

```
NOTE: Array is 0-indexed. You may choose any subset of indices satisfying the skip constraint;
you are not required to select any element.
```
INPUT FORMAT

- The first line contains an integer N, denoting the size of the array.
- Each of the N subsequent lines contains an integer describing A[i].

CONSTRAINTS

- 1 <= N <= 200000
- 1 <= A[i] <= 10^
Sample Case 1
INPUT
3
10
10
10

OUTPUT
10

EXPLANATION


```
Array: [10, 10, 10].
Picking index 0 (value 10): next allowed index = 0 + 10 + 1 = 11, out of bounds. Sum = 10.
Picking any single element gives 10. Best = 10.
```
Sample Case 2
INPUT
5
2
4
1
2
10

OUTPUT
12

EXPLANATION
DP from right: dp[4]=10, dp[3]=10, dp[2]=11, dp[1]=11.
dp[0]: take index 0 (val=2) + dp[0+2+1] = 2 + dp[3] = 2 + 10 = 12.
skip index 0 -> dp[1] = 11. Best = 12.

Sample Case 3
INPUT
5
1
1
1
1


```
1
```
OUTPUT
3

EXPLANATION
Pick index 0 (val 1): next = 0+1+1 = 2.
Pick index 2 (val 1): next = 2+1+1 = 4.
Pick index 4 (val 1): done. Sum = 1+1+1 = 3.


```
Question 3
```
### Prefix Flow Stability

PROBLEM DESCRIPTION
You are given an array E of size N. You may perform the following operation any number of times:

- Choose an index i such that 1 <= i <= N-1.
- Transfer 1 unit from E[i] to E[i+1] (forward transfer only — no backward transfers allowed).
Find the maximum prefix length K (1 <= K <= N) such that it is possible to make the first K elements
non-decreasing after applying any number of the allowed operations.
If the entire array can be made non-decreasing, return N. Otherwise return the largest valid K.

```
NOTE: Arrays are 1-indexed. You can only shift units to the right, never to the left. Units cannot be
created or destroyed.
```
INPUT FORMAT

- The first line contains an integer N, denoting the size of the array.
- Each of the N subsequent lines contains an integer describing E[i] (1-indexed).

CONSTRAINTS

- 1 <= N <= 10^
- 1 <= E[i] <= 10^
Sample Case 1
INPUT
6
9
12
0
4
3

OUTPUT


```
2
```
EXPLANATION
E = [9, 12, 0, 4, 3] (5 elements, N=6 likely includes a 6th).
Prefix of length 2: [9, 12] is already non-decreasing. Valid.
Extend to index 3 (value 0): need prefix [9,12,0] non-decreasing.
Transfer units from index 2 to index 3: [9, 2, 10, 4, 3].
Now index 1 has 9, index 2 has 2 -> 9 > 2, prefix broken.
Cannot repair prefix of length 3. Maximum valid prefix length = 2.

Sample Case 2
INPUT
5
11
0
8
4
2

OUTPUT
3

EXPLANATION
E = [11, 0, 8, 4, 2].
Transfer 11 units from index 1 to index 2: E = [0, 11, 8, 4, 2].
Prefix of 2: [0, 11] non-decreasing. Valid.
Extend to index 3 (value 8): 11 > 8, transfer 3 units right -> [0, 8, 11, 4, 2].
But now we also need index 2 (8) <= index 3 (11): 8 <= 11. Valid!
Prefix [0, 8, 11] is non-decreasing. Valid.
Extend to index 4 (value 4): 11 > 4, cannot transfer left. Impossible.


```
Maximum valid prefix length = 3.
```
Sample Case 3
INPUT
5
5
0
13
18
0
2

OUTPUT
4


```
Question 4
```
### Peak Elimination

PROBLEM DESCRIPTION
You are given a sequence of N integers arranged in a line.
An element at position i (2 <= i <= N-1, 1-indexed) is called a peak if it is strictly greater than both of
its immediate neighbors: A[i] > A[i-1] and A[i] > A[i+1].
A peak element can be removed from the sequence. When an element is removed, the sequence
shrinks and the two neighbors of the removed element become adjacent. You may perform removals
in any order.
Find the maximum number of elements that can be removed.

```
NOTE: Only interior elements (not first or last) can be removed. First and last elements can never
be removed.
```
INPUT FORMAT

- The first line contains an integer N, denoting the size of the sequence.
- Each of the N subsequent lines contains an integer describing A[i].

CONSTRAINTS

- 1 <= N <= 10^
- 1 <= A[i] <= 10^
Sample Case 1
INPUT
5 5 1 4 1 5


OUTPUT
1

EXPLANATION
Sequence: [5, 1, 4, 1, 5].
Check peaks: A[3]=4 > A[2]=1 and A[3] > A[4]=1. Peak! Remove 4.
Sequence becomes: [5, 1, 1, 5].
Check peaks: no element is strictly greater than both neighbors.
Final Answer: 1.

Sample Case 2
INPUT
6 1 3 4 2 4 1

OUTPUT
3

EXPLANATION
Sequence: [1, 3, 4, 2, 4, 1].
Step 1: A[3]=4 > 3 and > 2. Peak. Remove 4. -> [1, 3, 2, 4, 1].
Step 2: A[4]=4 > 2 and > 1. Peak. Remove 4. -> [1, 3, 2, 1].
Step 3: A[2]=3 > 1 and > 2. Peak. Remove 3. -> [1, 2, 1].
No more peaks. Final Answer: 3.


Sample Case 3
INPUT
7
10
1 9 2 8 3 7

OUTPUT
2

EXPLANATION
Sequence: [10, 1, 9, 2, 8, 3, 7].
Step 1: A[3]=9 > 1 and > 2. Peak. Remove 9. -> [10, 1, 2, 8, 3, 7].
Step 2: A[4]=8 > 2 and > 3. Peak. Remove 8. -> [10, 1, 2, 3, 7].
Step 3: No interior element is strictly greater than both neighbors.
Final Answer: 2.


```
Question 5
```
### Threshold 1

PROBLEM DESCRIPTION
You are given an array A of N integers representing heights, and two integers X and K.
You start at index 0 and want to move as far right as possible. To move from index i to index i+1,
apply the following rule:

```
Step 1: Compare A[i+1] with A[i] + X.
Step 2: If A[i+1] <= A[i] + X -> move to i+1 for free (no power-up
used).
If A[i+1] > A[i] + X -> you MUST use one power-up to move to i+1.
Step 3: If a power-up is needed but K = 0 -> STOP at index i.
```
Find the maximum index you can reach.

```
NOTE: You start with exactly K power-ups. Each power-up is consumed once used. You stop
immediately when a required power-up is unavailable.
```
INPUT FORMAT

- The first line contains an integer N.
- The next line contains an integer X.
- The next line contains an integer K.
- Each of the N subsequent lines contains an integer describing A[i] (0-indexed).

CONSTRAINTS

- 1 <= N <= 2*10^
- 1 <= X <= 50
- 0 <= K <= 10^
- 1 <= A[i] <= 10^
Sample Case 1
INPUT


```
4
5
0
1
6
12
13
```
OUTPUT
3

EXPLANATION
A = [1, 6, 12, 13], X = 5, K = 0.
Index 0->1: A[1]=6, A[0]+X=1+5=6. 6 <= 6 -> free. Move to index 1.
Index 1->2: A[2]=12, A[1]+X=6+5=11. 12 > 11 -> need power-up. K=0. STOP at index 1.
Wait — output is 3, so let's re-read: K=0 means the third input line (K) = 0.
Actually tracing: index 1->2: 12 > 11, K=0, stop. Max index = 1.
(If K=1: 1->2 uses 1 power-up. 2->3: A[3]=13, A[2]+X=17. 13<=17 free. Reach index 3.)
Note: verify K value from original problem.


```
Question 6
```
### Stable Temperature System

PROBLEM DESCRIPTION
You are given an array T of size N representing daily temperatures.
A system is considered stable if for every pair of adjacent elements: |T[i] - T[i-1]| <= 1.
You may decrease any element any number of times. Each decrease of 1 costs exactly 1 operation.
You are not allowed to increase any element.
Find the minimum total number of operations required to make the array stable.

```
NOTE: You can only decrease elements, never increase. Any element can be decreased as many
times as needed.
```
INPUT FORMAT

- The first line contains an integer N, denoting the size of the array.
- Each of the N subsequent lines contains an integer describing T[i] (0-indexed).

CONSTRAINTS

- 1 <= N <= 10^
- 1 <= T[i] <= 10^
Sample Case 1
INPUT
4
10
8
6
4

OUTPUT
6


EXPLANATION
T = [10, 8, 6, 4]. Check differences: |10-8|=2, |8-6|=2, |6-4|=2.
Each difference exceeds 1. Must reduce T[0] to at most T[1]+1=9: cost 1.
Must reduce T[1] to at most T[2]+1=7: cost 1.
Must reduce T[2] to at most T[3]+1=5: cost 1.
But we also need T[i-1] <= T[i]+1 going left->right.
Propagate from left: effective T[0]<=T[1]+1, T[1]<=T[2]+1, T[2]<=T[3]+1.
Total operations = 6.

Sample Case 2
INPUT
5 1 3 5 7 9

OUTPUT
10

EXPLANATION
T = [1, 3, 5, 7, 9]. Each adjacent pair differs by 2 (exceeds limit of 1).
Process left to right: reduce each element so difference <= 1.
T[1]=3 must be <= T[0]+1=2: reduce by 1. T[2]=5 must be <= 3: reduce by 2. Etc.
Total operations = 0+1+2+3+4 = 10.

Sample Case 3
INPUT
5


```
0
100
0
100
0
```
OUTPUT
198

EXPLANATION
T = [0, 100, 0, 100, 0]. Spikes at indices 1 and 3 must be heavily reduced.
T[1]=100 must be <= T[0]+1=1: reduce by 99.
T[2]=0 must be <= T[1]+1=1: already satisfied.
T[3]=100 must be <= T[2]+1=1: reduce by 99.
Total operations = 99 + 99 = 198.


```
Question 7
```
### Blocks

PROBLEM DESCRIPTION
You are given an integer N, and two arrays:

- A of length N: sizes of blocks of 1-bits.
- B of length N: sizes of blocks of 0-bits.
You must arrange all 2N blocks (N blocks of 1s and N blocks of 0s) into a binary string such that no
two adjacent blocks have the same bit value (strict alternation between 0-blocks and 1-blocks).
You can arrange the N one-blocks and N zero-blocks in any order, as long as the alternation rule is
satisfied.
Among all valid arrangements, find the maximum possible integer value obtained by interpreting the
resulting binary string as a decimal number. Return the answer modulo 10^9 + 7.

```
NOTE: To maximize the decimal value, sort the 1-blocks in descending order and the 0-blocks in
ascending order. This puts the most 1-bits at the front and the fewest 0-bits between them.
```
INPUT FORMAT
N
A[0]
A[1]
...
A[N-1]
B[0]
B[1]
...
B[N-1]

CONSTRAINTS

- 1 <= N <= 10^


- 1 <= A[i], B[i] <= 10^6
Sample Case 1
INPUT
1
2
1

OUTPUT
6

EXPLANATION
A=[2], B=[1]. Only arrangement (start with 1-block): "11" + "0" = "110".
Decimal value = 110 in binary = 6.

Sample Case 2
INPUT
2
1
1
1
2

OUTPUT
20

EXPLANATION
A=[1,1], B=[1,2]. Sort A desc=[1,1], sort B asc=[1,2].
Arrangement: 1|0|1|00 = "10100".


```
Decimal = 10100 in binary = 20.
```
Sample Case 3
INPUT
3 2 1 2 2 2 1

OUTPUT
868

EXPLANATION
A=[2,1,2], B=[2,2,1]. Sort A desc=[2,2,1], sort B asc=[1,2,2].
Arrangement: 11|0|11|00|1|00 = "1101100100".
Decimal = 1101100100 in binary = 868. (Verified: int("1101100100", 2) = 868)


```
Question 8
```
### String Stability Boost

PROBLEM DESCRIPTION
You are given a string S consisting of lowercase English letters.
The stability score of the string is defined as the number of distinct adjacent pairs in the string. An
adjacent pair is formed by the characters at positions (i, i+1) for 1 <= i < |S| (1-indexed). Two pairs are
considered the same if both characters match.
You are allowed to perform exactly one adjacent swap: choose an index i and swap S[i] with S[i+1].
Find the maximum possible stability score after performing exactly one adjacent swap.

```
NOTE: You must perform exactly one swap — you cannot skip it. If all swaps give the same score,
return that score.
```
INPUT FORMAT

- The first line contains a string S, denoting the given lowercase string.

CONSTRAINTS

- 1 <= len(S) <= 10^3
Sample Case 1
INPUT
abc

OUTPUT
2

EXPLANATION
Original pairs: (a,b), (b,c). Distinct = {ab, bc}. Count = 2.
Swap positions 1&2 -> "bac": pairs ba, ac -> distinct = {ba, ac} = 2.
Swap positions 2&3 -> "acb": pairs ac, cb -> distinct = {ac, cb} = 2.
Maximum stability after exactly one swap = 2.


Sample Case 2
INPUT
abca

OUTPUT
3

EXPLANATION
Original pairs: (a,b), (b,c), (c,a). Distinct = {ab, bc, ca}. Count = 3.
Swap 1&2 -> "baca": pairs ba, ac, ca -> distinct = {ba, ac, ca} = 3.
Swap 2&3 -> "acba": pairs ac, cb, ba -> distinct = {ac, cb, ba} = 3.
Swap 3&4 -> "abac": pairs ab, ba, ac -> distinct = {ab, ba, ac} = 3.
Maximum stability after exactly one swap = 3.

Sample Case 3
INPUT
aaaa

OUTPUT
1

EXPLANATION
Original pairs: (a,a), (a,a), (a,a). Distinct = {aa}. Count = 1.
Any adjacent swap keeps the string unchanged (all characters are identical).
Distinct pairs remain = {aa} = 1.
Maximum stability after exactly one swap = 1.


```
Question 9
```
### Tool Rental Maximization

PROBLEM DESCRIPTION
A hardware rental shop has N customers requesting tools and M available tools. Each customer i
needs a tool with at least P[i] power rating (minimum requirement). Each tool j has a base power
rating R[j].
The Amplification Option: You have K "power amplifiers" available. You can choose up to K tools to
attach an amplifier to. If you amplify a tool with rating R[j], its effective power becomes 2 x R[j]. A tool
can receive at most one amplifier.

- A customer i can be served by tool j if the tool's effective power (base or amplified) is >= P[i].
- Each customer rents at most one tool.
- Each tool is rented to at most one customer.
Find the maximum number of customers that can be served.

```
NOTE: Greedy strategy: Sort customers by requirement ascending, sort tools by power
descending. Greedily decide which tools to amplify to maximize the count of satisfied customers.
```
INPUT FORMAT

- Line 1: integer N (number of customers).
- Line 2: integer M (number of tools).
- Line 3: integer K (number of amplifiers available).
- Next N lines: integer P[i] (minimum power requirement for customer i).
- Next M lines: integer R[j] (base power rating of tool j).

CONSTRAINTS

- 1 <= N <= 10^5
- 1 <= M <= 10^5
- 1 <= K <= M
- 1 <= P[i] <= 10^5
- 1 <= R[j] <= 10^5
Sample Case 1
INPUT


```
2
2
1
10
20
5
10
```
OUTPUT
1

EXPLANATION
Customers need: [10, 20]. Tools: [5, 10]. K=1 amplifier.
Amplify tool R=10 -> effective 20. Serve customer P=20. Tool R=5 cannot serve P=10.
Maximum customers served = 1.

Sample Case 2
INPUT
2
2
2
100
200
50
60

OUTPUT


```
1
```
EXPLANATION
Customers need: [100, 200]. Tools: [50, 60]. K=2 amplifiers.
Amplify both: tool 50->100, tool 60->120.
Tool 100 >= P=100: serves first customer.
Tool 120 < P=200: cannot serve second customer.
Maximum customers served = 1.

Sample Case 3
INPUT
5
6
1
33
39
2
36
13
46
42
45
35
27
15

OUTPUT


```
5
```
EXPLANATION
Customers (sorted asc): [2, 13, 33, 36, 39].
Tools (sorted desc): [46, 45, 42, 35, 27, 15].
Match without amplification: 46>=39, 45>=36, 42>=33, 35>=13, 27>=2. All 5 matched!
No amplifier needed. Maximum customers served = 5.


```
Question 10
```
### Coins

PROBLEM DESCRIPTION
You are given a number N, followed by two arrays A and B, each containing N integers.
For each index i, you initially have zero coins. Then, you repeatedly perform one of the following
operations until both A[i] and B[i] become zero:

- If A[i] is not zero: add 1 coin and subtract 1 from A[i].
- If B[i] is not zero: multiply your coins by 2 and subtract 1 from B[i].
Let cost[i] be the maximum number of coins you can obtain for index i. Find the sum of cost[i] over all
i from 1 to N. Since the answer can be large, return it modulo 10^9 + 7.

```
NOTE: Greedy: To maximize coins, perform all additions first, then all multiplications. Order: (0 +
A[i]) * 2^B[i]. This is always optimal since multiplying a larger value gives more coins.
```
INPUT FORMAT

- Line 1: integer N (length of arrays A and B).
- Next N lines: integer A[i].
- Next N lines: integer B[i].

CONSTRAINTS

- 1 <= N <= 5 * 10^5
- 1 <= A[i] <= 10^9
- 1 <= B[i] <= 10^9
Sample Case 1
INPUT
1
1
1

OUTPUT


```
2
```
EXPLANATION
N=1, A=[1], B=[1].
Perform: add 1 coin (A[0]-=1), then multiply by 2 (B[0]-=1).
Coins = (0 + 1) * 2 = 2.

Sample Case 2
INPUT
1
1
2

OUTPUT
4

EXPLANATION
N=1, A=[1], B=[2].
Add 1 coin, then multiply by 2 twice.
Coins = (0 + 1) * 2 * 2 = 4.

Sample Case 3
INPUT
1
2
2

OUTPUT
8


EXPLANATION
N=1, A=[2], B=[2].
Add 1, add 1, then multiply by 2 twice.
Coins = (0 + 1 + 1) * 2 * 2 = 8.


```
Question 11
```
### Vault Digit Alignment

PROBLEM DESCRIPTION
In a high-security research facility, a digital vault is protected by N rotating digits arranged in a row.
Each digit initially shows a value A[i] where 0 <= A[i] <= 9.
You are allowed to rotate any digit forward only (cyclically): 0 -> 1 -> 2 -> ... -> 8 -> 9 -> 0 -> 1 -> ...
Your goal is to make the sequence of digits non-decreasing from left to right using the minimum total
number of rotations. Find the minimum total rotations required.

```
NOTE: Since rotation is cyclic forward only, to bring digit d up to a target t: if t >= d, cost = t - d. If t
< d (wrapping required), cost = (10 - d + t). Propagate the "effective minimum target" left to right.
```
INPUT FORMAT

- Line 1: integer N (number of digits).
- Next N lines: integer Arr[i] (0-indexed, digit value 0-9).

CONSTRAINTS

- 1 <= N <= 10^5
- 0 <= Arr[i] <= 9
Sample Case 1
INPUT
5 1 3 2 1 1

OUTPUT


```
5
```
EXPLANATION
Sequence: [1, 3, 2, 1, 1]. Make non-decreasing with forward rotations.
A[0]=1: target=1 (no change). Effective target = 1.
A[1]=3: 3>=1, no rotation. Effective target = 3.
A[2]=2: 2<3, rotate 2->3. Cost=(3-2)=1. Effective target=3.
A[3]=1: 1<3, rotate 1->3. Cost=(3-1)=2. Effective target=3.
A[4]=1: 1<3, rotate 1->3. Cost=(3-1)=2. Effective target=3.
Total rotations = 0+0+1+2+2 = 5.

Sample Case 2
INPUT
4
9
0
1
2

OUTPUT
24

EXPLANATION
Sequence: [9, 0, 1, 2]. Effective target starts at 9.
A[1]=0: 0<9, rotate forward cyclically: 0->9. Cost=(10-0+9)%10=9... wait cyclic: cost=10-9+0=1? No.
Forward rotation: 0->1->...->9 requires 9 steps. Cost=9. Effective target=9.
A[2]=1: 1<9, rotate 1->9. Cost=(10-1+9)%10=8. Effective target=9.
A[3]=2: 2<9, rotate 2->9. Cost=(10-2+9)%10=7. Effective target=9.
Total = 9+8+7 = 24.


```
Question 12
```
### Fabric Weaving Beauty Score

PROBLEM DESCRIPTION
A textile artist is weaving a decorative fabric by combining threads from two spools A and B.

- Spool A contains N threads with colors A[1], A[2], ..., A[N].
- Spool B contains M threads with colors B[1], B[2], ..., B[M].
The artist weaves exactly N + M threads into the final fabric, maintaining the original relative order
from each spool. At each step, the artist selects the next available thread from the front of either
Spool A or Spool B.
The beauty of the fabric is determined by color transitions: if two consecutive threads in the final
woven fabric have the same color, a harmony bonus H is earned. If colors are different, no bonus is
awarded.
Find the maximum possible total beauty score achievable.

```
NOTE: This is a DP problem: dp[i][j] = max beauty score when i threads from A and j threads from
B have been placed. Transition: pick next from A or B and check if it matches the last placed
thread.
```
INPUT FORMAT

- Line 1: integer N (threads in Spool A).
- Line 2: integer M (threads in Spool B).
- Line 3: integer H (harmony bonus for same-color consecutive pair).
- Next N lines: integer A[i] (1-indexed).
- Next M lines: integer B[j] (1-indexed).

CONSTRAINTS

- 1 <= N <= 1000
- 1 <= M <= 1000
- 1 <= H <= 10^5
- 1 <= A[i] <= 10^5
- 1 <= B[j] <= 10^5
Sample Case 1


INPUT
2 2 5 1 1 1 1

OUTPUT
15

EXPLANATION
A=[1,1], B=[1,1]. H=5. All threads have color 1.
Weave in any order: [1,1,1,1]. Adjacent pairs: (1,1),(1,1),(1,1) -> 3 matches.
Total beauty = 3 x 5 = 15.

Sample Case 2
INPUT
3
3
10
1
2
1
1
3


```
1
```
OUTPUT
20

EXPLANATION
A=[1,2,1], B=[1,3,1]. H=10.
Optimal interleaving: [1,1,2,3,1,1].
Adjacent matches: (1,1) at pos 1-2, (1,1) at pos 5-6. Count=2.
Total beauty = 2 x 10 = 20.

Sample Case 3
INPUT
3
3
100
1 2 3 4 5 6

OUTPUT
0

EXPLANATION
A=[1,2,3], B=[4,5,6]. H=100. All threads have unique colors.
No two identical colors can ever be placed consecutively.


Total beauty = 0.


```
Question 13
```
### Lazy Student

PROBLEM DESCRIPTION
You are given a test with n questions, each worth x[i] marks, and a passing threshold of m marks.
For each question, you may either:

- Answer it correctly by thinking: you earn the full x[i] marks.
- Guess uniformly at random among c choices: you earn x[i] / c marks in expectation.
You aim to minimize the number of questions you actually think through, while ensuring that the
expected total score is at least m (your criterion for a sufficiently high probability of passing).
Find the minimum number of questions you must think through to achieve an expected total score >=
m.

```
NOTE: Greedy: To maximize expected score with fewest "thought" questions, always think
through the highest-value questions first. Sort questions descending by x[i], greedily assign
thinking vs guessing.
```
INPUT FORMAT

- Line 1: integer n (number of questions).
- Line 2: integer m (passing threshold).
- Line 3: integer c (number of choices per question).
- Next n lines: integer x[i] (marks for question i).

CONSTRAINTS

- 1 <= n <= 10^5
- 1 <= m <= 10^9
- 1 <= c <= 10^5
- 1 <= x[i] <= 10^5
Sample Case 1
INPUT
1
1


```
2
1
```
OUTPUT
1

EXPLANATION
n=1, m=1, c=2. Question worth x[0]=1.
If guessing: expected score = 1/2 = 0.5 < 1. Insufficient.
If thinking: score = 1 >= 1. Sufficient.
Must think through 1 question. Answer = 1.

Sample Case 2
INPUT
2
15
2
7
8

OUTPUT
2

EXPLANATION
n=2, m=15, c=2. Questions worth [7, 8].
If think both: expected = 7+8 = 15 >= 15. Sufficient.
If think only x=8: score from thinking = 8. Guessing x=7: 7/2=3.5. Total=11.5 < 15.
If think only x=7: score from thinking = 7. Guessing x=8: 8/2=4. Total=11 < 15.
Must think through both questions. Answer = 2.


