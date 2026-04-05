# Tree Plucking

## Problem Summary
Remove all nodes from a tree by repeatedly removing leaves. Each removal pays the node's current value and adds it to neighbors. Minimize total cost.

## Intuition
Use greedy approach: always remove the cheapest leaf first. When a leaf is removed, its value propagates to neighbors, potentially making them more expensive.

## Approach
1. Use priority queue of leaves sorted by current value.
2. Repeatedly remove minimum leaf, pay its value, propagate to neighbor.
3. Continue until all nodes removed.

## Time Complexity
O(N log N)

## Space Complexity
O(N)
