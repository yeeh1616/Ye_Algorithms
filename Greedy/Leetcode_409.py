class Solution:
    def longestPalindrome(self, s: str) -> int:
        ans = 0
        count = collections.Counter(s)
        for v in count.values():
            ans += v // 2 * 2
            if ans % 2 == 0 and v % 2 == 1:
                ans += 1
        return ans

      
class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char,int> mp;
        for(auto& c:s){
            mp[c]++;
        }
        int ans=0,f=0;
        for(auto& [_,cnt]:mp){
            ans+=cnt%2==0?cnt:(f=1,cnt-1);
        }
        return ans+f;
    }
};

作者：qiu-yu-mei-xue
链接：https://leetcode-cn.com/problems/longest-palindrome/solution/c-zui-jian-tan-xin-by-qiu-yu-mei-xue-zj2k/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
