/*使用dp[i][j]记录s[:i], t[:j]的所有substring中，完全相同的substring和有一个差异的substring的个数
遍历列表，dp[i][j]只与dp[i-1][j-1]相关。
初始化时增加额外的一行与一列方便边界条件处理*/


class Solution:
    def countSubstrings(self, s: str, t: str) -> int:
        len_s, len_t = len(s), len(t)
        dp = [[(0,0)]*(len_t+1) for _ in range(len_s+1)] 
        # dp[i][j] = (m, n) means that for substrings that ends with s[i-1] and t[j-1] the there are m equals and n got one diff 
        res = 0
        for i in range(1, len_s+1):
            for j in range(1, len_t+1):
                zero, one = dp[i-1][j-1]
                if s[i-1] == t[j-1]:
                    zero += 1
                else:
                    one = zero + 1
                    zero = 0
                dp[i][j] = (zero, one)
                res += one
        return res

作者：here0009
链接：https://leetcode-cn.com/problems/count-substrings-that-differ-by-one-character/solution/python-dong-tai-gui-hua-210000-by-here0009/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
