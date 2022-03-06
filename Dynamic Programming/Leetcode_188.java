// DP

import kotlin.math.max

class Solution {
    fun maxProfit(k: Int, prices: IntArray): Int {
        if (prices.size == 0) return 0
        /*
            状态分析：
            0. 未买入
            1. 第一次买入
            2. 第一次出售
            3. 第二次买入
            4. 第二次出售
            5. 第三次买入
            6. 第三次出售
            ....
            n. 第k次买入
            n+1. 第k次出售

            集合：f[i][1]表示在第i天没有持有股票的最大利润
                 f[i][2]表示在第i天第一次持有股票的最大利润  2/2 = 1
                 f[i][3]表示在第i天第一次售出股票的最大利润  3/2 = 1
                 f[i][4]表示在第i天第二次持有股票的最大利润  4/2 = 2
                 f[i][5]表示在第i天第二次售出股票的最大利润  5/2 = 2
                 f[i][6]表示在第i天第三次持有股票的最大利润  6/2 = 3
                 f[i][7]表示在第i天第三次出售股票的最大利润  7/2 = 3


             属性：最大值
         */

        val f = Array<IntArray>(prices.size+1){IntArray(k*2+2)}

        // 初始化
        for (j in 1..k*2+1) {
            f[0][j] = if (j and 1 == 1) 0 else (-prices[0])
        }

        for (i in 1..prices.size) {
            for (j in 2..k*2+1) {
                // 奇数的时候出售，偶数的时候买入
                f[i][j] = if (j and 1 == 1) max(f[i-1][j],f[i-1][j-1] + prices[i-1])
                else max(f[i-1][j],f[i-1][j-1] - prices[i-1])
            }
        }
        return f[prices.size][k*2+1]
    }
}

作者：woodwhale
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/kotlin-dong-tai-gui-hua-zhuang-tai-fen-x-if4k/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
