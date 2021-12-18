/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
*/
class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        if (n < 1) return {};
        size = n;
        mask = (1 << n) - 1;

        vector<int> firstSol(n, 0);
        BackTrack(0, 0, 0, 0, firstSol);

        return GenRes();
    }

private:
    void BackTrack(int row, int left, int down, int right, vector<int> &curSol) {
        if (row == size) {
            binRes.push_back(curSol);
        } else {
            int bitmap = mask & ~(left | down | right);
            while (bitmap) {
                int pick = -bitmap & bitmap;
                curSol[row] = pick;
                BackTrack(row + 1, (pick | left) << 1, pick | down, (pick | right) >> 1, curSol);
                bitmap ^= pick;
            }
        }
    }

    vector<vector<string>> GenRes() {
        vector<vector<string>> res(binRes.size(), vector<string>(size, string(size, '.')));
        for (int i = 0; i < binRes.size(); ++i) {
            for (int j = 0; j < size; ++j) {
                int binIdx = binRes[i][j];
                int count = 0;
                while (binIdx) {
                    binIdx >>= 1;
                    ++count;
                }
                res[i][j][size - count] = 'Q';
            }
        }
        return res;
    }

    int size, mask;
    vector<vector<int>> binRes;
};
