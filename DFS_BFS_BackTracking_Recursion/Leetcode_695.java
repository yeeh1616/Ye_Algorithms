// DFS
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0; 
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        } 
        return res;
    }
    // 每次调用的时候默认num为1，进入后判断如果不是岛屿，则直接返回0，就可以避免预防错误的情况。
    // 每次找到岛屿，则直接把找到的岛屿改成0，这是传说中的沉岛思想，就是遇到岛屿就把他和周围的全部沉默。
    // ps：如果能用沉岛思想，那么自然可以用朋友圈思想。有兴趣的朋友可以去尝试。
    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) { 
            return 0;
        } 
        grid[i][j] = 0;
        int num = 1;
        num += dfs(i + 1, j, grid);
        num += dfs(i - 1, j, grid);
        num += dfs(i, j + 1, grid);
        num += dfs(i, j - 1, grid);
        return num;
        
    }
}

作者：mark-42
链接：https://leetcode-cn.com/problems/max-area-of-island/solution/biao-zhun-javadong-tai-gui-hua-jie-fa-100-by-mark-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


// BFS
class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        def bfs(grid, x, y):
            # 第一个点加入队列
            queue = [[x, y]]
            # 只要队列里面有东西就继续
            while queue:
                # 考虑当前最先进去的点
                [x, y] = queue.pop(0)
                # 满足条件不超界，不是0
                if 0 <= x < len(grid) and 0 <= y < len(grid[0]) and grid[x][y]:
                    # 标记已经遍历过的
                    grid[x][y] = 0
                    # 记录当前面积
                    self.result += 1
                    '''
                    bfs，下一次优先考虑每个点扩散开的.
                    此处可能会加入不满足条件的点，但是这些在下一轮不会被考虑
                    '''
                    queue += [[x - 1, y], [x, y - 1], [x + 1, y], [x, y + 1]]
            return self.result
        maximum = 0
        # 找第一个陆地的开始
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    # 每个岛单独统计
                    self.result = 0
                    # 保留最大值，此时找过的岛全被标注为0了
                    maximum = max(maximum, bfs(grid, i, j))
        return maximum

作者：yangyb25
链接：https://leetcode-cn.com/problems/max-area-of-island/solution/python-bfs-dfs-xiang-xi-zhu-shi-by-yangy-kh6i/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
