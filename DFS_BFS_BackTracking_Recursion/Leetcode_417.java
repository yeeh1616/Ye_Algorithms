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



// BFS
class Solution {
public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        int m=heights.size();
        int n=heights[0].size();
        
        queue<pair<int,int>> q1;
        queue<pair<int,int>> q2;

        vector<pair<int,int>> dirs={{-1,0},{1,0},{0,-1},{0,1}};
        //用来存放已经经过的单元格
        vector<vector<int>> vis1(m,vector<int>(n,0));
        vector<vector<int>> vis2(m,vector<int>(n,0));
        //海洋旁边的单元格是一定可以流通的，存入队列中
        for(int i=0;i<m;++i){
            q1.push({i,0});
            vis1[i][0]=1;
            q2.push({i,n-1});
            vis2[i][n-1]=1;
        }
        for(int j=0;j<n;++j){
            q1.push({0,j});
            vis1[0][j]=1;
            q2.push({m-1,j});
            vis2[m-1][j]=1;
        }

        while(!q1.empty()){
            auto ind=q1.front();
            q1.pop();
            for(auto cur:dirs){
                int x=ind.first+cur.first;
                int y=ind.second+cur.second;
                if(x>=0&&x<m&&y>=0&&y<n&&heights[x][y]>=heights[ind.first][ind.second]&&!vis1[x][y]){
                    q1.push({x,y});
                    vis1[x][y]=1;
                }
            }
        }
        while(!q2.empty()){
            auto ind=q2.front();
            q2.pop();
            for(auto cur:dirs){
                int x=ind.first+cur.first;
                int y=ind.second+cur.second;
                if(x>=0&&x<m&&y>=0&&y<n&&heights[x][y]>=heights[ind.first][ind.second]&&!vis2[x][y]){
                    q2.push({x,y});
                    vis2[x][y]=1;
                }
            }
        }

        vector<vector<int>> res;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(vis1[i][j]==1&&vis2[i][j]==1){
                    res.push_back({i,j});
                }
            }
        }

        return res;


    }
};

作者：xiao-pu-tao-zhu
链接：https://leetcode-cn.com/problems/pacific-atlantic-water-flow/solution/bfsni-liu-xun-zhao-by-xiao-pu-tao-zhu-25h2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
