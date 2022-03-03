// 深搜找岛，广搜找桥

function shortestBridge(grid) {
  const rows = grid.length;
  const cols = grid[0].length;
  // 方向数组
  const directions = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  const queue = [];
  const dfs = (i, j) => {
    // 1代表陆地  岛是由四面相连的 1 形成的一个最大组
    if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] !== 1) return;
    // 标记小岛2
    grid[i][j] = 2;
    // 初始化queue（记录小岛2的坐标）
    queue.push([i, j]);
    for (let [x, y] of directions) {
      dfs(i + x, j + y);
    }
  };
  const bfs = () => {
    let step = 0;
    while (queue.length) {
      let size = queue.length;
      step++;
      while (size--) {
        const [i, j] = queue.shift();
        // 出队列向四周扩散
        for (let [x, y] of directions) {
          const newI = i + x;
          const newJ = j + y;
          if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols) {
            // 找到小岛1，直接返回
            // 找到空白，继续前进搜寻
            if (grid[newI][newJ] === 1) {
              return step - 1;
            } else if (grid[newI][newJ] === 0) {
              // 先把它融入小岛1中避免重复访问到
              grid[newI][newJ] = 2;
              queue.push([newI, newJ]);
            }
          }
        }
      }
    }
  };
  // 标记小岛2 之所以用dfs是需要把当前岛上所有的陆地都遍历到并且加入队列
  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < cols; j++) {
      // 从任一一个陆地节点出发去找到它所在的岛屿，
      if (grid[i][j] === 1) {
        dfs(i, j);
        return bfs();
      }
    }
  }
  return -1;
}

作者：angela-x
链接：https://leetcode-cn.com/problems/shortest-bridge/solution/xian-yong-dfszai-yong-bfsdai-ma-zhong-zh-7svd/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
