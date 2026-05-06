class LFUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.low = 1
        self.freqdict = collections.defaultdict(int)
        self.removedict = collections.defaultdict(list)
        self.val = collections.defaultdict(int)

    def get(self, key: int) -> int:
        if key in self.freqdict:
            freq = self.freqdict[key]
            self.freqdict[key] = freq + 1
            self.removedict[freq].remove(key)
            self.removedict[freq + 1].append(key)
            if freq == self.low and not self.removedict[freq] :
                self.low = freq + 1
            return self.val[key]
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if key in self.freqdict:
            freq = self.freqdict[key]
            self.freqdict[key] = freq + 1
            self.removedict[freq].remove(key)
            self.removedict[freq + 1].append(key)
            self.val[key] = value
            if freq == self.low and not self.removedict[freq] :
                self.low = freq + 1
            return
        elif len(self.freqdict) >= self.capacity:
            abortkey = self.removedict[self.low][0]
            self.removedict[self.low].remove(abortkey)
            self.freqdict.pop(abortkey)
            self.val.pop(abortkey)
        self.removedict[1].append(key)
        self.freqdict[key] = 1
        self.low = 1
        self.val[key] = value
        


# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)