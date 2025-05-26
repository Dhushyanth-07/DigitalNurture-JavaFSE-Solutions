public class VirtualThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        
        for (int i = 0; i < 100_000; i++) {
            Thread.startVirtualThread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");
    }
}