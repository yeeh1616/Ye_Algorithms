// DFS
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res=new ArrayList();
        int m=heights.length,n=heights[0].length;
        //记录坐标地是否到达太平洋、大西洋
        boolean canReachP[][]=new boolean[m][n],canReachX[][]=new boolean[m][n];
        //上下左右出发，深度优先搜索
        for(int i=0;i<m;i++){
            dfs(heights,canReachP,i,0);
            dfs(heights,canReachX,i,n-1);
        }
        for(int j=0;j<n;j++){
            dfs(heights,canReachP,0,j);
            dfs(heights,canReachX,m-1,j);
        }
        //遍历记录，如果都可到达即可加入结果
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(canReachP[i][j]&&canReachX[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    public void dfs(int[][] heights,boolean[][] canReach,int i,int j){
        //如果已经扫描过可达就不用扫描
        if(canReach[i][j])return;
        //扫描过即说明可达，这也是逆流的优点
        canReach[i][j]=true;
        //上下左右深度搜索，越界就不搜索
        if(i-1>=0&&heights[i-1][j]>=heights[i][j]){dfs(heights,canReach,i-1,j);}
        if(j-1>=0&&heights[i][j-1]>=heights[i][j]){dfs(heights,canReach,i,j-1);}
        if(i+1<heights.length&&heights[i+1][j]>=heights[i][j]){dfs(heights,canReach,i+1,j);}
        if(j+1<heights[0].length&&heights[i][j+1]>=heights[i][j]){dfs(heights,canReach,i,j+1);}
    }
}
// https://leetcode-cn.com/problems/pacific-atlantic-water-flow/solution/shui-wang-gao-chu-liu-by-xiaohu9527-xxsx/
