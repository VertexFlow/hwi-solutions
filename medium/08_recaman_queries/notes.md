# Recaman Queries

## Problem Summary
Process array queries with point updates and range max queries. For each range query, compute the Recaman distance of the maximum value with optional multiplier for fortunate numbers.

## Intuition
Use segment tree for efficient range queries. Compute Recaman distance by generating the sequence. Precompute fortunate numbers using primorials.

## Approach
1. Build segment tree for range maximum queries and point updates.
2. Precompute fortunate numbers (p# + m is prime).
3. For each range query: find max, compute Recaman distance, apply multiplier if fortunate.
4. Sum all results.

## Time Complexity
O((N + Q) log N + precomputation)

## Space Complexity
O(N) for segment tree and precomputed data.
