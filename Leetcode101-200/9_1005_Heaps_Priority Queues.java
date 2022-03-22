//小堆优先队列

class Solution {
public:
    int largestSumAfterKNegations(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> priQue;
        for(int num : nums) priQue.push(num);
        while(k--) {
            int temp = priQue.top();
            priQue.pop();
            priQue.push(-temp); 
        }
        int res = 0; 
        while(!priQue.empty()) {
            res += priQue.top();
            priQue.pop();
        }
        return res;
    }
};
