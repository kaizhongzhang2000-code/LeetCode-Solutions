class BoundedBlockingQueue {
    private final Queue<Integer> items = new LinkedList<>();
    private final int capacity;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }
    
    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while(items.size() == capacity){
                notFull.await();
            }
            items.offer(element);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }
    
    public int dequeue() throws InterruptedException {
        lock.lock();
        int result;
        try {
            while(items.size() == 0){
                notEmpty.await();
            }
            result = items.poll();
            notFull.signal();
        } finally {
            lock.unlock();
        }
        return result;
    }
    
    public int size() {
        return this.items.size();
    }
}