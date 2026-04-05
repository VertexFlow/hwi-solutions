# Minimum Cost Swaps

## Problem Summary
Sort an array using adjacent swaps where each swap costs the absolute difference of the swapped elements. Return -1 if duplicates exist.

## Intuition
Use cycle decomposition. Each element needs to reach its sorted position, forming cycles. We compute minimum cost for each cycle.

## Approach
1. Check for duplicates - if any, return -1.
2. Create sorted copy and track target positions.
3. Decompose into cycles using position mapping.
4. For each cycle of size k with sum S and minimum value m, compute min cost:
   - Without shortcut: (k-1) * S
   - With shortcut: S + m + (k+1) * m

## Time Complexity
O(N log N) for sorting

## Space Complexity
O(N) for auxiliary arrays
