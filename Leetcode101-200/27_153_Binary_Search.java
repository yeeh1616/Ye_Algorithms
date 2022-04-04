class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        
        int left = 0;
        int right = n-1;
        
        while(left + 1 < right){
            int mid = (left+right)/2;
            if(nums[left] < nums[right]){
                right = mid;
            }else{
                if(nums[left]<nums[mid]&&nums[mid]>nums[right]){
                    left = mid;
                }else if(nums[left]>nums[mid]&&nums[mid]<nums[right]){
                    right = mid;
                }
            }
            
            
        }
        
        if(nums[left] < nums[right]){
            return nums[left];
        }else{
            return nums[right];
        }
    }
}
