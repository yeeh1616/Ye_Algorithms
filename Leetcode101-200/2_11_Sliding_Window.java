class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int first = 0;
        int second = n-1;
        int max = 0;
        while (first<second){
            int curr = (second-first)*Math.min(height[first],height[second]);
            if (curr>max){
                max = curr;
            }
            if (height[first]<height[second]){
                first++;
            }
            else {
                second--;
            }
        }
        return max;
    }
}

作者：gtothemoon
链接：https://leetcode-cn.com/problems/container-with-most-water/solution/11-sheng-zui-duo-shui-de-rong-qi-zuo-you-t8i8/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
