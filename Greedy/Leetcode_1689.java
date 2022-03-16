class Solution {
    public int minPartitions(String n) {
        char[] ca = n.toCharArray();
        
        int max = 0;
        
        for(int i = 0; i < ca.length; i++){
            int tmp = Character.getNumericValue(ca[i]);
            if(max < tmp){
                max = tmp;
            }
        }
        
        return max;
    }
}
