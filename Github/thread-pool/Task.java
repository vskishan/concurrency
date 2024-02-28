public class Task extends Thread{

  public void run(){
    try{
      Thread.sleep(1000);
      System.out.println("Reported from thread : " + Thread.currentThread().getName());
    } catch(Exception exception){
      System.out.println("Some error has been occurred");
    }
  }

}
