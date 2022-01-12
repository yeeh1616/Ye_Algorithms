'''
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

递归就是自我调用，经常作为一种编程的实现方式，比如题主问题中的DFS 、动态规划、回溯法都可以用递归来实现，当然也可以用非递归来实现。
很多时候一个概念也可以用递归的方式来定义（比如gnu）。
回溯是一种通用的算法，把问题分步解决，在每一步都试验所有的可能，当发现已经找到一种方式或者目前这种方式不可能是结果的时候，退回上一步继续尝试其他可能。
很多时候每一步的处理都是一致的，这时候用递归来实现就很自然。当回溯用于树的时候，就是深度优先搜索。当然了，几乎所有可以用回溯解决的问题都可以表示为树。
那么这俩在这里就几乎同义了。如果一个问题解决的时候显式地使用了树，那么我们就叫它dfs。
很多时候没有用树我们也管它叫dfs严格地说是不对的，但是dfs比回溯打字的时候好输入。
别的回答里提到了砍枝，实际上这二者都可以砍枝。
至于动态规划，被题主放到这里是因为都是竞赛中经常会遇到并且学起来不容易明白吗？
回溯可以用于所有用穷举法可以解决的问题，而DP只用于具有最优子结构的问题。
所以不是所有问题都适合用dp来解决，比如八皇后。
dp需要存贮子问题的解，回溯不需要。
'''

class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if x == 0.0: 
            return 0.0
        res = 1
        
        if n < 0:
            x = 1 / x
            # n = -n
            
        while n:
            if n & 1:
                res *= x
                print("asdf")
            x *= x
            print("asdf2")
            n >>= 1
            
        return res
    
