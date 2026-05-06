class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.dict = collections.OrderedDict()

    def get(self, key: int) -> int:
        if not key in self.dict:
            return -1
        self.dict.move_to_end(key)
        return self.dict.get(key, -1)

    def put(self, key: int, value: int) -> None:
        if key in self.dict:
            self.dict.move_to_end(key)
        elif len(self.dict) >= self.capacity:
            self.dict.popitem(last=False)
        self.dict[key] = value


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)