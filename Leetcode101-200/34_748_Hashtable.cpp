class Solution {
public:
    string shortestCompletingWord(string licensePlate, vector<string>& words) {
        unordered_map<char, int> dict;
        for (auto& c : licensePlate)
            if (c != ' ' && !isdigit(c))
                dict[tolower(c)]++;
        string res;
        for (auto& word : words)
        {
            unordered_map<char, int> curFreq;
            for (auto c : word)
                curFreq[c]++;
            if (isValid(curFreq, dict))
            {
                if (res.empty() || res.size() > word.size())
                    res = word;
            }
        }
        return res;
    }
    /* str1中含有str2中的所有字符 */
    bool isValid(unordered_map<char, int>& dict1, unordered_map<char, int>& dict2)
    {
        for (auto& kvp : dict2)
        {
            if (dict1[kvp.first] < kvp.second)
                return false;
        }
        return true;
    }
};

作者：yanglr
链接：https://leetcode-cn.com/problems/shortest-completing-word/solution/geekplayers-leetcode-ac-yi-kan-jiu-dong-2276g/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
