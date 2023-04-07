import java.util.concurrent.BlockingQueue;

class WorkerThread extends Thread {
    private final BlockingQueue<Runnable> queue;


/** 
 *
 * It is a constructor. 
 *
 * @param queue  the queue. 
 */
    public WorkerThread(BlockingQueue<Runnable> queue) { 

        this.queue = queue;
    }

    @Override

/** 
 *
 * It is a constructor. 
 *
 */
    public void run() { 

        while (true) {
            try {
                // Беремо команду з черги та виконуємо її
                Runnable task = queue.take();
                task.run();
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
