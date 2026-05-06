class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        i:int = 0;
        while i < len(nums):
            if nums[i] <= len(nums) and nums[i] > 0 and nums[i] != i + 1 and nums[i] != nums[nums[i] - 1]:
                holder: int = nums[nums[i] - 1]
                nums[nums[i] - 1] = nums[i]
                nums[i] = holder
            else:
                i = i + 1
        for j in range(len(nums)):
            if nums[j] != j + 1:
                return j + 1

        return len(nums) + 1
        