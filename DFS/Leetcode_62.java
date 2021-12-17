/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?

Example 1:
Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:

Input: m = 7, n = 3
Output: 28
Example 4:

Input: m = 3, n = 3
Output: 6

*/

var uniquePaths = function(m, n) {
    const cache = new Map()
    function dfs(m, n){
        const keys = [m+'-'+n,n+'-'+m]
        for(const key of keys){
            if(cache.has(key)){
                return cache.get(key)
            }
        }
        let sum = 0
        if(m === 0 && n === 0){
            return 1
        }
        if(m > 0){
            sum += dfs(m-1,n)
        }
        if(n > 0){
            sum += dfs(m,n-1)
        }
        for(const key of keys){
            cache.set(key, sum)
        }
        return sum
    }
    return dfs(m-1, n-1)
};
