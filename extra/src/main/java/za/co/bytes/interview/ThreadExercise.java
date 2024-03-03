package za.co.bytes.interview;

public class ThreadExercise extends Thread {
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();

        synchronized(b) {
            try{
                System.out.println("Waiting for b to complete...");
                sleep(1000);
            }catch(InterruptedException e){}

            System.out.println("Total is: " + b.total);
        }
    }
}

class ThreadB extends Thread {
    int total;
    @Override
    public void run() {
        synchronized(this){
            for(int i=0; i<=100 ; i++) {
                total = i;
            }
            notify();
        }
    }
}   
