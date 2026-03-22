import java.lang.Thread;
import java.lang.InterruptedException;
import java.lang.RuntimeException;

public class First {
    public static void main(String[] args) {
        Thread A = new Thread(() -> {
            System.out.println("Thread A created.\n");

            Thread B = new Thread (() -> {
                System.out.println("Thread B created.\n");
                throw new RuntimeException("Runtime exception in B.\n");
            });

            B.start();

            try {
                B.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread A waited thread B.\n");

        });

        A.start();

        try {
            A.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}