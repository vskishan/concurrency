import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

  static BlockingQueue<Task> tasks;
  static ExecutorService pool;

  public static void main(String[] args) throws Exception{

    int queueSize = 5;
    int poolSize = 2;

    createPool(poolSize, queueSize);

    for(int i=0;i<9;i++){
      submit(new Task());
    }

  }

  public static void createPool(int poolSize, int queueSize){
    //Creating a pool of worker threads
    pool = Executors.newFixedThreadPool(poolSize);

    //Creating a queue for tasks
    tasks = new LinkedBlockingQueue<>(queueSize);

    //Starting the worker threads
    for(int i=0;i<poolSize;i++){
      pool.execute(new Worker(tasks));
    }
  }

  public static void submit(Task task) throws InterruptedException {
    tasks.put(task);
  }

}
