/* 1395. Count Number of Teams
There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

You have to form a team of 3 soldiers amongst them under the following rules:

Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).

 

Example 1:

Input: rating = [2,5,3,4,1]
Output: 3
Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1). 
Example 2:

Input: rating = [2,1,3]
Output: 0
Explanation: We can't form any team given the conditions.
Example 3:

Input: rating = [1,2,3,4]
Output: 4
 

Constraints:

n == rating.length
3 <= n <= 1000
1 <= rating[i] <= 105
All the integers in rating are unique.
*/

// Solution 1 枚举三元组
class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if ((rating[i] < rating[j] && rating[j] < rating[k]) || (rating[i] > rating[j] && rating[j] > rating[k])) {
                        ++ans;
                    }
                }
            }
        }
        return ans;
    }
}

// Solution 2 枚举中间点
class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int ans = 0;
        // 枚举三元组中的 j
        for (int j = 1; j < n - 1; ++j) {
            int iless = 0, imore = 0;
            int kless = 0, kmore = 0;
            for (int i = 0; i < j; ++i) {
                if (rating[i] < rating[j]) {
                    ++iless;
                }
                // 注意这里不能直接写成 else
                // 因为可能有评分相同的情况
                else if (rating[i] > rating[j]) {
                    ++imore;
                }
            }
            for (int k = j + 1; k < n; ++k) {
                if (rating[k] < rating[j]) {
                    ++kless;
                } else if (rating[k] > rating[j]) {
                    ++kmore;
                }
            }
            ans += iless * kmore + imore * kless;
        }
        return ans;
    }
}

// Solution 3 离散化树状数组
class Solution {
    int maxN;
    int[] c;
    List<Integer> disc;
    int[] iLess;
    int[] iMore;
    int[] kLess;
    int[] kMore;

    public int numTeams(int[] rating) {
        int n = rating.length;
        maxN = n + 2;
        c = new int[maxN];
        disc = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            disc.add(rating[i]);
        }
        disc.add(-1);
        Collections.sort(disc);
        iLess = new int[n];
        iMore = new int[n];
        kLess = new int[n];
        kMore = new int[n];

        for (int i = 0; i < n; ++i) {
            int id = getId(rating[i]);
            iLess[i] = get(id);
            iMore[i] = get(n + 1) - get(id); 
            add(id, 1);
        }

        c = new int[maxN];
        for (int i = n - 1; i >= 0; --i) {
            int id = getId(rating[i]);
            kLess[i] = get(id);
            kMore[i] = get(n + 1) - get(id); 
            add(id, 1);
        }
        
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += iLess[i] * kMore[i] + iMore[i] * kLess[i];
        }

        return ans;
    }

    public int getId(int target) {
        int low = 0, high = disc.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (disc.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int get(int p) {
        int r = 0;
        while (p > 0) {
            r += c[p];
            p -= lowbit(p);
        }
        return r;
    }

    public void add(int p, int v) {
        while (p < maxN) {
            c[p] += v;
            p += lowbit(p);
        }
    }

    public int lowbit(int x) {
        return x & (-x);
    }
}
