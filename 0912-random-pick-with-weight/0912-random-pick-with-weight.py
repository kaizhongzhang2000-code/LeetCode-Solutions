class Solution:

    def __init__(self, w: List[int]):
        self.range_list = []
        self.sum: int = 0
        for i in range(len(w)):
            self.sum += w[i]
            self.range_list.append(self.sum)



    def pickIndex(self) -> int:
        position: int = random.randint(1, self.sum)
        return bisect.bisect_left(self.range_list, position)


# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()