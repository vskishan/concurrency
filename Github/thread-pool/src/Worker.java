import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable{

  private final BlockingQueue<Task> taskQueue;

  public Worker(BlockingQueue<Task> taskQueue) {
    this.taskQueue = taskQueue;
  }

  public void run(){
    while(!Thread.interrupted()){
      try {
        Task task = taskQueue.take();
        task.run();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

}
