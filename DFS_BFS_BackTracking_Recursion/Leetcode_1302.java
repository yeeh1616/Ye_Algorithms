// DFS
//记录树的最大深度
private int maxLevel = 0;
//记录最后一层所有节点的和
private int sum = 0;

public int deepestLeavesSum(TreeNode root) {
    dfs(root, 0);
    return sum;
}

//level表示第几层，根节点是第0层
private void dfs(TreeNode root, int level) {
    //边界条件判断，如果是空直接返回
    if (root == null)
        return;
    //操作当前节点，如果没到最后一层，记录
    //当前访问过的最大层数，并且把sum重置为0，
    //也就是之前加的作废
    if (level > maxLevel) {
        maxLevel = level;
        sum = 0;
    }
    //如果到了最后一层，就把节点值相加
    if (level == maxLevel) {
        sum = sum + root.val;
    }
    //访问左子节点和右子节点，
    dfs(root.left, level + 1);
    dfs(root.right, level + 1);
}

作者：sdwwld
链接：https://leetcode-cn.com/problems/deepest-leaves-sum/solution/shu-ju-jie-gou-he-suan-fa-bfshe-dfsjie-c-z93i/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// BFS
