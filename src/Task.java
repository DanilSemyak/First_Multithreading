import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task {
    private int counter;
    private Lock lock = new ReentrantLock();

    private void increment() {
        for (int i = 0; i < 10000; i++)
            counter++;
    }

    public void firstThread() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void secondThread() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void showCounter() {
        System.out.println(counter);
    }
}
