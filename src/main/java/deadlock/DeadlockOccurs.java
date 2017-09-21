package deadlock;

/**
 * @author Piotr_Sekula
 * @since 21.09.2017.
 */
public class DeadlockOccurs {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        
        Thread t1 = new Thread(() -> {
           synchronized (lock1) {
               System.out.println("t1 locked 1");
               try {
                   Thread.sleep(250);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               synchronized (lock2) {
                   System.out.println("t1 locked 2");
               }
           }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("t2 locked 2");
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("t2 locked 1");
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}