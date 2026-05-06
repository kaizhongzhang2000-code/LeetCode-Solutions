class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        value_map = {}
        for i, num in enumerate(nums):
            value_map[num] = i;
        for i, num in enumerate(nums):
            diff: int = target - num;
            if diff in value_map and value_map[diff] != i:
                return [i, value_map[diff]]
