// 妙！！！！！！！！！！！！！！！！！！！
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    // 必须到达end下标的数字
    let end = nums.length - 1;

    for (let i = nums.length - 2; i >= 0; i--) {
        if (end - i <= nums[i]) {
            end = i;
        }
    }

    return end == 0;
};

作者：iexn
链接：https://leetcode-cn.com/problems/jump-game/solution/javascript-55-tiao-yue-you-xi-fan-xiang-5uqdl/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


//2.
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n=nums.size();
        int a=nums[0];  // a=dp[i-1]
        for(int i=1;i<n;i++){
            if(a==0)  return false;
            a=max(a-1,nums[i]);     // a=dp[i]
        }
        return true;
    }
};

作者：valerie-w
链接：https://leetcode-cn.com/problems/jump-game/solution/55-tiao-yue-you-xi-dong-tai-gui-hua-jie-9vsu7/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
