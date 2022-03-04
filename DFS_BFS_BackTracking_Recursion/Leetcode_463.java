// BFS
class Solution:
    def bfs(self, grid, rows, cols, row, col):
        directs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        queue = collections.deque([(row, col)])

        count = 0
        while queue:
            row, col = queue.popleft()
             # 避免重复统计
            grid[row][col] = 2             
            for direct in directs:
                new_row = row + direct[0]
                new_col = col + direct[1]
                # 遇到边界或者水域，则周长加 1
                if new_row < 0 or new_row >= rows or new_col < 0 or new_col >= cols or grid[new_row][new_col] == 0:
                    count += 1
                # 相邻区域为陆地，则将其标记为 2，加入队列
                elif grid[new_row][new_col] == 1:
                    grid[new_row][new_col] = 2
                    queue.append((new_row, new_col))
                # 相邻区域为 2 的情况不做处理
        return count

    def islandPerimeter(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == 1:
                    return self.bfs(grid, rows, cols, row, col)

作者：ITCharge
链接：https://leetcode-cn.com/problems/island-perimeter/solution/itcharge-463-dao-yu-de-zhou-chang-yan-du-5zz7/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
