/*
1641. Count Sorted Vowel Strings

Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

 

Example 1:

Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
Example 2:

Input: n = 2
Output: 15
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
Example 3:

Input: n = 33
Output: 66045
*/

class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][5];

        //初始化n=1的情况
        for (int i=0;i<5;i++){
            dp[1][i]=1;
        }

        for (int i=2;i<=n;i++){
            //长度i的以u结尾的字符串可以由任意一个长度i-1的字符串结尾加个u得到
            dp[i][4]=dp[i-1][0]+dp[i-1][1]+dp[i-1][2]+dp[i-1][3]+dp[i-1][4];
            dp[i][3]=dp[i-1][0]+dp[i-1][1]+dp[i-1][2]+dp[i-1][3];
            dp[i][2]=dp[i-1][0]+dp[i-1][1]+dp[i-1][2];
            dp[i][1]=dp[i-1][0]+dp[i-1][1];
            //长度i的以a结尾的字符串只能由长度i-1的以a结尾的字符串结尾加个a得到
            dp[i][0]=dp[i-1][0];
        }

        //最终答案求个和就行啦
        return dp[n][0]+dp[n][1]+dp[n][2]+dp[n][3]+dp[n][4];
    }
}

// 状态表可降到一维
public static int countVowelStrings(int n) {
     int dp[] = new int[6];
     for (int i = 1; i <= 5; i++) {
         dp[i] = 1;
     }
     for (int j = 2; j <= n; j++) {
         for(int i=2;i<=5;i++){
             dp[i]+=dp[i-1];
         }
     }
     return dp[1]+dp[2]+dp[3]+dp[4]+dp[5];
 }
