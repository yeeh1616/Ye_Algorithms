class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        ans = []
        nums.sort()
        len_nums = len(nums)

        # 构建hash表
        table = {val: index for index, val in enumerate(nums)}

        # 枚举前三个数
        for i in range(len_nums-3):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            if nums[i] * 4 > target:
                break
            if nums[i] + 3 * nums[-1] < target:
                continue
            for j in range(i + 1, len_nums-2):
                if j > i + 1 and nums[j] == nums[j-1]:
                    continue
                if nums[i] + 3*nums[j] > target:
                    break
                if nums[i] + nums[j] + 2*nums[-1] < target:
                    continue
                for k in range(j + 1, len_nums-1):
                    if k > j + 1 and nums[k] == nums[k - 1]:
                        continue
                    key = target - nums[i] - nums[j] - nums[k]
                    if table.get(key, -1) > k:
                        ans.append([nums[i], nums[j], nums[k], key])

        return ans
