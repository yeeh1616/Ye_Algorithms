        // 特解
        if (s.length() < 3) return 0;
        // 窗口
        StringBuffer window = new StringBuffer();
        // 收集结果
        int res = 0;
        // 窗口范围
        int left = 0;
        int right = 1;
        // 预处理
        window.append(s.charAt(left));
        window.append(s.charAt(right));
        // 滑动
        while (left < right && right < s.length() - 1) {
            // 右边界向右滑动
            while (right - left < 2) {
                right++;
                window.append(s.charAt(right));
            }
            // 判断
            if (window.charAt(0) != window.charAt(1) && window.charAt(0) != window.charAt(2) && window.charAt(1) != window.charAt(2)) res++;
            // 左边界向右滑动
            window.deleteCharAt(0);
            left++;
        }
        // 返回结果
        return res;

作者：keyfly
链接：https://leetcode-cn.com/problems/substrings-of-size-three-with-distinct-characters/solution/java-dan-ci-xun-huan-bian-li-huo-hua-don-ds0t/
来源：力扣（LeetCode）
