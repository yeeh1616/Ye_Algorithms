// DFS
class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Deque<Integer> stack = new ArrayDeque<Integer>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    public void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            ans.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int y : graph[x]) {
            stack.offerLast(y);
            dfs(graph, y, n);
            stack.pollLast();
        }
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target/solution/suo-you-ke-neng-de-lu-jing-by-leetcode-s-iyoh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



// BFS
class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        que = collections.deque()
        que.append([0])
        paths = []
        #每一次都是作为整个路径来进行存储的
        while que:
            tmp_path = que.popleft()
        #跳出最后一个元素 如果是最后的元素 就直接添加路径
            node = tmp_path[-1]
            if node == len(graph) - 1:
                paths.append(tmp_path)
        #遍历对应节点的graph
            for i in graph[node]:
                tmp_path.append(i)
                que.append(tmp_path.copy())
                tmp_path.pop()
        return paths


作者：dudu-21
链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target/solution/bfs-12yue-bu-bai-lan-by-dudu-21-7xcb/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
