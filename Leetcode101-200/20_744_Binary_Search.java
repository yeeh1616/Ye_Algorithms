class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int left = 0;
        int right = n-1;

        while (left+1<right){
            int mid = (left+right)/2;

            if(target < letters[mid]){ // 注意！这里一定是<, 不能是 <=
                right = mid;
            }else if(target >= letters[mid]){
                left = mid;
            }
        }

        if(target < letters[left]){
            return letters[left];
        }else if(target < letters[right]){
            return letters[right];
        }else {
            return letters[0];
        }
    }
}
