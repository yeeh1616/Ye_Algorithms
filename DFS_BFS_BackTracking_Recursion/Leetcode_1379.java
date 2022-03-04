// DFS 递归
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null){
            return null;
        }
        if (original == target){
            return cloned;
        }
        // 递归左子树
        TreeNode res = getTargetCopy(original.left,cloned.left,target);
        if (res != null){
            return res;
        }
        // 递归右子树
        res = getTargetCopy(original.right,cloned.right,target);
        if (res != null){
            return res;
        }
        return null;
    }
}

作者：burning-summer
链接：https://leetcode-cn.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/solution/tong-shi-bian-li-liang-ke-shu-jin-xing-jie-dian-pi/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// DFS 迭代
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<TreeNode> clonedStack = new LinkedList<>();
        TreeNode node = original;
        TreeNode cloneTarget = cloned;
        while (node != null || !stack.isEmpty()){
            if (node != null){
                if (node == target){
                    return cloneTarget;// 找到目标，返回
                }
                // 节点不空，走左子树
                stack.push(node);
                node = node.left;
                clonedStack.push(cloneTarget);
                cloneTarget = cloneTarget.left;
            }else {
                // 节点空了，进入右子树
                node = stack.pop();
                node = node.right;
                cloneTarget = clonedStack.pop();
                cloneTarget = cloneTarget.right;
            }
        }
        return null;
    }
}

作者：burning-summer
链接：https://leetcode-cn.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/solution/tong-shi-bian-li-liang-ke-shu-jin-xing-jie-dian-pi/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// BFS
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> clonedQueue = new LinkedList<>();
        queue.offer(original);
        clonedQueue.offer(cloned);
        TreeNode node1;
        TreeNode node2;
        while (!queue.isEmpty()){
            node1 = queue.poll();
            node2 = clonedQueue.poll();
            if (target == node1){
                return node2;
            }
            if (node1.left != null){
                queue.offer(node1.left);
                clonedQueue.offer(node2.left);
            }
            if (node1.right != null){
                queue.offer(node1.right);
                clonedQueue.offer(node2.right);
            }
        }
        return null;
    }
}

作者：burning-summer
链接：https://leetcode-cn.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/solution/tong-shi-bian-li-liang-ke-shu-jin-xing-jie-dian-pi/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
