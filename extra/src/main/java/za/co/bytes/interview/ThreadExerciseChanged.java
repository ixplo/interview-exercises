package za.co.bytes.interview;

public class ThreadExerciseChanged extends Thread {
    public static void main(String[] args) {
        ThreadBC b = new ThreadBC();
        b.start();

        synchronized(b) {
            try{
                System.out.println("Waiting for b to complete...");
                b.wait();
            }catch(InterruptedException e){}

            System.out.println("Total is: " + b.total);
        }
    }
}

class ThreadBC extends Thread {
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


