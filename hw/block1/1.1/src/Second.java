import java.lang.Thread;
import java.lang.InterruptedException;
import java.lang.RuntimeException;

public class Second {
    public static void main(String[] args) {
        Thread A = new Thread(() -> {
            System.out.println("Thread A created.");

            Thread B = new Thread (() -> {
                System.out.println("Thread B created.");
                throw new RuntimeException("Runtime exception in B.");
            });

            B.start();

            try {
                B.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread A waited thread B.");


            Thread C = new Thread (() -> {
                System.out.println("Thread C created.");
                try {
                    B.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread C finished.");
            });

            C.start();

            try {
                C.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread A finished.");
        });

        A.start();

        try {
            A.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}