// 还是有点东西的
class Solution {
    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int num : position) {
            if ((num & 1) == 0) even++;
            else odd++;
        }
        return Math.min(odd, even);
    }
}

作者：shangshanhuiliyi
链接：https://leetcode-cn.com/problems/minimum-cost-to-move-chips-to-the-same-position/solution/yong-tan-xin-si-xiang-lai-zhao-gui-lu-chao-xiang-x/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
