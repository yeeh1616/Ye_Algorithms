// 重点在二维数组排序

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> (o2[1] - o1[1]));
        int ans = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            int num = Math.min(truckSize, boxTypes[i][0]);
            truckSize -= num;
            ans += num * boxTypes[i][1];
        }
        return ans;
    }
}

作者：mufanlee
链接：https://leetcode-cn.com/problems/maximum-units-on-a-truck/solution/5641-qia-che-shang-de-zui-da-dan-yuan-sh-m9jx/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
