// 卒
// 改了尼玛的一万遍
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        if(n==0){
            return new int[]{-1,-1};
        }

        if(n==1){
            if(nums[0]==target){
                return new int[]{0,0};
            }else {
                return new int[]{-1,-1};
            }
        }

        int left = 0;
        int right = n-1;
        int mid = 0;

        while (left<right){
            mid = (left+right)/2;

            if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid;
            }else {
                break;
            }
        }
        mid = (left+right)/2;//天地之精华

        if(nums[mid]!=target){
            return new int[]{-1, -1};
        }

        left = mid;
        right = mid;
        while (left-1 >= 0 && nums[left-1]==target){
            left--;
        }
        while (right+1 < n && nums[right+1]==target){
            right++;
        }

        return new int[]{left, right};
    }
}
