/*答案：https://leetcode-cn.com/problems/valid-triangle-number/solution/you-xiao-san-jiao-xing-de-ge-shu-by-byq-3/
611. Valid Triangle Number
Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

Example 1:
Input: nums = [2,2,3,4]
Output: 3
Explanation: Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3

Example 2:
Input: nums = [4,2,3,4]
Output: 4
*/
class Solution {
public:
    int triangleNumber(vector<int>& nums) {
        std::sort(nums.begin(), nums.end(), std::greater<int>());
        int ans = 0;
        int n = nums.size();
        for(int c = 0; c < n - 2; c++){
            int a = n - 1;
            int b = c + 1;
            while(a > b){
                if(nums[a] + nums[b] > nums[c]){
                    ans += a-b;
                    b++;
                }else{
                    a--;
                }
            }
        }
        return ans;
    }
};
