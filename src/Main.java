public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread1 = new Thread(() -> task.firstThread());

        Thread thread2 = new Thread(() -> task.secondThread());
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        task.showCounter();
    }
}