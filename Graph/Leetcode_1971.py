class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        gra=[[] for _ in range(n)]
        for e in edges:
            x,y=e[0],e[1]
            gra[x].append(y)
            gra[y].append(x)
        #print(gra)
        if destination in gra[source]:
            return True
        v=set()
        flag=False
        def dfs(st):
            nonlocal flag
            if st==destination:
                flag=True
                return flag
            for i in gra[st]:
                if i in v:
                    continue
                v.add(i)
                dfs(i)            
        dfs(source)        
        return flag


作者：peiyao68
链接：https://leetcode-cn.com/problems/find-if-path-exists-in-graph/solution/pythonshen-du-you-xian-you-xiang-tu-tong-515k/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
