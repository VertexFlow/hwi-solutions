# Maximum Weight Independent Set (Tree)

## Problem Summary
Find MWIS on tree, then apply Kolakoski bonus, Thue-Morse penalty, and Ore constraint multiplier.

## Intuition
Tree DP for MWIS + special scoring rules. Use DP to find max weight independent set, then compute final score with bonuses/penalties.

## Approach
1. Tree DP: dp[v][0/1] = max weight with v excluded/included
2. Recursively compute best set
3. Apply scoring: base + Kolakoski bonus - Thue-Morse penalty
4. Apply 0.9 multiplier if Ore node count > K

## Time Complexity
O(N) for tree DP

## Space Complexity
O(N)
