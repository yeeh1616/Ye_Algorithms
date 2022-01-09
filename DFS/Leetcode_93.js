/* 93. Restore IP Addresses
A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

 

Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 

Constraints:

0 <= s.length <= 20
s consists of digits only.
*/

/**
 * @param {string} s
 * @return {string[]}
 */
var restoreIpAddresses = function(s) {
    const res = [];
  // 复原从start开始的子串
  const dfs = (subRes, start) => {                 
    if (subRes.length == 4 && start == s.length) { // 片段满4段，且耗尽所有字符
      res.push(subRes.join('.'));                  // 拼成字符串，加入解集
      return;                     // 返不返回都行，指针已经到头了，严谨的说还是返回
    }
    if (subRes.length == 4 && start < s.length) {  // 满4段，字符未耗尽，不用往下选了
      return;
    }
    for (let len = 1; len <= 3; len++) {           // 枚举出选择，三种切割长度
      if (start + len - 1 >= s.length) return;     // 加上要切的长度就越界，不能切这个长度
      if (len != 1 && s[start] == '0') return;     // 不能切出'0x'、'0xx'

      const str = s.substring(start, start + len); // 当前选择切出的片段
      if (len == 3 && +str > 255) return;          // 不能超过255

      subRes.push(str);                            // 作出选择，将片段加入subRes
      dfs(subRes, start + len);                    // 基于当前选择，继续选择，注意更新指针
      subRes.pop(); // 上面一句的递归分支结束，撤销最后的选择，进入下一轮迭代，考察下一个切割长度
    }
  };

  dfs([], 0);       // dfs入口
  return res;
};


// 
