// 并不是动态规划！！
class Solution {
    private static int[][] cache;
    public static int getKth(int lo, int hi, int k) {
        cache = new int[hi -lo +1][2];

        for (int i = 0; i < cache.length; i++) {
            cache[i][1] = i +lo;
            if(cache[i][0] == 0){
                cache[i][0] = k(lo+i,lo);
            }
        }


        Arrays.sort(cache,(x,y) ->x[0]-y[0]);

        return cache[k-1][1];
    }

    public static int k(int k,int lo){
        int n = 0;

        while(k != 1){
            if( k - lo < cache.length && k - lo >=0 && cache[k - lo ][0] !=0){
                return cache[k - lo][0] + n;
            }

            if(k%2 == 0){
                k/=2;
            }
            else{
                k = k *3 +1;
            }
            n++;
        }
        return n;
    }
}

作者：XTU_R
链接：https://leetcode-cn.com/problems/sort-integers-by-the-power-value/solution/java-dong-tai-gui-hua-by-xtu_r-htio/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
