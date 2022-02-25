class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] f = new int[m + 1][n + 1];
        
        for (String str : strs) {
            int a = 0, b = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') a++;
                else b++;
            }
            
            for (int i = m; i >= a; i--)
                for (int j = n; j >= b; j--)
                    f[i][j] = Math.max(f[i][j], f[i - a][j - b] + 1);
        }
        
        return f[m][n];
    }
}

https://leetcode-cn.com/problems/ones-and-zeroes/solution/yi-he-ling-by-leetcode-solution-u2z2/
