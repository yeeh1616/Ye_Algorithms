/*
我们很容易地知道一个满二叉树必须是奇数。
当N = 1时，只有一个节点本身。
当N = 3时，一个根节点，左边是N = 1时的子树，右边是N= 3 - 1 - 1，所以也是N= 1的子树。
当N = 5时，一个根节点，左边可以是N = 1 或者N =3，相应的右边是N= 3或者N=1。
由此可见，每一次我们都可以使用之前的结果，这是典型的动态规划的使用范围。所以可以得出代码如下：
*/

public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> n1 = new ArrayList();
        if (N % 2 == 0) return n1;
        n1.add(new TreeNode(0));
        if (N == 1) return n1;
        
        int len = (N + 1) / 2;
        List<TreeNode>[] dp = new List[len];
        dp[0] = n1;
        
        for (int total = 3; total <= N; total += 2){
            List<TreeNode> nodes = new LinkedList();
            for (int leftCount = 1; leftCount < total; leftCount += 2){
                List<TreeNode> leftNodes = dp[leftCount / 2];
                List<TreeNode> rightNodes = dp[(total - leftCount - 1) / 2];
                
                for (TreeNode left : leftNodes){
                    for (TreeNode right : rightNodes){
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        nodes.add(root);
                    }
                }
            }
            dp[total/2] = nodes;
        }
        return dp[len - 1];
    }

作者：w1sl1y
链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees/solution/dong-tai-gui-hua-fa-by-w1sl1y/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
