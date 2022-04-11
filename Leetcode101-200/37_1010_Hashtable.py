/**
 * @param {number[]} time
 * @return {number}
 */
var numPairsDivisibleBy60 = function(time) {
    // % 60 map
    let m = new Map();
    let res = 0;
    for (let t of time) {
        let cur = t % 60;
        let tar = (60 - cur) % 60;
        if (m.has(tar)) res += m.get(tar);
        if (!m.has(cur)) m.set(cur, 1);
        else m.set(cur, m.get(cur) + 1);
    }
    return res;
};

作者：marswiz
链接：https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/solution/js-ha-xi-ji-shu-by-marswiz-4gnw/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
