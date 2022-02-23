class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
           int              n=words.length;
           int[]           st=new int[26];
           int[][]        map=new int[n][27];
           for (char c:letters)  
            st[c-'a']++;
           for (int i=0;i<n;i++) 
            for (int j=0;j<words[i].length();j++){
                map[i][words[i].charAt(j)-'a']++;
                map[i][26]+=score[words[i].charAt(j)-'a'];
            }
            int             ans=0;
            int[][]          dp=new int[1<<n][27];
            for (int i=1;i<(1<<n);i++){                           
                 int j=Integer.bitCount(i^(i-1))-1;

                 boolean        f=true;
                 for (int k=0;k<26;k++)
                  if (st[k]<dp[i-(1<<j)][k]+map[j][k]){
                      f=false;
                      break;
                  }
                  if (!f) continue;

                  for (int k=0;k<26;k++)
                   dp[i][k]=dp[i-(1<<j)][k]+map[j][k];
                  dp[i][26]=map[j][26]+dp[i-(1<<j)][26];              
              
              ans=Math.max(ans,dp[i][26]);
            }
            
    return ans;
    }
}

作者：ABCNO1
链接：https://leetcode-cn.com/problems/maximum-score-words-formed-by-letters/solution/bi-jiao-chang-gui-de-zhuang-ya-dpmo-ban-da8ec/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
