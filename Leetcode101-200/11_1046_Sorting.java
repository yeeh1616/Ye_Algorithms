class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length <= 1){
            return stones[0];
        }
        
        int n = stones.length;
        
        while(true){
            Arrays.sort(stones);
            
            if(stones[n-2] == 0){
                break;
            }
            
            int r = Math.abs(stones[n-1]-stones[n-2]);
            stones[n-1] = r;
            stones[n-2] = 0;
        }
        
        return stones[n-1];
    }
}
