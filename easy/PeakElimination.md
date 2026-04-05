## Peak Elimination

### Problem Summary
Remove as many peak elements as possible. A peak is an element strictly greater than both neighbors.

### Intuition
Peaks are elements higher than their neighbors. When removed, neighbors become adjacent and might become new peaks. We repeat until no more peaks exist.

### Approach
1. Find all peak indices in current array.
2. Remove all peaks simultaneously.
3. Repeat until no peaks found.
4. Count total removed elements.

### Time Complexity
O(N^2) in worst case due to repeated scans.

### Space Complexity
O(N) for storing the array.
