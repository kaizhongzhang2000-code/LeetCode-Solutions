class DiningPhilosophers {
    private final Semaphore s0 = new Semaphore(1);
    private final Semaphore s1 = new Semaphore(0);
    private final Semaphore s2 = new Semaphore(0);
    private final Semaphore s3 = new Semaphore(0);
    private final Semaphore s4 = new Semaphore(0);
    private final Map<Integer, Semaphore> semaphoreMap = new HashMap<>();
    public DiningPhilosophers() {
        this.semaphoreMap.put(0, s0);
        this.semaphoreMap.put(1, s1);
        this.semaphoreMap.put(2, s2);
        this.semaphoreMap.put(3, s3);
        this.semaphoreMap.put(4, s4);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        Semaphore semaphore = this.semaphoreMap.get(philosopher);
        semaphore.acquire();
        try {
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        } finally {
            Semaphore nextSemaphore = this.semaphoreMap.get((philosopher + 1) % 5);
            nextSemaphore.release();
        }
    }
}