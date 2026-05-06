import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        num_count = collections.defaultdict(int)
        for num in nums:
            num_count[num] += 1

        count_heap = []
        for key in num_count:
            heapq.heappush(count_heap, (num_count[key], key))

        return [elem[1] for elem in heapq.nlargest(k, count_heap)]