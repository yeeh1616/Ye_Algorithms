// 并查集
// https://leetcode-cn.com/problems/regions-cut-by-slashes/solution/tu-jie-bing-cha-ji-he-bing-ding-dian-by-bb22r/
class Solution {
    public int regionsBySlashes(String[] grid) {
        int regions = 1;
        int N = grid.length;
        //每行节点数
        int nodesPerLine = N + 1;
        //N*N的图, 节点数是 (n+1) * (n+1)
        UnionFind uf = new UnionFind(nodesPerLine * nodesPerLine);
        for (int i = 0; i < N + 1; i++) {
            //把边都合并起来, 以2*2为例
            //合并0行,   0, 1, 2
            uf.union(0, i);
            //合并0列,   0, 3, 6
            uf.union(0, i * nodesPerLine);
            //合并最后行 6, 7, 8
            uf.union(N * nodesPerLine, N * nodesPerLine + i);
            //合并最后列 2, 5, 8
            uf.union(N, (i + 1) * nodesPerLine - 1);
        }

        for (int i = 0; i < N; i++) {
            char[] ca = grid[i].toCharArray();
            for (int j = 0; j < ca.length; j++) {
                char c = ca[j];
                //左上角点
                int leftTop = i * nodesPerLine + j;
                int top;
                int bottom;
                if (c == '/') {
                    top = leftTop + 1;
                    bottom = leftTop + nodesPerLine;
                } else if (c == '\\') {
                    top = leftTop;
                    bottom = leftTop + nodesPerLine + 1;
                } else {
                    continue;
                }
                if (!uf.union(top, bottom)) {
                    //合并失败 说明成环了, 这时候就 区域数 + 1
                    regions++;
                }
            }
        }
        return regions;
    }
    private static class UnionFind {
        private final int[] roots;
        public UnionFind(int n) {
            this.roots = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
            }
        }

        int findRoot(int i) {
            int root = roots[i];

            if (root == i) {
                return root;
            } else {
                roots[i] = findRoot(root);
                return roots[i];
            }
        }

        boolean union(int i, int j) {
            int root1 = findRoot(i);
            int root2 = findRoot(j);
            if (root1 != root2) {
                roots[root2] = root1;
                return true;
            }
            return false;
        }
    }
}

// DFS
