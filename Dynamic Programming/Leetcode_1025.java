/*
Alice and Bob take turns playing a game, with Alice starting first.

Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:

Choosing any x with 0 < x < n and n % x == 0.
Replacing the number n on the chalkboard with n - x.
Also, if a player cannot make a move, they lose the game.

Return true if and only if Alice wins the game, assuming both players play optimally.

 

Example 1:

Input: n = 2
Output: true
Explanation: Alice chooses 1, and Bob has no more moves.
Example 2:

Input: n = 3
Output: false
Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
*/

// 数学
class Solution {
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }
}
// 复杂度分析
// 时间复杂度：O(1)
// 空间复杂度：O(1)


// 动态规划
class Solution {
    public boolean divisorGame(int n) {
        boolean[] f = new boolean[n + 5];

        f[1] = false;
        f[2] = true;
        for (int i = 3; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                if ((i % j) == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[n];
    }
}
// 复杂度分析
// 时间复杂度：O(n^2)。递推的时候一共有 n 个状态要计算，每个状态需要 O(n) 的时间枚举因数，因此总时间复杂度为 O(n^2)。
// 空间复杂度：O(n)。我们需要 O(n) 的空间存储递推数组 f 的值。
