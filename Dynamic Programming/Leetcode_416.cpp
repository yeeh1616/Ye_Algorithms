class Solution {
    
public:
    bool canPartition(vector<int>& nums) {
        int sum = 0;
        for(int num : nums)sum+=num;
        int n=nums.size();
        bool dp[sum+1];
        memset(dp,0,sizeof(dp));
        dp[0]=true;
        for(int i=0;i<n;i++){
            for(int j=sum;j>=nums[i]*2;j--){
                dp[j]|=dp[j-nums[i]*2];
                
            }
        }
        return dp[sum];
    }
};

作者：feng-476
链接：https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/ti-gong-wo-de-yi-ge-xie-dong-tai-gui-hua-44n4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
