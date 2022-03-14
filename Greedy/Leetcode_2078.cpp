// 有点东西
class Solution {
public:
    int maxDistance(vector<int>& colors) {
        int n = colors.size();        
        int i, j;
        for(i = 0, j = n-1; i < j; ++i, --j) //由于一定存在不同的颜色，所以当i==j时候一定就是不同的颜色
            if(colors[i] != colors[n-1] || colors[j] != colors[0]) break;
        return j;
    }
};

作者：mochi-ds
链接：https://leetcode-cn.com/problems/two-furthest-houses-with-different-colors/solution/zhi-xin-meng-nan-xiang-jie-yi-xia-tan-xi-3pt8/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
