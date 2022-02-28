// DFS
/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {TreeNode}
 */
var mergeTrees = function (root1, root2) {
  // 如果一棵树有，另一棵树没有，接上去
  if (root1 == null) return root2;
  if (root2 == null) return root1;
  return new TreeNode(
    root1.val + root2.val,
    mergeTrees(root1.left, root2.left),
    mergeTrees(root1.right, root2.right)
  );
};

作者：angela-x
链接：https://leetcode-cn.com/problems/merge-two-binary-trees/solution/6xing-dai-ma-gao-ding-he-bing-er-cha-shu-uhk4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



// BFS
/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {TreeNode}
 */
var mergeTrees = function (root1, root2) {
  // 如果只要有一个二叉树为空，则合并后的二叉树为另一个非空的二叉树
  if (root1 == null) return root2;
  if (root2 == null) return root1;
  // 两个二叉树都不为空的情况
  let merged = new TreeNode(root1.val + root2.val);
  // 三个队列齐头并进
  let queue = [merged],
    queue1 = [root1],
    queue2 = [root2];
  while (queue1.length && queue2.length) {
    // 队首出队列
    let node = queue.shift(),
      node1 = queue1.shift(),
      node2 = queue2.shift();
    let left1 = node1.left,
      left2 = node2.left,
      right1 = node1.right,
      right2 = node2.right;
    if (left1 || left2) {
      // 要合并俩节点有左子节点都非空
      if (left1 && left2) {
        // 合并并赋值为左子树
        let left = new TreeNode(left1.val + left2.val);
        node.left = left;
        // 齐头并进入队列
        queue.push(left);
        queue1.push(left1);
        queue2.push(left2);
      } else if (left1) node.left = left1;
      else if (left2) node.left = left2;
    }
    if (right1 || right2) {
      if (right1 && right2) {
        let right = new TreeNode(right1.val + right2.val);
        node.right = right;
        queue.push(right);
        queue1.push(right1);
        queue2.push(right2);
      } else if (right1) node.right = right1;
      else if (right2) node.right = right2;
    }
  }
  return merged;
};

作者：angela-x
链接：https://leetcode-cn.com/problems/merge-two-binary-trees/solution/6xing-dai-ma-gao-ding-he-bing-er-cha-shu-uhk4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
