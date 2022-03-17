class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        
        int n = piles.length/3;
        int res = 0;
        
        for(int i = n, j=piles.length-2; i > 0; i--,j-=2){
            res += piles[j];
        }
        
        return res;
    }
}
