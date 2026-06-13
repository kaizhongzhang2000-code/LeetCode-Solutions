class DiningPhilosophers {
    private final Semaphore fork = new Semaphore(4);
    private Lock lock = new ReentrantLock();
    private final Condition[] conditions = new Condition[5];
    private final Map<Integer, Semaphore> semaphoreMap = new HashMap<>();
    boolean[] available = new boolean[5];
    public DiningPhilosophers() {
         for(int i = 0; i < 5; i++){
             conditions[i] = lock.newCondition();
         }
         Arrays.fill(available, true);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        fork.acquire();
        lock.lock();
        try {
            if(available[philosopher]){
                available[philosopher] = false;
                pickLeftFork.run();
            } else {
                conditions[philosopher].await();
            }
            if(available[(philosopher + 1) % 5]){
                available[(philosopher + 1) % 5] = false;
                pickRightFork.run();
            } else {
                conditions[(philosopher + 1) % 5].await();
            }
            eat.run();
            putLeftFork.run();
            available[philosopher] = true;
            conditions[philosopher].signalAll();
            putRightFork.run();
            available[(philosopher + 1) % 5] = true;
            conditions[(philosopher + 1) % 5].signalAll(); 
        } finally {
            lock.unlock();
            fork.release();
        }
    }
}