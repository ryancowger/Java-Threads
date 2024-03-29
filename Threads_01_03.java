/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads_01_03;

/**
 *
 * @author Ryan
 */
public class Threads_01_03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws InterruptedException {
        //print information about the current thread
        
       System.out.printf("%s is %salive and in the %s " +
               "state%n and priority %d \n", Thread.currentThread().getName(),
               Thread.currentThread().isAlive() ? "" : "not ",
               Thread.currentThread().getState(),
               Thread.currentThread().getPriority());
       //Create runnable that prints info about thread
       Runnable r1 = () -> {
           Thread thd = Thread.currentThread();
           System.out.printf("%s is %salive and in %s " +
                                "state%n and priority %d \n", thd.getName(),
                                thd.isAlive() ? "" : "not ",
                                thd.getState(), thd.getPriority());
       };
       
       //Create thread t1 and print the info before calling start method
       Thread t1 = new Thread (r1, "Thread t1");
       System.out.printf("%s is %salive and in %s "+
               "stae%n and priority %d \n", t1.getName(),
               t1.isAlive() ? "" : "not ",
               t1.getState(),
               t1.getPriority());
       t1.start();
       //create thread t2 with only a runnable object 
       Thread t2 = new Thread(r1);
       t2.start();
       //put main thread to sleep for 2 sec
       Thread.sleep(2000);
       
       //change the name of thread 2 and print out its info
       t2.setName("Thread t2");
       System.out.printf("%s is %salive and in %s " +
            "state%n and priority %d \n" t2.getName(),
            t2.isAlive() ? "" : "not ",
            t2.getState(),
            t2.getPriority());
       
       //print info about current thread
       System.out.printf("%s is %salive and in %s " +
            "state%n and priority %d \n", Thread.currentThread().getName(),
               Thread.currentThread().isAlive() ? "" : "not ",
               Thread.currentThread().getState(),
               Thread.currentThread().getPriority());
               
    }
}
    

