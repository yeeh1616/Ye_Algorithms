class Solution:
    def longestMountain(self, A: List[int]) -> int:
        # 三指针记录 i=开始，k=波峰， j=山脚
        i, k, j = 0, 0, 0
        n = len(A)
        res = 0
        # 一遍扫描
        while i < n-1:
            # 检索到波峰
            k = i
            while k < n-1 and A[k+1] > A[k]:
                k += 1
            # 检索到山脚
            j = k
            while j < n-1 and A[j+1] < A[j]:
                j += 1
            # 判断是否最大山峰
            if j - k > 0 and k - i > 0:
                res = max(res, j-i+1)
            # 指针移动
            if j - k > 0:
                i = j
            elif k - i > 0:
                i = k
            else:
                i += 1
        return res

作者：chongzi1990
链接：https://leetcode-cn.com/problems/longest-mountain-in-array/solution/hua-dong-chuang-kou-san-zhi-zhen-yi-bian-sao-miao-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
