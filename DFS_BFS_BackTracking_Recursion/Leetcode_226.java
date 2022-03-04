// BFS
  public TreeNode invertTree(TreeNode root) {
      if (root == null)
          return root;
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);//相当于把数据加入到队列尾部
      while (!queue.isEmpty()) {
          //poll方法相当于移除队列头部的元素
          TreeNode node = queue.poll();
          //先交换子节点
          TreeNode left = node.left;
          node.left = node.right;
          node.right = left;

          if (node.left != null)
              queue.add(node.left);
          if (node.right != null)
              queue.add(node.right);
      }
      return root;
  }

作者：sdwwld
链接：https://leetcode-cn.com/problems/invert-binary-tree/solution/di-gui-bfshe-dfsduo-chong-fang-shi-jie-jue-quan-bu/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// DFS
