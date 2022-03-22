// 我的代码(未通过)：
class Solution {
    public boolean contain(int[] arrS, int[] arrT){
        for(int i = 0; i < 26; i++){
            if(arrT[i]>0){
                if(arrS[i]<arrT[i]){   // arrs[i] != arrt[i]
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public String minWindow(String s, String t) {
        int[] arrS = new int[26];
        int[] arrT = new int[26];
        
        for(int i = 0; i < t.length(); i++){
//             int xxx = s.charAt(i) - 'A'；
                
//             System.out.print(s.charAt(i) + ":   " + xxx);
            // System.out.println(t.charAt(i) + ":    "+(t.charAt(i) - 'A'));
            ++arrT[t.charAt(i) - 'A'];
        }
        
        int left = 0;
        int right = 0;
        
        int ansLeft = 0;
        int ansRight = s.length();
        
        while(right < s.length()){
//             System.out.print("t:   ");
//             for(int i = 0; i < 26; i++){
//                 System.out.print(arrT[i]);
//                 System.out.print(" ");
//             }
//             System.out.println("");
            
            
//             System.out.print("s:   ");
//             for(int i = 0; i < 26; i++){
//                 System.out.print(arrS[i]);
//                 System.out.print(" ");
//             }
//             System.out.println("");
//             System.out.println("");
            
            
            if(contain(arrS, arrT)){
                if((right - left) < (ansRight - ansLeft) ){
                    ansLeft = left;
                    ansRight = right;
                }
                
                --arrS[s.charAt(left) - 'A'];
                left++;
                
                // System.out.print("true, left: " + left);
                // System.out.println("      right: " + right);
                // System.out.print("true, ansLeft: " + ansLeft);
                // System.out.println("      ansRight: " + ansRight);
                // System.out.println(s.substring(0, right));
                
            }else{
                ++arrS[s.charAt(right) - 'A'];
                right++;
                
//                 if(right == s.length()){
//                     if(contain(arrS, arrT)){
//                         if((right - left) < (ansRight - ansLeft) ){
//                             ansLeft = left;
//                             ansRight = right;
//                         }

//                         System.out.print("true, left: " + left);
//                         System.out.println("      right: " + right);
//                         System.out.print("true, ansLeft: " + ansLeft);
//                         System.out.println("      ansRight: " + ansRight);
//                         System.out.println(s.substring(0, right));
//                     }
//                 }
            }
        }
        
        return s.substring(ansLeft, ansRight);
    }
}

// 答案：
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        int[] need = new int[128];
        //记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        //遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {//需要字符c
                count--;
            }
            need[c]--;//把右边的字符加入窗口
            if (count == 0) {//窗口中已经包含所有字符
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;//释放右边移动出窗口的字符
                    l++;//指针右移
                }
                if (r - l + 1 < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    size = r - l + 1;
                    start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
